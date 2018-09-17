package com.attendance_tracker.client;

import com.attendance_tracker.client.api.AbstractApiResource;
import com.attendance_tracker.rest.endpoint.dto.InfoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class OwnerResource extends AbstractApiResource {

    private final Logger logger = LoggerFactory.getLogger(InfoResource.class);

    private ObjectMapper objectMapper;

    public OwnerResource(Client client, WebTarget rootTarget, ObjectMapper objectMapper) {
        super(client, rootTarget, "");
        this.objectMapper = objectMapper;
    }

    public InfoDto info() {
        return doGet("/owner", InfoDto.class);
    }
}
