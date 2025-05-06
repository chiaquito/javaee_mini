package mini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.Path;

import mini.model.Simple;
import mini.usecase.SimpleUsecase;



@Path("/simple")
@RequestScoped
public class SimpleController {

    @Inject
    SimpleUsecase usecase;
    
    // cdiを使う場合には引数なしのコンストラクタを書いておく必要がある
    // public SimpleController(SimpleUsecase uc) {
    //     this.usecase=uc;
    // }
    public SimpleController() {}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Simple> get() {
        try {
            return usecase.get();
        }catch(RuntimeException e) {
            throw new WebApplicationException(
            Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"" + e.getMessage() + "\"}")
                    .type(MediaType.APPLICATION_JSON)
                    .build()
            );
        }
    }
}