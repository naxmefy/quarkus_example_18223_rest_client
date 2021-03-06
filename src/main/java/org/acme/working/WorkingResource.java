package org.acme.working;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/working")
public class WorkingResource {
    @Inject
    @RestClient
    WorkingAPI api;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response working() {
        return Response.ok().entity(api.sub().hello()).build();
    }
}
