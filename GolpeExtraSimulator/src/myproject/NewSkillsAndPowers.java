package myproject;

import javax.swing.*;
import java.awt.*;

public class NewSkillsAndPowers {

    public static void showNewSkillsAndPowers(JFrame frame) {
        // Criar uma nova janela
        JFrame newSkillsFrame = new JFrame("Novas Habilidades e Poderes");
        newSkillsFrame.setSize(800, 350);
        newSkillsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Criar um painel principal com layout para exibir as habilidades e poderes
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        Style.applyStyles(panel); // Aplicar estilo ao painel
        newSkillsFrame.add(panel);

        // Seção de habilidades 
        JLabel skillsTitle = new JLabel("Novas Habilidades e Poderes");
        skillsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(skillsTitle);
        Style.applyStyles(skillsTitle); // Aplicar estilo ao rótulo

        // Usar JTextPane para renderizar HTML
        JTextPane skillsText = new JTextPane();
        skillsText.setContentType("text/html"); // Definir o tipo de conteúdo como HTML
        skillsText.setEditable(false);
        skillsText.setText(
                "<html>" +
                "<span style='color: #1E90FF;'>Origem: Militar</span><br>" +
                "<b>Em Guarda</b>: +2 HP e 2 CA<br><br>" +

                "<span style='color: #1E90FF;'>Caminho Estelar: A Ordem</span><br>" +
                "Você pode reorganizar a ordem de Iniciativa sua e dos aliados que possam ouvi-lo. Você só pode fazer um número de alterações na ordem equivalente ao seu valor de INT.<br><br>" +

                "<span style='color: #1E90FF;'>Rastros: Ataque Debilitante</span><br>" +
                "Ao acertar um ataque, você pode gastar 2 PS para que o próximo teste de ataque do alvo sofra uma penalidade equivalente ao seu valor de AGI.<br><br>" +

                "<span style='color: #1E90FF;'>Ataque Carregado: Comandante</span><br>" +
                "Ao atacar, independente de acertar ou errar, soma seu valor de PRE no teste de ataque e dano do próximo ataque de um aliado em alcance curto (9 metros (6 quadrados)).<br>" +
                "</html>"
        );
        JScrollPane skillsScroll = new JScrollPane(skillsText);
        panel.add(skillsScroll);

        // Mostrar a janela
        newSkillsFrame.setVisible(true);
    }
}
