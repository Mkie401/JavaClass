package com.ispan.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.ispan.apis.MyDrawer;

public class Mysign extends JFrame {
	private MyDrawer myDrawer; 
	private JButton clear, undo, redo, color, save, load,saveJpeg;
	public Mysign() {
		 super("簽名 App");
		 
		 setLayout(new BorderLayout());
		 myDrawer = new MyDrawer();
		 add(myDrawer, BorderLayout.CENTER);
		 
		 JPanel top = new JPanel(new FlowLayout());
		 // 加入 button
		 clear = new JButton("清除");
		 undo = new JButton("復原");
		 redo = new JButton("上一步");
		 color = new JButton("顏色");
		 save = new JButton("序列化");
		 load = new JButton("解序列化");
		 saveJpeg = new JButton("jpeg");
		 top.add(clear); top.add(undo); top.add(redo); top.add(color);top.add(save);top.add(load);
		 
		 add(top, BorderLayout.NORTH); // 加入一個 top 區塊
		 
		 setSize(1080,720);
		 setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 initEvent();
	 }
	// 設定事件監聽器
	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});
		color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		load.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		
//		saveJpeg.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				saveJpeg();
//			}
//		});

	
	}
	
	private void save() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			try {
				myDrawer.saveLines(file);
				JOptionPane.showMessageDialog(this, "save success");
			} catch (Exception e){
				JOptionPane.showMessageDialog(this, "save failure");
			}
		}
	}
	
	private void load() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			try {
				myDrawer.loadLines(file);
			} catch (Exception e){
				JOptionPane.showMessageDialog(this, "load failure");
			}
		}
	}
	
	private void changeColor() {
		Color newColor =JColorChooser.showDialog(null, "變更顏色", myDrawer.getDefaultColor());
		if (newColor != null) {
			myDrawer.setDefaultColor(newColor);
		}
	}
	
	public static void main(String[] args) {
		new Mysign();
	}
	

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// getSouce 來源
//		if (e.getSource() == clear) {
//			
//		}else if (e.getSource() == undo) {
//			
//		}else if (e.getSource() == redo) {
//			
//		}
//		
//	}

}
