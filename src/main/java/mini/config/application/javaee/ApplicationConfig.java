package mini.config.application.javaee;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import mini.controller.simple.SimpleController;
import mini.domain.repository.SimpleRepository;
import mini.infrastracture.repository.mysql.SimpleRepositoryImpl;

import mini.usecase.simple.SimpleUsecaseImpl;
import mini.usecase.simple.SimpleUsecase;


@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    private final Set<Object> singletons = new HashSet<>();

    public ApplicationConfig() {

        SimpleRepository repository = new SimpleRepositoryImpl();
        SimpleUsecase useCase = new SimpleUsecaseImpl(repository);
        SimpleController controller = new SimpleController(useCase);

        singletons.add(controller);
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}