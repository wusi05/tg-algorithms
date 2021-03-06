package top.treegrowth.async;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author wusi
 * @since 2019-10-31 08:32
 */
public class CallableFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务>>>" + DateUtil.getNowTimeString());
        //System.out.println("子线程取消任务>>>"+ DateUtil.getNowTimeString());
        //result.cancel(true);
        try {
            System.out.println("task运行结果>>" + result.get() + DateUtil.getNowTimeString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (CancellationException e) {
            System.out.println("子线程已经取消任务" + DateUtil.getNowTimeString());
        }

        System.out.println("所有任务执行完毕<<<" + DateUtil.getNowTimeString());
        System.out.println("主线程堆栈信息" + Arrays.toString(Thread.currentThread().getStackTrace()));
        System.out.println("主线程id" + Thread.currentThread().getId());
    }
}