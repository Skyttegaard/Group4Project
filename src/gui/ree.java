package gui;
import javax.swing.*;

import model.Task;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ree extends JFrame {
	static Task task;
    private JButton backButton;
    private JButton confirmButton;
    private JPanel mainPanel;

    public ree(Task task) {
        // Set the size of the JFrame
        setSize(400, 600);

        // Create the top panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        // Create the back button
        JPanel backButton = new JPanel();
        backButton.setPreferredSize(new Dimension(50, 50));
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	e ee = new e();}});
        
        ImageIcon icon = new ImageIcon("angle-left.png");
        JLabel iconLabel = new JLabel(icon);
        backButton.add(iconLabel);
        topPanel.add(backButton, BorderLayout.WEST);

        // Create the confirm button
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {}});
        topPanel.add(confirmButton, BorderLayout.EAST);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1));

        JPanel customerInfo = new JPanel();
        customerInfo.setBackground(Color.LIGHT_GRAY);
        customerInfo.setPreferredSize(new Dimension(200, 200));
        mainPanel.add(customerInfo);
        
        JPanel taskInfo = new JPanel();
        taskInfo.setBackground(Color.GRAY);
        taskInfo.setPreferredSize(new Dimension(200, 200));
        mainPanel.add(taskInfo);
        
        JPanel comment = new JPanel();
        comment.setBackground(Color.GRAY);
        comment.setPreferredSize(new Dimension(200, 200));
        mainPanel.add(comment);
        // Create a scroll pane for the main panel
        JScrollPane scrollPane = new JScrollPane(mainPanel);

        setLayout(new BorderLayout());
        
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ree reee = new ree(task);
                reee.setVisible(true);
            }
        });
    }
}
