package com.mousika.tool.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mousika.tool.bean.DatabaseInfo;
import com.mousika.tool.core.Config;
/**
 * 主界面
 * @author xiaojf
 *
 */
public class MainFrame extends JFrame {
    private JTextField driverField;
    private JTextField urlField;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField moduleName;
    private JTextField modelPack;
    private JTextField actionPack;
    private JTextField servicePack;
    private JTextField serviceImpPack;
    private JTextField daoPack;
    private JTextField daoImplPack;
    private JTextField modelTemp;
    private JTextField actionTemp;
    private JTextField serviceTemp;
    private JTextField serviceImplTemp;
    private JTextField daoTemp;
    private JTextField daoImplTemp;
    private JTextField tableNameField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame() {
        setTitle("mousika");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 928, 657);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        JMenuItem openMI = new JMenuItem("Open");
        fileMenu.add(openMI);
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(589, 401, 313, 186);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblDatabase = new JLabel("Database");
        lblDatabase.setBounds(10, 10, 71, 15);
        panel.add(lblDatabase);
        
        JLabel lblNewLabel = new JLabel("Driver");
        lblNewLabel.setBounds(10, 35, 71, 15);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Url");
        lblNewLabel_1.setBounds(10, 60, 71, 15);
        panel.add(lblNewLabel_1);
        
        JComboBox databaseCB = new JComboBox(Config.getDatabaseNames());
        databaseCB.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String dbName = ((JComboBox)e.getSource()).getSelectedItem().toString();
                DatabaseInfo db = Config.getDatabase(dbName);
                driverField.setText(db.getDriverClass());
                urlField.setText(db.getUrl());
                usernameField.setText(db.getUsername());
                passwordField.setText(db.getPassword());
            }
        });
        databaseCB.setBounds(91, 7, 147, 21);
        panel.add(databaseCB);
        
        driverField = new JTextField();
        driverField.setEditable(false);
        driverField.setBounds(91, 32, 197, 21);
        panel.add(driverField);
        driverField.setColumns(10);
        
        urlField = new JTextField();
        urlField.setBounds(91, 57, 197, 21);
        panel.add(urlField);
        urlField.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Username");
        lblNewLabel_2.setBounds(10, 85, 71, 15);
        panel.add(lblNewLabel_2);
        
        usernameField = new JTextField();
        usernameField.setBounds(91, 82, 197, 21);
        panel.add(usernameField);
        usernameField.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Password");
        lblNewLabel_3.setBounds(10, 110, 71, 15);
        panel.add(lblNewLabel_3);
        
        passwordField = new JTextField();
        passwordField.setBounds(91, 107, 197, 21);
        panel.add(passwordField);
        passwordField.setColumns(10);
        
        JButton refreshButt = new JButton("Refresh");
        refreshButt.setBounds(10, 153, 93, 23);
        panel.add(refreshButt);
        
        JButton generatorButt = new JButton("Generator");
        generatorButt.setBounds(108, 153, 93, 23);
        panel.add(generatorButt);
        
        JButton exitButt = new JButton("Exit");
        exitButt.setBounds(205, 153, 93, 23);
        panel.add(exitButt);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 401, 576, 186);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_4 = new JLabel("Module");
        lblNewLabel_4.setBounds(10, 10, 54, 15);
        panel_1.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Model");
        lblNewLabel_5.setBounds(10, 35, 54, 15);
        panel_1.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Action");
        lblNewLabel_6.setBounds(10, 60, 54, 15);
        panel_1.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Service");
        lblNewLabel_7.setBounds(10, 85, 54, 15);
        panel_1.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("ServiceImpl");
        lblNewLabel_8.setBounds(10, 110, 72, 15);
        panel_1.add(lblNewLabel_8);
        
        moduleName = new JTextField();
        moduleName.setBounds(74, 7, 189, 21);
        panel_1.add(moduleName);
        moduleName.setColumns(10);
        moduleName.addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                String module = ((JTextField)e.getComponent()).getText();
                modelPack.setText(module+".model");
                actionPack.setText(module+".controller");
                servicePack.setText(module+".service");
                serviceImpPack.setText(module+".service.impl");
                daoPack.setText(module+".dao");
                daoImplPack.setText(module+".dao.impl");
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                
            }
        });
        
        JLabel lblNewLabel_10 = new JLabel("Dao");
        lblNewLabel_10.setBounds(10, 135, 54, 15);
        panel_1.add(lblNewLabel_10);
        
        modelPack = new JTextField();
        modelPack.setEditable(false);
        modelPack.setBounds(74, 32, 189, 21);
        panel_1.add(modelPack);
        modelPack.setColumns(10);
        
        actionPack = new JTextField();
        actionPack.setEditable(false);
        actionPack.setBounds(74, 57, 189, 21);
        panel_1.add(actionPack);
        actionPack.setColumns(10);
        
        servicePack = new JTextField();
        servicePack.setEditable(false);
        servicePack.setBounds(74, 82, 189, 21);
        panel_1.add(servicePack);
        servicePack.setColumns(10);
        
        serviceImpPack = new JTextField();
        serviceImpPack.setEditable(false);
        serviceImpPack.setBounds(74, 107, 189, 21);
        panel_1.add(serviceImpPack);
        serviceImpPack.setColumns(10);
        
        daoPack = new JTextField();
        daoPack.setEditable(false);
        daoPack.setBounds(74, 132, 189, 21);
        panel_1.add(daoPack);
        daoPack.setColumns(10);
        
        JLabel lblNewLabel_9 = new JLabel("DaoImpl");
        lblNewLabel_9.setBounds(10, 160, 54, 15);
        panel_1.add(lblNewLabel_9);
        
        daoImplPack = new JTextField();
        daoImplPack.setEditable(false);
        daoImplPack.setBounds(74, 157, 189, 21);
        panel_1.add(daoImplPack);
        daoImplPack.setColumns(10);
        
        JCheckBox allCB = new JCheckBox("");
        allCB.setSelected(true);
        allCB.setBounds(269, 6, 30, 23);
        panel_1.add(allCB);
        
        JCheckBox modelCB = new JCheckBox("");
        modelCB.setSelected(true);
        modelCB.setBounds(269, 31, 30, 23);
        panel_1.add(modelCB);
        
        JCheckBox actionCB = new JCheckBox("");
        actionCB.setSelected(true);
        actionCB.setBounds(269, 56, 30, 23);
        panel_1.add(actionCB);
        
        JCheckBox serviceCB = new JCheckBox("");
        serviceCB.setSelected(true);
        serviceCB.setBounds(269, 81, 30, 23);
        panel_1.add(serviceCB);
        
        JCheckBox serviceImplCB = new JCheckBox("");
        serviceImplCB.setSelected(true);
        serviceImplCB.setBounds(269, 106, 30, 23);
        panel_1.add(serviceImplCB);
        
        JCheckBox daoCB = new JCheckBox("");
        daoCB.setSelected(true);
        daoCB.setBounds(269, 131, 30, 23);
        panel_1.add(daoCB);
        
        JCheckBox daoImplCB = new JCheckBox("");
        daoImplCB.setSelected(true);
        daoImplCB.setBounds(269, 156, 30, 23);
        panel_1.add(daoImplCB);
        
        modelTemp = new JTextField();
        modelTemp.setEditable(false);
        modelTemp.setBounds(305, 32, 200, 21);
        panel_1.add(modelTemp);
        modelTemp.setColumns(10);
        
        actionTemp = new JTextField();
        actionTemp.setEditable(false);
        actionTemp.setBounds(305, 57, 200, 21);
        panel_1.add(actionTemp);
        actionTemp.setColumns(10);
        
        serviceTemp = new JTextField();
        serviceTemp.setEditable(false);
        serviceTemp.setBounds(305, 82, 200, 21);
        panel_1.add(serviceTemp);
        serviceTemp.setColumns(10);
        
        serviceImplTemp = new JTextField();
        serviceImplTemp.setEditable(false);
        serviceImplTemp.setBounds(305, 107, 200, 21);
        panel_1.add(serviceImplTemp);
        serviceImplTemp.setColumns(10);
        
        daoTemp = new JTextField();
        daoTemp.setEditable(false);
        daoTemp.setBounds(305, 132, 200, 21);
        panel_1.add(daoTemp);
        daoTemp.setColumns(10);
        
        daoImplTemp = new JTextField();
        daoImplTemp.setEditable(false);
        daoImplTemp.setBounds(305, 157, 200, 21);
        panel_1.add(daoImplTemp);
        daoImplTemp.setColumns(10);
        
        JButton btnNewButton = new JButton("...");
        btnNewButton.setBounds(515, 31, 54, 23);
        panel_1.add(btnNewButton);
        
        JButton button = new JButton("...");
        button.setBounds(515, 56, 54, 23);
        panel_1.add(button);
        
        JButton button_1 = new JButton("...");
        button_1.setBounds(515, 81, 54, 23);
        panel_1.add(button_1);
        
        JButton button_2 = new JButton("...");
        button_2.setBounds(515, 106, 54, 23);
        panel_1.add(button_2);
        
        JButton button_3 = new JButton("...");
        button_3.setBounds(515, 131, 54, 23);
        panel_1.add(button_3);
        
        JButton button_4 = new JButton("...");
        button_4.setBounds(515, 156, 54, 23);
        panel_1.add(button_4);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 35, 311, 356);
        getContentPane().add(panel_2);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(331, 35, 571, 356);
        getContentPane().add(panel_3);
        
        JLabel lblNewLabel_11 = new JLabel("Table Name");
        lblNewLabel_11.setBounds(10, 10, 69, 15);
        getContentPane().add(lblNewLabel_11);
        
        tableNameField = new JTextField();
        tableNameField.setBounds(75, 7, 161, 21);
        getContentPane().add(tableNameField);
        tableNameField.setColumns(10);
        
        JButton searchButt = new JButton("Search");
        searchButt.setBounds(240, 6, 81, 23);
        getContentPane().add(searchButt);
        
    }
}
