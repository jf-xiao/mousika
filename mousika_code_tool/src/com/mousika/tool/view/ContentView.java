package com.mousika.tool.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 显示文件流
 * @author xiaojf 294825811@qq.com
 */
public class ContentView extends JFrame {
    
    private JScrollPane scrollPane;
    private JTextArea textArea;
    
    /**
     * 初始化
     */
    public void init(){
        this.setBounds(200,200,710,500);
        scrollPane = new JScrollPane();
        this.setContentPane(scrollPane);
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        
    }
    
    /**
     * 显示
     * @param title
     * @param fileStream
     */
    public void showView(String title,String fileStream){
        this.init();
        this.setTitle(title);
        textArea.setText(fileStream);
        this.setVisible(true);
    }
    
}
