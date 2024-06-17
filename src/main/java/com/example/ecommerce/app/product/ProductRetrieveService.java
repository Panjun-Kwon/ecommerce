package com.example.ecommerce.app.product;

import com.example.ecommerce.api.product.response.RetrieveProductDetail;
import com.example.ecommerce.api.product.response.RetrieveProductList;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerReader;
import com.example.ecommerce.domain.product.entity.product.Product;
import com.example.ecommerce.domain.product.service.ProductMapper;
import com.example.ecommerce.domain.product.service.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductRetrieveService {

    private final ProductReader productReader;
    private final PartnerReader partnerReader;
    private final ProductMapper productMapper;

    public RetrieveProductDetail retrieveProductDetail(Long productId) {
        Product product = productReader.getProduct(productId);
        Partner partner = partnerReader.getPartner(product.getRegistrant().getPartnerId());

        RetrieveProductDetail.ProductInfo productInfo = productMapper.retrieveDetailOf(product, partner);

        return new RetrieveProductDetail(productInfo);
    }

    public RetrieveProductList retrieveProductList(Pageable pageable) {
        Page<Product> productPage = productReader.getProductAll(pageable);
        List<RetrieveProductList.ProductInfo> productInfoList = productMapper.retrieveListOf(productPage.getContent());

        RetrieveProductList.PageInfo pageInfo = makePageInfo(productPage);

        return new RetrieveProductList(productInfoList, pageInfo);
    }

    private static RetrieveProductList.PageInfo makePageInfo(Page<Product> productPage) {
        return RetrieveProductList.PageInfo.builder()
                .currentElements(productPage.getNumberOfElements())
                .totalPages(productPage.getTotalPages())
                .totalElements(productPage.getTotalElements())
                .build();
    }
}
