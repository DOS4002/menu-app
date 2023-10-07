        import java.awt.Color;
    import java.awt.Font;
    import java.awt.Image;
    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;



    public class JogoVelha extends JDialog implements ActionListener {

        private boolean firstPlayer = true;
        private boolean gameOver = false;
        private int scorePlayerX = 0;
        private int scorePlayerO = 0;
        private JTextField inputPlayerX;
        private JTextField inputPlayerO;
        private JLabel namePlayerX;
        private JLabel namePlayerO;
        private JButton newGame;
        private JButton resetScore;
        private JButton[][]squareBoard;
        private JLabel txtPlayer2;
        private JLabel txtPlayer1;
        private JLabel scoreLabelX;
        private JLabel scoreLabelO;
        private JLabel titleGame;
        private JPanel gameRun;
        private JLabel boardImage;
        private ImageIcon gameBoard;
        private Image editBoard;
        private ImageIcon boardConstructorImage;
        private JTabbedPane tabbedPane;
        private ImageIcon iconPlayerX;
        private ImageIcon iconPlayerO;
        private Image editIconPlayer;
        private ImageIcon iconPlayGame;

        public JogoVelha(Menu tictacToe) {
            this.setTitle("Jogo da Velha");
            this.setSize(780, 630);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.getContentPane().setBackground(Color.WHITE);
            this.setResizable(false);
            this.setModal(true);

            tabbedPane = new JTabbedPane();

            JPanel jogador1 = new JPanel();
            jogador1.setLayout(null);

            namePlayerX = new JLabel("Nome do jogador  X: ");
            namePlayerX.setBounds(10, 10, 200, 50);
            namePlayerX.setFont(new Font("Poppins", Font.PLAIN, 17));
            namePlayerX.setForeground(Color.BLACK);
            jogador1.add(namePlayerX);

            inputPlayerX = new JTextField();
            inputPlayerX.setBounds(200, 20, 170, 30);
            inputPlayerX.setFont(new Font("Poppins", Font.PLAIN, 17));
            jogador1.add(inputPlayerX);

            JButton buttonPlayer1 = new JButton("Pronto");
            buttonPlayer1.setBackground(new Color(255, 255, 255));
            buttonPlayer1.setBounds(5, 100, 100, 40);
            buttonPlayer1.setFocusPainted(false);
            buttonPlayer1.addActionListener(this);
            jogador1.add(buttonPlayer1);

            iconPlayerX = new ImageIcon("src/gameImg/x.png");
            editIconPlayer = iconPlayerX.getImage().getScaledInstance(5, 5, Image.SCALE_SMOOTH);
            iconPlayerX = new ImageIcon(editIconPlayer);

            tabbedPane.addTab("Jogador X", iconPlayerX, jogador1, "Digite o nome do primeiro jogador:");

            JPanel jogador2 = new JPanel();
            jogador2.setLayout(null);

            namePlayerO = new JLabel("Nome do jogador  O: ");
            namePlayerO.setBounds(10, 10, 200, 50);
            namePlayerO.setFont(new Font("Poppins", Font.PLAIN, 17));
            namePlayerO.setForeground(Color.BLACK);
            jogador2.add(namePlayerO);


            inputPlayerO = new JTextField();
            inputPlayerO.setBounds(200, 20, 170, 30);
            inputPlayerO.setFont(new Font("Poppins", Font.PLAIN, 18));
            jogador2.add(inputPlayerO);

            JButton buttonPlayer2 = new JButton("Pronto");
            buttonPlayer2.setBackground(new Color(255, 255, 255));
            buttonPlayer2.setBounds(5, 100, 100, 40);
            buttonPlayer2.setFocusPainted(false);
            buttonPlayer2.addActionListener(this::ActionPlayerO); 
            jogador2.add(buttonPlayer2);

            iconPlayerO = new ImageIcon("src/gameImg/circulo.png");
            editIconPlayer = iconPlayerO.getImage().getScaledInstance(5, 5, Image.SCALE_SMOOTH);
            iconPlayerO = new ImageIcon(editIconPlayer);

            tabbedPane.addTab("Jogador O", iconPlayerO, jogador2, "Digite o nome do segundo jogador:");

            iconPlayGame = new ImageIcon("src/gameImg/play.png");
            editIconPlayer = iconPlayGame.getImage().getScaledInstance(5, 5, Image.SCALE_SMOOTH);
            iconPlayGame = new ImageIcon(editIconPlayer);

            gameRun = new JPanel();
            gameRun.setLayout(null); 

            titleGame = new JLabel("JOGO DA VELHA");
            titleGame.setBounds(510, 90, 200, 50);    
            titleGame.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 21));
            titleGame.setForeground(Color.BLACK);
            gameRun.add(titleGame);


            boardImage = new JLabel();
            boardImage.setBounds(10, 90, 340, 320);
            gameBoard = new ImageIcon("src/gameImg/tictac.png");
            editBoard = gameBoard.getImage().getScaledInstance(boardImage.getWidth(), boardImage.getHeight(), Image.SCALE_SMOOTH);
            boardConstructorImage = new ImageIcon(editBoard);
            boardImage.setIcon(boardConstructorImage);
            gameRun.add(boardImage);

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
            txtPlayer1.setFont(new Font("Poppins", Font.PLAIN, 17));
            gameRun.add(txtPlayer1);

            txtPlayer2 = new JLabel();
            txtPlayer2.setText("");
            txtPlayer2.setForeground(Color.BLACK);
            txtPlayer2.setBounds(500, 170, 300, 80);
            txtPlayer2.setFont(new Font("Poppins", Font.PLAIN, 17));
            gameRun.add(txtPlayer2);

            scoreLabelX = new JLabel("Pontos: " + scorePlayerX);
            scoreLabelX.setForeground(Color.BLACK);
            scoreLabelX.setBounds(500, 270, 300, 80);
            scoreLabelX.setFont(new Font("Poppins", Font.PLAIN, 18));
            gameRun.add(scoreLabelX);

            scoreLabelO = new JLabel("Pontos: " + scorePlayerO);
            scoreLabelO.setForeground(Color.BLACK);
            scoreLabelO.setBounds(500, 310, 300, 80);
            scoreLabelO.setFont(new Font("Poppins", Font.PLAIN, 18));
            gameRun.add(scoreLabelO);



            squareBoard = new JButton[3][3];
            int buttonSize = 100;
            int xOffset = 20;
            int yOffset = 90;

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    squareBoard[row][col] = new JButton();
                    squareBoard[row][col].setBounds(xOffset + col * (buttonSize + 10), yOffset + row * (buttonSize + 10), buttonSize, buttonSize);
                    squareBoard[row][col].setBackground(new Color(238, 238, 238));
                    squareBoard[row][col].setBorder(null);
                    squareBoard[row][col].setFocusPainted(false);
                    squareBoard[row][col].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!gameOver) {
                                JButton button = (JButton) e.getSource();
                                if (button.getText().isEmpty()) {
                                    if (firstPlayer) {
                                        button.setText("X");
                                        button.setFont(new Font("Poppins h", Font.PLAIN, 80));

                                        firstPlayer = false;
                                    } else {
                                        button.setText("O");
                                        button.setFont(new Font("Poppins h", Font.PLAIN, 80));

                                        firstPlayer = true;
                                    }
                                    button.setEnabled(false); // Desativar o botão após a jogada

                                    // Verificar vitória após a jogada
                                    if (verificarVitoria()) {
                                        gameOver = true;
                                        String nomeVencedor = firstPlayer ? inputPlayerO.getText() : inputPlayerX.getText();
                                        JOptionPane.showMessageDialog(null, "Jogador " + nomeVencedor + " venceu!", "Fim do Jogo", JOptionPane.INFORMATION_MESSAGE);

                                        // Atualizar a pontuação do jogador vencedor
                                        if (firstPlayer) {
                                            scorePlayerO++;
                                        } else {
                                            scorePlayerX++;
                                        }
                                        atualizarPontuacao();
                                    } else {
                                        verificarEmpate();
                                    }
                                }
                            }
                        }
                    });

                    gameRun.add(squareBoard[row][col]);
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
                    if (squareBoard[row][col].getText().isEmpty()) {
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
                if (!squareBoard[i][0].getText().isEmpty() &&
                    squareBoard[i][0].getText().equals(squareBoard[i][1].getText()) &&
                    squareBoard[i][0].getText().equals(squareBoard[i][2].getText())) {
                    return true; // Linha vencedora
                }
                if (!squareBoard[0][i].getText().isEmpty() &&
                    squareBoard[0][i].getText().equals(squareBoard[1][i].getText()) &&
                    squareBoard[0][i].getText().equals(squareBoard[2][i].getText())) {
                    return true; // Coluna vencedora
                }
            }

            // Verificar diagonais
           if (!squareBoard[0][0].getText().isEmpty() &&
                squareBoard[0][0].getText().equals(squareBoard[1][1].getText()) &&
                squareBoard[0][0].getText().equals(squareBoard[2][2].getText())) {
                return true; // Diagonal principal
            }
            if (!squareBoard[0][2].getText().isEmpty() &&
                squareBoard[0][2].getText().equals(squareBoard[1][1].getText()) &&
                squareBoard[0][2].getText().equals(squareBoard[2][0].getText())) {
                return true; // Diagonal secundária
            }

            return false;
        }

        // Método para reiniciar o jogo
        private void reiniciarJogo() {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    squareBoard[row][col].setText("");
                    squareBoard[row][col].setEnabled(true); // Reativar os botões
                }
            }
            gameOver = false;
            firstPlayer = true;
        }

        // Método para zerar o placar
        private void zerarPlacar() {
            scorePlayerX = 0;
            scorePlayerO = 0;
            atualizarPontuacao();
            reiniciarJogo(); // Reiniciar o jogo após zerar o placar
        }


        private void atualizarPontuacao() {
            scoreLabelX.setText(inputPlayerX.getText()+" - Pontos: " + scorePlayerX);
            scoreLabelO.setText(inputPlayerO.getText()+" - Pontos: " + scorePlayerO);
            
        }

        @Override
        public void actionPerformed(ActionEvent event) {
           inputPlayerX.setEnabled(false);
           scoreLabelX.setText(inputPlayerX.getText()+" - Pontos: " + scorePlayerX);
           if(inputPlayerX.getText().isEmpty()){
                inputPlayerX.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Digite o nome do jogador X", "Erro", JOptionPane.ERROR_MESSAGE);
           }
        }

        public void ActionPlayerO(ActionEvent event){
            inputPlayerO.setEnabled(false);
                
             scoreLabelO.setText(inputPlayerO.getText()+ " - Pontos: " + scorePlayerO);
                if(inputPlayerO.getText().isEmpty()){
                    inputPlayerO.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Digite o nome do jogador O", "Erro", JOptionPane.ERROR_MESSAGE);
                }

                if(inputPlayerX.getText().isEmpty() == false && inputPlayerO.getText().isEmpty() == false){
                 tabbedPane.addTab("Jogar", iconPlayGame, gameRun, "Se prepare para jogar!");
            }
        }

    }
