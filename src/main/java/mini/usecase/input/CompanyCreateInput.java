package mini.usecase.input;

import java.util.Objects;

import mini.common.error.BusinessError;

public class CompanyCreateInput {
    private String name;
    private String establishedDate;
    private int createUserId;

    public String getName() {
        return this.name;
    }
    
    public String getEstablishedDate() {
        return this.establishedDate;
    }

    public Integer getCreateUserId() {
        return this.createUserId;
    }


    public CompanyCreateInput(String name, String establishedDate, Integer createUserId){
        if (Objects.isNull(name)) {
            throw new BusinessError("name cannot accept null");
        }
        if (Objects.isNull(establishedDate)) {
            System.out.printf("here input context", establishedDate);
            throw new BusinessError("establishedDate cannot accept null");
        }
        if (Objects.isNull(createUserId)) {
            throw new BusinessError("createUserId cannot accept null");
        }
        this.name = name;
        this.establishedDate = establishedDate;
        this.createUserId = createUserId;
    }
}
