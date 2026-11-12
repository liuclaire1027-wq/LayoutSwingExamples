import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Buttons {
    private JFrame mainFrame;
    public int WIDTH=800;
    public  int HEIGHT=800;
    public JButton one,two,three,four,five;
    public JPanel northPanel;
    public JTextField name=new JTextField();
    public static void main(String[] args) {
        Buttons pushme= new Buttons();
    }
    public Buttons(){
        prepareGUI();
    }
    private void prepareGUI() {
        northPanel=new JPanel();
        one=new JButton("one!!!!!!!!!!!!");
        two=new JButton("two");
        three=new JButton("three");
        four=new JButton("four");
        five=new JButton("five");





        mainFrame = new JFrame("Java SWING Examples");
        northPanel.setLayout(new GridLayout(2,1));
        northPanel.add(four);
        northPanel.add(five);
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(three,BorderLayout.EAST);
        mainFrame.add(northPanel,BorderLayout.NORTH);
        mainFrame.add(two,BorderLayout.CENTER);

      /*  mainFrame.add(four);
        mainFrame.add(five);
        mainFrame.add(name);
        */

        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }
}
