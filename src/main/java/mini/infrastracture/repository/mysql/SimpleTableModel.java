package mini.infrastracture.repository.mysql;

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
}
