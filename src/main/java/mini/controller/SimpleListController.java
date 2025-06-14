package mini.controller;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

import mini.controller.response.ErrorResponse;
import mini.controller.response.SimpleListControllerResponse;
import mini.usecase.SimpleUsecase;
import mini.usecase.output.SimpleOutput;

@Path("/simple")
@RequestScoped
public class SimpleListController {

    SimpleUsecase usecase;
    
    public SimpleListController(SimpleUsecase useCase) {
        this.usecase = useCase;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response simpleList() {
        try {
            List<SimpleOutput> output = usecase.find();
            return SimpleListControllerResponse.toResponse(output);

        } catch(RuntimeException e) {
            return ErrorResponse.toResponse(Response.Status.BAD_REQUEST, e);
        }
    }
}