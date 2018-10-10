import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class OOXX extends JFrame {
    public static void main(String[] args) {
    }
    private Container cp;
    private JButton jbtns[][] = new JButton[3][3];
    private JPanel jpnC = new JPanel(new GridLayout(3, 3,3,3 ));
    private JLabel jl =new JLabel("Game Start");
    int a=0;
    private boolean flag = true;
    private MainFrame frame;

    public OOXX(MainFrame frame) {
        this.frame = frame;
        init4();
    }

    private void init4() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 600, 600);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(true);

            }
        });
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3, 3));
        cp.add(jpnC, BorderLayout.CENTER);
        this.add(jl, BorderLayout.NORTH);
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                jbtns[i][j] = new JButton();
                jbtns[i][j].setFont(new Font(null, Font.BOLD, 80));
                jbtns[i][j].addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tmpBtn = (JButton) e.getSource();
                        if (tmpBtn.getText().equals("")) {
                            if (flag) {
                                tmpBtn.setText("o");
                            } else {
                                tmpBtn.setText("x");
                            }
                            flag = !flag;
                            a++;
                            if (a%2==0){
                                jl.setText("Player 1's turn...");
                            }else {
                                jl.setText("Player 2's turn...");
                            }
                        }
                        checkStat();
                    }
                });
                jpnC.add(jbtns[i][j]);
            }
        }
    }



    private void checkStat() {
        if (jbtns[0][0].getText().equals(jbtns[0][1].getText()) && jbtns[0][0].getText().equals(jbtns[0][2].getText()) && !jbtns[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][0].getText() + "Win!");
        } else if (jbtns[1][0].getText().equals(jbtns[1][1].getText()) && jbtns[1][0].getText().equals(jbtns[1][2].getText()) && !jbtns[1][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[1][0].getText() + "Win!");
        } else if (jbtns[2][0].getText().equals(jbtns[2][1].getText()) && jbtns[2][0].getText().equals(jbtns[2][2].getText()) && !jbtns[2][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[2][0].getText() + "Win!");
        } else if (jbtns[0][0].getText().equals(jbtns[1][0].getText()) && jbtns[0][0].getText().equals(jbtns[2][0].getText()) && !jbtns[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][0].getText() + "Win!");
        } else if (jbtns[0][1].getText().equals(jbtns[1][1].getText()) && jbtns[0][1].getText().equals(jbtns[2][1].getText()) && !jbtns[0][1].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][1].getText() + "Win!");
        } else if (jbtns[0][2].getText().equals(jbtns[1][2].getText()) && jbtns[0][2].getText().equals(jbtns[2][2].getText()) && !jbtns[0][2].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][2].getText() + "Win!");
        } else if (jbtns[0][0].getText().equals(jbtns[1][1].getText()) && jbtns[0][0].getText().equals(jbtns[2][2].getText()) && !jbtns[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][0].getText() + "Win!");
        } else if (jbtns[0][2].getText().equals(jbtns[1][1].getText()) && jbtns[0][2].getText().equals(jbtns[2][0].getText()) && !jbtns[0][2].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][2].getText() + "Win!");
        }
    }
}