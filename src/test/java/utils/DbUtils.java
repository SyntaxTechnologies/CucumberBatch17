package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {
    public static List<Map<String,String>> fetch(String query){
        List<Map<String, String>> tableData = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER_NAME, Constants.PASSWORD);) {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                Map<String, String> rowMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String key=rsmd.getColumnName(i);
                    String value=rs.getString(i);
                    rowMap.put(key,value);
                }
                tableData.add(rowMap);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableData;

    }
}
