package top.treegrowth.designmodel.chain_of_reposibility;

/**
 * 这个是责任链的处理者，抽象类
 *
 * @author wusi
 * @version 2017/2/25 22:37.
 */
public abstract class Handler {

    private Handler nextHandler;

    public void handleMessage(Request request) {

        if (this.getLevel() == request.getLevel()) {
            this.echo(request);
        } else {
            if (this.nextHandler != null) {
                this.nextHandler.handleMessage(request);
            } else {
                System.out.println("-----------没地方请示了，按不同意处理---------\n");
            }
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract Response echo(Request request);

    public abstract Level getLevel();
}
