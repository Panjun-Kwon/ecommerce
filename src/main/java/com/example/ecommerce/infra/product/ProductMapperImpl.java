package com.example.ecommerce.infra.product;

import com.example.ecommerce.api.product.request.*;
import com.example.ecommerce.api.product.response.*;
import com.example.ecommerce.domain.partner.entity.partner.*;
import com.example.ecommerce.domain.product.command.*;
import com.example.ecommerce.domain.product.entity.product.*;
import com.example.ecommerce.domain.product.service.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public RetrieveProductDetail.ProductInfo retrieveDetailOf(Product product, Partner partner) {

        RetrieveProductDetail.PartnerInfo partnerInfo = RetrieveProductDetail.PartnerInfo.builder()
                .id(partner.getId())
                .name(partner.getProfile().getName())
                .build();

        RetrieveProductDetail.ProductInfo productInfo = RetrieveProductDetail.ProductInfo.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .partner(partnerInfo)
                .build();

        return productInfo;
    }

    @Override
    public List<RetrieveProductList.ProductInfo> retrieveListOf(List<Product> productList) {

        List<RetrieveProductList.ProductInfo> productInfoList = productList.stream()
                .map(product -> RetrieveProductList.ProductInfo.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .build())
                .collect(Collectors.toList());

        return productInfoList;
    }

    @Override
    public RegisterCommand commandOf(RegisterRequest request) {
        return RegisterCommand.of(request);
    }
}
