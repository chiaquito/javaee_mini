package mini.domain.model;

public class Company {
    public Integer id;
    public String name;
    public String establishedDate;
    public Integer version;
    public String createdAt; // Datetime
    public Integer createdUserId;
    public String updatedAt; // Datetime
    public Integer updatedUserId;


    public Company(Integer id, String name, String establishedDate, Integer version, String createdAt, Integer createdUserId, String updatedAt, Integer updatedUserId) {
        this.id = id;
        this.name = name;
        this.establishedDate = establishedDate;
        this.version = version;
        this.createdAt = createdAt;
        this.createdUserId = createdUserId;
        this.updatedAt = updatedAt;
        this.updatedUserId = updatedUserId;
    }


    public Integer getId(){
           return this.id;
    };
    public void setId(Integer id){
        this.id = id;   
    };

    public String getName(){
        return this.name;
    };
    public void setName(String name){
        this.name = name;   
    };

    public String getEstablishedDate(){
        return this.establishedDate;
    };
    public void setEstablishedDate(String establishedDate){
        this.establishedDate = establishedDate;   
    };

    public Integer getVersion(){
        return this.version;
     };
     public void setVersion(Integer version){
     this.version = version;   
     };

    public String getCreatedAt(){
        return this.createdAt;
    };
    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;   
    };


}
