package mini.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;

import mini.model.Simple; 

@RequestScoped
public class SimpleRepositoryImpl implements SimpleRepository {

    @Override
    public List<Simple> findAll() throws SQLException {
        List<Simple> products = new ArrayList<>();
        return products;
    }
}