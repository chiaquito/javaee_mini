package mini.usecase.output;


import java.util.ArrayList;
import java.util.List;

import mini.domain.model.Simple;


public class SimpleOutput {

    public Integer id;
    public String name;
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static  SimpleOutput toSimpleOutput(Simple model) {
        SimpleOutput res = new SimpleOutput();
        res.setId(model.id);
        res.setName(model.name);
        return res;
    }

    public static List<SimpleOutput> toSimpleOutputs(List<Simple> models) {
        List<SimpleOutput> res = new ArrayList<SimpleOutput>(models.size());
        for (int i = 0; i < models.size(); i++) {
            res.add(toSimpleOutput(models.get(i)));
        }
        return res;
    }
}



