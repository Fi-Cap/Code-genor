package generator;

import java.util.function.ToIntFunction;
import java.util.regex.*;
import generator.Addons.Addon;

public class loader {
    /*
     */
    String Version = "Alpha-1.0.0";

    public loader() {

    }

    private int equal_Version(String version) {
        /* 
         * @ version 1.0.0
         * @ author Fi_Cap
         * @ github url ""
         * @ Description This is a method to equal the version of the loader with the given version
         * if the loader version is lower than the addon version，then return -1
         * if the loader version is as the addon as version，then return 0
         * if the loader version is high than the addon version，then return 1
         * and if version is error,return -2
         */
        String pattern = "^[a|b|r][a|b|e|h|l|p|r-t]{4,6}";
        Pattern r = Pattern.compile(pattern);
        Matcher m1 = r.matcher(Version);
        Matcher m2 = r.matcher(version);
        int i1 = Integer.parseInt (m1.group("g"));
        int i2 = Integer.parseInt(m2.group("g"));

        if (i1 == 0 || i2 == 0) return -2;
        if (i1 < i2) {
            return -1;
        }
        int returnValue = -2;
        returnValue = i1 < i2 ? -1 : -2;
        returnValue = i1 == i2 ? 0 : -2;
        returnValue = i1 > i2 ? 1 : -2;
        return returnValue;
        
    }
    public void loading(Addon addon) {
        
    }

    private int VersionCheck(String version) {
        equal_Version(version);

    }
    
}
