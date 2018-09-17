package com.attendance_tracker.rest.endpoint.impl;

import com.attendance_tracker.rest.endpoint.InfoEndpoint;
import com.attendance_tracker.rest.endpoint.dto.InfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfoEndpointImpl implements InfoEndpoint {

    private final static Logger logger = LoggerFactory.getLogger(InfoEndpointImpl.class);

    @Override
    public InfoDto info() {
        logger.info("Sending response from /info.");
        return new InfoDto("Info Works great!");
    }
}
