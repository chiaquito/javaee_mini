package mini.repository;

import java.sql.SQLException;
import java.util.List;

import mini.model.Simple;

public interface SimpleRepository {
    List<Simple> findAll() throws SQLException;
}