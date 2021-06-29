package org.acme.broken;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MultivaluedMap;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

@ApplicationScoped
public class CustomClientHeadersFactory implements ClientHeadersFactory {

    @ConfigProperty(name = "greeting")
    String greeting;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> arg0,
            MultivaluedMap<String, String> arg1) {
        MultivaluedMap<String, String> result = new MultivaluedMapImpl<>();
        result.add("X-request-uuid", UUID.randomUUID().toString());
        result.add("X-greeting", greeting);
        return result;
    }

}