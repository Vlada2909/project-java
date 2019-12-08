package projects.pr;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class math extends JFrame{
	private static final long serialVersionUID = 1L;
	ButtonGroup G = new ButtonGroup();
	JPanel p =new JPanel();
	CardLayout cards=new CardLayout();
	int numQs;
	int c=0;
	int wrongs=0;
	int total=1;


		radio1 questions[]= this.readFromFile("C:\\Users\\Влада Гейфман\\IdeaProjects\\hw\\questions_1.txt");
		public static void main(String args[]) throws IOException {
			new math();
		}


		public math() throws IOException {
			super("Maths Quiz");
			setSize(1250,700);
			setResizable(true);
			super.setBackground(Color.GREEN);
			setBackground(Color.BLUE);
			Toolkit toolkit = getToolkit();
			Dimension size = toolkit.getScreenSize();
			setLocation(size.width/2 - getWidth()/2,
					size.height/2 - getHeight()/2);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			p.setLayout(cards);

			numQs=questions.length;
			for(int i=0;i<numQs;i++){
				p.add(questions[i],"q"+i);

			}
			Random r=new Random();
			int i=r.nextInt(numQs);
			cards.show(p,"q"+i);
			add(p);
			setVisible(true);

		}
		public void next(){
			c++;
			if((total-wrongs)==numQs){
				showSummary();
			}else{
				Random r=new Random();
				boolean found=false;
			int i=0;
			while(!found){
				i=r.nextInt(numQs);
				if(!questions[i].used){
					found=true;
				}
			}
			cards.show(p,"q"+i);
		}
	}
	public void showSummary(){
		JOptionPane.showMessageDialog(null,"All Done :), here are your results"+
			"\nNumber of incorrect Answers: \t"+wrongs+
			"\nNumber of Correct Answers: \t"+(total-wrongs));
		System.exit(0);

	}

	public radio1[] readFromFile(String filename) throws IOException {

		FileReader fr = new FileReader(filename);
		Scanner sc = new Scanner(fr);

//		ArrayList<ArrayList> answers = new ArrayList<ArrayList>();

		int n = 15;
		ArrayList<String> quest = new ArrayList<String>();
		String[][] answers = new String[n][4];

		int j = 0;
		while (sc.hasNext()){
			String[] cur = sc.nextLine().split("/");
			quest.add(cur[1]);

			answers[j] = Arrays.copyOfRange(cur, 2, 6);
			j++;
		}

		radio1[] q = new radio1[quest.size()];

		for (int i = 0; i < quest.size(); ++i){
			q[i] = new radio1(quest.get(i), answers[i], 0,this);
		}


		return q;
	}



}
