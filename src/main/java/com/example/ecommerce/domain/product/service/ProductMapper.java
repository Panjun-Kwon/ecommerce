package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.api.product.response.RetrieveProductDetail;
import com.example.ecommerce.api.product.response.RetrieveProductList;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.product.entity.product.Product;

import java.util.List;

public interface ProductMapper {
    RetrieveProductDetail.ProductInfo retrieveDetailOf(Product product, Partner partner);

    List<RetrieveProductList.ProductInfo> retrieveListOf(List<Product> content);
}
