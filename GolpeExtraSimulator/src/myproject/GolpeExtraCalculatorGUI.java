package myproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GolpeExtraCalculatorGUI {
    private static final Random random = new Random();
    private static final double CHANCE_GOLPE_EXTRA = 0.60; // 60%
    
    private static Inventory inventory = new Inventory(9600);
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculador de Golpe Extra");
        frame.setSize(750, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        Style.applyStyles(panel); // Aplicar estilo ao painel
        
        JLabel inputLabel = new JLabel("Insira os danos dos ataques separados por vírgula:");
        inputLabel.setBounds(10, 20, 400, 25);
        panel.add(inputLabel);
        Style.applyStyles(inputLabel); // Aplicar estilo ao rótulo
        
        JTextField inputField = new JTextField();
        inputField.setBounds(10, 50, 300, 25);
        panel.add(inputField);
        
        JButton calculateButton = new JButton("Calcular Golpes Extras");
        calculateButton.setBounds(10, 80, 200, 25);
        panel.add(calculateButton);
        Style.applyStyles(calculateButton); // Aplicar estilo ao botão
        
        JTextArea extraHitsResult = new JTextArea();
        extraHitsResult.setLineWrap(true);
        extraHitsResult.setWrapStyleWord(true);
        extraHitsResult.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(extraHitsResult);
        scrollPane.setBounds(10, 120, 450, 100);
        panel.add(scrollPane);
        Style.applyStyles(extraHitsResult); // Aplicar estilo à área de texto
        
        // Botão "Inventário"
        JButton inventoryButton = new JButton("Inventário");
        inventoryButton.setBounds(220, 80, 120, 25);
        panel.add(inventoryButton);
        Style.applyStyles(inventoryButton); // Aplicar estilo ao botão
        
        // Botão "Habilidades e Poderes"
        JButton skillsButton = new JButton("Habilidades");
        skillsButton.setBounds(350, 80, 180, 25);
        panel.add(skillsButton);
        Style.applyStyles(skillsButton); // Aplicar estilo ao botão
        
        // Botão para novas habilidades
        JButton newSkillsButton = new JButton("Novas Habilidades");
        newSkillsButton.setBounds(540, 80, 200, 25);
        panel.add(newSkillsButton);
        Style.applyStyles(newSkillsButton); // Aplicar estilo ao botão
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int[] danos = parseDanos(input);
                    int golpesExtras = calcularGolpesExtras(danos);
                    int danoExtra = calcularDanoExtra(golpesExtras);
                    int danoTotal = calcularDanoTotal(danos, danoExtra);
                    
                    String resultado = "Golpe Extra: " + golpesExtras + "\n";
                    resultado += "Dano Extra: " + danoExtra + "\n";
                    resultado += "Dano Total: " + danoTotal;
                    extraHitsResult.setText(resultado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Por favor, insira danos válidos separados por vírgula.");
                }
            }
        });
        
        // Ação do botão "Inventário"
        inventoryButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		JFrame inventoryFrame = new JFrame("Inventário");
        		inventoryFrame.setSize(300, 300);
        		inventoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		
        		inventory.showInventory(inventoryFrame);
                inventoryFrame.setVisible(true);
        	}
        });
        
        // Ação do botão "Habilidades e Poderes"
        skillsButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		SkillsAndPowers.showSkillsAndPowers(null);
        	}
        });
        
        // Ação do botão "novas habilidades"
        newSkillsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewSkillsAndPowers.showNewSkillsAndPowers(null);
            }
        });
    }

    private static int[] parseDanos(String input) {
        String[] parts = input.split(",");
        int[] danos = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            danos[i] = Integer.parseInt(parts[i].trim());
        }
        return danos;
    }
    
    private static int calcularGolpesExtras(int[] danos) {
        int golpesExtras = 0;
        for (int i = 0; i < 3; i++) {
            if (random.nextDouble() < CHANCE_GOLPE_EXTRA) {
                golpesExtras++;
            }
        }
        return golpesExtras;
    }
    
    private static int calcularDanoExtra(int golpesExtras) {
        int danoExtra = 0;
        for (int i = 0; i < golpesExtras; i++) {
            danoExtra += random.nextInt(6) + 1; // Simular o 1d6
        }
        return danoExtra;
    }
    
    private static int calcularDanoTotal(int[] danos, int danoExtra) {
        int danoTotal = 0;
        for (int dano : danos) {
            danoTotal += dano;
        }
        return danoTotal + danoExtra;
    }
}
