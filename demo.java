package projects.pr;
import javax.swing.JFrame;
import java.awt.Color;

import java.awt.Font;
import java.awt.TextField;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;




import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class demo extends  JFrame {
	int numQs;
	int wrongs=0;
	int total=0;
	private Object demo;
	
	public demo() {
		setResizable(true);
		JLabel label = new JLabel("Hi ! Welcome to the Quiz ..");
		label.setBounds(30, 10, 350, 30);
		add(label);
		
		Font font = new Font("Courier",Font.BOLD,20);
		label.setFont(font);
		setSize(400,400);
		setTitle("Quiz");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2,
		size.height/2 - getHeight()/2);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.BLUE);
		
		panel.setToolTipText("Quiz Board");
		JButton q1 = new JButton("Math");
		q1.setBounds(50, 150, 80, 30);
		q1.setToolTipText("Maths Quiz");
		q1.setBackground(Color.GREEN);
		q1.addActionListener(new ActionListener () {
		public void actionPerformed(ActionEvent e) {
			dispose();
			try {
				math mc = new math();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			rules();
		}
		});
		panel.add(q1);
		panel.add(label);

	}
	
	public static void main(String[] args) {
		demo s  = new demo();
		s.setVisible(true);

	}

	public void rules() {
		JOptionPane.showMessageDialog(null," There will be a few questions for each quiz you can choose any of the quiz given below .There is no time limit and only after answering all the questions you can submit:)");
	}
	
	
}