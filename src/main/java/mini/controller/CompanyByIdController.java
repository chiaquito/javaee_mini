package mini.controller;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mini.controller.request.CompanyRequest;
import mini.controller.response.ErrorResponse;
import mini.controller.response.CompanyControllerResponse;
import mini.usecase.CompanyUsecase;
import mini.usecase.input.CompanyInput;
import mini.usecase.output.CompanyOutput;

import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/company")
@RequestScoped
public class CompanyByIdController {
    CompanyUsecase usecase;
    
    public CompanyByIdController(CompanyUsecase useCase) {
        this.usecase = useCase;
    }
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response companybyId(@PathParam("id") Integer id) {

        CompanyRequest req = new CompanyRequest(id);
        CompanyInput input = req.toCompanyInput();
        try {
            CompanyOutput output = usecase.getById(input);
            return CompanyControllerResponse.toCompanyResponse(output);

        } catch(RuntimeException e) {
            return ErrorResponse.toResponse(Response.Status.BAD_REQUEST, e);
        }        
    }
}
