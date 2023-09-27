import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FalecNos extends JDialog{
	  private  JLabel labelTitulo;
	  private JTextField opniao;
	  private JButton botaoFale;
	public FalecNos() {
		  	this.setTitle("Fale com a gente ");
	        this.setSize(600, 500);
	        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        this.setLocationRelativeTo(null);

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
	     

	        labelTitulo = new JLabel("Fale conosco");
	        labelTitulo.setBounds(250, 50, 400, 30);
	        labelTitulo.setFont(new Font("Arial", Font.BOLD, 25));
	        add(labelTitulo);
	        
	        opniao = new JTextField();
	        opniao.setToolTipText("Digite sua Opnião");
	        opniao.setBounds(80, 150, 400, 100);
	        opniao.setFont(new Font("Poppins", Font.BOLD, 20));
	        add(opniao);
	        
	        botaoFale = new JButton("Enviar sua opnião");
	        botaoFale.setBounds(200, 350, 135, 60);
	        botaoFale.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	Opniao();
	            }
	        });
	        add(botaoFale);
	        
		panel.add(labelTitulo);
		panel.add(opniao);
		panel.add(botaoFale);
		
		 setVisible(true);
	        setLayout(null);
	        setContentPane(panel);
	}
	public void Opniao() {
		
		int opn = JOptionPane.showConfirmDialog(null,"Quer enviar sua opnião ?","Opnião", JOptionPane.YES_NO_OPTION);
		if(opn == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null,"Muito obrigado por dar sua opnião sobre a CD AutoCars");
		}
		opniao.setText("");
	}
}
