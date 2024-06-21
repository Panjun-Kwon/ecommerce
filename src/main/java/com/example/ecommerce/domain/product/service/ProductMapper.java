package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.api.product.response.*;
import com.example.ecommerce.domain.partner.entity.partner.*;
import com.example.ecommerce.domain.product.entity.product.*;

import java.util.*;

public interface ProductMapper {
    RetrieveProductDetail.ProductInfo retrieveDetailOf(Product product, Partner partner);

    List<RetrieveProductList.ProductInfo> retrieveListOf(List<Product> content);
}
