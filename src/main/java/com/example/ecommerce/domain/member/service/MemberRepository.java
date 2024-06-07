package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.domain.member.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUsername(String username);
}
