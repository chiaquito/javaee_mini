package mini;

import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

@Path("/test")
public class RestTest {
    
    public RestTest() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        return "fafafawasa";
    }
}