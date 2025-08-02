package mini.controller;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mini.config.EnvLoader;
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
            return Response.ok(String.format("Application is healthy %s", EnvLoader.getEnv().get("testVariable"))).build();
        } catch (RuntimeException e) {
            return ErrorResponse.toResponse(Response.Status.INTERNAL_SERVER_ERROR, e);
        }
    }
}
