package myproject;

import javax.swing.*;
import java.awt.*;

public class SkillsAndPowers {

    public static void showSkillsAndPowers(JFrame frame) {
        // Criar uma nova janela
        JFrame skillsFrame = new JFrame("Habilidades e Poderes");
        skillsFrame.setSize(800, 600);
        skillsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Criar um painel principal com layout para exibir as habilidades e poderes
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        Style.applyStyles(panel); // Aplicar estilo ao painel
        skillsFrame.add(panel);

        // Seção de habilidades
        JLabel skillsTitle = new JLabel("Habilidades");
        skillsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(skillsTitle);
        Style.applyStyles(skillsTitle); // Aplicar estilo ao rótulo

        // Usar JEditorPane para suporte a HTML
        JEditorPane skillsText = new JEditorPane();
        skillsText.setContentType("text/html");
        skillsText.setEditable(false);
        skillsText.setText(
                "<html>" +
                "<span style='color: #1E90FF;'>Habilidade Elemental - Minha Flecha Caça Demônios</span> <br>" +
                "<b>Alvo Único | Custo: 2 PS</b> <br><br>" +
                "Este ataque causa dano Hydro 5 vezes. <br>" +
                " - 1º e 2º Ataques: Causa dano Hydro 1d6 para cada ataque.<br>" +
                " - 3º e 4º Ataques: Causa dano Hydro 2d6 para cada ataque.<br>" +
                " - 5º Ataque: Causa dano Hydro 3d8<br><br>" +
                "Após realizar o golpe final, há uma chance fixa de 60% de realizar 1 golpe extra, <br>" +
                "até um máximo de 3 golpes extras.<br><br>" +

                "<span style='color: #00BFFF;'>Habilidade Elemental (Anemo) - Comando de Batalha: É Hora do Chá!</span><br>" +
                "<b>Suporte | Custo: 3 PS</b> <br><br>" +
                "Define um único aliado (excluindo esta unidade) como o Comandante e avança o turno do Comandante. <br>" +
                "Apenas o alvo mais recente da Habilidade de Anya será considerado seu 'Comandante'.<br><br>" +
                "Ao usar um ataque básico, ativa os seguintes efeitos com base no Elemento específico do Comandante:<br>" +
                " - <b>Hydro</b>: Aumenta o dano Hydro de Anya em 20% por 3 turnos.<br>" +
                " - <b>Pyro</b>: Adiciona um efeito de queimadura ao ataque básico do Comandante, causando dano Pyro adicional de 2d6 por 2 turnos.<br>" +
                " - <b>Dendro</b>: Cria uma área de efeito ao redor do Comandante e de Anya que cura 2d4 por 2 turnos + Proficiência Elemental.<br>" +
                " - <b>Cryo</b>: 100% de chance de crítico no último golpe de 'Minha Flecha Caça Demônios'.<br>" +
                " - <b>Electro</b>: Adiciona uma chance fixa de 60% de realizar 1 golpe extra.<br>" +
                " - <b>Veneno</b>: Aplica veneno ao inimigo-alvo, causando 1d8 + Proficiência Elemental de dano por 3 turnos.<br>" +
                " - <b>Físico</b>: Anya realiza um ataque extra no inimigo-alvo, causando 1d6 de dano Hydro.<br>" +
                " - <b>Geo</b>: Cria um escudo Geo para o Comandante ou um aliado, absorvendo dano fixo de ? por 2 turnos.<br>" +
                " - <b>Mítico</b>: Cria um pet de acordo com o elemento principal do Comandante e de Anya. Ambos terão a mesma vida e dano.<br>" +
                " - <b>Psíquico</b>: Aplica um dos seguintes efeitos no inimigo-alvo: Abalado, Agarrado, Cego, Confuso, Desprevenido, Debilitado, Enjoado ou Enredado.<br><br>" +

                "<span style='color: #1E90FF;'>Habilidade Suprema - Canção da Baleia</span><br>" +
                "<b>Em Área (6 metros esféricos) | Custo: 4 PS</b><br><br>" +
                "Aumenta todos os danos causados ao alvo em 20% por 2 turnos. <br>" +
                "Durante o tempo em que a habilidade estiver ativa, o Comandante causará um dano adicional de 10%.<br><br>" +

                "<span style='color: #1E90FF;'>Banquete de Uma Só Vez (Passiva)</span><br>" +
                "Sempre que Anya realizar um ataque extra, recupera 1 ponto de PS.<br><br>" +

                "<span style='color: #1E90FF;'>Ascensão do Comandante (Passiva)</span><br>" +
                "Depois que o Comandante gastar 3 PS ou mais, Anya realiza um ataque extra, <br>" +
                "causando 1d6 de dano Hydro.<br><br>" +

                "<span style='color: #1E90FF;'>Ataque Premeditado (Passiva)</span><br>" +
                "Ataca o inimigo imediatamente. Ao entrar na batalha, Anya causa 1d6 de Dano Hydro.<br>" +
                "</html>"
        );
        skillsText.setPreferredSize(new Dimension(750, 500)); // Ajustar tamanho preferido
        JScrollPane skillsScroll = new JScrollPane(skillsText);
        panel.add(skillsScroll);

        // Mostrar a janela
        skillsFrame.setVisible(true);
    }
}
