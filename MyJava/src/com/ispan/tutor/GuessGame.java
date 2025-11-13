// 1A2B 猜數字程式
package com.ispan.tutor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

									  // 對外宣稱
public class GuessGame extends JFrame implements ActionListener{
	private JTextField input;
	private JButton guess;
	private JTextArea log;
	private String answer;
	private int counter;
	
	public GuessGame() {
		
		super("1A2B猜數字遊戲"); // 找到祖先元素 JFrame(String title)
		counter = 0;
		input = new JTextField();
		input.setFont(new Font(null, Font.BOLD, 30));
		input.setForeground(Color.BLUE);
		guess = new JButton("猜");
		log = new JTextArea();
		log.setFont(new Font(null, Font.BOLD, 30));
		setLayout(new BorderLayout()); // 設定版面 指定的版面格式
		add(log, BorderLayout.CENTER); 
		JPanel top = new JPanel(new BorderLayout());
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		add(top, BorderLayout.NORTH);
		
		// 要在最後面
		setSize(720, 480); // 設定視窗大小
		setVisible(true); // 設定視窗的顯示
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 設定關閉視窗時 程式直接結束
		
		initGame();
		guess.addActionListener(this);
		log.setText("");
	}
	// 開啟新的一局
	private void initGame() {
		answer = createAnswer();
		//System.out.println(answer);
	}
	
	private String createAnswer() {
		final int nums = 10;
		int[] poker = new int[nums];
		for (int i=0; i<poker.length; i++) poker[i] = i;
		
		for (int i = nums - 1; i > 0; i--) {
			int r = (int)(Math.random()*(i+1));
			// poker[i] <=> poker[r]
			int temp = poker[i];
			poker[i] = poker[r];
			poker[r] = temp;
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(poker[0]).append(poker[1]).append(poker[2]);
		return sb.toString();
	}

	public static void main(String[] args) {
		new GuessGame();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		counter++;
		String g = input.getText();
		String result = checkAB(g);
		log.append(String.format("第%d.次 %s => %s\n ",counter, g, result ));
		input.setText("");
		
		// 猜對猜錯邏輯
		if (result.equals("3A0B")) {
			JOptionPane.showMessageDialog(null, "WINNER");
			initGame();
		}else if (counter == 5) {
			JOptionPane.showMessageDialog(null, "好笨no"+"\n" + answer);
			initGame();
		}
		
	}
	
	private String checkAB(String g) {
		// 1A2B 邏輯
		int a, b; a = b = 0;
		for (int i = 0;i<g.length();i++) {
			if (g.charAt(i) == answer.charAt(i)) {
				a++;
			}else if (answer.indexOf(g.charAt(i)) != -1) {
					b++;
				}
			}
		
		
		return String.format("%dA%dB", a, b);
	}
}
