package Task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.List;
public class ATM extends JFrame implements ActionListener{
    JButton jb1 = new JButton("withdraw");
    JButton jb2 = new JButton("deposit");
    JButton jb3 = new JButton("check balance");
    List liste=new List();
    public ATM() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel jp1 = new JPanel();
        jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS)); // Utilisation de BoxLayout avec axe Y
        jp1.setAlignmentX(Component.CENTER_ALIGNMENT); // Alignement au centre sur l'axe X
        JPanel jp2 = new JPanel();
        jp2.setLayout(new GridLayout());
        jp2.setSize(300,50);
        jb1.setMaximumSize(new Dimension(150, 50)); // Définition de la taille maximale des boutons
        jb2.setMaximumSize(new Dimension(150, 50));
        jb3.setMaximumSize(new Dimension(150, 50));
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jp1.add(Box.createVerticalGlue()); // Espace vertical flexible
        jp1.add(jb1);
        jp1.add(Box.createVerticalStrut(10)); // Espace vertical fixe
        jp1.add(jb2);
        jp1.add(Box.createVerticalStrut(10));
        jp1.add(jb3);
        jp1.add(Box.createVerticalGlue());

        this.add(jp1);
        this.add(jp2,BorderLayout.SOUTH);
        jp2.add(liste);
        pack(); // Ajuster la taille de la fenêtre aux composants
        this.setBounds(10,10,500,500);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        setVisible(true);
    }

    public static void main(String[] args) {
        new ATM();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        ATM2 atm2 = new ATM2();
        ATM1 atm1 = new ATM1();
        if(e.getSource()==jb1) {
            atm2.setVisible(false);
            atm1.setVisible(true);
            setVisible(false);
        }
        if(e.getSource()==jb2) {
            atm1.setVisible(false);
            atm2.setVisible(true);
            setVisible(false);
        }
        if(e.getSource()==jb3) {
            atm1.setVisible(false);
            atm2.setVisible(false);
            Service service=new ServiceImp();
            String id= Window.identificateur;
            try{
                Account acc=service.getAccById(id);
                liste.add("votre montant est:"+acc.getBalance());
            }
            catch(AccountNotFoundException err){
                JOptionPane.showMessageDialog(this, "Invalid Task2.Account.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

