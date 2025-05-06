package mini.usecase.response;

import java.util.ArrayList;
import java.util.List;

import mini.model.Simple;

public class SimpleResponse {
    static public List<Simple> toSimpleResponse(List<Simple> models) {
        List<Simple> res = new ArrayList<Simple>(models.size());
        for  (int i = 0; i < models.size(); i++) {
            Simple m = models.get(i);
            m.id = 2;
            res.add(m);
        }
        return res;
    }
}
