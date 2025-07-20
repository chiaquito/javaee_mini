package mini.controller;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mini.controller.response.ErrorResponse;

import javax.ws.rs.Produces;
import javax.ws.rs.Path;

@Path("/health")
@RequestScoped
public class HealthController {

    public HealthController() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response healthCheck() {
        try {
            return Response.ok("Application is healthy").build();
        } catch (RuntimeException e) {
            return ErrorResponse.toResponse(Response.Status.INTERNAL_SERVER_ERROR, e);
        }
    }
}
