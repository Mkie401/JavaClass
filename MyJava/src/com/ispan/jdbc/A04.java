package com.ispan.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ispan.apis.FarmData;

public class A04 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/iii";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");

        try {
            URL url1 = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
            URLConnection conn = url1.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();

            List<FarmData> farmList = parseJSON(sb.toString());

            String sqlInsert = """
                    INSERT INTO gift
                        (id, name, feature, city, town, addr, lat, lng, picurl)
                    VALUES
                        (?,?,?,?,?,?,?,?,?)
                    ON DUPLICATE KEY UPDATE
                        name=VALUES(name),
                        feature=VALUES(feature),
                        city=VALUES(city),
                        town=VALUES(town),
                        addr=VALUES(addr),
                        lat=VALUES(lat),
                        lng=VALUES(lng),
                        picurl=VALUES(picurl)
                    """;

            try (Connection conn1 = DriverManager.getConnection(url, prop);
                 PreparedStatement pstmt = conn1.prepareStatement(sqlInsert)) {

                int count = 0;

                for (FarmData farm : farmList) {
                    pstmt.setString(1, farm.id);
                    pstmt.setString(2, farm.name);
                    pstmt.setString(3, farm.feature);
                    pstmt.setString(4, farm.city);
                    pstmt.setString(5, farm.town);
                    pstmt.setString(6, farm.addr);

                    // 處理 lat
                    if (farm.lat == null || farm.lat.trim().isEmpty()) {
                        pstmt.setNull(7, java.sql.Types.DOUBLE);
                    } else {
                        pstmt.setDouble(7, Double.parseDouble(farm.lat.trim()));
                    }

                    // 處理 lng
                    if (farm.lng == null || farm.lng.trim().isEmpty()) {
                        pstmt.setNull(8, java.sql.Types.DOUBLE);
                    } else {
                        pstmt.setDouble(8, Double.parseDouble(farm.lng.trim()));
                    }

                    pstmt.setString(9, farm.picurl);

                    pstmt.executeUpdate();
                    count++;
                }

                System.out.println("資料匯入完成，共匯入 " + count + " 筆資料。");

            } catch (SQLException e) {
                System.out.println("資料庫錯誤：" + e);
            }

        } catch (Exception e) {
            System.out.println("程式錯誤：" + e);
        }
    }
	
	static List<FarmData> parseJSON(String json) {
	    List<FarmData> list = new ArrayList<>();
	    JSONArray root = new JSONArray(json);
	    for (int i = 0; i < root.length(); i++) {
	        JSONObject obj = root.getJSONObject(i);
	        FarmData farm = new FarmData();
	        farm.id = obj.getString("ID");
	        farm.name = obj.getString("Name");
	        farm.feature = obj.getString("Feature");
	        farm.city = obj.getString("County");
	        farm.town = obj.getString("Township");
	        farm.addr = obj.getString("SalePlace");
	        farm.lat = obj.getString("Latitude");
	        farm.lng = obj.getString("Longitude");
	        farm.picurl = obj.getString("Column1");
	        list.add(farm);
	    }
	    return list;
	}
}