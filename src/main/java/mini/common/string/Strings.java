package mini.common.string;

import org.apache.commons.lang3.StringUtils;

public class Strings {
    
    public static boolean exists(String str) {
        return !StringUtils.isEmpty(str);
    }
}
