package org.acme.broken;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@ApplicationScoped
@RegisterRestClient
@RegisterClientHeaders(CustomClientHeadersFactory.class)
@Produces(MediaType.TEXT_PLAIN)
public interface BrokenAPI {
    @GET
    @Path("/hello-resteasy")
    String hello();

    @Path("/hello-resteasy")
    BrokenSubAPI sub();
}
