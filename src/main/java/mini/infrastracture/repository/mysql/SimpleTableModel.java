package mini.infrastracture.repository.mysql;

import java.util.Arrays;
import java.util.List;

import mini.domain.model.Company;
import mini.domain.model.Simple;

public class SimpleTableModel {
    public Integer id;
    public String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;   
    };

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;   
    };

    public static Simple toModel(SimpleTableModel record) {
        return new Simple(record.getId(), record.getName());
    }

    public static List<Simple> toModels(List<SimpleTableModel> simples){
        Simple[] models = new Simple[simples.size()];
        for (int i = 0; i < simples.size(); i++) {
            models[i] = toModel(simples.get(i));
        }
        return Arrays.asList(models);
    }
}
