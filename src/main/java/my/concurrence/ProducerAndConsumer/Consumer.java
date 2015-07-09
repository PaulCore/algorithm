package my.concurrence.ProducerAndConsumer;

import java.util.Random;

/**
 * Created by paul on 2015/7/9.
 */
public class Consumer implements Runnable{
    private Storage storage;
    private volatile boolean stop = false;
    public Consumer(Storage storage) {
        this.storage = storage;
    }

    public void setStop() {
        stop = true;
    }

    @Override
    public void run() {
        while (!stop){
            int num = new Random().nextInt(10);
            storage.consumer(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
