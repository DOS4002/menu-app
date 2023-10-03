import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public  class Concessionaria extends JDialog  {
	
	
private JLabel title;
private JLabel nome;
private JLabel celular;
private JLabel email;
private JLabel marca;
private JLabel modelo;
private JTextField txNome;
private JTextField txCelular;
private JTextField txEmail;
private JComboBox cbModelo;
private JComboBox cbMarca;
private JRadioButton rbBranco;
private JRadioButton rbVermelho;
private JRadioButton rbPreto;
private JCheckBox Arcondicionado;
private JCheckBox Hidraulica;
private JCheckBox rodasLeve;
private JCheckBox Multimidaia;
private JButton salvar;
private JButton cancelar;
private JLabel imageLabel;
private JLabel opcionais;
private ImageIcon imagemCarro;


	
		public Concessionaria(Menu concessionaria){	
			this.setTitle("Concessionária");
			this.setSize(800, 700);	
			this.setModal(true);
			this.setResizable(false);
			this.setLocationRelativeTo(null);

	

			 


			JLabel imgLogo = new JLabel();
            imgLogo.setBounds(20, -40, 240, 220);
            ImageIcon boardimg = new ImageIcon("src/carros/cdCar.png");
            Image boardCar = boardimg.getImage().getScaledInstance(imgLogo.getWidth(), imgLogo.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newBoard = new ImageIcon(boardCar);
            imgLogo.setIcon(newBoard);
            add(imgLogo);
		          

			title = new JLabel("Concessionária CD AutoCars");
			title.setBounds(215,-70,400,300);
			title.setFont(new Font("Poppins",Font.PLAIN,30));
			title.setForeground(Color.BLACK);
			add(title);
			
			nome = new JLabel("Nome:");
			nome.setBounds(10,160,90,50);
			nome.setFont(new Font("Poppins",Font.PLAIN,20));
			nome.setForeground(Color.BLACK);
			add(nome);
			
			txNome = new JTextField();
			txNome.setBounds(70,170,170,30);
			txNome.setFont(new Font("Poppins",Font.PLAIN,20));
			add(txNome);
			
			
			celular = new JLabel("Celular:");
			celular.setBounds(250,160,90,50);
			celular.setFont(new Font("Poppins",Font.PLAIN,20));
			celular.setForeground(Color.BLACK);
			add(celular);
			
			txCelular = new JTextField();
			txCelular.setBounds(320,170,170,30);
			txCelular.setFont(new Font("Poppins",Font.PLAIN,20));
			txCelular.addKeyListener(new KeyListener() {
			    @Override
			    public void keyTyped(KeyEvent e) {
			    	//aceitando apenas determinados caracteres.
			        char c = e.getKeyChar();
			        // Só pode colocar numeros dentro do JTextField ou seja se for um caracter que não seja um numero, ele sera ignorado
			        if (!Character.isDigit(c)  && c != '-' && c != '(' && c != ')' && c != KeyEvent.VK_BACK_SPACE) {
			            e.consume(); // Ignora caracteres que não são numeros ou " - "
			        }
			    }

			    @Override
			    public void keyPressed(KeyEvent e) {
			    }

			    @Override
			    public void keyReleased(KeyEvent e) {
			    }
			});
			add(txCelular);
			

			email = new JLabel("Email:");
			email.setBounds(500,160,90,50);
			email.setFont(new Font("Poppins",Font.PLAIN,20));
			email.setForeground(Color.BLACK);
			add(email);
			
			txEmail = new JTextField();
			txEmail.setBounds(555,170,170,30);
			txEmail.setFont(new Font("Poppins",Font.PLAIN,20));
			// Adicione o KeyListener para validar o campo de email
			txEmail.addKeyListener(new KeyListener() {
			    @Override
			    public void keyTyped(KeyEvent e) {
			    	//aceitando apenas determinados caracteres.
			        char c = e.getKeyChar();
			        // convertendo para poder colocar numero . ou @
			        if (!Character.isLetterOrDigit(c) &&   c != '.' && c != '@') {
			            e.consume(); // Ignora caracteres que não são '.', '@' ou alfanuméricos
			        }
			    }

			    @Override
			    public void keyPressed(KeyEvent e) {
			    }

			    @Override
			    public void keyReleased(KeyEvent e) {
			    }
			});
			add(txEmail);

			marca = new JLabel("Marca:");
			marca.setBounds(10,230,90,50);
			marca.setFont(new Font("Poppins",Font.PLAIN,20));
			marca.setForeground(Color.BLACK);
			add(marca);
			
			cbMarca = new JComboBox<>(new String[]{"Marca","Tesla", "Toyota"});
			cbMarca.setBounds(80,243,100,25);
			add(cbMarca);
			cbMarca.addItemListener(new ItemListener() {
			    @Override
			    public void itemStateChanged(ItemEvent e) {
			        alimentoCombo(); // Atualize a combo de modelos
			        mostrarIcone(); // Atualize a imagem com base na nova marca selecionada
			    }
			});
			
			
			
			
			modelo = new JLabel("Modelo:");
			modelo.setBounds(10,300,90,50);
			modelo.setFont(new Font("Poppins",Font.PLAIN,20));
			modelo.setForeground(Color.BLACK);
			add(modelo);
			
			
			cbModelo = new JComboBox<>(new String[]{"Modelo"});
			cbModelo.setBounds(87,313,100,25);
			add(cbModelo);
			cbModelo.addItemListener(new ItemListener() {
			    @Override
			    public void itemStateChanged(ItemEvent e) {
			        mostrarIcone(); // Atualize a imagem com base no novo modelo selecionado
			    }
			});
			
	
			rbBranco = new JRadioButton("Branco");
			rbBranco.setBounds(10, 350, 100, 25);
			add(rbBranco);
			rbBranco.addItemListener(new ItemListener() {
			    @Override
			    public void itemStateChanged(ItemEvent e) {
			        mostrarIcone(); // Atualize a imagem com base na nova cor selecionada
			    }
			});
			
			
			
			rbVermelho = new JRadioButton("Vermelho");
			rbVermelho.setBounds(10, 380, 100, 25);
			add(rbVermelho);
			rbVermelho.addItemListener(new ItemListener() {
			    @Override
			    public void itemStateChanged(ItemEvent e) {
			        mostrarIcone(); // Atualize a imagem com base na nova cor selecionada
			    }
			});
			
			
			
			rbPreto = new JRadioButton("Preto");
			rbPreto.setBounds(10, 410, 100, 25);
			add(rbPreto);
			rbPreto.addItemListener(new ItemListener() {
			    @Override
			    public void itemStateChanged(ItemEvent e) {
			        mostrarIcone(); // Atualize a imagem com base na nova cor selecionada
			    }
			});

			
			
			
			ButtonGroup grupoCores = new ButtonGroup();
			grupoCores.add(rbBranco);
			grupoCores.add(rbVermelho);
			grupoCores.add(rbPreto);
			
			 	opcionais = new JLabel("Opcionais:");
		        opcionais.setBounds(10, 440, 100, 30);
		        opcionais.setFont(new Font("Poppins", Font.PLAIN, 20));
		        opcionais.setForeground(Color.BLACK);
		        add(opcionais);
		        
		        Arcondicionado = new JCheckBox("Ar Condicionado");
		        Arcondicionado.setBounds(10, 470, 180, 30);
		        add(Arcondicionado);

		        Hidraulica = new JCheckBox("Direção Hidráulica");
		        Hidraulica.setBounds(10, 500, 180, 30);
		        add(Hidraulica);

		        rodasLeve = new JCheckBox("Rodas Leve");
		        rodasLeve.setBounds(10, 530, 180, 30);
		        add(rodasLeve);

		        Multimidaia = new JCheckBox("Multimídia");
		        Multimidaia.setBounds(10, 560, 180, 30);
		        add(Multimidaia);
			
			   JPanel botoesPanel = new JPanel();
		        botoesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		        botoesPanel.setBounds(1, 600, 770, 50); 

				salvar = new JButton("Salvar");
				salvar.setFocusPainted(false);
				salvar.setBackground(new Color(255, 255, 255));
		        salvar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					
						String coresSelected = rbBranco.isSelected() ? "branco" : rbVermelho.isSelected() ? "vermelho" : "preto";
						String marcaSelected = (String) cbMarca.getSelectedItem();
						String modeloSelected = (String) cbModelo.getSelectedItem();
						String celular = (txCelular.getText());
						  boolean arSelected = Arcondicionado.isSelected();
						  boolean hidrauSelected = Hidraulica.isSelected();
						  boolean rodasSelected = rodasLeve.isSelected();
						  boolean multiSelected = Multimidaia.isSelected();
						 
						  
						//  criando uma variavel  mensagem para mostrar no JOptionPane
						String mensagem = "Informações salvas:\n" +
						                  "Nome: " + txNome.getText() + "\n" +
						                  "Celular: " + celular + "\n" +
						                  "Email: " + txEmail.getText() + "\n" +
						                  "Marca: " + marcaSelected + "\n" +
						                  "Modelo: " + modeloSelected  + "\n" +
						                  "Cores: " + coresSelected + "\n" +
						                  "Opcionais: ";
				
					
						if (arSelected) {
						    mensagem += " Ar Condicionado ";
						   
						}
						if (hidrauSelected) {
						    mensagem += " Direção Hidráulica ";
						}
						if (rodasSelected) {
						    mensagem += " Rodas Leve ";
						}
						if (multiSelected) {
						    mensagem += " Multimídia-";
						}


						JOptionPane.showMessageDialog(null, mensagem);
					}
		        });
		        
		        
		    
		        
		        
		        cancelar = new JButton("Cancelar");
				cancelar.setFocusPainted(false);
				cancelar.setBackground(new Color(255, 255, 255));
		        cancelar.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	int cancel = JOptionPane.showConfirmDialog(null,"Quer mesmo cancelar as informações ?","Opnião", JOptionPane.YES_NO_OPTION);
		        		if(cancel == JOptionPane.YES_OPTION) {
		            	
		                // Limpar todos os campos e seleções
		                txNome.setText("");
		                txCelular.setText("");
		                txEmail.setText("");
		                cbMarca.setSelectedIndex(0);
		                rbBranco.setSelected(false);
		                rbVermelho.setSelected(false);
		                rbPreto.setSelected(false);
		                Arcondicionado.setSelected(false);
		                Hidraulica.setSelected(false);
		                rodasLeve.setSelected(false);
		                Multimidaia.setSelected(false);

		                // Limpar o JLabel da imagem
		                imageLabel.setIcon(null);
		                JOptionPane.showMessageDialog(null,"Itens cancelados com sucesso!!", "Remoção",JOptionPane.WARNING_MESSAGE);
		            }
		           }
		        });

				botoesPanel.add(salvar);
				botoesPanel.add(cancelar);
				add(botoesPanel);
		     
			
		        imageLabel = new JLabel();
				add(imageLabel);
			
			/* adicionando os buttons,TextsFilds,label e title em cima do painel para a imagem ficar no background*/

			
				
		
			
			this.setLayout(null);
			this.setVisible(true);	
			}
		
		private void alimentoCombo() {
			String alimentoSelected = (String) cbMarca.getSelectedItem();
			//remove os itens q foram adicionados
			cbModelo.removeAllItems();
			
			if("Tesla".equals(alimentoSelected)) {
				//Adiconado novos elementos na comboBox modelo
				cbModelo.addItem("Modelo");
				cbModelo.addItem("Tesla-S");
				cbModelo.addItem("Tesla-X");
			}else if("Toyota".equals(alimentoSelected)) {
				cbModelo.addItem("Modelo");
				cbModelo.addItem("corollaSport");
				cbModelo.addItem("corollaGLi");
			}
		}
		
		private void mostrarIcone() {
			// verificando qual item esta selecionado, e colocando duas condições (verdadeira e falsa)
			   String coresSelected = rbBranco.isSelected() ? "branco" :  rbVermelho.isSelected() ? "vermelho" : "preto";
		        String marcaSelected = (String) cbMarca.getSelectedItem();
		        String modeloSelected = (String) cbModelo.getSelectedItem();
		     
		       
		        int larguraImg = 530;  // Defina a largura da imagem corretamente
		        int alturaImg = 370;   // Defina a altura da imagem corretamente

		        
		        
		        if ("Modelo".equals(modeloSelected)) {
		            // Limpar o JLabel se nenhum modelo for selecionado
		            imageLabel.setIcon(null);

		        }
		        
		        String imagePath = "src/carros/";  // Defina o caminho da imagem corretamente

		        if ("Tesla".equals(marcaSelected)) {
		            if ("Tesla-S".equals(modeloSelected)) {
		                imagePath += "TeslaModeloS-" + coresSelected + ".png";
		            } else if ("Tesla-X".equals(modeloSelected)) {
		                imagePath += "TeslaModeloX-" + coresSelected + ".png";
		            }
		        } else if ("Toyota".equals(marcaSelected)) {
		            if ("corollaGLi".equals(modeloSelected)) {
		                imagePath += "corollaGLi-" + coresSelected + ".png";
		            } else if ("corollaSport".equals(modeloSelected)) {
		                imagePath += "corollaGRSport-" + coresSelected + ".png";
		            }
		        }

		        // Redimensionar a imagem para um tamanho específico 
		      
		        ImageIcon icone = redimensionarCarro(imagePath, larguraImg, alturaImg);
		        imageLabel.setIcon(icone);

		        // Atribuir a imagem redimensionada à variável imagemCarro
		        imagemCarro = redimensionarCarro(imagePath, larguraImg, alturaImg);
		        
		        // Configurar as coordenadas para posicionar a imagem
		        int x = getWidth() - larguraImg;  // A largura da janela menos a largura da imagem
		        int y = 0;  
		        imageLabel.setBounds(240, 200, 530, alturaImg);
		        
		    }

		    // Função para redimensionar uma imagem para a largura e altura desejadas
		    private ImageIcon redimensionarCarro(String imagePath, int largura, int altura) {
		        ImageIcon originalIcon = new ImageIcon(imagePath);
		        Image imagemOriginal = originalIcon.getImage();
		        Image imagemRedimensionada = imagemOriginal.getScaledInstance(530, altura, Image.SCALE_SMOOTH);
		        return new ImageIcon(imagemRedimensionada);
		    }
		
		

		
		
}
