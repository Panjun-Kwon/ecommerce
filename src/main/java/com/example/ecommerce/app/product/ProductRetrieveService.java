package com.example.ecommerce.app.product;

import com.example.ecommerce.api.product.dto.ProductResponse;
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

    public ProductResponse.ProductList retrieveProductList(Pageable pageable) {
        Page<Product> productPage = productReader.getProductAll(pageable);

        List<ProductInfo.ProductList> infoList = productPage.stream()
                .map(product -> ProductInfo.ProductList.of(product))
                .collect(Collectors.toList());

        return ProductResponse.ProductList.builder()
                .productList(infoList)
                .currentElements(productPage.getNumberOfElements())
                .totalPages(productPage.getTotalPages())
                .totalElements(productPage.getTotalElements())
                .build();
    }

    public ProductResponse.ProductDetail retrieveProductDetail(Long productId) {
        Product product = productReader.getProduct(productId);

        ProductInfo.ProductDetail info = ProductInfo.ProductDetail.of(product);

        return ProductResponse.ProductDetail.builder()
                .product(info)
                .build();
    }
}
