package top.treegrowth.designmodel.mediator;

/**
 * @author wusi
 * @version 2017/3/26 21:36.
 */
public abstract class Colleague {

    protected Mediator mediator;
    //强制子类必须注入，因为没有空的构造方法了
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
