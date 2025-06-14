package mini.controller.request;

import java.util.Objects;

import mini.common.error.InvalidParameterValueError;

public class CompanyCreateRequest {
    private String name;
    private String establishedDate;
    private int createdUserId;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEstablishedDate(){
        return this.establishedDate;
    }

    public void setEstablishedDate(String establishedDate){
        this.establishedDate = establishedDate;
    }

    public int getCreatedUserId(){
        return this.createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId){
        this.createdUserId = createdUserId;
    }

    public CompanyCreateRequest(){

    }

    public CompanyCreateRequest(String name, String establishedDate, Integer createdUserId){
        System.out.println(establishedDate);
        if (Objects.isNull(name)){
            throw new InvalidParameterValueError("name", name);
        }
        if (Objects.isNull(establishedDate)){
            throw new InvalidParameterValueError("establishedDate", establishedDate);
        }
        if (Objects.isNull(createdUserId)){
            throw new InvalidParameterValueError("createUserId", String.valueOf(createdUserId));
        }
        this.name = name;
        this.establishedDate = establishedDate;
        this.createdUserId = createdUserId;
    }
}
