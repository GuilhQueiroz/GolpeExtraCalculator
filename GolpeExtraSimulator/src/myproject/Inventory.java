package myproject;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Inventory {

    private int dinheiro;
    private int espacoDisponivel;
    private final int ESPACO_INICIAL = 12;
    private final int CUSTO_ARMA = 2;

    public Inventory(int dinheiroInicial) {
        this.dinheiro = dinheiroInicial;
        calcularEspacoDisponivel();
    }

    // Calcular baseado no dinheiro
    private void calcularEspacoDisponivel() {
        int espaco = ESPACO_INICIAL - (dinheiro / 2000) - CUSTO_ARMA;
        espacoDisponivel = Math.max(0, espaco); // Garantir que o slot não seja negativo
    }

    // Atualizar o valor e recalcular o espaço
    public void atualizarDinheiro(int novoDinheiro) {
        this.dinheiro = novoDinheiro;
        calcularEspacoDisponivel();
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public int getEspacoDisponivel() {
        return espacoDisponivel;
    }

    // Tela do Inventário
    public void showInventory(JFrame frame) {
        frame.setLayout(new BorderLayout());
        Style.applyStyles(frame.getContentPane()); // Aplicar estilo ao conteúdo do frame

        // Criar o modelo da tabela
        String[] columnNames = {"", ""}; // Colunas vazias para títulos
        Object[][] data = {
            {"Arma:", "Arco"},
            {"Dano:", "1d6"},
            {"Crítico:", "20x3"},
            {"Distância:", "30 metros (20 quadrados)"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Não permitir edição das células
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(30); // Altura das linhas
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(50, 50, 50));
        table.setGridColor(Color.GRAY); // Cor das linhas da tabela

        // Adicionar a tabela a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Adicionar o painel de informações no topo
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        topPanel.setBackground(new Color(50, 50, 50)); // Cor de fundo para o painel
        frame.add(topPanel, BorderLayout.NORTH);

        JLabel dinheiroLabel = new JLabel("Dinheiro: M$=");
        dinheiroLabel.setForeground(Color.WHITE); // Cor do texto
        topPanel.add(dinheiroLabel);
        Style.applyStyles(dinheiroLabel); // Aplicar estilo ao rótulo

        JTextField dinheiroField = new JTextField(String.valueOf(getDinheiro()));
        dinheiroField.setForeground(Color.WHITE); // Cor do texto
        dinheiroField.setBackground(new Color(70, 70, 70)); // Cor de fundo
        topPanel.add(dinheiroField);

        JLabel espacoLabel = new JLabel("Espaço disponível:");
        espacoLabel.setForeground(Color.WHITE); // Cor do texto
        topPanel.add(espacoLabel);
        Style.applyStyles(espacoLabel); // Aplicar estilo ao rótulo

        JLabel espacoValueLabel = new JLabel(String.valueOf(getEspacoDisponivel()));
        espacoValueLabel.setForeground(Color.WHITE); // Cor do texto
        topPanel.add(espacoValueLabel);

        // Listener para atualizar o slot sempre que o valor do dinheiro for alterado
        dinheiroField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                atualizarEspaco();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                atualizarEspaco();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                atualizarEspaco();
            }

            private void atualizarEspaco() {
                try {
                    int novoDinheiro = Integer.parseInt(dinheiroField.getText());
                    atualizarDinheiro(novoDinheiro);
                    espacoValueLabel.setText(String.valueOf(getEspacoDisponivel()));
                } catch (NumberFormatException ex) {
                    // Ignorar se o valor não for um número válido
                }
            }
        });

        // Configurar o frame
        frame.setSize(400, 210);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
