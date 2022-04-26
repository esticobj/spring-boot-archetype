package org.example.archetype.common.env;

import org.example.archetype.common.exception.CommonErrorCode;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.LinkedHashMap;
import java.util.Map;

public class ErrorCodeEnumPropertiesLoadListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        Map<String, Object> errorCodeMap = new LinkedHashMap<>();
        for (CommonErrorCode value : CommonErrorCode.values()) {
            errorCodeMap.put(value.getCode(), value.getDesc());
        }
        MapPropertySource mapPropertySource = new MapPropertySource("errorCodeEnumProperties", errorCodeMap);
        environment.getPropertySources().addLast(mapPropertySource);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 40;
    }
}
