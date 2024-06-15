package com.example.ecommerce.infra.product;

import com.example.ecommerce.api.partner.request.Register;
import com.example.ecommerce.api.product.response.RetrieveProductDetail;
import com.example.ecommerce.api.product.response.RetrieveProductList;
import com.example.ecommerce.domain.partner.dto.PartnerCommand;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.product.entity.product.Product;
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
                .unitPrice(product.getUnitPrice())
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
                        .unitPrice(product.getUnitPrice())
                        .build())
                .collect(Collectors.toList());

        return productInfoList;
    }

    @Override
    public PartnerCommand.Register commandOf(Register request) {
        PartnerCommand.Register command = PartnerCommand.Register.builder()
                .name(request.getName())
                .build();

        return command;
    }
}
