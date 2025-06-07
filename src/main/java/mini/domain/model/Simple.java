package mini.domain.model;

public class Simple {
    public Integer id;
    public String name;

    public void setId(Integer id){
        this.id = id;   
    };

    public void setName(String name){
        this.name = name;   
    };

    public Simple(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
