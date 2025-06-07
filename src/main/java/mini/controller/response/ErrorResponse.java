package mini.controller.response;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

public class ErrorResponse {
    public static Response toResponse(StatusType status, Exception e){
        return Response.status(status).entity(e).build();
    }
}
