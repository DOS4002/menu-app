import javax.swing.*;
import java.awt.*;
public class SobreNos  extends JDialog{
	private JLabel sobreNos;
	private JLabel titulo;
	
	public SobreNos() {
		
	    this.setTitle("Sobre nós");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
		this.setModal(true);		

        JPanel panel = new JPanel() {
            @Override
            /* Criando um paint para desenha a imagem e chamar ela*/
            protected void paintComponent(Graphics g) {
            	/* Chamando a variavel "g" com o super*/
                super.paintComponent(g);
                Image img = new ImageIcon("src/carros/cdCar.png").getImage();
                /* drawImage serve para desenhar a imagem, como aumentar a imagem ou mexer ou eixo x e y*/
                g.drawImage(img, 70, -46, 200, 200, this);
            }
        };
        panel.setLayout(null);
     
        titulo = new JLabel("Sobre a CD autoCars");
        titulo.setBounds(250, 50, 400, 30); // Ajuste a posição aqui
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        add(titulo);

        
		sobreNos = new JLabel();
		sobreNos.setBounds(70, 100, 800, 300);
		sobreNos.setText("<html>Olá!!<br>"
		        + "Somos uma concessionária especializada em vendas de veículos novos e seminovos. Oferecemos serviços de revisão e manutenção de veículos, além da venda de peças originais.<br>"
		        + "Venha nos conhecer!!</html>");
		sobreNos.setFont(new Font("Poppins",Font.PLAIN,20));
		sobreNos.setForeground(Color.BLACK);
		
		panel.add(sobreNos);
		panel.add(titulo);
		 setContentPane(panel);
		
	 this.setVisible(true);
	}
}
