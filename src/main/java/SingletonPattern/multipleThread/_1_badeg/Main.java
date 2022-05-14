package SingletonPattern.multipleThread._1_badeg;

public class Main {

    /**
     * 多线程 Buyers 向 单例 ChocolateBoiler 提交请求
     * 按照 ChocolateBoiler 判断逻辑，不可能出现 2.煮沸中 时 进行 1.加入原料
     * 但 执行中就会发现奇怪的事情
     *
     * 1.加入原料 Thread-4
     * 2.煮沸中 Thread-4
     * 1.加入原料 Thread-1
     * 2.煮沸中 Thread-1
     * 3.排出成品 Thread-7
     *
     * 问题根源: 从一开始的打印 可以看出多线程 Buyer 获取单例对象的 HasCode 并不一致
     * 378778546 Thread-6
     * 378778546 Thread-2
     * 378778546 Thread-9
     * 378778546 Thread-0
     * 242512469 Thread-8 *
     * 378778546 Thread-5
     * 378778546 Thread-7
     * 378778546 Thread-1
     * 378778546 Thread-4
     * 378778546 Thread-3
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        Buyer[] buyers = new Buyer[10];
        for (int i = 0; i < buyers.length; i++) {
            buyers[i] = new Buyer();
        }
        for (Buyer buyer : buyers) {
            buyer.start();
        }
    }
}


