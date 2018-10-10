import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private Container cp;
    private JMenuBar jmbr =new JMenuBar();
    private JMenu jm1 =new JMenu("File");
    private JMenu jm2 =new JMenu("Tool");
    private JMenu jm3 =new JMenu("Game");
    private JMenu jm4 =new JMenu("Help");
    private JMenuItem jmop =new JMenuItem("Open");
    private JMenuItem jmcl =new JMenuItem("Close");
    private JMenuItem jmexit =new JMenuItem("Exit");
    private JMenuItem jmOOXX =new JMenuItem("OOXX");
    private JMenuItem jmencrypt =new JMenuItem("Encrypt");
    public MainFrame(){
        init3();
    }
    private void init3(){
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setJMenuBar(jmbr);
        jmbr.add(jm1);
        jmbr.add(jm2);
        jmbr.add(jm3);
        jmbr.add(jm4);
        jm1.add(jmop);
        jm1.add(jmcl);
        jm1.add(jmexit);
        jm2.add(jmencrypt);
        jm3.add(jmOOXX);
        jmexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmencrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Encrypt op = new Encrypt(MainFrame.this);
                op.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });
        jmOOXX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OOXX ox = new OOXX(MainFrame.this);
                ox.setVisible(true);
                MainFrame.this.setVisible(false);
            }
        });
    }
}