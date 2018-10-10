import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Keyboard extends JFrame {
    private Container cp ;
    private JButton jbn[] =new JButton[12];
    private String jl[] =new String[10];
    private JPanel jp1 =new JPanel(new GridLayout(4,3,3,3));
    private JPanel jp2 =new JPanel(new GridLayout(1,1,3,3));
    private JPasswordField jl1=new JPasswordField("");
    private Font fon =new Font(null,Font.BOLD,18);
    private Long lg;
    public Keyboard(Long uuu){
        lg = uuu ;
        init();
    }
    private void init(){
        this.setBounds(500, 300, 500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jp1, BorderLayout.CENTER);
        cp.add(jp2, BorderLayout.NORTH);
        getjl(jl);
        for (int i=0;i<10;i++){
            jbn[i] =new JButton(jl[i]) ;
            jbn[i].setFont(fon);
            jp1.add(jbn[i]);
            jbn[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jbn =(JButton)e.getSource();
                    jl1.setText(jl1.getText()+jbn.getText());
                }
            });
        }
        jbn[10]=new JButton("rest");
        jbn[11]=new JButton("submit");
        jp1.add(jbn[10]);
        jp1.add(jbn[11]);
        jp2.add(jl1);
        jbn[10].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getjl(jl);
                for (int i=0;i<10;i++){
                    jbn[i].setText(jl[i]);
                }
            }
        });
        jbn[11].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lg.vvv(new String(jl1.getPassword()));
                Keyboard.this.dispose();

            }
        });

    }
    private void getjl(String str[]){
        int i=0;
        Random rnd=new Random(System.currentTimeMillis());
        while (i<10){
            jl[i]=Integer.toString(rnd.nextInt(10));
            int j=0;
            boolean flag =false;
            while (j<i){
                if (jl[i].equals(jl[j])){
                    flag=true;
                    j=i;
                }
                j++;
            }
            if (!flag){
                i++;
            }
        }
    }
}