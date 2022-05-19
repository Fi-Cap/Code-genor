/*
重写了JFrame
实现了窗口的一些事件
    -关闭
        -提示是否保存 <需要判断是否已经保存>
        -可以取消关闭

*/
package generator;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.apache.log4j.*;

import generator.Main;
public class MFrame extends JFrame {
    public MFrame() {
        this.enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            int m = Main.askSave();
            if (m == 1 || m == 2) {
                super.processWindowEvent(e);
            } else {
                return;
            }
        }
    }

}