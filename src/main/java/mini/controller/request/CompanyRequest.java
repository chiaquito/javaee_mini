package mini.controller.request;

import mini.usecase.input.CompanyInput;

public class CompanyRequest {
    private Integer id;

    public CompanyRequest(Integer id){
        this.id = id;
    }

    public CompanyInput toCompanyInput() {
        return new CompanyInput(this.id);
    }
}
