import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Encrypt extends JFrame {
    public static void main(String[] args) {
        //    new encrypt().setVisible(true);
    }
    Container cp;
    private JTextArea jtaL = new JTextArea("",30,15);
    private JTextArea jtaR = new JTextArea("",30,15);
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JLabel jlbMethod = new JLabel("Method");
    private String methodStr[] = {"DES" , "AES" , "XOR" , "Caesar"};
    private JComboBox jcomb = new JComboBox<String>(methodStr);
    private JLabel jlbPW = new JLabel("Password");
    private JTextField jtfPW = new JTextField();
    private JRadioButton jrbtn1 = new JRadioButton("Encrypt");
    private JRadioButton jrbtn2 = new JRadioButton("Decrypt");
    private JButton jbtnrun = new JButton("Run");
    private JButton jbtnclose = new JButton("close");
    private ButtonGroup btnGroup = new ButtonGroup();

    private JPanel jpl1 = new JPanel(new GridLayout(9,1,1,1));
    private JPanel jpl2 = new JPanel(new GridLayout(1,1,1,1));
    private JPanel jpl3 = new JPanel(new GridLayout(1,1,1,1));

    private MainFrame frame2;

    public Encrypt(MainFrame frame2){
        this.frame2 = frame2;
        init5();
    }
    public void init5(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(100,200,550,600);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

               frame2.setVisible(true);

            }
        });

        cp = this.getContentPane();
        cp.add(jpl2, BorderLayout.WEST);
        cp.add(jpl1, BorderLayout.CENTER);
        cp.add(jpl3, BorderLayout.EAST);

//        cp.setLayout(new BorderLayout(1,1));

        jpl1.add(jlbMethod);
        jpl1.add(jcomb);
        jpl1.add(jlbPW);
        jpl1.add(jtfPW);
        jpl1.add(jrbtn1);
        jpl1.add(jrbtn2);
        jpl1.add(jbtnrun);
        jpl1.add(jbtnclose);

        jpl2.add(jspL);

        jpl3.add(jspR);

        btnGroup.add(jrbtn1);
        btnGroup.add(jrbtn2);
        jbtnrun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String newstr = "";
                for (int i = 0; i<jtaL.getText().length();i++){
                    newstr = newstr + (char)(jtaL.getText().charAt(i)+jtfPW.getText().charAt(i% jtfPW.getText().length()));
                }
                jtaR.setText(newstr);
            }
        });
    }
}
