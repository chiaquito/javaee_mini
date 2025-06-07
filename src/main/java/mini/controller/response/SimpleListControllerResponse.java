package mini.controller.response;

import java.util.List;

import javax.ws.rs.core.Response;

import mini.usecase.output.SimpleOutput;

public class SimpleListControllerResponse  {
    public static Response toResponse(List<SimpleOutput> outputs) {
        return Response.status(Response.Status.OK).entity(outputs).build();
    }
}
