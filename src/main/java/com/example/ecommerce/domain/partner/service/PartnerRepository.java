package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.entity.partner.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
    @Query("select count(p) from Partner p where p.profile.name = :name")
    boolean existsByName(@Param("name") String name);
}
