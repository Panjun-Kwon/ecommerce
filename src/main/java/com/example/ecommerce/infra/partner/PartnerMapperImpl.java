package com.example.ecommerce.infra.partner;

import com.example.ecommerce.api.partner.request.RegisterRequest;
import com.example.ecommerce.api.partner.response.RetrievePartnerDetail;
import com.example.ecommerce.api.partner.response.RetrievePartnerList;
import com.example.ecommerce.domain.partner.dto.RegisterCommand;
import com.example.ecommerce.domain.partner.entity.partner.Address;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PartnerMapperImpl implements PartnerMapper {
    @Override
    public RetrievePartnerDetail.PartnerInfo retrieveDetailOf(Partner partner) {
        RetrievePartnerDetail.PartnerInfo partnerInfo = RetrievePartnerDetail.PartnerInfo.builder()
                .id(partner.getId())
                .name(partner.getName())
                .build();

        return partnerInfo;
    }

    @Override
    public List<RetrievePartnerList.PartnerInfo> retrieveListOf(List<Partner> partnerList) {
        List<RetrievePartnerList.PartnerInfo> partnerInfoList = partnerList.stream()
                .map(partner -> RetrievePartnerList.PartnerInfo.builder()
                        .id(partner.getId())
                        .name(partner.getName())
                        .build())
                .collect(Collectors.toList());

        return partnerInfoList;
    }

    @Override
    public RegisterCommand commandOf(RegisterRequest request) {

        Address address = Address.builder()
                .city(request.getAddress() == null ? null : request.getAddress().getCity())
                .street(request.getAddress() == null ? null : request.getAddress().getStreet())
                .build();

        RegisterCommand command = RegisterCommand.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .name(request.getName())
                .phoneNum(request.getPhoneNum())
                .email(request.getEmail())
                .address(address)
                .build();

        return command;
    }
}
