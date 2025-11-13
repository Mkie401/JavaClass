package com.ispan.apis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class GiftDB {
	private static Connection conn = null;
	private static String QUERY_ALL = """
			SELECT id as 編號, name as 名稱, city as 城市, town as 鄉鎮, addr as 地址, feature as 特色
			FROM gift
			""";
	private static ResultSet rs;
	
	private String[] fieldNames;
	
	public GiftDB() throws Exception{
		conn = Utils.getConnection();
		queryDB();
	}
	
	public void queryDB() throws Exception{
			queryDB(QUERY_ALL);
	}
	
	public void queryDB(String sql) throws Exception{
		Statement stmt= conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE
				);
		rs = stmt.executeQuery(sql);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		fieldNames = new String[rsmd.getColumnCount()];
		for (int i=0; i<fieldNames.length; i++) {
			fieldNames[i] = rsmd.getColumnLabel(i+1);
		}
	}
	
	public int getRows() throws Exception{
		rs.last();
		return rs.getRow();
	}
	
	public int getCols() {
		return fieldNames.length;
	}
	
	public String getData(int row, int col) {
		try {
		rs.absolute(row + 1);
		return rs.getString(col + 1);
		}catch (Exception e){
			System.out.println(e);
			return "ERROR";
		}
	}
	
	public String getColName(int col) {
		return fieldNames[col];
	}
	
	public void setData(Object aValue, int row, int column) throws Exception{
		rs.absolute(row + 1);
		rs.updateString(column + 1, (String)aValue);
		rs.updateRow();
	}
	
	public void delData(int row) {
		try {
		rs.absolute(row +1 );
		rs.deleteRow();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void addRow(int row) {
	//	rs.absolute(row + 1);
	//	rs.
	}
}
