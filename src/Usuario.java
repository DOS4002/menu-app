import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Usuario extends JDialog {
	private JTextField campoNome;
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JButton botaoCadastrar;
    private JTextField campoCPF;
    private  JLabel labelTitulo;
	public Usuario() {
		// Configurar a janela
        setTitle("Cadastro de Usuário");
        setSize(600, 500);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
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
     

        labelTitulo = new JLabel("Cadastro de Usuário");
        labelTitulo.setBounds(250, 50, 400, 30); // Ajuste a posição aqui
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        add(labelTitulo);


      
        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField();
        labelNome.setBounds(50, 150, 100, 30);
        campoNome.setBounds(150, 150, 200, 30);
        campoNome.setToolTipText("Digite seu Nome");

        JLabel labelEmail = new JLabel("Email:");
        campoEmail = new JTextField();
        labelEmail.setBounds(50, 200, 100, 30);
        campoEmail.setBounds(150, 200, 200, 30);
        campoEmail.setToolTipText("Digite seu Email");

        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField();
        labelSenha.setBounds(50, 250, 100, 30);
        campoSenha.setBounds(150, 250, 200, 30);
        campoSenha.setToolTipText("Digite sua Senha");
   
        JLabel labelCpf = new JLabel("CPF:");
        campoCPF = new JTextField();
        
        campoCPF.addKeyListener(new KeyListener() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		    	//aceitando apenas determinados caracteres.
		        char c = e.getKeyChar();
		        /// Só permite números ou o caractere "-"
		        if (!Character.isDigit(c) && c != '-' && c != KeyEvent.VK_BACK_SPACE) {
		            e.consume();
		        }
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		    }
		});
        labelCpf.setBounds(50, 300, 100, 30);
        campoCPF.setBounds(150, 300, 200, 30);
        campoCPF.setToolTipText("Digite seu CPF");
        
        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(210, 350, 100, 30);
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        // Adicionar componentes à janela
        add(labelNome);
        add(campoNome);
        add(labelEmail);
        add(campoEmail);
        add(labelSenha);
        add(campoSenha);
        add(botaoCadastrar);
        add(labelCpf); 
        add(campoCPF);
        add(labelTitulo);
        
        panel.add(labelNome);
        panel.add(campoNome);
        panel.add(labelEmail);
        panel.add(campoEmail);
        panel.add(labelSenha);
        panel.add(campoSenha);
        panel.add(botaoCadastrar);
        panel.add(campoCPF);
        panel.add(labelCpf);
        panel.add(labelTitulo);

        // Exibir a janela
        setVisible(true);
        setLayout(null);
        setContentPane(panel);
    }

    private void cadastrarUsuario() {
        String nome = campoNome.getText();
        String email = campoEmail.getText();
        char[] senhaChars = campoSenha.getPassword();
        String senha = new String(senhaChars);
        String cpf = campoCPF.getText();
      

        

        JOptionPane.showMessageDialog(this, "Usuário cadastrado:\nNome: " + nome + "\nEmail: " + email + "\nCPF: " + cpf );

        // Limpar os campos após o cadastro
        campoNome.setText("");
        campoEmail.setText("");
        campoSenha.setText("");
        campoCPF.setText("");
    }
	}

