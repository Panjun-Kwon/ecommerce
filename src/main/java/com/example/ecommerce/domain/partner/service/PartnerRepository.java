package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.entity.partner.*;
import org.springframework.data.jpa.repository.*;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
    boolean existsByProfileName(String name);
}
