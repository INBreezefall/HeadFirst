package DecoratorPattern._4_homework;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int c;
        try {
            LowerCaseInputStream in = new LowerCaseInputStream(
                    new FileInputStream("src/main/resources/DecoratorPattern/LowerTest.txt"));
            while ((c = in.read()) >= 0)
                System.out.print((char) c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
