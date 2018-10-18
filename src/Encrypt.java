import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;


public class Encrypt extends JFrame {
    public static void main(String[] args) {
        //    new encrypt().setVisible(true);
    }
    Container cp;
    private JMenuBar jmbr =new JMenuBar();
    private JMenu jmu1 =new JMenu("File");
    private JMenu jmu2 =new JMenu("about");
    private JMenuItem jmop =new JMenuItem("Open");
    private JMenuItem jmsa =new JMenuItem("Save");
    private JMenuItem jmcl =new JMenuItem("Close");
    private JTextArea jtaL = new JTextArea("",30,15);
    private JTextArea jtaR = new JTextArea("",30,15);
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JLabel jlbMethod = new JLabel("Method");
    private String methodStr[] = {"DES" , "AES" , "Caesar" , "XOR"};
    private JComboBox jcomb = new JComboBox<String>(methodStr);
    private JLabel jlbPW = new JLabel("Password");
    private JTextField jtfPW = new JTextField();
    private JRadioButton jrbtn1 = new JRadioButton("Encrypt");
    private JRadioButton jrbtn2 = new JRadioButton("Decrypt");
    private JButton jbtnrun = new JButton("Run");
    private JButton jbtnclear = new JButton("Clear");
    private JButton jbtnclose = new JButton("close");
    private JFileChooser jfcr =new JFileChooser();
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
        this.setJMenuBar(jmbr);
        jmbr.add(jmu1);
        jmbr.add(jmu2);
        jmu1.add(jmop);
        jmu1.add(jmsa);
        jmu1.add(jmcl);
        jpl1.add(jlbMethod);
        jpl1.add(jcomb);
        jpl1.add(jlbPW);
        jpl1.add(jtfPW);
        jpl1.add(jrbtn1);
        jpl1.add(jrbtn2);
        jpl1.add(jbtnrun);
        jpl1.add(jbtnclear);
        jpl1.add(jbtnclose);

        jpl2.add(jspL);

        jpl3.add(jspR);

        btnGroup.add(jrbtn1);
        btnGroup.add(jrbtn2);
        jbtnrun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jrbtn1.isSelected()) {
                    int dataLength = jtaL.getText().length();
                    if (dataLength > 0) {
                        switch (jcomb.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(Encrypt.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(Encrypt.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                try {
                                    int key = Integer.parseInt(jtfPW.getText());
                                    char data[] = jtaL.getText().toCharArray();
                                    for (int i = 0; i < dataLength; i++) {
                                        data[i] = (char) (data[i] + key);
                                    }
                                    jtaR.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(Encrypt.this,
                                            "key is not a number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(Encrypt.this, "Error:" +
                                            exp1.toString());
                                }
                                break;
                            case 3:
                                char data[]=jtaL.getText().toCharArray();
                                char key[]=jtfPW.getText().toCharArray();
                                for (int i=0;i<data.length;i++){
                                    data[i]=(char)((int)data[i]^(int)key[i%key.length]);
                                }
                                jtaR.setText(new String(data));
                                break;
//                                JOptionPane.showMessageDialog(Encrypt.this, "sorry, "
//                                        + jcomb.getSelectedItem() + "not implement yet!");
                        }
                    }
                } else if (jrbtn2.isSelected()) {
                    int dataLength = jtaR.getText().length();
                    if (dataLength > 0) {
                        switch (jcomb.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(Encrypt.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(Encrypt.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                try {
                                    int key = Integer.parseInt(jtfPW.getText());
                                    char data[] = jtaR.getText().toCharArray();
                                    for (int i = 0; i < dataLength; i++) {
                                        data[i] = (char) (data[i] - key);
                                    }
                                    jtaL.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(Encrypt.this,
                                            "key is not a number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(Encrypt.this, "Error:" +
                                            exp1.toString());
                                }
                                break;
                            case 3:
                                char data[]=jtaR.getText().toCharArray();
                                char key[]=jtfPW.getText().toCharArray();
                                for (int i=0;i<data.length;i++){
                                    data[i]=(char)((int)data[i]^(int)key[i%key.length]);
                                }
                                jtaL.setText(new String(data));
                                break;
//                                JOptionPane.showMessageDialog(Encrypt.this, "sorry, "
//                                        + jcomb.getSelectedItem() + "not implement yet!");
                        }
                    }
                }
            }
        });
        jbtnclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("");
                jtaR.setText("");
            }
        });
        jmop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (jfcr.showOpenDialog(Encrypt.this) == JFileChooser.APPROVE_OPTION){
                        jtaL.setText("");
                        String str = "";
                        File selectFile = jfcr.getSelectedFile();
                        FileReader fr = new FileReader(selectFile);
                        BufferedReader bfr = new BufferedReader(fr);
                        while ((str = bfr.readLine()) != null){
                            jtaL.append(str);
                        }
                        fr.close();
                    }
                }catch (IOException ioe){
                    JOptionPane.showMessageDialog(Encrypt.this, "Open file error: "
                            +ioe.toString());
                }
            }
        });
        jmsa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (jtaR.getText().length()>0){
                        if (jfcr.showSaveDialog(Encrypt.this)==JFileChooser.APPROVE_OPTION){
                            File selectFile =jfcr.getSelectedFile();
                            FileWriter fw =new FileWriter(selectFile);
                            BufferedWriter bwr =new BufferedWriter(fw);
                            bwr.write(jtaR.getText());
                            bwr.close();
                        }
                    }
                        else {
                            JOptionPane.showMessageDialog(Encrypt.this,"No Data Can Write Out");
                        }

                }catch (IOException io1){
                    JOptionPane.showMessageDialog(Encrypt.this,"Open file error"+io1.toString());
                }catch (Exception exp2){
                    JOptionPane.showMessageDialog(Encrypt.this,"Error"+exp2.toString());
                }
            }
        });
    }
}
