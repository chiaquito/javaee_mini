package mini.config.application.javaee;

import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;
import javax.ws.rs.core.Application;

import mini.config.db.mysql.MySQLConfig;
import mini.controller.HealthController;
import mini.controller.CompaniesController;
import mini.controller.CompanyByIdController;
import mini.controller.CompanyCreateController;
import mini.controller.SimpleController;
import mini.controller.SimpleListController;
import mini.domain.repository.CompanyRepository;
import mini.domain.repository.SimpleRepository;
import mini.infrastracture.repository.mysql.CompanyRepositoryImpl;
import mini.infrastracture.repository.mysql.SimpleRepositoryImpl;
import mini.usecase.CompanyUsecaseImpl;
import mini.usecase.CompanyUsecase;
import mini.usecase.SimpleUsecase;
import mini.usecase.SimpleUsecaseImpl;


@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    private final Set<Object> singletons = new HashSet<>();

    public ApplicationConfig() {

        DataSource ds = MySQLConfig.getDataSource();
        
        SimpleRepository simpleRepo = new SimpleRepositoryImpl(ds);
        CompanyRepository companyRepo = new CompanyRepositoryImpl(ds);
        SimpleUsecase simpleUsecase = new SimpleUsecaseImpl(simpleRepo);
        CompanyUsecase companyUsecase = new CompanyUsecaseImpl(companyRepo);

        singletons.add(new HealthController());
        singletons.add(new SimpleListController(simpleUsecase));
        singletons.add(new SimpleController(simpleUsecase));
        singletons.add(new CompaniesController(companyUsecase));
        singletons.add(new CompanyByIdController(companyUsecase));
        singletons.add(new CompanyCreateController(companyUsecase));
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}