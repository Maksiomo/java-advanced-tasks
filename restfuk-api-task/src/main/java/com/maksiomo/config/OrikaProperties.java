package com.maksiomo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "orika")
public class OrikaProperties {
    private Boolean mapNulls = false;
    private String name;
}
