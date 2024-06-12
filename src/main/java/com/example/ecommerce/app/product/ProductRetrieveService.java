package com.example.ecommerce.app.product;

import com.example.ecommerce.api.product.dto.ProductResponse;
import com.example.ecommerce.domain.partner.dto.PartnerInfo;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerReader;
import com.example.ecommerce.domain.product.dto.ProductInfo;
import com.example.ecommerce.domain.product.entity.product.Product;
import com.example.ecommerce.domain.product.service.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductRetrieveService {

    private final ProductReader productReader;
    private final PartnerReader partnerReader;

    public ProductResponse.ProductSimple retrieveProductList(Pageable pageable) {
        Page<Product> productPage = productReader.getProductAll(pageable);
        List<ProductResponse.ProductSimple.Info> infoList = productPage.stream()
                .map(product -> ProductResponse.ProductSimple.Info.builder()
                        .product(ProductInfo.ProductSimple.of(product))
                        .partner(PartnerInfo.PartnerSimple.of(partnerReader.getPartner(product.getPartnerId())))
                        .build())
                .collect(Collectors.toList());

        return ProductResponse.ProductSimple.builder()
                .productList(infoList)
                .currentElements(productPage.getNumberOfElements())
                .totalPages(productPage.getTotalPages())
                .totalElements(productPage.getTotalElements())
                .build();
    }

    public ProductResponse.ProductDetail retrieveProductDetail(Long productId) {
        Product product = productReader.getProduct(productId);
        ProductInfo.ProductDetail productInfo = ProductInfo.ProductDetail.of(product);

        Partner partner = partnerReader.getPartner(product.getPartnerId());
        PartnerInfo.PartnerSimple partnerInfo = PartnerInfo.PartnerSimple.of(partner);

        return ProductResponse.ProductDetail.builder()
                .product(productInfo)
                .partner(partnerInfo)
                .build();
    }
}
