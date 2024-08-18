package myproject;

import javax.swing.*;
import java.awt.*;

public class Style {
    public static void applyStyles(JComponent component) {
        if (component instanceof JPanel) {
            component.setBackground(new Color(30, 30, 30)); // Fundo escuro
        }

        if (component instanceof JLabel) {
            component.setForeground(Color.WHITE);
            ((JLabel) component).setFont(new Font("Serif", Font.BOLD, 16)); // Fonte dos rótulos
        }

        if (component instanceof JTextArea) {
            component.setBackground(new Color(50, 50, 50)); // Fundo escuro
            component.setForeground(Color.WHITE);
            component.setFont(new Font("Serif", Font.PLAIN, 14)); // Fonte da área de texto
        }

        if (component instanceof JButton) {
            component.setBackground(new Color(50, 50, 50)); // Fundo escuro
            component.setForeground(Color.WHITE);
            component.setFont(new Font("Serif", Font.PLAIN, 14)); // Fonte dos botões
        }

        if (component instanceof JTable) {
            component.setForeground(Color.WHITE);
            component.setBackground(new Color(50, 50, 50)); // Fundo escuro
            JTable table = (JTable) component;
            table.setGridColor(Color.GRAY); // Cor das linhas da tabela
        }
    }

    // Método auxiliar para aplicar estilo a containers
    public static void applyStyles(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JComponent) {
                applyStyles((JComponent) component);
            }
            if (component instanceof Container) {
                applyStyles((Container) component); // Recursão para containers
            }
        }
    }
}
