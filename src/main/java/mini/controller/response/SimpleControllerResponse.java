package mini.controller.response;

import javax.ws.rs.core.Response;

import mini.usecase.output.SimpleOutput;

public class SimpleControllerResponse  {
    public static Response toResponse(SimpleOutput output) {
        return Response.status(Response.Status.OK).entity(output).build();
    }
}
