package mini.domain.repository;

import java.sql.SQLException;
import java.util.List;

import mini.domain.model.Simple;

public interface SimpleRepository {
    // get all items
    public List<Simple> findAll() throws SQLException;
    // retrieve simple by id
    public Simple getById(Integer id);
}