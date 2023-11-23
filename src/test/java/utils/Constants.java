package utils;

public class Constants {

    public static final String CONFIGURATION_FILEPATH =
            System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 20;
    public static final String TESTDATA_FILEPATH =
            System.getProperty("user.dir")+"/src/test/resources/testdata/batch17excel.xlsx";
    public static final String SCREENSHOT_FILEPATH =
            System.getProperty("user.dir")+"/screenshots/";

    public static final String DB_URL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
    public static final String USER_NAME="syntax_hrm";
    public static final String PASSWORD="syntaxhrm123";
}
