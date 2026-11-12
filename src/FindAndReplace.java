import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
// Starter Code for TextEditorApp
// chales 10/2025
public class FindAndReplace {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField findField;
    private JTextField replaceField;

    public FindAndReplace() {
        frame = new JFrame("Find and Replace Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new BorderLayout());
        textArea = new JTextArea();
        // uncomment the two lines bellow and comment the third line to have textarea scroll
        // JScrollPane scrollPane = new JScrollPane(textArea);
        // panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(textArea, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout());
        JButton loadButton = new JButton("Load File");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFile();
            }
        });
        controlPanel.add(loadButton);

        findField = new JTextField(10);
        controlPanel.add(new JLabel("Find:"));
        controlPanel.add(findField);

        replaceField = new JTextField(10);
        controlPanel.add(new JLabel("Replace:"));
        controlPanel.add(replaceField);

        JButton replaceButton = new JButton("Replace");
        replaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceText();
            }
        });
        controlPanel.add(replaceButton);

        panel.add(controlPanel, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
    }

    private void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
                textArea.setText(content);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error loading file: " + ex.getMessage());
            }
        }
    }

    private void replaceText() {
        String findText = findField.getText();
        String replaceText = replaceField.getText();
        if (!findText.isEmpty()) {
            String content = textArea.getText();
            content = content.replace(findText, replaceText);
            textArea.setText(content);
        } else {
            JOptionPane.showMessageDialog(frame, "Find field cannot be empty.");
        }
    }

    public static void main(String[] args) {
        FindAndReplace app = new FindAndReplace();
    }
}