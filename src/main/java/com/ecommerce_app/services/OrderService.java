package com.ecommerce_app.services;

import com.ecommerce_app.dtos.order.CreateOrder;
import com.ecommerce_app.dtos.order.OrderItem;
import com.ecommerce_app.dtos.order.OrderResponseDto;
import com.ecommerce_app.entities.CustomerEntity;
import com.ecommerce_app.entities.OrderEntity;
import com.ecommerce_app.entities.OrderItemEntity;
import com.ecommerce_app.entities.ProductEntity;
import com.ecommerce_app.exceptions.ResourceNotFoundException;
import com.ecommerce_app.repositories.CustomerRepository;
import com.ecommerce_app.repositories.OrderItemRepository;
import com.ecommerce_app.repositories.OrderRepository;
import com.ecommerce_app.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

//    public void createOrder (CreateOrder createOrder) {
//        CustomerEntity customer = customerRepository.findById(createOrder.getCustomerId())
//                .orElseThrow(() -> new ResourceNotFoundException("Customer not Found !"));
//        List<OrderItem> items = createOrder.getItems();
//        customer.getOrders().add((OrderEntity) items);
//
//        orderRepository.save();
//    }

    @Transactional
    public OrderResponseDto createOrder (CreateOrder request) {
        CustomerEntity customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not Found !"));

        OrderEntity order = new OrderEntity();


        order.setCustomer(customer);
        order.setStatus("PLACED");
        order.setOrderedAt(LocalDateTime.now());

        BigDecimal totalAmount = BigDecimal.ZERO;

//        check if the product exist or not
        for(OrderItem od : request.getItems()) {
            ProductEntity product = productRepository.findById(od.getProductId()).orElseThrow(() ->
                        new ResourceNotFoundException("Invalid Product Id")
                    );

            if(product.getStockQuantity()
                    < od.getQuantity()) {

                throw new IllegalArgumentException(
                        "Insufficient stock"
                );
            }


            OrderItemEntity orderItem =
                    new OrderItemEntity();

            orderItem.setProduct(product);

            orderItem.setQuantity(
                    od.getQuantity()
            );

            orderItem.setPriceAtPurchase(
                    product.getPrice()
            );

            order.addOrderItem(orderItem);

            BigDecimal itemTotal =
                    product.getPrice()
                            .multiply(
                                    BigDecimal.valueOf(
                                            od.getQuantity()
                                    )
                            );

            totalAmount =
                    totalAmount.add(itemTotal);

            orderItemRepository.save(orderItem);
        }

        order.setTotalAmount(totalAmount);

        OrderEntity savedOrder =
                orderRepository.save(order);



        return OrderResponseDto.builder()
                .orderId(savedOrder.getId())
                .totalAmount(savedOrder.getTotalAmount())
                .status(savedOrder.getStatus())
                .orderedAt(savedOrder.getOrderedAt())
                .build();
    }

}
