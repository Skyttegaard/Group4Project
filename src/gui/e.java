package gui;
import javax.swing.*;

import model.Task;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class e extends taskview {
    public e() {
        super();

        ArrayList<Task> objectsList = new ArrayList<>();

        for (int i = 0; i < 66; i++) {
            Task task = new Task(i + 1, "Some information", new Date(), "Some task type", "Some status", i + 1);
            objectsList.add(task);
        }

        JScrollPane scrollPane = new JScrollPane();
        
        getContentPanel().add(scrollPane, BorderLayout.CENTER);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(0, 2)); 
        scrollPane.setViewportView(gridPanel);

        for (Task obj : objectsList) {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel.setBackground(Color.WHITE);
            panel.setPreferredSize(new Dimension(180, 80));

            JLabel label = new JLabel("Task Id: " + obj.getTaskId());
            JLabel label1 = new JLabel("\nTasktype: " + obj.getTaskType());
            JLabel label2 = new JLabel("\nTask status: " + obj.getStatus());
            panel.add(label);
            panel.add(label1);
            panel.add(label2);
            gridPanel.add(panel);
        }       
        
        
        scrollPane.revalidate();
        scrollPane.repaint();
    }


	public static void main(String[] args) {
        SwingUtilities.invokeLater(e::new);
    }
}
