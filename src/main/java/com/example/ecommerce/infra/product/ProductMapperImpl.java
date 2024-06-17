package com.example.ecommerce.infra.product;

import com.example.ecommerce.api.product.request.RegisterRequest;
import com.example.ecommerce.api.product.response.RetrieveProductDetail;
import com.example.ecommerce.api.product.response.RetrieveProductList;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.product.dto.RegisterCommand;
import com.example.ecommerce.domain.product.entity.product.Product;
import com.example.ecommerce.domain.product.entity.product.Registrant;
import com.example.ecommerce.domain.product.service.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public RetrieveProductDetail.ProductInfo retrieveDetailOf(Product product, Partner partner) {

        RetrieveProductDetail.PartnerInfo partnerInfo = RetrieveProductDetail.PartnerInfo.builder()
                .id(partner.getId())
                .name(partner.getName())
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

        Registrant registrant = Registrant.builder()
                .partnerId(request.getRegistrant().getPartnerId())
                .name(request.getRegistrant().getName())
                .build();

        RegisterCommand command = RegisterCommand.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .registrant(registrant)
                .build();

        return command;
    }
}
