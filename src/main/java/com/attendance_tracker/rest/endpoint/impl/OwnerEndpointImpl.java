package com.attendance_tracker.rest.endpoint.impl;

import com.attendance_tracker.rest.endpoint.OwnerEndpoint;
import com.attendance_tracker.rest.endpoint.dto.InfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OwnerEndpointImpl implements OwnerEndpoint {

    private final static Logger logger = LoggerFactory.getLogger(OwnerEndpointImpl.class);

    @Override
    public InfoDto owner() {
        logger.info("Sending response from /owner.");
        return new InfoDto("Owner works great");
    }
}
