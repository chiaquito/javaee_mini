package mini.domain.repository;

import java.sql.SQLException;
import java.util.List;

import mini.domain.model.Simple;

public interface SimpleRepository {
    List<Simple> findAll() throws SQLException;
}