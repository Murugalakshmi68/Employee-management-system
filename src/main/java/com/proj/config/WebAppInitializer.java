package com.proj.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Spring config file
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // URL mapping
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
