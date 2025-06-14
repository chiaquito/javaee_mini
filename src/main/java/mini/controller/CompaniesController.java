package mini.controller;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mini.controller.response.ErrorResponse;
import mini.controller.response.CompanyControllerResponse;
import mini.usecase.CompanyUsecase;
import mini.usecase.output.CompanyOutput;

import javax.ws.rs.Produces;
import javax.ws.rs.Path;



@Path("/company")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class CompaniesController {

    private CompanyUsecase usecase;
    
    public CompaniesController(CompanyUsecase usecase) {
        this.usecase = usecase;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanies() {
        try {
            List<CompanyOutput> output = usecase.find();
            return CompanyControllerResponse.toResponse(output);

        } catch(RuntimeException e) {
            return ErrorResponse.toResponse(Response.Status.BAD_REQUEST, e);
        }        
    }
}