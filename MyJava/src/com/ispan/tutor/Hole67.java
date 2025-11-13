package com.ispan.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Hole67 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			URLConnection conn = url.openConnection();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			
			
			System.out.println("ok:");
			//System.out.println(sb.toString());
			
			parseJSON(sb.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		for (int i=0; i<root.length(); i++) {
			JSONObject obj = root.getJSONObject(i);
			String id = obj.getString("ID");
			String name = obj.getString("Name");
			String feature = obj.getString("Feature");
			String city = obj.getString("County");
			String town = obj.getString("Township");
			String addr = obj.getString("SalePlace");
			String lat = obj.getString("Latitude");
			String lng = obj.getString("Longitude");
			String picurl = obj.getString("Column1");
			
			System.out.println(name + city);
		}
	}

}


