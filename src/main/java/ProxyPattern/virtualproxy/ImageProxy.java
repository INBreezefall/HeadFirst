package ProxyPattern.virtualproxy;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxy implements Icon {
    private ImageIcon imageIcon;
    private final URL imageURL;
    private boolean retrieving;

    public ImageProxy(URL imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        // image 已加载完成 / 加载过
        if (imageIcon != null) {
            System.out.printf("....paint true image(x=%s,y=%s)...%n", x, y);
            imageIcon.paintIcon(c, g, x, y);
        } else {
            // ImageProxy.paintIcon() 时 由于 imageIcon == null 故 x & y 都被减到了 0, 0
            g.drawString("Loading CD Cover...", x + 400, y + 300);
            System.out.println("....downloading...");
            // 未进行检索及下载
            if (!retrieving) {
                retrieving = true;
                // 新建线程 进行 图片下载
                // 下载图片
                // 下载完成 触发重绘
                Thread retrievalThread = new Thread(() -> {
                    // 下载图片
                    imageIcon = new ImageIcon(imageURL, "CD Cover");
                    System.out.println("....repainting...");
                    // 下载完成 触发重绘
                    c.repaint();
                });
                // 启动线程
                retrievalThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
            return 600;
        }
    }
}
