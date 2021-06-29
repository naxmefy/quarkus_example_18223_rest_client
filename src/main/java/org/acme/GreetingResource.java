package org.acme;

import java.util.Objects;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-resteasy")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@HeaderParam("X-greeting") String greeting) {
        if (Objects.isNull(greeting)) throw new BadRequestException();
        return "Hello RESTEasy (" + greeting + ")";
    }
}