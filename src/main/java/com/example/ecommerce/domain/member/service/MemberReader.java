package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.domain.member.entity.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberReader {
    Member getMember(Long memberId);

    Page<Member> getMemberAll(Pageable pageable);
}
