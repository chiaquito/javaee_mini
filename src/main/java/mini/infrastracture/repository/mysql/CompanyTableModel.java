package mini.infrastracture.repository.mysql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mini.domain.model.Company;

public class CompanyTableModel {
    private Integer id;
    private String name;
    private String establishedDate;
    private Integer version;
    private String createdAt; // Datetime
    private Integer createdUserId;
    private String updatedAt; // Datetime
    private Integer updatedUserId;

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

    public Integer getCreatedUserId(){
        return this.createdUserId;
    };
    
    public void setCreatedUserId(Integer createdUserId){
        this.createdUserId = createdUserId;   
    };

    public String getUpdatedAt(){
        return this.updatedAt;
    };

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;   
    };

    public Integer getUpdatedUserId(){
        return this.updatedUserId;
    };

    public void setUpdatedUserId(Integer updatedUserId){
        this.updatedUserId = updatedUserId;   
    };

    public static Company toModel(CompanyTableModel company){
        return new Company(
            company.getId(), company.getName(), company.getEstablishedDate(), 
            company.getVersion(), company.getCreatedAt(), company.getCreatedUserId(), 
            company.getUpdatedAt(), company.getUpdatedUserId()
            );
    }

    public static List<Company> toModels(List<CompanyTableModel> companies){
        Company[] models = new Company[companies.size()];
        for (int i = 0; i < companies.size(); i++) {
            models[i] = toModel(companies.get(i));
        }
        return Arrays.asList(models);
    }

}
