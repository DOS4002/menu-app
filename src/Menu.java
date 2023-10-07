import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame{
	JMenu archivMenu;
	JMenu calculadora;
	JMenu sobre;
	JMenu games;
	JMenu concessionariaApp;
	JMenuItem sair;
	JMenuItem gameApp;
	JMenuItem calculatorApp;
	JMenuItem cdCars;
	JMenuItem sobreCaio;
	JMenuItem sobreDiego;
	JMenuBar navBar;
	JLabel title;
	JLabel subtitle;
	private Concessionaria concessionariaDialog;
	private Calculadora calculadoraDialog;
	private JogoVelha tictactoeDialog;
	
	public Menu() {
		this.setTitle("Projetos");
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(255, 255, 255));
		this.setResizable(false);
		

		
		 archivMenu = new JMenu("Arquivo");
		 calculadora = new JMenu("Calculadora");
		 games = new JMenu("Jogos");
		 concessionariaApp = new JMenu("Concessionaria");
		  sobre = new JMenu("Sobre");
		
		 sair = new JMenuItem("Sair");
		 calculatorApp = new JMenuItem("Calculadora");
		 cdCars = new JMenuItem("Concessionária");
		 gameApp = new JMenuItem("Jogo da Velha");
		sobreCaio = new JMenuItem("Sobre o Caio");
		 sobreDiego = new JMenuItem("Sobre o Diego");
		 
		
		archivMenu.add(sair);
		
		calculadora.add(concessionariaApp);
	
		concessionariaApp.add(cdCars);

		games.add(gameApp);

		sobre.add(sobreCaio);
		sobre.add(sobreDiego);


		 navBar = new JMenuBar();
		this.setJMenuBar(navBar);
		navBar.add(archivMenu);
		navBar.add(calculadora);
		navBar.add(games);
		navBar.add(concessionariaApp);
		navBar.add(sobre);

		
		JPanel painel = new JPanel() {
			@Override
			/* Criando um paint para desenha a imagem e chamar ela*/
			protected void paintComponent(Graphics g) {
				/* Chamando a variavel "g" com o super*/
				super.paintComponent(g);
				Image img = new ImageIcon("src/imgMenu/calvin-and-hobbes.jpg").getImage();
				/* drawImage serve para desenhar a imagem, como aumentar a imagem ou mexer ou eixo x e y*/
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};
		painel.setLayout(null);
		
		title = new JLabel();
		title.setText("Seja bem-vindo ao CD Menu");
		title.setBounds(340, 20, 900, 400);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Paytone One",Font.PLAIN,50));
		title.setForeground(Color.WHITE);
		this.add(title);
	
		subtitle = new JLabel();
		subtitle.setText("Caio e Diego");
		subtitle.setBounds(340, 100, 900, 400);	
		subtitle.setHorizontalAlignment(SwingConstants.CENTER);	
		subtitle.setFont(new Font("Poppins",Font.PLAIN,25));
		subtitle.setForeground(Color.WHITE);	
		this.add(subtitle);

		calculatorApp.addActionListener(new ActionListener() {

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
		
		gameApp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent events) {
				if(tictactoeDialog == null){
					JogoVelha tictactoeDialog = new JogoVelha(Menu.this);
				}
				gameApp.setVisible(true);
				
				
			}
			
		});

		painel.add(title);
		painel.add(subtitle);
		setContentPane(painel);
		this.setLayout(null);
		this.setVisible(true);
	}
}
