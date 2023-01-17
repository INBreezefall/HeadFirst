package StatePattern.greateg;


/**
 * <pre>greateg 改进了什么问题？
 * 1.消灭了 if else
 * 2.抽象出了 状态机体系
 *      Context [Class]    {       <---组合---          State [Interface]
 *          拥有内部状态的上下文对象                            /      |          \
 *          State stateImpl1                     StateImpl1 StateImpl2   ...
 *          State stateImpl2
 *          State curState
 *
 *          行为 1() {
 *              curState.行为1()
 *          }
 *
 *          行为 2() {
 *              curState.行为2()
 *          }
 *      }
 *
 * 策略模式 & 状态模式 差异在哪里？ 实质上看起来都很相像 [组合 & 变更当前实例引用]
 *      策略模式 算法族/行为族 即是一个统一接口 且 很细化专项性，每个族下有复数个实现类
 *              族内的复数个实现类 毫无关联 无顺序性
 *              一个 Context 上下文主体 可以有多个 算法族/行为族 (叫、飞、走)
 *              外部视角下 —— 对于 Context 内部使用的 具体算法 浑然不觉 / 完全不关心
 *      状态模式 中的 状态转换 是 相互关联的 也就是 宿主行为 1 & 行为 2 都需要在 其内部每个状态实现类中实现
 *              状态族中的状态之间具备 预定好的流转逻辑，是一整套既定方案 [核心区别 与 策略模式]
 *              在 状态实现类中 会关联 / 决定 当前行为 n 流转的下一个状态 是 哪一个 [在状态转换比较明确的时候]
 *                  当然 Context 的 行为 n 中 也可以 做下一个状态流转指定 [关注的重点是 哪个类 对 修改关闭]
 *              外部视角下 —— 关注 Context 内部状态实例
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        // 1.初始化 & 打印糖果机状态
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);

        // 2.插入 25 美分且转动曲柄 & 打印糖果机状态 [-1]
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        // 测试可以再完善下 测到每种状态
    }
}
