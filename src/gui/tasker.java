package gui;

import javax.swing.*;

import controller.CustomerController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tasker extends JFrame {
	CustomerController ffff = new CustomerController();
    private JComboBox<String> selectionComboBox;
    private JTextArea commentTextArea;
    private JTextField textField;
    private JButton clearButton;
    private JButton acceptButton;

    public tasker() {
        
        setSize(400, 600);

        
        JPanel mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.setLayout(new BorderLayout());

       
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton();
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setPreferredSize(new Dimension(50, 50));
        topPanel.add(backButton);

        
        JPanel contentPanel = new JPanel(new GridLayout(4, 1, 5, 5));

        
        JPanel selectionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel selectionLabel = new JLabel("Select:");
        String[] selectionOptions = {"Service", "Installation"};
        selectionComboBox = new JComboBox<>(selectionOptions);
        selectionPanel.add(selectionLabel);
        selectionPanel.add(selectionComboBox);
        contentPanel.add(selectionPanel);

        
        JPanel commentPanel = new JPanel(new BorderLayout());
        JLabel commentLabel = new JLabel("Comment:");
        commentTextArea = new JTextArea(10, 30);
        JScrollPane commentScrollPane = new JScrollPane(commentTextArea);
        commentPanel.add(commentLabel, BorderLayout.NORTH);
        commentPanel.add(commentScrollPane, BorderLayout.CENTER);
        contentPanel.add(commentPanel);

        
        JPanel buttonPanel = new JPanel(new BorderLayout());
        textField = new JTextField(20);
        buttonPanel.add(textField, BorderLayout.CENTER);

        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

       
        JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        clearButton = new JButton("Clear");
        acceptButton = new JButton("Accept");
        lowerPanel.add(clearButton);
        lowerPanel.add(acceptButton);
        mainPanel.add(lowerPanel, BorderLayout.SOUTH);

        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent mainView) {
            	mainView mainview = new mainView();}});

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent mainView) {
                String phoneNumber = JOptionPane.showInputDialog(tasker.this, "Enter a phone number:");
                if (phoneNumber != null && phoneNumber.matches("\\d{8}")) {
                    model.Customer customer = ffff.findCustomer(phoneNumber);
                    textField.setText("Customer Phonenumber: " + customer.getPhoneNumber() + "\nCustomer Address: " + customer.getAddress());
                } else {
         JOptionPane.showMessageDialog(tasker.this, "Phone number doenst work.");}}});
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent mainView) {
             commentTextArea.setText("");}});}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new tasker();
            }
        });
    }
}
