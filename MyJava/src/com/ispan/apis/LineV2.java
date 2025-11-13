package com.ispan.apis;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LineV2 implements Serializable{
	private ArrayList<Map<String,Integer>> points;
	private Color color;
	public LineV2(Color color) {
		points = new ArrayList<>();
		this.color = color;
	}
	
	public void addPoint(int x,int y) {
		Map<String,Integer> point = new HashMap<>();
		point.put("x", x);point.put("y", y);
		points.add(point);
	}
	
	public int length() {
		return points.size();
	}
	
	public int getPointX1(int index) {
		return points.get(index).get("x");
	}
	
	public int getPointY(int index) {
		return points.get(index).get("y");
	}
	
	public Color getColor() {
		return color;
		
	}

	public int getPointX(int index) {
			return points.get(index).get("x");
		}
}
