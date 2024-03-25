package Task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
public class Window extends JFrame implements ActionListener{
    public static String identificateur;

    JLabel jl=new JLabel("Identifier:");
    JTextField text=new JTextField(20); // Augmenter la taille du JTextField
    JButton jb=new JButton("Log in");

    public Window() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel jp1 = new JPanel();
        jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS)); // Utilisation de BoxLayout avec axe Y
        jp1.setAlignmentX(Component.CENTER_ALIGNMENT); // Alignement au centre sur l'axe X

        jb.setMaximumSize(new Dimension(160, 50)); // Définition de la taille maximale du JButton
        jb.addActionListener(this);
        jp1.add(Box.createVerticalGlue()); // Espace vertical flexible
        jp1.add(Box.createVerticalStrut(10)); // Espace vertical fixe
        jp1.add(jl);
        jp1.add(Box.createVerticalStrut(10));
        jp1.add(text);
        jp1.add(Box.createVerticalGlue());
        jp1.add(jb);

        add(jp1);

        pack(); // Ajuster la taille de la fenêtre aux composants
        this.setBounds(10,10,500,500);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ATM atm = new ATM();
        atm.setVisible(false);
        if(e.getSource()==jb) {
            Service service=new ServiceImp();
            service.addRandomData(3);
            String id=text.getText();
            identificateur=text.getText();
            Account acc=new Account(Math.random()*10000);
            acc.setId(id);
            service.add(acc);
            atm.setVisible(true);
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Window();
    }
}
