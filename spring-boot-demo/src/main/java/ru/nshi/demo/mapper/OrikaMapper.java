package ru.nshi.demo.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author rassafel
 */
public abstract class OrikaMapper {

    @Autowired
    protected MapperFactory mapperFactory;

    public abstract void configure(MapperFactory mapperFactory);

    @PostConstruct
    protected void init() {
        configure(mapperFactory);
    }

}
