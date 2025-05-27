package mini.usecase.simple;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.management.RuntimeErrorException;

import mini.domain.model.Simple;
import mini.domain.repository.SimpleRepository;
import mini.usecase.output.SimpleOutput;

@RequestScoped
public class SimpleUsecaseImpl implements SimpleUsecase{

    SimpleRepository repo;
    
    public SimpleUsecaseImpl(SimpleRepository repo) {
        this.repo=repo;
    }

    public List<Simple> get() throws RuntimeErrorException{

        try {
            List<Simple> models = repo.findAll();
            List<Simple> output = SimpleOutput.toSimpleResponse(models);
            return output;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
