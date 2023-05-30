package gui;
import javax.swing.*;

import controller.TaskController;
import dbo.TaskDB;
import model.Task;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

public class e extends taskview {
	TaskController tasko = new TaskController();
	TaskDB taskDB = new TaskDB();
	
    public e() {
        super();

        ArrayList<Task> objectsList = taskDB.getAllTasks();


        


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
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                int iko = obj.getTaskId();
                Task ito = tasko.findTask(iko);
                ree reee = new ree(ito);
                }
            });
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
