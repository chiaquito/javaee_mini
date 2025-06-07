package mini.usecase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import mini.domain.model.Company;
import mini.domain.repository.CompanyRepository;
import mini.usecase.input.CompanyInput;
import mini.usecase.output.CompanyOutput;

public class CompanyUsecaseImpl implements CompanyUsecase{
 
    CompanyRepository repo;
    
    public CompanyUsecaseImpl(CompanyRepository repo) {
        this.repo=repo;
    }

    public List<CompanyOutput> find() throws RuntimeErrorException{

        List<Company> models = new ArrayList<>();
        try {
            models = repo.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        List<CompanyOutput> output = CompanyOutput.toSimpleOutputs(models);
        return output;
    }

    public CompanyOutput getById(CompanyInput input) throws RuntimeErrorException{
        Company model = repo.getById(input.getId());

        CompanyOutput output = CompanyOutput.toCompanyOutput(model);
        return output;
    };
    
}
