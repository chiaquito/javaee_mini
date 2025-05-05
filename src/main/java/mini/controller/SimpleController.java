package mini.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

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
    public String get() {
        try {
            return usecase.get();
        }catch(RuntimeException e) {
            return e.toString();
        }
    }
}