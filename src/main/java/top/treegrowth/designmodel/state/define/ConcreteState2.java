package top.treegrowth.designmodel.state.define;

import static top.treegrowth.designmodel.state.define.Context.STATE1;

/**
 * @author wusi
 * @version 2017/5/21 19:16.
 */
public class ConcreteState2 extends State{

    @Override
    protected void doSomething1() {
        //状态发生改变时处理的逻辑
        //设置当前的状态
        super.context.setCurrentState(STATE1);
        //调用当前状态的行为
        super.context.doSomething1();
    }

    @Override
    protected void doSomething2() {
        //本状态下必须处理的逻辑
    }
}
