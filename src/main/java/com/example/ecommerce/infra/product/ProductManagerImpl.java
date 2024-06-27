package com.example.ecommerce.infra.product;

import com.example.ecommerce.common.exception.*;
import com.example.ecommerce.domain.order.entity.order.*;
import com.example.ecommerce.domain.order.entity.order_line.*;
import com.example.ecommerce.domain.product.service.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
@RequiredArgsConstructor
public class ProductManagerImpl implements ProductManager {

    private final ProductReader productReader;

    @Override
    public void increaseProductStock(Order order) {
        List<OrderLine> orderLineList = order.getOrderLineList();

        Map<Long, Integer> quantityMap = orderLineList.stream()
                .collect(Collectors.toMap(ol -> ol.getOrderProduct().getProductId(), OrderLine::getQuantity));

        List<Long> productIdList = orderLineList.stream()
                .map(ol -> ol.getOrderProduct().getProductId())
                .collect(Collectors.toList());

        MultiException multiException = new MultiException();
        productReader.getProductAllByIdList(productIdList)
                .stream()
                .forEach(p -> {
                    try {
                        p.increaseStock(quantityMap.get(p.getId()));
                    } catch (CommonException e) {
                        multiException.addException(e);
                    }
                });
        if (!multiException.getExceptions().isEmpty()) {
            throw multiException;
        }
    }

    @Override
    public void decreaseProductStock(Order order) {
        List<OrderLine> orderLineList = order.getOrderLineList();

        Map<Long, Integer> quantityMap = orderLineList.stream()
                .collect(Collectors.toMap(ol -> ol.getOrderProduct().getProductId(), OrderLine::getQuantity));

        List<Long> productIdList = orderLineList.stream()
                .map(ol -> ol.getOrderProduct().getProductId())
                .collect(Collectors.toList());

        MultiException multiException = new MultiException();
        productReader.getProductAllByIdList(productIdList)
                .stream()
                .forEach(p -> {
                    try {
                        p.decreaseStock(quantityMap.get(p.getId()));
                    } catch (CommonException e) {
                        multiException.addException(e);
                    }
                });
        if (!multiException.getExceptions().isEmpty()) {
            throw multiException;
        }
    }
}
