package generator;

import javax.swing.*;
import java.awt.event.*;

public class MenuDemo extends JMenuBar {
    public MenuDemo() {
        add(createFileMenu());
    }
    // 定义"文件"菜单
    private JMenu createFileMenu(){
        JMenu menu=new JMenu("文件(F)");
        menu.setMnemonic(KeyEvent.VK_F);// 设置快速访问符
        JMenuItem item=new JMenuItem("新建(N)", KeyEvent.VK_N);
        item.setAccelerator(KeyStroke.getKeyStroke (KeyEvent. VK_N, ActionEvent.CTRL_MASK)); 
        menu.add(item);
        item=new JMenuItem( "打开(O)",KeyEvent.VK_O);
        item.setAccelerator(KeyStroke. getKeyStroke(KeyEvent. VK_O, ActionEvent.CTRL_MASK));
        menu.add(item);
        item=new JMenuItem( "保存(S)",KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke (KeyEvent. VK_S, ActionEvent.CTRL_MASK));
        menu.add(item) ;
        menu.addSeparator();//将新分割符追加到创建菜单的末尾
        item=new JMenuItem( "退出(E)" ,KeyEvent.VK_E);
        item.setAccelerator(KeyStroke.getKeyStroke (KeyEvent. VK_E, ActionEvent.CTRL_MASK));
        menu.add(item);
        return menu;
    }

}

// 定义"编辑"菜单