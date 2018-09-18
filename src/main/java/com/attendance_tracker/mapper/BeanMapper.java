package com.attendance_tracker.mapper;


import com.attendance_tracker.facade.authentication.model.AuthenticationRequest;
import com.attendance_tracker.rest.endpoint.dto.AuthRequestDto;
import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Component
public class BeanMapper  extends ConfigurableMapper {
    private MapperFactory factory;

    private final List<Converter<?, ?>> converters;

    private final List<Mapper<?, ?>> mappers;

    @Autowired(required = false)
    public BeanMapper(
            final List<Converter<?, ?>> converters,
            final List<Mapper<?, ?>> mappers
    ) {
        super(false);

        this.converters = converters != null ? converters : Collections.emptyList();
        this.mappers = mappers != null ? mappers : Collections.emptyList();
    }

    @PostConstruct
    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void configure(final MapperFactory factory) {
        this.factory = factory;

        factory.classMap(AuthRequestDto.class, AuthenticationRequest.class)
                .field("password", "plainPassword")
                .byDefault()
                .register();

        addAllSpringBeans();
    }

    @Override
    protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
        // Nothing to configure for now
    }

    @SuppressWarnings("rawtypes")
    public void addMapper(final Mapper<?, ?> mapper) {
        factory.classMap(mapper.getAType(), mapper.getBType())
                .byDefault()
                .customize((Mapper) mapper)
                .register();
    }

    public void addConverter(final Converter<?, ?> converter) {
        factory.getConverterFactory().registerConverter(converter);
    }

    private void addAllSpringBeans() {
        mappers.forEach(this::addMapper);
        converters.forEach(this::addConverter);
    }
}
