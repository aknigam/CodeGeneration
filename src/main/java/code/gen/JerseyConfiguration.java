package code.gen;


import code.gen.exception.ValidationExceptionMapper;
import code.gen.written.entities.DeliveryAgent;
import code.gen.written.resources.DeliveryAgentResource;
import code.gen.written.resources.VendorResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Component
@MapperScan("code.gen.repository.mapper")
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
    }

    @PostConstruct
    public void setUp() {
        register(code.gen.resources.VendorResource.class);
        register(code.gen.resources.DeliveryAgentResource.class);

        register(ValidationExceptionMapper.class);

    }




}
