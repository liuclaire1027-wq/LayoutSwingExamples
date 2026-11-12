import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Layout {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField findField;
    private JTextField findField1;
    private JTextField replaceField;
    public JButton submit;
    public JButton reset;
    public JButton quotegen;
   ;

    public Layout(){
        frame = new JFrame("Find and Replace Application");
        submit=new JButton("submit");
        reset = new JButton("reset");
        quotegen = new JButton("Quote Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        ;
        JPanel toppanel = new JPanel(new BorderLayout());
        JPanel textinput = new JPanel(new FlowLayout());
        JPanel buttonpanel = new JPanel(new FlowLayout());



        textArea = new JTextArea("hello world");

        textArea.setBounds(50, 5, 100, 50);
        textArea.setEditable(false);
        // uncomment the two lines bellow and comment the third line to have textarea scroll
        JScrollPane scrollPane = new JScrollPane(textArea);

        findField = new JTextField(20);
        textinput.add(new JLabel("Input:"));
        textinput.add(findField);
        buttonpanel.add(submit);
        buttonpanel.add(reset);
        buttonpanel.add(quotegen);
        toppanel.add(textinput,BorderLayout.NORTH);
        toppanel.add(buttonpanel,BorderLayout.SOUTH);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceText();
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        quotegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {chooseQuote();}
        });
        frame.add(scrollPane);
        frame.add(toppanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Layout assignment = new Layout();
    }
    private void replaceText() {
        String findText = findField.getText();
        if (!findText.isEmpty()) {
            String content = textArea.getText();
            content = content.replace(content, findText);

            textArea.setText(content);
        } else {
            JOptionPane.showMessageDialog(frame, "Find field cannot be empty.");
        }
    }
    private void reset(){
        String test = "just resetting github push";
        String content = textArea.getText();
        String findText = findField.getText();
        String blank = " ";
        content = content.replace(content, blank);
        findText = findText.replace(findText, blank);
        findField.setText(findText);
        textArea.setText(content);
    }
    private void chooseQuote(){
        String content = textArea.getText();
        int rand = (int)(Math.random()*3)+1;
        String select = " ";
        if(rand==1){
            select = "I've learned that people will forget what you said, \n people will forget what you did, \n but people will never forget how you made them feel. \n-Maya Angelou";
        }
        if(rand == 2){
            select = "May the Force be with you. \n -Star Wars";
        }
        if(rand == 3){
            select = "Life is like riding a bicycle. \n To keep your balance, you must keep moving. \n -Albert Einstein";
        }
        content = content.replace(content, select);
        textArea.setText(content);
    }
}
