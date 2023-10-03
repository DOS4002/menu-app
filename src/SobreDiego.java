import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
public class SobreDiego extends JDialog  {
	public SobreDiego() {
	
		this.setTitle("Sobre");
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(255, 255, 255));
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
			this.setModal(true);	
			
		JLabel title = new JLabel();
		title.setText("<html><body><h1>Diego Olegario</h1></body></html>");
		title.setBounds(190, 167, 200, 30);
		add(title);
		
		JLabel redes = new JLabel();
		redes.setText("<html><body><strong><h2>Redes sociais:</h2></strong></body></html>");
		redes.setBounds(40, 390, 200, 30);
		add(redes);
		
		  JButton Button = new JButton("Github");
	        Button.setBounds(190, 390, 80, 30);
	        Button.setFocusPainted(false);
	        Button.setBackground(new Color(255, 255, 255));
	        Button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://www.github.com/DOS4002"));
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
	        add(Button);
	        
	        JButton Button2 = new JButton("Linkedin");
	        Button2.setBounds(290, 390, 100, 30);
	        Button2.setFocusPainted(false);
	        Button2.setBackground(new Color(255, 255, 255));
	        Button2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/diego-olegario-6462b5235"));
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
	        add(Button2);
	        
	        JLabel sobre = new JLabel();
	        sobre.setBounds(50, 160, 500, 200);
	        sobre.setText("<html><body><strong><p style='font-size:13px;font-family:'Arial';>Eu sou Diego e tenho 17 anos. Atualmente, estou cursando Desenvolvimento de Sistemas na ETEC de Guaianazes, onde eu aprendo e conheço as areas da tecnologia da informação, criando sites, apps e sistemas de banco de dados</p></strong></body></html>");
	        sobre.setFont(new Font("Poppins",Font.PLAIN,20));
	        add(sobre);
	        
	 JLabel imgDiego = new JLabel();	
            imgDiego.setBounds(210, -5, 140, 160);
            ImageIcon diego = new ImageIcon("src/ImgCaioDiego/diego.jpeg");
            Image boardDiego = diego.getImage().getScaledInstance(imgDiego.getWidth(), imgDiego.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newDiego = new ImageIcon(boardDiego);
            imgDiego.setIcon(newDiego);
            add(imgDiego);

	        this.setLayout(null);
	}
}
