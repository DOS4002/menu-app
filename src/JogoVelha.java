    import java.awt.Color;
    import java.awt.Font;
    import java.awt.Image;
    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;



    public class JogoVelha extends JDialog implements ActionListener {

        private boolean jogador1Vez = true;
        private boolean jogoAcabou = false;
        private int pontosPlayer1 = 0;
        private int pontosPlayer2 = 0;
        private JTextField nomeJogo1;
        private JTextField nomeJogo2;
        private JLabel nomePlayer1;
        private JLabel nomePlayer2;
        private JButton newGame;
        private JButton resetScore; // Botão para zerar o placar
        private JButton[][] buttons;
        private JLabel txtPlayer2;
        private JLabel txtPlayer1;
        private JLabel pontosLabel1;
        private JLabel pontosLabel2;

        public JogoVelha(Menu tictacToe) {
            this.setTitle("Jogo da Velha");
            this.setSize(780, 630);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.getContentPane().setBackground(Color.WHITE);
            this.setResizable(false);
            this.setModal(true);

            JTabbedPane tabbedPane = new JTabbedPane();

            JPanel jogador1 = new JPanel();
            jogador1.setLayout(null);

            nomePlayer1 = new JLabel("Nome do jogador  X: ");
            nomePlayer1.setBounds(10, 10, 200, 50);
            nomePlayer1.setFont(new Font("Poppins", Font.PLAIN, 20));
            nomePlayer1.setForeground(Color.BLACK);
            jogador1.add(nomePlayer1);

            nomeJogo1 = new JTextField();
            nomeJogo1.setBounds(220, 20, 170, 30);
            nomeJogo1.setFont(new Font("Poppins", Font.PLAIN, 20));
            jogador1.add(nomeJogo1);

            JButton buttonPlayer1 = new JButton("Pronto");
            buttonPlayer1.setBackground(new Color(255, 255, 255));
            buttonPlayer1.setBounds(5, 100, 100, 40);
            buttonPlayer1.setFocusPainted(false);
            buttonPlayer1.addActionListener(this);
            jogador1.add(buttonPlayer1);

            tabbedPane.addTab("Jogador X", null, jogador1, "Digite o nome do primeiro jogador:");

            JPanel jogador2 = new JPanel();
            jogador2.setLayout(null);

            nomePlayer2 = new JLabel("Nome do jogador  O: ");
            nomePlayer2.setBounds(10, 10, 200, 50);
            nomePlayer2.setFont(new Font("Poppins", Font.PLAIN, 20));
            nomePlayer2.setForeground(Color.BLACK);
            jogador2.add(nomePlayer2);

            
            
            

            nomeJogo2 = new JTextField();
            nomeJogo2.setBounds(220, 20, 170, 30);
            nomeJogo2.setFont(new Font("Poppins", Font.PLAIN, 20));
            jogador2.add(nomeJogo2);

            JButton buttonPlayer2 = new JButton("Pronto");
            buttonPlayer2.setBackground(new Color(255, 255, 255));
            buttonPlayer2.setBounds(5, 100, 100, 40);
            buttonPlayer2.setFocusPainted(false);
            buttonPlayer2.addActionListener(this::ActionPlayer2); 
            jogador2.add(buttonPlayer2);

            tabbedPane.addTab("Jogador O", null, jogador2, "Digite o nome do segundo jogador:");

            JPanel gameRun = new JPanel();
            gameRun.setLayout(null);
            tabbedPane.addTab("Jogar", null, gameRun, "Se prepare para jogar!");

            JLabel imgTab = new JLabel();
            imgTab.setBounds(10, 90, 340, 320);
            ImageIcon boardimg = new ImageIcon("src/gameImg/tictac.png");
            Image boardRe = boardimg.getImage().getScaledInstance(imgTab.getWidth(), imgTab.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newBoard = new ImageIcon(boardRe);
            imgTab.setIcon(newBoard);
            gameRun.add(imgTab);

            newGame = new JButton("Nova Partida");
            newGame.setBackground(new Color(255, 255, 255));
            newGame.setBounds(600, 200, 130, 40);
            newGame.setFocusPainted(false);
            gameRun.add(newGame);

            resetScore = new JButton("Zerar Placar");
            resetScore.setBackground(new Color(255, 255, 255));
            resetScore.setBounds(450, 200, 140, 40);
            resetScore.setFocusPainted(false);
            gameRun.add(resetScore);

            txtPlayer1 = new JLabel();
            txtPlayer1.setText("");
            txtPlayer1.setForeground(Color.BLACK);
            txtPlayer1.setBounds(500, 90, 300, 80);
            txtPlayer1.setFont(new Font("Poppins", Font.PLAIN, 20));
            gameRun.add(txtPlayer1);

            txtPlayer2 = new JLabel();
            txtPlayer2.setText("");
            txtPlayer2.setForeground(Color.BLACK);
            txtPlayer2.setBounds(500, 170, 300, 80);
            txtPlayer2.setFont(new Font("Poppins", Font.PLAIN, 20));
            gameRun.add(txtPlayer2);

            pontosLabel1 = new JLabel(nomeJogo1.getText()+" - Pontos: " + pontosPlayer1);
            pontosLabel1.setForeground(Color.BLACK);
            pontosLabel1.setBounds(500, 270, 300, 80);
            pontosLabel1.setFont(new Font("Poppins", Font.PLAIN, 21));
            gameRun.add(pontosLabel1);

            pontosLabel2 = new JLabel(nomeJogo2.getText()+ " - Pontos: " + pontosPlayer2);
            pontosLabel2.setForeground(Color.BLACK);
            pontosLabel2.setBounds(500, 310, 300, 80);
            pontosLabel2.setFont(new Font("Poppins", Font.PLAIN, 21));
            gameRun.add(pontosLabel2);



            // Botões do jogo da velha
            buttons = new JButton[3][3];
            int buttonSize = 100;
            int xOffset = 20;
            int yOffset = 90;

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    buttons[row][col] = new JButton();
                    buttons[row][col].setBounds(xOffset + col * (buttonSize + 10), yOffset + row * (buttonSize + 10), buttonSize, buttonSize);
                    buttons[row][col].setBackground(new Color(238, 238, 238));
                    buttons[row][col].setBorder(null);
                    buttons[row][col].setFocusPainted(false);
                    buttons[row][col].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!jogoAcabou) {
                                JButton button = (JButton) e.getSource();
                                if (button.getText().isEmpty()) {
                                    if (jogador1Vez) {
                                        button.setText("X");
                                        button.setFont(new Font("Poppins", Font.PLAIN, 80));

                                        jogador1Vez = false;
                                    } else {
                                        button.setText("O");
                                        button.setFont(new Font("Poppins", Font.PLAIN, 80));

                                        jogador1Vez = true;
                                    }
                                    button.setEnabled(false); // Desativar o botão após a jogada

                                    // Verificar vitória após a jogada
                                    if (verificarVitoria()) {
                                        jogoAcabou = true;
                                        String nomeVencedor = jogador1Vez ? nomeJogo2.getText() : nomeJogo1.getText();
                                        JOptionPane.showMessageDialog(null, "Jogador " + nomeVencedor + " venceu!", "Fim do Jogo", JOptionPane.INFORMATION_MESSAGE);

                                        // Atualizar a pontuação do jogador vencedor
                                        if (jogador1Vez) {
                                            pontosPlayer2++;
                                        } else {
                                            pontosPlayer1++;
                                        }
                                        atualizarPontuacao();
                                    } else {
                                        verificarEmpate();
                                    }
                                }
                            }
                        }
                    });

                    gameRun.add(buttons[row][col]);
                }
            }

            // Configurar o botão Novo Jogo
            newGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    reiniciarJogo();
                }
            });

            // Configurar o botão Zerar Placar
            resetScore.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    zerarPlacar();
                }
            });

            add(tabbedPane);
            this.setVisible(true);
        }

        private void verificarEmpate() {
            boolean todasAsCelulasPreenchidas = true;
            // Verificar se todas as células estão preenchidas
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (buttons[row][col].getText().isEmpty()) {
                        todasAsCelulasPreenchidas = false;
                        break;
                    }
                }
            }
            
            if (todasAsCelulasPreenchidas && !verificarVitoria()) {
                JOptionPane.showMessageDialog(null, "Empate! O jogo acabou em empate.", "Fim do Jogo", JOptionPane.INFORMATION_MESSAGE);
                reiniciarJogo();
            }
        }
        // Método para verificar se há um vencedor
        private boolean verificarVitoria() {
            // Verificar linhas e colunas
            for (int i = 0; i < 3; i++) {
                if (!buttons[i][0].getText().isEmpty() &&
                    buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][0].getText().equals(buttons[i][2].getText())) {
                    return true; // Linha vencedora
                }
                if (!buttons[0][i].getText().isEmpty() &&
                    buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[0][i].getText().equals(buttons[2][i].getText())) {
                    return true; // Coluna vencedora
                }
            }

            // Verificar diagonais
           if (!buttons[0][0].getText().isEmpty() &&
                buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[0][0].getText().equals(buttons[2][2].getText())) {
                return true; // Diagonal principal
            }
            if (!buttons[0][2].getText().isEmpty() &&
                buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[0][2].getText().equals(buttons[2][0].getText())) {
                return true; // Diagonal secundária
            }

            return false;
        }

        // Método para reiniciar o jogo
        private void reiniciarJogo() {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    buttons[row][col].setText("");
                    buttons[row][col].setEnabled(true); // Reativar os botões
                }
            }
            jogoAcabou = false;
            jogador1Vez = true;
        }

        // Método para zerar o placar
        private void zerarPlacar() {
            pontosPlayer1 = 0;
            pontosPlayer2 = 0;
            atualizarPontuacao();
            reiniciarJogo(); // Reiniciar o jogo após zerar o placar
        }

       



        private void atualizarPontuacao() {
            pontosLabel1.setText(nomeJogo1.getText()+" - Pontos: " + pontosPlayer1);
            pontosLabel2.setText(nomeJogo2.getText()+ " - Pontos: " + pontosPlayer2);
            
        }

        @Override
        public void actionPerformed(ActionEvent event) {
           nomeJogo1.setEnabled(false);
           pontosLabel1.setText(nomeJogo1.getText()+" - Pontos: ");
        }

        public void ActionPlayer2(ActionEvent event){
            nomeJogo2.setEnabled(false);
             pontosLabel2.setText(nomeJogo2.getText()+ " - Pontos: ");
        }

    }
