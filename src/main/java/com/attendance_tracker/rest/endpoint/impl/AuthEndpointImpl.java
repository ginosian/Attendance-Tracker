package com.attendance_tracker.rest.endpoint.impl;

import com.attendance_tracker.facade.authentication.AuthenticationFacade;
import com.attendance_tracker.mapper.BeanMapper;
import com.attendance_tracker.rest.endpoint.AuthEndpoint;
import com.attendance_tracker.rest.endpoint.dto.AuthRequestDto;
import com.attendance_tracker.rest.endpoint.dto.AuthResponseDto;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthEndpointImpl implements AuthEndpoint {

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private BeanMapper mapper;

    @Override
    public AuthResponseDto login(final AuthRequestDto requestDto) {
        return null;
    }
}
