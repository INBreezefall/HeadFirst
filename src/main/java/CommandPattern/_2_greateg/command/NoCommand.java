package CommandPattern._2_greateg.command;

/**
 * NoCommand 不是 null
 * 注意！！！ 一定不要使用 null，为此 我们将创建 NoCommand 对象来完成 空 这一情况的行为
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("No Command");
    }

    @Override
    public void undo() {
        System.out.println("No Command");
    }
}
