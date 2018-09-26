package com.attendance_tracker.rest.config;

import com.attendance_tracker.rest.endpoint.impl.InfoEndpointImpl;
import com.attendance_tracker.rest.endpoint.impl.KeycloakEndpointImpl;
import com.attendance_tracker.rest.endpoint.impl.OwnerEndpointImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("")
public class JerseyConfig extends ResourceConfig{

    @Value("${api.mountPath}")
    private String mountPath;

    public JerseyConfig() {
        configEndpoints();
    }

    private void configEndpoints(){
        this.register(MultiPartFeature.class);
        JacksonJsonProvider jacksonJsonProvider =
                new JacksonJaxbJsonProvider()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.register(jacksonJsonProvider);
        this.property("jersey.config.beanValidation.enableOutputValidationErrorEntity.server", false);
        this.property("jersey.config.disableAutoDiscovery", true);

        EncodingFilter.enableFor(this, GZipEncoder.class);
        // Endpoints
        register(InfoEndpointImpl.class);
        register(OwnerEndpointImpl.class);
        register(KeycloakEndpointImpl.class);
    }
}
