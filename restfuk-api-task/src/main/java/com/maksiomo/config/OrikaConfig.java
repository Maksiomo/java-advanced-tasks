package com.maksiomo.config;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.maksiomo.mapper.converters.StringToLocalDateConverter;

@Slf4j
@Configuration
@EnableConfigurationProperties(OrikaProperties.class)
public class OrikaConfig {
    @Bean
    public MapperFactory mapperFactory(OrikaProperties properties) {
        log.info("{}", properties);
        MapperFactory factory = new DefaultMapperFactory.Builder()
                .mapNulls(properties.getMapNulls())
                .build();

        ConverterFactory converterFactory = factory.getConverterFactory();
        converterFactory.registerConverter(StringToLocalDateConverter.CONVERTER_CODE,
                new StringToLocalDateConverter());
        return factory;
    }
}
