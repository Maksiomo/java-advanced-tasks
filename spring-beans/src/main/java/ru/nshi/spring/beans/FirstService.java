package ru.nshi.spring.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author rassafel
 */

@Service
@Slf4j
public class FirstService implements InitializingBean {

    private final SecondService secondService;

    private ThirdComponent thirdComponent;

    public FirstService(SecondService secondService) {
        this.secondService = secondService;
        log.info("Called constructor");
    }

    @Autowired
    public void setThirdComponent(ThirdComponent thirdComponent) {
        this.thirdComponent = thirdComponent;
        log.info("Injecting component from setter");
    }

    @PostConstruct
    public void init(){
        log.info("Post construct method called");
    }

    public void go(){
        log.info("First service go");
    }

    @Override
    public void afterPropertiesSet() {
        log.info("afterPropertiesSet method go");
    }
}
