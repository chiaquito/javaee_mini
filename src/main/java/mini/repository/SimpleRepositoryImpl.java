package mini.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import mini.config.DataBase;
import mini.model.Simple;
import mini.usecase.response.SimpleResponse; 

@RequestScoped
public class SimpleRepositoryImpl implements SimpleRepository {

    @Override
    public List<Simple> findAll() throws SQLException {

        String sql = "SELECT id, name FROM company";
        try (Connection conn = DataBase.getDataSource().getConnection()) {
            QueryRunner runner = new QueryRunner();
            
            List<Simple> simples = runner.query(conn, sql, new BeanListHandler<>(Simple.class));
            List<Simple> res = SimpleResponse.toSimpleResponse(simples);
            return res;
        }
    }
}