package com.example.ecommerce.api.order.request;

import com.example.ecommerce.domain.order.dto.OrderCommand;
import lombok.Getter;

import java.util.List;

@Getter
public class Register {
    private Long purchaserId;
    private String purchaserUsername;
    private String receiverAddressCity;
    private String receiverAddressStreet;
    private List<OrderCommand.RegisterOrderLine> orderLineList;

    public static class RegisterOrderLine {
        private Long productId;
        private String name;
        private int unitPrice;
        private int quantity;
    }
}