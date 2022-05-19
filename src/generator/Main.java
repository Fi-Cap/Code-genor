package generator;

import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;

import org.apache.log4j.Logger;

import generator.MFrame;
import generator.MenuDemo;

public class Main {
    public static Logger Log = Logger.getLogger(".\\Log.txt");
    public static String OpeningFile = new String();
    public static String data = new String();
    public static MenuDemo menuDemo = new MenuDemo();
    public static MFrame win = new MFrame();
    public static JTextArea txt = new JTextArea("Code");
    public static JPanel panel = new JPanel();
    public static JScrollPane ScrPane = new JScrollPane(txt);

    public static void main(String[] args) {
        
        // put txt in ScrPane
        ScrPane.setBounds(790, 0, 10, 600);
        ScrPane.getViewport().add(txt);
        ScrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // win init
        win.setTitle("Code generator");
        win.setSize(800, 680);
        win.setDefaultCloseOperation(MFrame.EXIT_ON_CLOSE);
        win.setJMenuBar(menuDemo);
        win.getContentPane().setLayout(null);
        win.getContentPane().add(ScrPane);
        win.setVisible(true);
    }

    public static int askSave() {// 询问是否保存
        if (!isSave()) {
            // 询问是否保存的消息框
            Object[] Options = { "取消", "是", "否" };
            int m = JOptionPane.showOptionDialog(null, "是否保存?", "提示", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, Options, Options[0]);

            if (m == 1) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.java", "java file");
                fc.setFileFilter(filter);
                int result = fc.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    if (!file.getPath().endsWith(".java")) {
                        file = new File(file.getPath() + ".java");
                    }
                    try {
                        if (!file.exists()) {// 文件不存在 则创建一个
                            Log.info("没有找到文件,正在创建");
                            file.createNewFile();
                        }
                        try (FileOutputStream fos = new FileOutputStream(file)) {
                            data = txt.getText();
                            fos.write(data.getBytes());
                            fos.flush();
                        }
                    } catch (IOException e) {
                        System.err.println("文件创建失败：");
                        Log.error("文件创建失败：" + e.fillInStackTrace());
                        e.printStackTrace();
                        return 0;
                    } finally {
                        System.err.println("未知问题");
                    }
                }
            }
            return m;
        }
        return -1;
    }

    public static String readAllText(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long fileLength = file.length();
        byte[] data = new byte[fileLength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(data);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(data, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isSave() {// 是否需要保存
        if (OpeningFile == null || OpeningFile == "") {
            return (true);
        }

        else if (txt.getText() == readAllText(OpeningFile)) {
            return (true);
        } else {
            return (false);
        }
    }
}
