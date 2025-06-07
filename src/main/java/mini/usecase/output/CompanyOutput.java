package mini.usecase.output;

import java.util.ArrayList;
import java.util.List;

import mini.domain.model.Company;

public class CompanyOutput {
    
    private Integer id;
    private String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    CompanyOutput(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CompanyOutput toCompanyOutput(Company model) {
        return new CompanyOutput(model.id, model.name);
    }

    public static List<CompanyOutput> toSimpleOutputs(List<Company> models) {
        List<CompanyOutput> res = new ArrayList<CompanyOutput>(models.size());
        for (int i = 0; i < models.size(); i++) {
            res.add(toCompanyOutput(models.get(i)));
        }
        return res;
    }
}
