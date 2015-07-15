package my.concurrence.threadShutdown;

import java.util.Date;

/**
 * Created by paul on 2015/7/15.
 * 优雅的关闭线程
 * 1.设置一个标志位，但是如果只有标志位，当线程遇到阻塞或者sleep变不能stop
 * 2.调用interrupt方法，如果线程处于上述状态会抛出异常，捕获后在进行标志位判断
 */
public class ThreadShutdownGraceful extends Thread{
    private volatile boolean stop;
    public void setStop(){
        stop = true;
        interrupt();
    }

    @Override
    public void run() {


            try {
                while (!stop) {
                    System.out.println(new Date());
                Thread.sleep(6000);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadShutdownGraceful thread = new ThreadShutdownGraceful();
        thread.start();
        Thread.sleep(3000);
        thread.setStop();
    }
}
