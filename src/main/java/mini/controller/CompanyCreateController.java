package mini.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mini.controller.request.CompanyCreateRequest;
import mini.controller.response.ErrorResponse;
import mini.domain.SystemErrException;
import mini.usecase.CompanyUsecase;
import mini.usecase.input.CompanyCreateInput;
import mini.config.application.javaee.Context;
import mini.config.db.mysql.MySQLConfig;

@Path("/company")

public class CompanyCreateController {
    
    private CompanyUsecase usecase;
    
    public CompanyCreateController(CompanyUsecase usecase){
        this.usecase = usecase;
    }

    @RequestScoped
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response create(CompanyCreateRequest req){
        try (Connection conn = MySQLConfig.getDataSource().getConnection()) {

            conn.setAutoCommit(false);
            Context ctx = new Context(conn);

            CompanyCreateInput input = new CompanyCreateInput(req.getName(), req.getEstablishedDate(), req.getCreatedUserId());
            usecase.create(ctx, input);
            conn.commit();
            return Response.ok("success").build();
            
        } catch(SystemErrException err) {
            return ErrorResponse.toResponse(Response.Status.INTERNAL_SERVER_ERROR, err);
        } catch (SQLException err) {
            return ErrorResponse.toResponse(Response.Status.INTERNAL_SERVER_ERROR, err);
        }
    }

}
