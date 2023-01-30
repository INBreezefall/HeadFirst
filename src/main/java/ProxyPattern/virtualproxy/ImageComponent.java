package ProxyPattern.virtualproxy;

import javax.swing.*;
import java.awt.*;

public class ImageComponent extends JComponent {
    private Icon proxy;

    public ImageComponent(Icon icon) {
        this.proxy = icon;
    }

    public void setIcon(Icon icon) {
        this.proxy = icon;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = proxy.getIconWidth();
        int h = proxy.getIconHeight();
        if (w == 0 || h == 0) {
            System.out.println("Warning: True image has broken! (May be network problem)");
        }
        int x = (800 - w) / 2; // x轴 起始位置
        int y = (600 - h) / 2; // y轴 起始位置
        // 将 icon 呈现在 ImageComponent 组件上
        System.out.println("x=" + x + ", y=" + y);
        System.out.println(proxy);
        proxy.paintIcon(this, g, x, y);
    }
}
