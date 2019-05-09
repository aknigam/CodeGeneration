package com.codegen.CodeGeneration;


import com.codegen.CodeGeneration.resource.VendorResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
    }

    @PostConstruct
    public void setUp() {
        register(VendorResource.class);
    }

}
