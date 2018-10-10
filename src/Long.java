import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Long extends JFrame {
    private Container cp ;
    private JLabel jl1 =new JLabel("ID");
    private JLabel jl2 =new JLabel("PassWord");
    private JTextField jtf =new JTextField();
    private JPasswordField jps =new JPasswordField();
    private JButton jb1 =new JButton("keyboard");
    private JButton jb2 =new JButton("Long in");
    private JButton jb3 =new JButton("Exit");
    private JPanel jp1 =new JPanel(new GridLayout(2,2,3,3));
    private JPanel jp2 =new JPanel(new GridLayout(1,3,3,3));
    public Long (){
        init2();
    }
    private void init2() {
        this.setBounds(100, 100, 300, 100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jp1, BorderLayout.CENTER);
        cp.add(jp2, BorderLayout.SOUTH);
        jp1.add(jl1);
        jp1.add(jtf);
        jp1.add(jl2);
        jp1.add(jps);
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        jb1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Keyboard min = new Keyboard(Long.this);
                min.setVisible(true);
            }
        });
        jb2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf.getText().equals("1")&&new String(jps.getPassword()).equals("1")){
                    MainFrame a1 = new MainFrame();
                    a1.setVisible(true);
                    Long.this.dispose();
                }else {
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
    public void vvv(String yyy){
        jps.setText(yyy);
    }
}