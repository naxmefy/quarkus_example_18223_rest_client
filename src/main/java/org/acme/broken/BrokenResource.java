package org.acme.broken;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path("/broken")
public class BrokenResource {
    @Inject
    @RestClient
    BrokenAPI api;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response broken() {
        return Response.ok().entity(api.sub().hello()).build();
    }

    @GET
    @Path("/working")
    @Produces(MediaType.APPLICATION_JSON)
    public Response working() {
        return Response.ok().entity(api.hello()).build();
    }
}
