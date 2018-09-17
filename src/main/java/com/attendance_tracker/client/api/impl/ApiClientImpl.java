package com.attendance_tracker.client.api.impl;

import com.attendance_tracker.client.InfoResource;
import com.attendance_tracker.client.OwnerResource;
import com.attendance_tracker.client.api.ApiClient;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.filter.EncodingFilter;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.message.GZipEncoder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;

/**
 * @author Marta Ginosyan<br/>
 */

public class ApiClientImpl implements ApiClient {

    private static final String BASE_URL = "https://localhost:8080";

    private final Client client;

    private final InfoResource infoResource;
    private final OwnerResource ownerResource;

    public ApiClientImpl(final String apiUrl) {
        final ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule("apiErrorMapper", Version.unknownVersion());
        mapper.registerModule(module);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ClientConfig cc = new ClientConfig();
        cc.property(CommonProperties.FEATURE_AUTO_DISCOVERY_DISABLE, true);

        cc.register(GZipEncoder.class);
        cc.register(EncodingFilter.class);
        cc.register(new JacksonJsonProvider(mapper));

        client = ClientBuilder.newClient(cc);

        final WebTarget rootTarget = client.target(BASE_URL);

        infoResource = new InfoResource(client, rootTarget, mapper);
        ownerResource = new OwnerResource(client, rootTarget, mapper);
    }

    @Override
    public InfoResource info() {
        return infoResource;
    }

    @Override
    public OwnerResource owner() {
        return ownerResource;
    }

    @Override
    public void close() throws IOException {

    }
}
