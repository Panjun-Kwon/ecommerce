package com.example.ecommerce.domain.member.entity.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "members")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;
    @Embedded
    private Address address;

    @Builder
    private Member(String username, Address address) {
        this.username = username;
        this.address = address;
    }
}
