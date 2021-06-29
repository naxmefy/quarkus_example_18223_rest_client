package org.acme.working;

import java.io.IOException;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class CustomClientRequestFilter implements ClientRequestFilter {

    @ConfigProperty(name = "greeting")
    String greeting;

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("X-request-uuid", UUID.randomUUID().toString());
        requestContext.getHeaders().add("X-greeting", greeting);
    }
    
}
