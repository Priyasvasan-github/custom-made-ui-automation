package utils;

import java.util.ResourceBundle;

/**
 * Created by Sripriya srinivasan on 07/03/2020.
 */
public class GetTestProperties {

    /**
     * This method returns the input values provided in config value
     * @param propName
     * @return the properties
     */
    public static String getValue(String propName){
        ResourceBundle properties =ResourceBundle.getBundle("test-keys");
        return properties.getString(propName);
    }
}
