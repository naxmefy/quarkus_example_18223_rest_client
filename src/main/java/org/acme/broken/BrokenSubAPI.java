package org.acme.broken;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;

@Produces(MediaType.TEXT_PLAIN)
public interface BrokenSubAPI {
    @GET
    String hello();
}
