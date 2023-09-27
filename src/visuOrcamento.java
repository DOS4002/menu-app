import javax.swing.*;
import java.awt.*;

public class visuOrcamento extends JDialog {
    private JLabel marcaLabel;
    private JLabel modeloLabel;
    private JLabel opcionaisLabel;
    private  JLabel valorLabel;
    private JLabel imageLabel; 
    private JLabel title;

    //criando vairaveis
    public visuOrcamento( String marca, String modelo, String opcionais, double valorAr, double valorDire, double valorRodas, double valorMulti, double valorTeslaS, double valorTeslaX,  double valorCorollaSpo, double valor, ImageIcon imagemCarro) {
    	this.setTitle("Visualizar Orçamento");
        this.setSize(800, 400);
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
                g.drawImage(img, 80, -46, 200, 200, this);
            }
        };
        panel.setLayout(null);
        
    	title = new JLabel("Orçamento");
		title.setBounds(250,-90,400,300);
		title.setFont(new Font("Poppins",Font.PLAIN,30));
		title.setForeground(Color.BLACK);
		add(title);
               
    
	
        marcaLabel = new JLabel("Marca: " + marca);
        marcaLabel.setBounds(20, 100, 300, 30);
        
        modeloLabel = new JLabel("Modelo: " + modelo);
        
        modeloLabel.setBounds(20, 140, 300, 30); 
        opcionaisLabel = new JLabel(opcionais);
        
 
        opcionaisLabel.setHorizontalAlignment(JLabel.LEFT); // Alinhe o texto à esquerda
        opcionaisLabel.setBounds(20, 170, 300, 100); 
        
         valorLabel = new JLabel("Valor total: " + valor);
         valorLabel.setBounds(20, 250, 300, 100);
       
      
         imageLabel = new JLabel();
     
         add(imageLabel);
     
        
        panel.add(marcaLabel);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(modeloLabel);
        panel.add(new JLabel());
        panel.add(opcionaisLabel);
        panel.add(valorLabel);
        panel.add(imageLabel);
        panel.add(title);

        add(panel);
        getContentPane().add(panel);
    }
    public void definirImagem(ImageIcon imagem) {
        imageLabel.setIcon(imagem);
        int larguraImg = 475;  // Defina a largura desejada para a imagem
        int alturaImg = 225;   // Defina a altura desejada para a imagem

        // Ajuste as coordenadas X e Y 
        int x = 320;  // Posição horizontal (X) para alinhar à direita
        int y = 140;  // Posição vertical (Y)

        imageLabel.setIcon(imagem);
        imageLabel.setBounds(x, y, larguraImg, alturaImg);  // Configura a posição e as dimensões da imagem
    }

  

}