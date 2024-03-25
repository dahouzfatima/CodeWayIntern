package Task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM2 extends JFrame implements ActionListener {
    private ATM atm;
    JLabel jl=new JLabel("amount:");
    JTextField amount=new JTextField(20); // Augmenter la taille du JTextField
    JButton jb=new JButton("confirm");

    public ATM2() {
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
        jp1.add(amount);
        jp1.add(Box.createVerticalGlue());
        jp1.add(jb);
        jb.addActionListener(this);
        add(jp1);

        pack(); // Ajuster la taille de la fenêtre aux composants
        this.setBounds(10,10,500,500);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        setVisible(true);
    }
    public static void main(String[] args) {
        new ATM2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id= Window.identificateur;
        Service service=new ServiceImp();
        if(e.getSource()==jb) {
            try{
                service.deposite(id,Integer.parseInt(amount.getText()));
                JOptionPane.showMessageDialog(null, "deposite with Succes.", "infos", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false); // Déplacer cette ligne après la boîte de dialogue
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
            catch(AccountNotFoundException err){
                JOptionPane.showMessageDialog(this, "Invalid Task2.Account.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            setVisible(false);
        }

    }
}
