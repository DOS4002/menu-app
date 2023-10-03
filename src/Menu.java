import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame{
	JMenu func;
	JMenu calculadora;
	JMenu sobre;
	JMenu games;
	JMenu concCarros;
	JMenuItem sair;
	JMenuItem ticTacToe;
	JMenuItem calc;
	JMenuItem cdCars;
	JMenuItem sobreCaio;
	JMenuItem sobreDiego;
	JMenuBar navBar;
	JLabel title;
	private Concessionaria concessionariaDialog;
	private Calculadora calculadoraDialog;
	private JogoVelha tictactoeDialog;
	
	public Menu() {
		this.setTitle("Projetos");
		this.setSize(3000, 3000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(255, 255, 255));
		this.setResizable(false);
		

		
		 func = new JMenu("Funcionamentos");
		 calculadora = new JMenu("Calculadora");
		 games = new JMenu("Jogos");
		 concCarros = new JMenu("Concessionaria");
		  sobre = new JMenu("Sobre");
		
		 sair = new JMenuItem("Sair");
		 calc = new JMenuItem("Calculadora");
		 cdCars = new JMenuItem("Concessionária");
		 ticTacToe = new JMenuItem("Jogo da Velha");
		sobreCaio = new JMenuItem("Sobre o Caio");
		 sobreDiego = new JMenuItem("Sobre o Diego");
		 
		
		func.add(sair);
		
		calculadora.add(calc);
	
		concCarros.add(cdCars);

		games.add(ticTacToe);

		sobre.add(sobreCaio);
		sobre.add(sobreDiego);


		 navBar = new JMenuBar();
		this.setJMenuBar(navBar);
		navBar.add(func);
		navBar.add(calculadora);
		navBar.add(games);
		navBar.add(concCarros);
		navBar.add(sobre);

		
		JPanel painel = new JPanel() {
			@Override
			/* Criando um paint para desenha a imagem e chamar ela*/
			protected void paintComponent(Graphics g) {
				/* Chamando a variavel "g" com o super*/
				super.paintComponent(g);
				Image img = new ImageIcon("src/imgMenu/fundo_menu.png").getImage();
				/* drawImage serve para desenhar a imagem, como aumentar a imagem ou mexer ou eixo x e y*/
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};
		painel.setLayout(null);
		
		title = new JLabel();
		title.setText("Seja bem-vindo ao nosso menu de apps");
		title.setBounds(340, 20, 900, 400);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Poppins",Font.PLAIN,50));
		title.setForeground(Color.WHITE);
		this.add(title);
	
		calc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(calculadoraDialog == null){
					Calculadora calculadoraDialog = new Calculadora(Menu.this);
				}
				calculadoraDialog.setVisible(true);
				
			}
			
		});
		
		cdCars.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
						if(concessionariaDialog == null){
							Concessionaria concessionariaDialog = new Concessionaria(Menu.this);
						}
					
					concessionariaDialog.setVisible(true);
					
				
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
				int sair =	JOptionPane.showConfirmDialog(null,"Você quer sair do Menu de aplicativos ?","Atenção", JOptionPane.YES_NO_OPTION);
				if(sair == JOptionPane.YES_OPTION){
					System.exit(0);
			}
		}
				
		
			
		});
		
		ticTacToe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent events) {
				if(tictactoeDialog == null){
					JogoVelha tictactoeDialog = new JogoVelha(Menu.this);
				}
				ticTacToe.setVisible(true);
				
				
			}
			
		});

		painel.add(title);
		setContentPane(painel);
		this.setLayout(null);
		this.setVisible(true);
	}
}
