package com.attendance_tracker.rest.endpoint.impl;

import com.attendance_tracker.rest.endpoint.InfoEndpoint;
import com.attendance_tracker.rest.endpoint.dto.InfoDto;

public class InfoEndpointImpl implements InfoEndpoint {

    @Override
    public InfoDto info() {
        return new InfoDto();
    }
}
