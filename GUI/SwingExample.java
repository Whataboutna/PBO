import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingExample {
    public static void main(String[] args) {
        // 1. Top-Level Container (The Window)
        JFrame frame = new JFrame("Swing Component Hierarchy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        // 2. Intermediate Container (Groups components)
        JPanel panel = new JPanel();
        
        // 3. Layout Manager (Organizes components inside the panel)
        panel.setLayout(new FlowLayout());

        // 4. Atomic Components (Direct user interaction)
        JLabel promptLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField(15);
        JButton submitButton = new JButton("Greet");
        JLabel resultLabel = new JLabel("");

        // 5. Event Listener (Reacts when the button is clicked)
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (name.isEmpty()) {
                    resultLabel.setText("Please enter a name!");
                } else {
                    resultLabel.setText("Hello, " + name + "!");
                }
            }
        });

        // Add Atomic Components into the Intermediate Container
        panel.add(promptLabel);
        panel.add(nameField);
        panel.add(submitButton);
        panel.add(resultLabel);

        // Add the Intermediate Container into the Top-Level Container
        frame.add(panel);

        // Make the window visible on screen
        frame.setVisible(true);
    }
}