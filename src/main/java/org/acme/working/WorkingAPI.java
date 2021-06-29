package org.acme.working;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@ApplicationScoped
@RegisterRestClient
@RegisterProvider(CustomClientRequestFilter.class)
@Produces(MediaType.TEXT_PLAIN)
public interface WorkingAPI {
    @GET
    @Path("/hello-resteasy")
    String hello();

    @Path("/hello-resteasy")
    WorkingSubAPI sub();
}
