package mini.usecase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.management.RuntimeErrorException;

import mini.domain.model.Simple;
import mini.domain.repository.SimpleRepository;
import mini.usecase.input.SimpleInput;
import mini.usecase.output.SimpleOutput;

@RequestScoped
public class SimpleUsecaseImpl implements SimpleUsecase{

    SimpleRepository repo;
    
    public SimpleUsecaseImpl(SimpleRepository repo) {
        this.repo=repo;
    }

    public List<SimpleOutput> find() throws RuntimeErrorException{

        List<Simple> models = new ArrayList<>();
        try {
            models = repo.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        List<SimpleOutput> output = SimpleOutput.toSimpleOutputs(models);
        return output;
    }

    public SimpleOutput getById(SimpleInput input) throws RuntimeErrorException{
        Simple model = repo.getById(input.id);        
        SimpleOutput output = SimpleOutput.toSimpleOutput(model);
        return output;
    }
}
