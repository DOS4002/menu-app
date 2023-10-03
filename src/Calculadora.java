import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

import javax.swing.plaf.synth.ColorType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public  class Calculadora extends JDialog implements ActionListener{
	
	JTextField num1;
	JTextField num2;
	JLabel title;
	Image img;


	
		public Calculadora(Menu calculadora){	
			this.setTitle("Formulario");
			this.setSize(680, 600);	
			this.setLocationRelativeTo(null);
			this.getContentPane().setBackground(Color.black);
			this.setModal(true);
			this.setResizable(false);
	
		
					JLabel imgCalc = new JLabel();
					imgCalc.setBounds(0, 0, 670, 670);
					ImageIcon caio = new ImageIcon("src/imgCalc/ceu.jpg");
					Image boardCaio = caio.getImage().getScaledInstance(imgCalc.getWidth(), imgCalc.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon newCaio = new ImageIcon(boardCaio);
					imgCalc.setIcon(newCaio);
					add(imgCalc);
						  
			JButton soma = new JButton("Somar");
			soma.setBounds(20,400,150,30);
			soma.setFont(new Font("Poppins", Font.PLAIN,20));
			soma.setForeground(Color.BLACK);
			soma.setBackground(Color.white);
			add(soma);
			
			soma.addActionListener(this);
			

			
			JButton subtracao= new JButton("Subtrair");
			subtracao.setBounds(175,400,150,30);
			subtracao.setFont(new Font("Poppins", Font.PLAIN,20));
			subtracao.setForeground(Color.BLACK);
			subtracao.setBackground(Color.white);
			add(subtracao);
			subtracao.addActionListener(this::subtracao);
			

			
			JButton multiplicacao = new JButton("Multiplicar");
			multiplicacao.setBounds(333,400,150,30);
			multiplicacao.setFont(new Font("Poppins", Font.PLAIN,20));
			multiplicacao.setForeground(Color.BLACK);
			multiplicacao.setBackground(Color.white);
			add(multiplicacao);
			multiplicacao.addActionListener(this::multiplicacao);
			

			
			JButton divisao = new JButton("Dividir");
			divisao.setBounds(490,400,150,30);
			divisao.setFont(new Font("Poppins", Font.PLAIN,20));
			divisao.setForeground(Color.BLACK);
			divisao.setBackground(Color.white);
			add(divisao);
			divisao.addActionListener(this::divisao);
			
	
			
			
			
			num2 = new JTextField();
			num2.setBounds(420,300,170,30);
			num2.setFont(new Font("Poppins",Font.PLAIN,30));
			num2.setBackground(Color.white);  
			num2.setForeground(Color.BLACK);
			add(num2);
			
			
			
			num1 = new JTextField();
			num1.setBounds(100,300,170,30);
			num1.setFont(new Font("Poppins",Font.PLAIN,30));
			num1.setBackground(Color.white);
			num1.setForeground(Color.BLACK);
			add(num1);
			
			
			
			JLabel label1 = new JLabel("Numero 1");
			label1.setBounds(100,260,90,50);
			label1.setFont(new Font("Arial",Font.PLAIN,20));
			label1.setForeground(Color.WHITE);
			add(label1);
			
			
			
			JLabel label2 = new JLabel("Numero 2");
			label2.setBounds(420,260,90,50);
			label2.setFont(new Font("Poppins",Font.PLAIN,20));
			label2.setForeground(Color.WHITE);
			
			add(label2);
			
			title = new JLabel("Calculadora Basica");
			title.setBounds(215,20,400,300);
			title.setFont(new Font("Poppins",Font.PLAIN,30));
			title.setForeground(Color.WHITE);
			add(title);
			
		
				imgCalc.add(title);
				imgCalc.add(subtracao);
				imgCalc.add(soma);
				imgCalc.add(label2);
				imgCalc.add(divisao);
				imgCalc.add(multiplicacao);
				imgCalc.add(label1);
			
			this.setLayout(null);
			this.setVisible(true);	
			/* setContentPane serve para mostrar qual painel vai ser principal*/
		
			}
		
		
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Double numero1 = Double.parseDouble(num1.getText());
			Double numero2 = Double.parseDouble(num2.getText());
			Double soma = numero1 + numero2;


			JOptionPane.showMessageDialog(null,"A soma �: " + soma);
			
			
	}
		
		
		public void subtracao(ActionEvent ActionEvent) {

			Double numero1 = Double.parseDouble(num1.getText());
			Double numero2 = Double.parseDouble(num2.getText());
			Double subtracao = numero1 - numero2;
			
			
			
			JOptionPane.showMessageDialog(null,"O resto �: " + subtracao);
		
	}
		
		
		public void multiplicacao(ActionEvent ActionEvent){
			
			Double numero1 = Double.parseDouble(num1.getText());
			Double numero2 = Double.parseDouble(num2.getText());
			Double multiplicacao = numero1 * numero2;
			
			
			JOptionPane.showMessageDialog(null,"O produto �: " + multiplicacao);
			
	}
		
		
		public void divisao(ActionEvent ActionEvent) {
		
			Double numero1 = Double.parseDouble(num1.getText());
			Double numero2 = Double.parseDouble(num2.getText());
			Double divisao = numero1 / numero2;
			
			
		
			if(numero2 == 0) {
				JOptionPane.showMessageDialog(null,"� impossivel dividir por 0","aten��o",JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,"O quoeficiente �: " + divisao);
			}
			
	
	
	}
		
	
		
}

