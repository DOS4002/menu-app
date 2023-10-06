import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

import javax.swing.plaf.synth.ColorType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public  class Calculadora extends JDialog implements ActionListener{
	
	JTextField firstNumber;
	JTextField secondNumber;
	JLabel titleCalculator;
	Image backgroundCalculatorApp;
	ImageIcon calculatorImage;
	JLabel iconCalculator;


	
		public Calculadora(Menu calculadora){	
			this.setTitle("Formulario");
			this.setSize(680, 600);	
			this.setLocationRelativeTo(null);
			this.getContentPane().setBackground(Color.black);
			this.setModal(true);
			this.setResizable(false);
	
		
			JLabel background = new JLabel();
			background.setBounds(0, 0, 670, 670);
			ImageIcon backgroundImage = new ImageIcon("src/imgCalc/ceu.jpg");
			Image editBackground = backgroundImage.getImage().getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon backgroundConstructor = new ImageIcon(editBackground);
			background.setIcon(backgroundConstructor);
			add(background);
						  
			iconCalculator = new JLabel();
			iconCalculator.setBounds(295, 235, 100, 100);
			calculatorImage = new ImageIcon("src/imgCalc/calculator.png");
			Image editCalculator = calculatorImage.getImage().getScaledInstance(iconCalculator.getWidth(), iconCalculator.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon calculatorConstructor = new ImageIcon(editCalculator);
			iconCalculator.setIcon(calculatorConstructor);
			background.add(iconCalculator);


			JButton soma = new JButton("Somar");
			soma.setBounds(20,400,150,30);
			soma.setFont(new Font("Poppins", Font.PLAIN,15));
			soma.setForeground(Color.BLACK);
			soma.setBackground(Color.white);
			add(soma);
			
			soma.addActionListener(this);
			

			
			JButton subtracao= new JButton("Subtrair");
			subtracao.setBounds(175,400,150,30);
			subtracao.setFont(new Font("Poppins", Font.PLAIN,15));
			subtracao.setForeground(Color.BLACK);
			subtracao.setBackground(Color.white);
			add(subtracao);
			subtracao.addActionListener(this::subtracao);
			

			
			JButton multiplicacao = new JButton("Multiplicar");
			multiplicacao.setBounds(333,400,150,30);
			multiplicacao.setFont(new Font("Poppins", Font.PLAIN,15));
			multiplicacao.setForeground(Color.BLACK);
			multiplicacao.setBackground(Color.white);
			add(multiplicacao);
			multiplicacao.addActionListener(this::multiplicacao);
			

			
			JButton divisao = new JButton("Dividir");
			divisao.setBounds(490,400,150,30);
			divisao.setFont(new Font("Poppins", Font.PLAIN,15));
			divisao.setForeground(Color.BLACK);
			divisao.setBackground(Color.white);
			add(divisao);
			divisao.addActionListener(this::divisao);
			
			
			
			secondNumber = new JTextField();
			secondNumber.setBounds(420,300,170,30);
			secondNumber.setFont(new Font("Poppins",Font.PLAIN,18));
			secondNumber.setBackground(Color.white);  
			secondNumber.setForeground(Color.BLACK);
			add(secondNumber);
			
			
			
			firstNumber = new JTextField();
			firstNumber.setBounds(100,300,170,30);
			firstNumber.setFont(new Font("Poppins",Font.PLAIN,18));
			firstNumber.setBackground(Color.white);
			firstNumber.setForeground(Color.BLACK);
			add(firstNumber);
			
			
			
			JLabel label1 = new JLabel("Numero 1");
			label1.setBounds(100,260,90,50);
			label1.setFont(new Font("Poppins",Font.PLAIN,15));
			label1.setForeground(Color.WHITE);
			add(label1);
			
			
			
			JLabel label2 = new JLabel("Numero 2");
			label2.setBounds(420,260,90,50);
			label2.setFont(new Font("Poppins",Font.PLAIN,15));
			label2.setForeground(Color.WHITE);
			
			add(label2);
			
			titleCalculator = new JLabel("Calculadora Basica");
			titleCalculator.setBounds(200,20,400,300);
			titleCalculator.setFont(new Font("Poppins ExtraBold",Font.BOLD,26));
			titleCalculator.setForeground(Color.WHITE);
			add(titleCalculator);
			
		
				background.add(titleCalculator);
				background.add(subtracao);
				background.add(soma);
				background.add(label2);
				background.add(divisao);
				background.add(multiplicacao);
				background.add(label1);
			
			this.setLayout(null);
			this.setVisible(true);	
			/* setContentPane serve para mostrar qual painel vai ser principal*/
		
			}
		
		
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Double numberOne = Double.parseDouble(firstNumber.getText());
			Double numberTwo = Double.parseDouble(secondNumber.getText());
			Double soma = numberOne + numberTwo;


			JOptionPane.showMessageDialog(null,"A soma �: " + soma);
			
			
	}
		
		
		public void subtracao(ActionEvent ActionEvent) {

			Double numberOne = Double.parseDouble(firstNumber.getText());
			Double numberTwo = Double.parseDouble(secondNumber.getText());
			Double subtracao = numberOne - numberTwo;
			
			
			
			JOptionPane.showMessageDialog(null,"O resto �: " + subtracao);
		
	}
		
		
		public void multiplicacao(ActionEvent ActionEvent){
			
			Double numberOne = Double.parseDouble(firstNumber.getText());
			Double numberTwo = Double.parseDouble(secondNumber.getText());
			Double multiplicacao = numberOne * numberTwo;
			
			
			JOptionPane.showMessageDialog(null,"O produto �: " + multiplicacao);
			
	}
		
		
		public void divisao(ActionEvent ActionEvent) {
		
			Double numberOne = Double.parseDouble(firstNumber.getText());
			Double numberTwo = Double.parseDouble(secondNumber.getText());
			Double divisao = numberOne / numberTwo;
			
			
		
			if(numberTwo == 0) {
				JOptionPane.showMessageDialog(null,"� impossivel dividir por 0","aten��o",JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,"O quoeficiente �: " + divisao);
			}
			
	
	
	}
		
	
		
}

