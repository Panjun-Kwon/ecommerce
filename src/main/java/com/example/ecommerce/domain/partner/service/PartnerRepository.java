package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.entity.partner.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
    boolean existsByProfileName(String name);

    Optional<Partner> findByUsername(String username);
}
