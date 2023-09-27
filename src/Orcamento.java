import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import javax.swing.plaf.synth.ColorType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.awt.event.*; 

public  class Orcamento extends JDialog  {
	
	
private JLabel title;
private JLabel nome;
private JLabel celular;
private JLabel email;
private JLabel marca;
private JLabel modelo;
private ImageIcon logo;
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
private JMenuBar principal;
private JMenu arq;
private JMenu orc; 
private JMenu cadastro;
private JMenu ajuda;
private JMenu lojas;
private JMenu opc;
private JMenuItem viOrc;
private JMenuItem itemNv;
private JMenuItem itemSair;
private JMenuItem itemNovo;
private JMenuItem itemSobre;
private JMenuItem saoPaulo;
private JMenuItem rioJan;
private JMenuItem santaCat;
private JMenuItem copy;
private JMenuItem cadastroUs;
private JMenuItem faleNos;
private ImageIcon imagemCarro;


	
		public Orcamento(){	
			this.setTitle("Concession�ria");
			this.setSize(800, 700);	
			this.setResizable(false);
		
			 this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
	

			 JPanel painel = new JPanel() {
		            @Override
		            /* Criando um paint para desenha a imagem e chamar ela*/
		            protected void paintComponent(Graphics g) {
		            	/* Chamando a variavel "g" com o super*/
		                super.paintComponent(g);
		                Image img = new ImageIcon("src/carros/cdCar.png").getImage();
		                /* drawImage serve para desenhar a imagem, como aumentar a imagem ou mexer ou eixo x e y*/
		                g.drawImage(img, 0, -20, 200, 200, this);
		            }
		        };
		        painel.setLayout(null);
			
		       
		        
		      principal = new JMenuBar();
		        
		        
		        arq = new JMenu("Arquivo");
		        opc = new JMenu("Op��es");
		        orc = new JMenu("Or�amento");
		        cadastro = new JMenu("Cadastrar");
		        lojas = new JMenu("Lojas");
		        ajuda = new JMenu("Ajuda");
			
		       
		        viOrc = new JMenuItem("Vizualisar Or�amento");
		        viOrc.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					
				        // Obtenha os valores do modelo e da marca
				        String marca = (String) cbMarca.getSelectedItem();
				        String modelo = (String) cbModelo.getSelectedItem();
				        String cor = rbBranco.isSelected() ? "branco" : rbVermelho.isSelected() ? "vermelho" : "preto";
				      
				        double valorAr = 400;
						  double valorDire = 700;
						  double valorRodas = 800;
						  double valorMulti = 300;
						  double valorTeslaS = 10000.00;
						  double valorTeslaX = 2000000.0;
						  double valorCorollaSpo = 100000.0 * 1000;
						  double valorCorollaGLI = 9000.0;
						  double valor = 0;
						 
						  
						// Obtenha os valores dos checkboxes selecionados
						  String opcionais = "<html>";
						  if (Arcondicionado.isSelected()) {
						      opcionais += "Ar Condicionado " + "R$" + valorAr + "<br>";
						      valor += valorAr;
						  }
						  if (Hidraulica.isSelected()) {
						      opcionais += "Dire��o Hidr�ulica " + "R$" + valorDire + "<br>";
						      valor += valorDire;
						  }
						  if (rodasLeve.isSelected()) {
						      opcionais += "Rodas Leve " + "R$" + valorRodas + "<br>";
						      valor += valorRodas;
						  }
						  if (Multimidaia.isSelected()) {
						      opcionais += "Multim�dia " + "R$" + valorMulti + "<br>";
						      valor += valorMulti;
						  }
						  opcionais += "</html>";

				        
				        if("Tesla-S".equals(modelo)) {
				        	modelo += " R$" + valorTeslaS;
				        	valor += valorTeslaS;
				        }
				        else if("Tesla-X".equals(modelo)) {
				        	modelo += " R$" + valorTeslaX;
				        	valor += valorTeslaX;
				        }
				        
				        if("corollaSport".equals(modelo)) {
				        	modelo += " R$" + valorCorollaSpo;
				        	valor += valorCorollaSpo;
				        }else if("corollaGLi".equals(modelo)) {
				        	modelo += " R$" + valorCorollaGLI;
				        	valor += valorCorollaGLI;
				        }
				 
				        
				        // Crie uma inst�ncia de visuOrcamento e passe os dados
				        visuOrcamento visuOrcamentoDialog = new visuOrcamento( marca, modelo, opcionais, valorAr, valorDire, valorRodas, valorMulti, valorTeslaS, valorTeslaX, valorCorollaSpo, valor, imagemCarro);
				        // Defina a imagem no visuOrcamento
				        visuOrcamentoDialog.definirImagem(imagemCarro);

				        visuOrcamentoDialog.setVisible(true);
				    }
				});

		        
		        
		        itemNv = new JMenuItem("usuario");
		        itemNv.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Usuario Usuario = new Usuario();
						Usuario.setVisible(true);	
					}
		        	
		        });
		        
		        itemSobre = new JMenuItem("Sobre a CD AUTOCAR");
		        itemSobre.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						SobreNos sobreNos = new SobreNos();
						sobreNos.setVisible(true);
					}
					
		        });
		        
		        itemSair = new JMenuItem("Sair");
		        itemSair.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						

					int sair =	JOptionPane.showConfirmDialog(null,"Voc� quer sair da concession�ria ?","Aten��o", JOptionPane.YES_NO_OPTION);
							if(sair == JOptionPane.YES_OPTION){
								System.exit(0);
						}
					}
		        	
		        });
		        
		        copy = new JMenuItem("Copiar");
		        copy.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						 JOptionPane.showMessageDialog(null,"Informa��es copiadas com sucesso!!","Aten��o", JOptionPane.WARNING_MESSAGE);
						
					}
		        	
		        });
		        
		        
		    
		        
		        
		        saoPaulo = new JMenuItem("S�o Paulo");
		        saoPaulo.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						JOptionPane.showMessageDialog(null,"A CD autoCars tambem esta em:\n"+
								"Ferraz: Vila Margarida - 581.\n"+
								"------------------------------\n"+
								"Mogi: Vila Oliveira - 370.\n"+
								"------------------------------\n"+
								"Suzano: Casa Branca - 120.\n"+
								"------------------------------\n"+
								"Butant�: Vila Indiana - 890."
								);
						
					}
		        	
		        });
		        
		        rioJan = new JMenuItem("Rio de Janeira");
		        rioJan.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						JOptionPane.showMessageDialog(null,"A CD autoCars tambem esta em:\n"+
								"Duque de Caxias: Laureano - 721.\n"+
								"------------------------------\n"+
								"Guapimirim: Barreira - 469.\n"+
								"------------------------------\n"+
								"Nil�polis: Manoel Reis - 323.\n"+
								"------------------------------\n"+
								"Niter�i: S�o Francisco  - 880."
								);
						
					}
		        	
		        });
		        
		        
		        santaCat = new JMenuItem("Santa Catarina");
		        santaCat.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						JOptionPane.showMessageDialog(null,"A CD autoCars tambem esta em:\n"+
								"Joinville: Am�rica - 122.\n"+
								"------------------------------\n"+
								"Florian�polis: Itacorubi - 360.\n"+
								"------------------------------\n"+
								"Blumenau: Fid�lis - 523.\n"+
								"------------------------------\n"+
								"S�o Jos�: Barreiros  - 985."
								);
						
					}
		        	
		        });
		        
		        
		        itemNovo = new JMenuItem("Novo");
		        itemNovo.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						

					int criar =	JOptionPane.showConfirmDialog(null,"Quer criar novas inform��es?","Criar", JOptionPane.YES_NO_OPTION);
						if(criar == JOptionPane.YES_OPTION) {
							 txNome.setText("");
				                txCelular.setText("");
				                txEmail.setText("");
				                cbMarca.setSelectedIndex(0);
				                cbModelo.removeAllItems();
				                rbBranco.setSelected(false);
				                rbVermelho.setSelected(false);
				                rbPreto.setSelected(false);
				                Arcondicionado.setSelected(false);
				                Hidraulica.setSelected(false);
				                rodasLeve.setSelected(false);
				                Multimidaia.setSelected(false);

				                // Limpar o JLabel da imagem
				                imageLabel.setIcon(null);
						}
					}
		        	
		        });
		        
		        

		        
		        faleNos = new JMenuItem("Fale com nosco");
		        faleNos.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						FalecNos FalecNos = new FalecNos();
						FalecNos.setVisible(true);
					}
		        });		
		        
		        
		      
		     
		       
		       setJMenuBar(principal);
		       principal.add(arq);
		       //Arquivo
		     
		      
		       arq.add(itemSair);
		      
		       
		       principal.add(opc);
		       //edit
		       opc.add(itemNovo);
		       opc.add(copy);
	
		       principal.add(orc);
		       //Or�amento
		       orc.add(viOrc);
		       
		       
		       principal.add(cadastro);
		       //cadastro
		       cadastro.add(itemNv);
		       
		       
		       principal.add(lojas);
		       //lojas
		       lojas.add(saoPaulo);
		       lojas.add(rioJan);
		       lojas.add(santaCat);
		       
		       principal.add(ajuda);
		       //ajuda
		       ajuda.add(itemSobre);
		       ajuda.add(faleNos);
		       
		
			title = new JLabel("Concession�ria CD AutoCars");
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
			        // S� pode colocar numeros dentro do JTextField ou seja se for um caracter que n�o seja um numero, ele sera ignorado
			        if (!Character.isDigit(c)  && c != '-' && c != '(' && c != ')' && c != KeyEvent.VK_BACK_SPACE) {
			            e.consume(); // Ignora caracteres que n�o s�o numeros ou " - "
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
			            e.consume(); // Ignora caracteres que n�o s�o '.', '@' ou alfanum�ricos
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
		        painel.add(opcionais);
		        
		        Arcondicionado = new JCheckBox("Ar Condicionado");
		        Arcondicionado.setBounds(10, 470, 180, 30);
		        add(Arcondicionado);

		        Hidraulica = new JCheckBox("Dire��o Hidr�ulica");
		        Hidraulica.setBounds(10, 500, 180, 30);
		        add(Hidraulica);

		        rodasLeve = new JCheckBox("Rodas Leve");
		        rodasLeve.setBounds(10, 530, 180, 30);
		        add(rodasLeve);

		        Multimidaia = new JCheckBox("Multim�dia");
		        Multimidaia.setBounds(10, 560, 180, 30);
		        add(Multimidaia);
			
			   JPanel botoesPanel = new JPanel();
		        botoesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		        botoesPanel.setBounds(1, 600, 770, 50); 

		        salvar = new JButton("Salvar");
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
						String mensagem = "Informa��es salvas:\n" +
						                  "Nome: " + txNome.getText() + "\n" +
						                  "Celular: " + celular + "\n" +
						                  "Email: " + txEmail.getText() + "\n" +
						                  "Marca: " + marcaSelected + "\n" +
						                  "Modelo: " + modeloSelected  + "\n" +
						                  "Cores: " + coresSelected + "\n" +
						                  "Opcionais: ";
				
					
						if (arSelected) {
						    mensagem += " Ar Condicionado " /*+ valorAr + " R$\n"*/;
						   
						}
						if (hidrauSelected) {
						    mensagem += " Dire��o Hidr�ulica " /*+ valorDire + " R$\n"*/;
						}
						if (rodasSelected) {
						    mensagem += " Rodas Leve " /*+ valorRodas + " R$\n"*/;
						}
						if (multiSelected) {
						    mensagem += " Multim�dia-" /*+ valorMulti + " R$\n"*/;
						}


						JOptionPane.showMessageDialog(null, mensagem);
					}
		        });
		        
		        
		    
		        
		        
		        cancelar = new JButton("Cancelar");
		        cancelar.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	int cancel = JOptionPane.showConfirmDialog(null,"Quer mesmo cancelar as informa��es ?","Opni�o", JOptionPane.YES_NO_OPTION);
		        		if(cancel == JOptionPane.YES_OPTION) {
		            	
		                // Limpar todos os campos e sele��es
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
		                JOptionPane.showMessageDialog(null,"Itens cancelados com sucesso!!", "Remo��o",JOptionPane.WARNING_MESSAGE);
		            }
		           }
		        });

		        botoesPanel.add(salvar);
		        botoesPanel.add(cancelar);
		     
			
		        imageLabel = new JLabel();
			
			/* adicionando os buttons,TextsFilds,label e title em cima do painel para a imagem ficar no background*/

			painel.add(title);
			painel.add(txNome);
			painel.add(nome);
			painel.add(celular);
			painel.add(txCelular);
			painel.add(email);
			painel.add(txEmail);
			painel.add(marca);
			painel.add(cbMarca);
			painel.add(modelo);
			painel.add(cbModelo);
			painel.add(Arcondicionado);
			painel.add(Hidraulica);
			painel.add(rodasLeve);
			painel.add(Multimidaia);
			painel.add(rbBranco);
			painel.add(rbVermelho);
			painel.add(rbPreto);
			painel.add(botoesPanel);
			painel.add(imageLabel);
		
		
			
			this.setLayout(null);
			this.setVisible(true);	
			/* setContentPane serve para mostrar qual painel vai ser principal*/
			  setContentPane(painel);
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
			// verificando qual item esta selecionado, e colocando duas condi��es (verdadeira e falsa)
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

		        // Redimensionar a imagem para um tamanho espec�fico 
		      
		        ImageIcon icone = redimensionarCarro(imagePath, larguraImg, alturaImg);
		        imageLabel.setIcon(icone);

		        // Atribuir a imagem redimensionada � vari�vel imagemCarro
		        imagemCarro = redimensionarCarro(imagePath, larguraImg, alturaImg);
		        
		        // Configurar as coordenadas para posicionar a imagem
		        int x = getWidth() - larguraImg;  // A largura da janela menos a largura da imagem
		        int y = 0;  
		        imageLabel.setBounds(240, 200, 530, alturaImg);
		        
		    }

		    // Fun��o para redimensionar uma imagem para a largura e altura desejadas
		    private ImageIcon redimensionarCarro(String imagePath, int largura, int altura) {
		        ImageIcon originalIcon = new ImageIcon(imagePath);
		        Image imagemOriginal = originalIcon.getImage();
		        Image imagemRedimensionada = imagemOriginal.getScaledInstance(530, altura, Image.SCALE_SMOOTH);
		        return new ImageIcon(imagemRedimensionada);
		    }
		
		

		
		
}

