package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class taskview extends JFrame {
	
	GridBagConstraints gbc = new GridBagConstraints();
	//Main panels
	 JPanel contentPanel = new JPanel();
     JPanel topPanel = new JPanel();
    public taskview() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Phone Frame");
        setSize(400, 600);
        contentPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.LIGHT_GRAY);
        contentPanel.add(topPanel, BorderLayout.NORTH);
        
        JPanel addPanel = new JPanel();
        addPanel.setBackground(Color.LIGHT_GRAY);
        addPanel.setPreferredSize(new Dimension(50, 50));
        addPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mainView) {
            	tasker taske = new tasker();}});
        //Icon added
        ImageIcon addIcon = new ImageIcon("add.png"); 
        JLabel addPanelLabel = new JLabel(addIcon);
        addPanel.add(addPanelLabel);
        //Panel placed
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(addPanel);

       
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);
        middlePanel.setBackground(Color.GRAY);
        contentPanel.add(middlePanel, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);

        //Bottom panels
        JPanel button1Panel = new JPanel();
        JPanel button2Panel = new JPanel();
        JPanel button3Panel = new JPanel();
        JPanel button4Panel = new JPanel();
        
        
        button1Panel.setBackground(Color.GRAY);
        button1Panel.setPreferredSize(new Dimension(150, 100));
        button2Panel.setBackground(Color.WHITE);
        button2Panel.setPreferredSize(new Dimension(100, 80)); 
        button3Panel.setBackground(Color.BLUE);
        button3Panel.setPreferredSize(new Dimension(100, 80)); 
        button4Panel.setBackground(Color.GREEN);
        button4Panel.setPreferredSize(new Dimension(100, 80)); 
       
        //MouseListeners 
        button1Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mainView) {
            	mainView ee = new mainView();
            	}});
        ImageIcon icon = new ImageIcon("icon_2.png"); 
        JLabel iconLabel = new JLabel(icon);
        button1Panel.add(iconLabel);

        button2Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mainView) {
                JOptionPane.showMessageDialog(taskview.this, "Button 2 clicked!");}});
        ImageIcon icon2= new ImageIcon("briefcase.png"); 
        JLabel iconLabel2 = new JLabel(icon2);
        button2Panel.add(iconLabel2);

        button3Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mainView) {
                JOptionPane.showMessageDialog(taskview.this, "Button 3 clicked!");}});
        ImageIcon icon3= new ImageIcon("users-alt.png"); 
        JLabel iconLabel3 = new JLabel(icon3);
        button3Panel.add(iconLabel3);

        
         button4Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mainView) {
                JOptionPane.showMessageDialog(taskview.this, "Button 4 clicked!");}});
        ImageIcon icon4= new ImageIcon("user.png"); 
        JLabel iconLabel4 = new JLabel(icon4);
        button4Panel.add(iconLabel4);
        
        
        bottomPanel.setLayout(new GridBagLayout()); 
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.insets = new Insets(0, 10, 0, 10); 
        bottomPanel.add(button1Panel, gbc);
        gbc.gridx = 1;
        bottomPanel.add(button2Panel, gbc);
        gbc.gridx = 2;
        bottomPanel.add(button3Panel, gbc);
        gbc.gridx = 3;
        bottomPanel.add(button4Panel, gbc);
      
        setContentPane(contentPanel);
        setVisible(true);
    }
    public JPanel getContentPanel() {
        return contentPanel;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new taskview());
    }
    
}
