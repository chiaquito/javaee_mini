package mini.controller;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mini.usecase.simple.SimpleUsecase;

import javax.ws.rs.Produces;
import javax.ws.rs.Path;



@Path("/simple")
@RequestScoped
public class SimpleController {

    @Inject
    SimpleUsecase usecase;
    
    public SimpleController() {}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        try {
            // todo: 使える形にしておく
            return Response.status(Response.Status.OK).entity(usecase.get()).build();
        } catch(RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }
}