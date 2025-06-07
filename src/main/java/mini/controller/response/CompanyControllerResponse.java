package mini.controller.response;

import java.util.List;

import javax.ws.rs.core.Response;

import mini.usecase.output.CompanyOutput;

public class CompanyControllerResponse  {
    public static Response toResponse(List<CompanyOutput> outputs) {
        return Response.status(Response.Status.OK).entity(outputs).build();
    }

    public static Response toCompanyResponse(CompanyOutput output) {
        return Response.status(Response.Status.OK).entity(output).build();
    }
}
