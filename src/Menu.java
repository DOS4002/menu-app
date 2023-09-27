import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame{
	JMenu func;
	JMenu app;
	JMenu ajuda;
	JMenuItem sair;
	JMenuItem calc;
	JMenuItem orc;
	JMenuItem sobreCaio;
	JMenuItem sobreDiego;
	JMenuItem Jogo;
	JMenuBar barzinho;
	JLabel title;
	JLabel title2;
	JLabel title3;
	
	public Menu() {
		this.setTitle("Projetos");
		this.setSize(760, 430);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(255, 255, 255));
		this.setResizable(false);
		
		
		 func = new JMenu("Funcionamentos");
		 app = new JMenu("Aplicativos");
		 ajuda = new JMenu("Ajuda");
		
		 sair = new JMenuItem("Sair");
		 calc = new JMenuItem("Calculadora");
		 orc = new JMenuItem("Concessionária");
		 sobreCaio = new JMenuItem("Sobre o Caio");
		 sobreDiego = new JMenuItem("Sobre o Diego");
		 Jogo = new JMenuItem("Jogo da Velha");
		 
		
		func.add(sair);
		app.add(calc);
		app.add(orc);
		app.add(Jogo);
		
		ajuda.add(sobreCaio);
		ajuda.add(sobreDiego);
		
		 barzinho = new JMenuBar();
		this.setJMenuBar(barzinho);
		barzinho.add(func);
		barzinho.add(app);
		barzinho.add(ajuda);
		
		title = new JLabel();
		title.setText("<html><body><h1>Seja bem vindo aos Aplicativos</h1></body></html>");
		title.setBounds(0, 50, 700, 30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(title);
		
	
		
		
		
		calc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Calculadora Calculadora = new Calculadora();
				Calculadora.setVisible(true);
				
			}
			
		});
		
		orc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Orcamento Orcamento = new Orcamento();
				Orcamento.setVisible(true);
				
			}
			
		});
		
		sobreCaio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SobreCaio SobreCaio = new SobreCaio();
				SobreCaio.setVisible(true);
			}
			
		});
		
		sobreDiego.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SobreDiego SobreDiego = new SobreDiego();
				SobreDiego.setVisible(true);
			}
			
		});
		
		sair.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int sair =	JOptionPane.showConfirmDialog(null,"Você quer sair do Menu de aplicativos ?","Aten��o", JOptionPane.YES_NO_OPTION);
				if(sair == JOptionPane.YES_OPTION){
					System.exit(0);
			}
		}
				
		
			
		});
		
		Jogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent events) {
				JogoVelha ticTacToe = new JogoVelha();
				ticTacToe.setVisible(true);
				
				
			}
			
		});
		
		this.setLayout(null);
		this.setVisible(true);
	}
}