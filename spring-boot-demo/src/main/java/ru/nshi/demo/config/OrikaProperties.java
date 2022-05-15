package ru.nshi.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author rassafel
 */
@Data
@ConfigurationProperties(prefix = "orika")
public class OrikaProperties {
    private Boolean mapNulls = false;
    private String name;
}
