package mini.usecase;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.management.RuntimeErrorException;

import mini.model.Simple;
import mini.repository.SimpleRepository;
// import mini.repository.SimpleRepositoryImpl;

@RequestScoped
public class SimpleUsecaseImpl implements SimpleUsecase{

    // @Inject
    // SimpleRepositoryImpl repo;
    @Inject
    SimpleRepository repo;
    
    // public SimpleUsecase(SimpleRepositoryImpl repo) {
    //     this.repo=repo;
    // }
    public SimpleUsecaseImpl() {}

    public List<Simple> get() throws RuntimeErrorException{

        // cdiをする場合には、自分でインスタンス化する必要はない
        // SimpleRepositoryImpl repo = new SimpleRepositoryImpl();

        try {
            return repo.findAll();            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
