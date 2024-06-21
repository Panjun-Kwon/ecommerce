package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.domain.member.command.*;
import com.example.ecommerce.domain.member.entity.member.*;

public interface MemberFactory {
    Member make(SignUpCommand command);
}
