package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.entity.partner.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
    boolean existsByName(String name);
}
