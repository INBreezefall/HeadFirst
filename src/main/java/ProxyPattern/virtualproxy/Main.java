package ProxyPattern.virtualproxy;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Main {
    private static ImageComponent imageComponent;
    // 最外层框架
    private static final JFrame frame = new JFrame("CD Cover Viewer");
    // 顶部菜单栏
    private static final JMenuBar menuBar = new JMenuBar();
    // 菜单
    private static final JMenu menu = new JMenu("Favorite CDs");

    private static final HashMap<String, String> cds = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // 1.CD 封面 URL 初始化
        // 图片已丢失，理应在 ImageProxy 中考虑到这种特殊情况
        cds.put("Ambient: Music for Airports", "https://images.amazon.com/images/PB000003S2k.01.LZZZZZZZ.jpg");
        // 正常可下载图片
        cds.put("Buddha Bar", "https://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
        cds.put("Ima", "https://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
        cds.put("Karma", "https://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.jpg");
        cds.put("MCMXC a.D.", "https://images.amazon.com/images/P/B0000002URV.01.LZZZZZZZ.jpg");
        cds.put("Northern Exposure", "https://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
        cds.put("Selected Ambient Works, Vol. 2", "https://images.amazon.com/images/P/B000002MNZ.01LZZZZZZZ.jpg");
        cds.put("oliver", "https://www.cs.yale.edu/homes/freeman-elisabeth/2004/9/Oliver_sm.jpg");

        // 2.构建图像界面
        cds.forEach((name, url) -> {
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            // 为当前 新建的项目 增加点击事件监听器
            menuItem.addActionListener((event) -> {
                try {
                    imageComponent.setIcon(new ImageProxy(new URL(url)));
                    frame.repaint();
                } catch (MalformedURLException e) {
                    System.out.println("URL(" + url +") is illegal");
                    // 这里还应进行 异常处理 将 URL 解析失败的图片进行默认图片设置 DefaultImage [Image = Icon]
                }
            });
        });
        menuBar.add(menu);
        imageComponent = new ImageComponent(new ImageProxy(new URL("https://www.cs.yale.edu/homes/freeman-elisabeth/2004/9/Oliver_sm.jpg")));
        frame.setContentPane(imageComponent);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
