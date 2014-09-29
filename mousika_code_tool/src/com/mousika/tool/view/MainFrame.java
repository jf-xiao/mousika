package com.mousika.tool.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mousika.tool.bean.ColumnInfo;
import com.mousika.tool.bean.ConfigInfo;
import com.mousika.tool.bean.ConstantMap;
import com.mousika.tool.bean.Constants;
import com.mousika.tool.bean.DatabaseInfo;
import com.mousika.tool.bean.JdbcConfigInfo;
import com.mousika.tool.bean.TableInfo;
import com.mousika.tool.bean.TemplateConfigInfo;
import com.mousika.tool.core.Config;
import com.mousika.tool.core.MainOperate;
import com.mousika.tool.util.UrlUtil;

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
    private JTable tableGrid;
    private JTable columnGrid;
    private DefaultTableModel table_tmd;
    private DefaultTableModel column_tmd;
    private JCheckBox modelCB;
    private JCheckBox actionCB;
    private JCheckBox serviceCB;
    private JCheckBox serviceImplCB;
    private JCheckBox daoCB;
    private JCheckBox daoImplCB;
    private JTextField outputPathField;
    private JComboBox databaseCB;

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

    public void loadTableInfo(JdbcConfigInfo jdbcConfigInfo) {
        if (jdbcConfigInfo == null) {
            JOptionPane.showMessageDialog(null, "数据库连接不能为空", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jdbcConfigInfo.getDriverClass() == null || "".equals(jdbcConfigInfo.getDriverClass())) {
            JOptionPane.showMessageDialog(null, "driverClass不能为空", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jdbcConfigInfo.getUrl() == null || "".equals(jdbcConfigInfo.getUrl())) {
            JOptionPane.showMessageDialog(null, "url不能为空", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jdbcConfigInfo.getUsername() == null || "".equals(jdbcConfigInfo.getUsername())) {
            JOptionPane.showMessageDialog(null, "username不能为空", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jdbcConfigInfo.getPassword() == null || "".equals(jdbcConfigInfo.getPassword())) {
            JOptionPane.showMessageDialog(null, "password不能为空", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<TableInfo> tableInfos = MainOperate.loadTableInfo(jdbcConfigInfo);
        table_tmd.setRowCount(0);

        int len = tableInfos.size();

        for (int i = 0; i < len; i++) {
            Object[] obj = new Object[3];
            obj[0] = tableInfos.get(i).isEnable();
            obj[1] = tableInfos.get(i).getTableName().toUpperCase();
            obj[2] = tableInfos.get(i).getRemarks();
            table_tmd.addRow(obj);
        }
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

        databaseCB = new JComboBox(Config.getDatabaseNames());
        databaseCB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String dbName = ((JComboBox) e.getSource()).getSelectedItem().toString();
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
        refreshButt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String driverClass = driverField.getText();
                String url = urlField.getText();
                String username = usernameField.getText();
                String password = passwordField.getText();
                String type = databaseCB.getSelectedItem().toString();

                JdbcConfigInfo jdbcConfigInfo = new JdbcConfigInfo(driverClass, url, username, password, type);
                loadTableInfo(jdbcConfigInfo);
            }
        });
        refreshButt.setBounds(10, 153, 93, 23);
        panel.add(refreshButt);

        JButton generatorButt = new JButton("Generator");
        generatorButt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isSelected = false;
                for (TableInfo info : ConfigInfo.tableInfos) {
                    if (info.isEnable() == true) {
                        isSelected = true;
                        break;
                    }
                }

                if (isSelected == false) {
                    JOptionPane.showMessageDialog(null, "请至少选择一张表", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if ("".equals(outputPathField.getText())) {
                    JOptionPane.showMessageDialog(null, "请选择输出路径", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (modelCB.isSelected() == false && actionCB.isSelected() == false && daoCB.isSelected() == false && daoImplCB.isSelected() == false && serviceCB.isSelected() == false
                        && serviceImplCB.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "请至少选择一个模块", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (moduleName.getText() == null || "".equals(moduleName.getText())) {
                    JOptionPane.showMessageDialog(null, "包路径未设置", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (modelCB.isSelected() && "".equals(modelTemp.getText())) {
                    JOptionPane.showMessageDialog(null, "请选择model的模板路径", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (actionCB.isSelected() && "".equals(actionTemp.getText())) {
                    JOptionPane.showMessageDialog(null, "请选择action的模板路径", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (daoCB.isSelected() && "".equals(daoTemp.getText())) {
                    JOptionPane.showMessageDialog(null, "请选择dao的模板路径", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (daoImplCB.isSelected() && "".equals(daoImplTemp.getText())) {
                    JOptionPane.showMessageDialog(null, "请选择daoImpl的模板路径", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (serviceCB.isSelected() && "".equals(serviceTemp.getText())) {
                    JOptionPane.showMessageDialog(null, "请选择service的模板路径", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (serviceImplCB.isSelected() && "".equals(serviceImplTemp.getText())) {
                    JOptionPane.showMessageDialog(null, "请选择serviceImpl的模板路径", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JdbcConfigInfo jdbcConfigInfo = new JdbcConfigInfo(driverField.getText(), urlField.getText(), usernameField.getText(), passwordField.getText());
                ConfigInfo.jdbcConfigInfo = jdbcConfigInfo;

                Map<Constants, TemplateConfigInfo> tempConfigMap = new HashMap<Constants, TemplateConfigInfo>();
                tempConfigMap.put(Constants.MODEL, new TemplateConfigInfo(modelPack.getText(), modelTemp.getText(), modelCB.isSelected()));
                tempConfigMap.put(Constants.ACTION, new TemplateConfigInfo(actionPack.getText(), actionTemp.getText(), actionCB.isSelected()));
                tempConfigMap.put(Constants.SERVICE, new TemplateConfigInfo(servicePack.getText(), serviceTemp.getText(), serviceCB.isSelected()));
                tempConfigMap.put(Constants.SERVICE_IMPL, new TemplateConfigInfo(serviceImpPack.getText(), serviceImplTemp.getText(), serviceImplCB.isSelected()));
                tempConfigMap.put(Constants.DAO, new TemplateConfigInfo(daoPack.getText(), daoTemp.getText(), daoCB.isSelected()));
                tempConfigMap.put(Constants.DAO_IMPL, new TemplateConfigInfo(daoImplPack.getText(), daoImplTemp.getText(), daoImplCB.isSelected()));
                ConfigInfo.tempConfigMap = tempConfigMap;

                ConfigInfo.outputPath = outputPathField.getText();

                String result = MainOperate.generatorFiles();
                JOptionPane.showMessageDialog(null, result, "提示", JOptionPane.WARNING_MESSAGE);
            }
        });
        generatorButt.setBounds(108, 153, 93, 23);
        panel.add(generatorButt);

        JButton exitButt = new JButton("Exit");
        exitButt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });
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
                String module = ((JTextField) e.getComponent()).getText();
                modelPack.setText(module + ".model");
                actionPack.setText(module + ".controller");
                servicePack.setText(module + ".service");
                serviceImpPack.setText(module + ".service.impl");
                daoPack.setText(module + ".dao");
                daoImplPack.setText(module + ".dao.impl");
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
        allCB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isSelected = ((JCheckBox) e.getSource()).isSelected();
                modelCB.setSelected(isSelected);
                actionCB.setSelected(isSelected);
                serviceCB.setSelected(isSelected);
                serviceImplCB.setSelected(isSelected);
                daoCB.setSelected(isSelected);
                daoImplCB.setSelected(isSelected);
            }
        });
        allCB.setSelected(true);
        allCB.setBounds(269, 6, 30, 23);
        panel_1.add(allCB);

        modelCB = new JCheckBox("");
        modelCB.setSelected(true);
        modelCB.setBounds(269, 31, 30, 23);
        panel_1.add(modelCB);

        actionCB = new JCheckBox("");
        actionCB.setSelected(true);
        actionCB.setBounds(269, 56, 30, 23);
        panel_1.add(actionCB);

        serviceCB = new JCheckBox("");
        serviceCB.setSelected(true);
        serviceCB.setBounds(269, 81, 30, 23);
        panel_1.add(serviceCB);

        serviceImplCB = new JCheckBox("");
        serviceImplCB.setSelected(true);
        serviceImplCB.setBounds(269, 106, 30, 23);
        panel_1.add(serviceImplCB);

        daoCB = new JCheckBox("");
        daoCB.setSelected(true);
        daoCB.setBounds(269, 131, 30, 23);
        panel_1.add(daoCB);

        daoImplCB = new JCheckBox("");
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

        JButton modelTmpPath = new JButton("...");
        modelTmpPath.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setApproveButtonText("确定");
                fileChooser.setCurrentDirectory(new File(UrlUtil.getRootPath()));
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.showDialog(new JLabel(), "选择");
                File file = fileChooser.getSelectedFile();
                if (file != null) {
                    modelTemp.setText(file.getAbsolutePath());
                }
            }
        });
        modelTmpPath.setBounds(515, 31, 54, 23);
        panel_1.add(modelTmpPath);

        JButton actionTmpPath = new JButton("...");
        actionTmpPath.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setApproveButtonText("确定");
                fileChooser.setCurrentDirectory(new File(UrlUtil.getRootPath()));
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.showDialog(new JLabel(), "选择");
                File file = fileChooser.getSelectedFile();
                if (file != null) {
                    actionTemp.setText(file.getAbsolutePath());
                }
            }
        });
        actionTmpPath.setBounds(515, 56, 54, 23);
        panel_1.add(actionTmpPath);

        JButton serviceTmpPath = new JButton("...");
        serviceTmpPath.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setApproveButtonText("确定");
                fileChooser.setCurrentDirectory(new File(UrlUtil.getRootPath()));
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.showDialog(new JLabel(), "选择");
                File file = fileChooser.getSelectedFile();
                if (file != null) {
                    serviceTemp.setText(file.getAbsolutePath());
                }
            }
        });
        serviceTmpPath.setBounds(515, 81, 54, 23);
        panel_1.add(serviceTmpPath);

        JButton serviceImplTmpPath = new JButton("...");
        serviceImplTmpPath.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setApproveButtonText("确定");
                fileChooser.setCurrentDirectory(new File(UrlUtil.getRootPath()));
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.showDialog(new JLabel(), "选择");
                File file = fileChooser.getSelectedFile();
                if (file != null) {
                    serviceImplTemp.setText(file.getAbsolutePath());
                }
            }
        });
        serviceImplTmpPath.setBounds(515, 106, 54, 23);
        panel_1.add(serviceImplTmpPath);

        JButton daoTmpPath = new JButton("...");
        daoTmpPath.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setApproveButtonText("确定");
                fileChooser.setCurrentDirectory(new File(UrlUtil.getRootPath()));
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.showDialog(new JLabel(), "选择");
                File file = fileChooser.getSelectedFile();
                if (file != null) {
                    daoTemp.setText(file.getAbsolutePath());
                }
            }
        });
        daoTmpPath.setBounds(515, 131, 54, 23);
        panel_1.add(daoTmpPath);

        JButton daoImplTmpPath = new JButton("...");
        daoImplTmpPath.setBounds(515, 156, 54, 23);
        daoImplTmpPath.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setApproveButtonText("确定");
                fileChooser.setCurrentDirectory(new File(UrlUtil.getRootPath()));
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.showDialog(new JLabel(), "选择");
                File file = fileChooser.getSelectedFile();
                if (file != null) {
                    daoImplTemp.setText(file.getAbsolutePath());
                }
            }
        });
        panel_1.add(daoImplTmpPath);
        // ------------------------------------------------------
        JScrollPane panel_2 = new JScrollPane();
        panel_2.setBounds(10, 35, 311, 356);
        getContentPane().add(panel_2);

        String[][] row = new String[20][2];
        String[] column = { "", "表名", "注释" };
        table_tmd = new DefaultTableModel(row, column);

        tableGrid = new JTable(table_tmd);

        TableColumn aColumn = tableGrid.getColumnModel().getColumn(0);
        aColumn.setCellEditor(tableGrid.getDefaultEditor(Boolean.class));
        aColumn.setCellRenderer(tableGrid.getDefaultRenderer(Boolean.class));

        tableGrid.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                synchronized (this) {
                    String table = tableGrid.getModel().getValueAt(tableGrid.getSelectedRow(), 1) + "";
                    ConfigInfo.tableInfos.get(tableGrid.getSelectedRow()).setEnable(Boolean.parseBoolean(tableGrid.getModel().getValueAt(tableGrid.getSelectedRow(), 0) + ""));
                    List<ColumnInfo> columnInfos = ConfigInfo.tabAndcolMap.get(table);

                    column_tmd.setRowCount(0);

                    int len = columnInfos.size();

                    for (int i = 0; i < len; i++) {
                        Object[] obj = new Object[6];
                        ColumnInfo columnInfo = columnInfos.get(i);
                        obj[0] = columnInfo.isEnable();
                        obj[1] = columnInfo.getColumnName();
                        obj[2] = columnInfo.getTypeName();
                        obj[3] = ConstantMap.sql2JavaMap.get(columnInfo.getTypeName());
                        obj[4] = columnInfo.getColumnSize();
                        obj[5] = columnInfo.getRemarks();
                        column_tmd.addRow(obj);
                    }
                }
            }
        });

        panel_2.setViewportView(tableGrid);
        // -------------------------------------------------------

        JScrollPane panel_3 = new JScrollPane();
        panel_3.setBounds(331, 35, 571, 356);
        getContentPane().add(panel_3);

        String[][] row2 = new String[20][6];
        String[] column2 = { "", "列名", "SQL类型", "JAVA类型", "大小", "注释" };
        column_tmd = new DefaultTableModel(row2, column2);

        columnGrid = new JTable(column_tmd);
        columnGrid.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                boolean colEnable = Boolean.parseBoolean(columnGrid.getModel().getValueAt(columnGrid.getSelectedRow(), 0) + "");
                String table = tableGrid.getModel().getValueAt(tableGrid.getSelectedRow(), 1) + "";
                List<ColumnInfo> columnInfos = ConfigInfo.tabAndcolMap.get(table.toUpperCase());
                columnInfos.get(columnGrid.getSelectedRow()).setEnable(colEnable);
            }
        });

        TableColumn aColumn2 = columnGrid.getColumnModel().getColumn(0);
        aColumn2.setCellEditor(columnGrid.getDefaultEditor(Boolean.class));
        aColumn2.setCellRenderer(columnGrid.getDefaultRenderer(Boolean.class));

        panel_3.setViewportView(columnGrid);

        // ----------------------------------------------------------
        JLabel lblNewLabel_11 = new JLabel("输出路径");
        lblNewLabel_11.setBounds(10, 10, 69, 15);
        getContentPane().add(lblNewLabel_11);

        outputPathField = new JTextField();
        outputPathField.setBounds(75, 7, 161, 21);
        getContentPane().add(outputPathField);
        outputPathField.setColumns(10);

        JButton outpathButt = new JButton("...");
        outpathButt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setApproveButtonText("确定");
                fileChooser.setCurrentDirectory(new File(UrlUtil.getRootPath()));
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.showDialog(new JLabel(), "选择");
                File file = fileChooser.getSelectedFile();
                if (file != null) {
                    outputPathField.setText(file.getAbsolutePath());
                }
            }
        });
        outpathButt.setBounds(240, 6, 81, 23);
        getContentPane().add(outpathButt);

    }
}
