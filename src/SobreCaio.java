import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
public class SobreCaio extends JDialog {

	public SobreCaio() {
		this.setTitle("Sobre");
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(255, 255, 255));
		 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		 this.setModal(true);

		JLabel title = new JLabel();
		title.setText("<html><body><h1>Caio Pinheiro</h1></body></html>");
		title.setBounds(190, 147, 200, 30);
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
	                    Desktop.getDesktop().browse(new URI("https://www.github.com/Caioxz"));
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
	        add(Button);
	        
	        JButton Button2 = new JButton("Instagram");
	        Button2.setBounds(290, 390, 100, 30);
	        Button2.setFocusPainted(false);
	        Button2.setBackground(new Color(255, 255, 255));
	        Button2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://www.instagram.com/_.caioxz"));
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
	        add(Button2);
	        
	        JLabel sobre = new JLabel();
	        sobre.setBounds(50, 160, 500, 200);
	        sobre.setText("<html><body><strong><p style='font-size:13px;font-family:'Arial';>Prazer!! Me chamo Caio e tenho 16 anos e faço curso de PhotoShop e criação de games  tambem estudo na ETEC de Guaianases, na ETEC faço cuso de Desenvolvimento de Sistemas, la eu mexo com banco de dados, programação web e mobile!!</p></strong></body></html>");
	        sobre.setFont(new Font("Poppins",Font.PLAIN,20));
	        add(sobre);
	        
	        JLabel imgCaio = new JLabel();
            imgCaio.setBounds(210, -5, 140, 140);
            ImageIcon caio = new ImageIcon("src/ImgCaioDiego/caio.jpeg");
            Image boardCaio = caio.getImage().getScaledInstance(imgCaio.getWidth(), imgCaio.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newCaio = new ImageIcon(boardCaio);
            imgCaio.setIcon(newCaio);
            add(imgCaio);
		          

	        this.setLayout(null);
	}
}
