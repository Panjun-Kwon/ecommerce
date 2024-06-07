package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.domain.member.entity.member.Member;

public interface MemberStore {
    Member store(Member initMember);
}
