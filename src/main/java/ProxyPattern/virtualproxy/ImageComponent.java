package ProxyPattern.virtualproxy;

import javax.swing.*;
import java.awt.*;

public class ImageComponent extends JComponent {
    private Icon icon;

    public ImageComponent(Icon icon) {
        this.icon = icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        if (w == 0 || h == 0) {
            System.out.println("Warning: Image has broken! (May be network problem)");
        }
        int x = (800 - w) / 2; // x轴 起始位置
        int y = (600 - h) / 2; // y轴 起始位置
        // 将 icon 呈现在 ImageComponent 组件上
        System.out.println("x=" + x + ", y=" + y);
        System.out.println(icon);
        icon.paintIcon(this, g, x, y);
    }
}
