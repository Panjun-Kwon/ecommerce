package com.example.ecommerce.app.order;

import com.example.ecommerce.domain.order.dto.OrderCommand;
import com.example.ecommerce.domain.order.entity.order.Order;
import com.example.ecommerce.domain.order.entity.order_line.OrderLine;
import com.example.ecommerce.domain.order.service.OrderFactory;
import com.example.ecommerce.domain.order.service.OrderStore;
import com.example.ecommerce.domain.order.service.OrderValidator;
import com.example.ecommerce.domain.product.service.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderRegisterService {

    private final OrderFactory orderFactory;
    private final OrderStore orderStore;
    private final ProductReader productReader;
    private final OrderValidator orderValidator;

    public Long register(OrderCommand.Register command) {
        orderValidator.validate(command);
        Order initOrder = orderFactory.make(command);
        Order order = orderStore.store(initOrder);

        // 재고 감소
        // 방법 1 : Product 조회, dirty checking
//        order.getOrderLineList().stream()
//                .forEach(ol -> {
//                    productReader.getProduct(ol.getProductId())
//                            .decreaseStock(ol.getQuantity());
//                });

        // 방법 2 : Product 조회 최적화
        List<OrderLine> orderLineList = order.getOrderLineList();

        Map<Long, Integer> quantityMap = orderLineList.stream()
                .collect(Collectors.toMap(OrderLine::getProductId, OrderLine::getQuantity));

        List<Long> productIdList = orderLineList.stream()
                .map(OrderLine::getProductId)
                .collect(Collectors.toList());

        productReader.getProductAll(productIdList)
                .stream()
                .forEach(p -> {
                    if (p.decreaseStock(quantityMap.get(p.getId())) < 0) {
                        throw new RuntimeException(p.getName() + "\'STOCK NOT ENOUGH");
                    }
                });

        // 방법 3 : Product 조회 x, 도메인 서비스(update 쿼리)
//        order.getOrderLineList().forEach(ol -> {
//            productStockAdjuster.decreaseProductStock(ol.getProductId(), ol.getQuantity());
//        });
//        em.flush();
//        em.clear();

        return order.getId();
    }
}
