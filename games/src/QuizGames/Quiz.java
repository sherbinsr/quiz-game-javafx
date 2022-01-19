package QuizGames;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



public class Quiz  implements ActionListener  {
	

	   String [] questions = {
				
				"who invented java?",
				
				"77+88+97+98 =?",
				"World programmers day?",
				"Choose the most powerfull nuclear weapon?",
				"Father of Mathematics?",
				"which year was java invented?",
				"The percentage of irrigated land in India  is about?",
				"World largest Mammal?",
				"world's Largest university?",
				"Which country has more Island?",
				"Who invente World Wide Web?",
				"No 1 Richest person in world?",
				"First Programming language?",
				"Time Zone of India",
				"Which of the following is used in Pencil"
				
		};
		
		String [] [] options = {
			 
				{"Gudio van rossum","James Godling","Bjarne Stroustrup","Bill Joy"},
				{"370","375","360","373"},
				{" 13 September","18 December","27 October","None of the above"},
				{"RDS-9", "Tsar Bomba","AN602","SS-7ICBM"},
				{"Archimedes","Herodotus","Adam smith","AL-KHWARIZMI"},
				{"1980","1989","1995","1982"},
				{"37","28","33","35"},
				{"Asian Elephant","African Bush Elephant","White rhinocerous","Antarctic blue whale"},
				{"Indira Gandhi National Open Uinversity","Oxford University","California University","Liberity University"},
				{"India","Austrlia","Sweden","Denmark"},
				{"Bill Gates","Tim berners lee","Martin peters","Hanson"},
				{"Bill Gates","Elon Musk","Jeff Bezos","Warren Buffett"},
				{"C","c++","Fortran","R"},
				{"GMT+5:30","GMT+5:00","GMT+3:30","GMT4;00"},
				{"clay","Graphite","Silica","Ferrous"}
				
				
		};
		
		char[] answers = {
				
				'B',
				'C',
				'A',
				'B',
				'A',
				'C',
				'D',
				'D',
				'A',
				'C',
				'B',
				'C',
				'C',
				'A',
				'B'
				
		};
		
		char guess;
		char answer;
		int index;
		int correct_guesses=0;
		int total_questions =questions.length;
		int result;
		int seconds=10;
		
		JFrame frame = new JFrame();
		JTextField textfield = new JTextField();
		JTextArea textarea = new JTextArea();
		JButton buttonA = new JButton();
		JButton buttonB = new JButton();
		JButton buttonC = new JButton();
		JButton buttonD = new JButton();
		JLabel answer_labelA = new JLabel();
		JLabel answer_labelB = new JLabel();
		JLabel answer_labelC = new JLabel();
		JLabel answer_labelD = new JLabel();
		JLabel time_label = new JLabel();
		JLabel seconds_left = new JLabel();
		JTextField number_right = new JTextField();
		JTextField percentage = new JTextField();
		
		Timer timer = new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds--;
				seconds_left.setText(String.valueOf(seconds));
				if(seconds<=0) {
					displayanswers();
				}
				
			}
		});
		
		
		
		
		public Quiz(){
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(650,650);
			frame.setVisible(true);
	        frame.getContentPane().setBackground(new Color(50,50,50));	
	        frame.setLayout(null);
	        frame.setFont(new Font("MV Boli ", Font.PLAIN,30));
	        frame.setResizable(false);
	        
	        
	        textfield.setBounds(0, 0, 650, 50);
	        textfield.setBackground(new Color(25,25,25));
	        textfield.setForeground(new Color(25,255,0));
	        textfield.setFont(new Font("MV Boli ", Font.PLAIN,30));
	        textfield.setBorder(BorderFactory.createBevelBorder(1));
	        textfield.setHorizontalAlignment(JTextField.CENTER);
	        textfield.setEditable(false);
	        
	        
	        textarea.setBounds(0, 50, 650, 50);
	        textarea.setLineWrap(true);
	        textarea.setWrapStyleWord(true);        
	        textarea.setBackground(new Color(25,25,25));
	        textarea.setForeground(new Color(25,255,0));
	        textarea.setFont(new Font("Ink Free ", Font.PLAIN,25));
	        textarea.setBorder(BorderFactory.createBevelBorder(1));
	        textarea.setEditable(false);
	        
	        buttonA.setBounds(0, 100, 100, 100);
	        buttonA.setFont(new Font("MV Boli ", Font.PLAIN,35));
	        buttonA.setFocusable(false);
	        buttonA.addActionListener(this);
	        buttonA.setText("A.");
	        
	        buttonB.setBounds(0, 200, 100, 100);
	        buttonB.setFont(new Font("MV Boli ", Font.PLAIN,35));
	        buttonB.setFocusable(false);
	        buttonB.addActionListener(this);
	        buttonB.setText("B.");
	        
	        buttonC.setBounds(0, 300, 100, 100);
	        buttonC.setFont(new Font("MV Boli ", Font.PLAIN,35));
	        buttonC.setFocusable(false);
	        buttonC.addActionListener(this);
	        buttonC.setText("C.");
	        
	        buttonD.setBounds(0, 400, 100, 100);
	        buttonD.setFont(new Font("MV Boli ", Font.PLAIN,35));
	        buttonD.setFocusable(false);
	        buttonD.addActionListener(this);
	        buttonD.setText("D.");
	        
	        answer_labelA.setBounds(125, 100, 500, 100);
	        answer_labelA.setBackground(new Color(50,50,50));
	        answer_labelA.setForeground(new Color(25,255,0));
	        answer_labelA.setFont(new Font("MV Boli",Font.PLAIN,35));
	        
	        
	        answer_labelB.setBounds(125, 200, 500, 100);
	        answer_labelB.setBackground(new Color(50,50,50));
	        answer_labelB.setForeground(new Color(25,255,0));
	        answer_labelB.setFont(new Font("MV Boli",Font.PLAIN,35));
	       
	        
	        answer_labelC.setBounds(125, 300, 500, 100);
	        answer_labelC.setBackground(new Color(50,50,50));
	        answer_labelC.setForeground(new Color(25,255,0));
	        answer_labelC.setFont(new Font("MV Boli",Font.PLAIN,35));
	       
	        
	        answer_labelD.setBounds(125, 400, 500, 100);
	        answer_labelD.setBackground(new Color(50,50,50));
	        answer_labelD.setForeground(new Color(25,255,0));
	        answer_labelD.setFont(new Font("MV Boli",Font.PLAIN,35));
	        
	        seconds_left.setBounds(535, 510, 100,100);
	        seconds_left.setBackground(new Color(50,50,50));
	        seconds_left.setForeground(new Color(153,0,0));
	        seconds_left.setFont(new Font("MV Boli",Font.BOLD,50));
	        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
	        seconds_left.setOpaque(true);
	        seconds_left.setHorizontalAlignment(JTextField.CENTER);
	        seconds_left.setText(String.valueOf(seconds));
	        
	        time_label.setBounds(535, 475, 100,25);
	        time_label.setBackground(new Color(50,50,50));
	        time_label.setForeground(new Color(255,0,0));
	        time_label.setFont(new Font("MV Boli",Font.PLAIN,16));
	        time_label.setHorizontalAlignment(JTextField.CENTER);
	        time_label.setText("");
	        
	        number_right.setBounds(225, 225, 200, 100);
	        number_right.setBackground(new Color(25,25,25));
	        number_right.setForeground(new Color(25,255,0));
	        number_right.setFont(new Font("MV Boli",Font.PLAIN,50));
	        number_right.setBorder(BorderFactory.createBevelBorder(1));
	        number_right.setHorizontalAlignment(JTextField.CENTER);
	        number_right.setEditable(false);
	        
	        percentage.setBounds(225, 3325, 200, 100);
	        percentage.setBackground(new Color(25,25,25));
	        percentage.setForeground(new Color(25,255,0));
	        percentage.setFont(new Font("MV Boli",Font.PLAIN,50));
	        percentage.setBorder(BorderFactory.createBevelBorder(1));
	        percentage.setHorizontalAlignment(JTextField.CENTER);
	        percentage.setEditable(false);
	        
	        
	        frame.add(time_label);
	        frame.add(seconds_left);
	        frame.add(answer_labelA);
	        frame.add(answer_labelB);
	        frame.add(answer_labelC);
	        frame.add(answer_labelD);
	        frame.add(buttonA);
	        frame.add(buttonB);
	        frame.add(buttonC);
	        frame.add(buttonD);
	        frame.add(textarea);
	        frame.add(textfield);
	        frame.setVisible(true);
	        
	        nextquestion();
	        
		}
		public void nextquestion() {
			
			if(index>=total_questions) {
				results();
			}
			else {
				textfield.setText("Question"+(index+1));
				textarea.setText(questions[index]);
				answer_labelA.setText(options[index][0]);
				answer_labelB.setText(options[index][1]);
				answer_labelC.setText(options[index][2]);
				answer_labelD.setText(options[index][3]);
				timer.start();
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(e.getSource()==buttonA) {
				
				answer='A';
				if(answer==answers[index]) {
					
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				
				answer='B';
				if(answer==answers[index]) {
					
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				
				answer='C';
				if(answer==answers[index]) {
					
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonD) {
				
				answer='D';
				if(answer==answers[index]) {
					
					correct_guesses++;
				}
			}
			
			displayanswers();
		
			
			
		}
		public void displayanswers() {
			
	        timer.stop();
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(answers[index]!='A') {
				
				answer_labelA.setForeground(new Color(255,0,0));
			}
			if(answers[index]!='B') {
				
				answer_labelB.setForeground(new Color(255,0,0));
			}
			if(answers[index]!='C') {
				
				answer_labelC.setForeground(new Color(255,0,0));
			}
			if(answers[index]!='D') {
				
				answer_labelD.setForeground(new Color(255,0,0));
			}
			
			Timer pause = new Timer(2000,new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					answer_labelA.setForeground(new Color(25,255,0));
					answer_labelB.setForeground(new Color(25,255,0));
					answer_labelC.setForeground(new Color(25,255,0));
					answer_labelD.setForeground(new Color(25,255,0));
					
					seconds=10;
					seconds_left.setText(String.valueOf(seconds));
					buttonA.setEnabled(true);
					buttonB.setEnabled(true);
					buttonC.setEnabled(true);
					buttonD.setEnabled(true);
					
					index++;
					nextquestion();
				}
			});
			pause.setRepeats(false);
			pause.start();
			
			
		}
		public void  results() {
			

			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			result =(int)((correct_guesses/(double)total_questions)*100);
			
			textfield.setText("Your Score! ");
			textarea.setText("");
			answer_labelA.setText("");
			answer_labelB.setText("");
			answer_labelC.setText("");
			answer_labelD.setText("");
			
			
			number_right.setText("("+correct_guesses+"/"+total_questions+")");
			percentage.setText(result+"%");
			
			frame.add(number_right);
			frame.add(percentage);
			
			 
		}

	

}
