package mini.controller;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import mini.controller.response.ErrorResponse;
import mini.controller.response.SimpleControllerResponse;
import mini.usecase.SimpleUsecase;
import mini.usecase.input.SimpleInput;
import mini.usecase.output.SimpleOutput;



@Path("/simple")
@RequestScoped
public class GetSimpleController {

    SimpleUsecase usecase;
    
    public GetSimpleController(SimpleUsecase useCase) {
        this.usecase = useCase;
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response simpleList(@PathParam("id") String id ) {
        SimpleInput input = new SimpleInput();

        try {
            input.id = Integer.parseInt(id); 
        } catch(NumberFormatException e) {
            return ErrorResponse.toResponse(Response.Status.BAD_REQUEST, new Exception("idが数値ではありません："+e.getMessage()));
        }
        SimpleOutput output = usecase.getById(input);
        return SimpleControllerResponse.toResponse(output);
    }
}