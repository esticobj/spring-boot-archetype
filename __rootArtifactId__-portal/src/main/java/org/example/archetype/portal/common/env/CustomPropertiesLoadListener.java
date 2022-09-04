package org.example.archetype.portal.common.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CustomPropertiesLoadListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
        Resource[] resources;
        try {
            resources = resourceLoader.getResources("classpath:/properties/*.properties");
            for (Resource resource : resources) {
                EncodedResource encodedResource = new EncodedResource(resource, StandardCharsets.UTF_8);
                ResourcePropertySource resourcePropertySource = new ResourcePropertySource(encodedResource);
                propertySources.addLast(resourcePropertySource);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 30;
    }
}
