package SingletonPattern.multipleThread._3_greateg;


public class Main {
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
