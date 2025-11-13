package com.ispan.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MyDrawer extends JPanel{
	       //很多條線<一條線<一個點>>
	private LinkedList<LineV2> Lines, recycler;
	private Color defaultColor;
	
	public MyDrawer() {
		setBackground(new Color(127, 255, 212)); // 設定背景顏色(使用色碼)
		
		Lines = new LinkedList<>();
		recycler = new LinkedList<>();
		
		MyListener myListener = new MyListener(); // 建立物件
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
		
	}
	
	// MyListener 繼承 MouseAdapter 屬性 (MouseAdapter 有 absbract 屬性 可以只 使用需要的 其他不用使用)
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
//			Point p = new Point(e.getX(), e.getY());//收集座標位置 形成物件p
//			points.add(p); // 將 p 物件加入 points
			
			LineV2 line = new LineV2(defaultColor);
			line.addPoint(e.getX(), e.getY());
			Lines.add(line);
			recycler.clear();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
//			Point p = new Point(e.getX(), e.getY()); //收集座標位置 形成物件p
//			points.add(p); // 將 p 物件加入 points
			
			Lines.getLast().addPoint(e.getX(), e.getY());
			repaint(); // 重畫(更新畫面)
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(3));
		
		g2d.setColor(Color.DARK_GRAY);
		
		for (LineV2 line: Lines) {
			g2d.setColor(line.getColor());
			for (int i=1; i<line.length(); i++) {
				g2d.drawLine(line.getPointX(i-1), line.getPointY(i-1), line.getPointX(i), line.getPointY(i));
			
		}
		
		}
		
	}
	
	public void clear() {
		Lines.clear();
		repaint();
	}
	
	public void redo() {
		if (Lines.size() > 0) {
			recycler.add(Lines.removeLast());
			repaint();
		}

	}
	
	public void undo() {
		if (Lines.size() > 0) {
			Lines.add(recycler.removeLast());
			repaint();
		}
	}

	public Color getDefaultColor() {
		return defaultColor;
	}

	public void setDefaultColor(Color defaultColor) {
		this.defaultColor = defaultColor;
	}
	
	public void saveLines(File file) throws Exception {
		try(ObjectOutputStream oout = new ObjectOutputStream(
				new FileOutputStream(file))){
			oout.writeObject(Lines);
		}
	}
	
	public void loadLines(File file) throws Exception {
		try(ObjectInputStream oin = new ObjectInputStream(
				new FileInputStream(file))){
			Lines = (LinkedList<LineV2>)oin.readObject();
			repaint();
		}
	}
	
	public boolean saveJpeg(File file) throws Exception {
		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		paint(g2d);
		
		return ImageIO.write(img, "jpeg", file);
	}
	
}

