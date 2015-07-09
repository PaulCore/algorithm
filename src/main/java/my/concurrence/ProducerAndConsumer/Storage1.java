package my.concurrence.ProducerAndConsumer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by paul on 2015/7/9.
 * use synchronized wait notify
 */
public class Storage1 implements Storage {
    private int capacity;
    private Queue queue ;
    public Storage1(int capacity) {
        this.capacity = capacity;
        queue = new ArrayDeque(capacity);
    }



    public void producer(int num){
        synchronized (queue){
            while (queue.size() + num > capacity){
                System.out.println("storage当前容量不够" + Thread.currentThread().getName() + "需等待");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < num; i++){
                queue.add(new Object());
            }
            System.out.println(Thread.currentThread().getName()+"向storage" + "添加" + num + "个产品,当前总量为" + queue.size());
            queue.notifyAll();
        }
    }

    public void consumer(int num){
        synchronized(queue){
            while (queue.size() < num){
                System.out.println("storage当前库存不够" + Thread.currentThread().getName() + "需等待");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++){
                queue.remove();
            }
            queue.notifyAll();
            System.out.println(Thread.currentThread().getName()+"向storage" + "消费" + num + "个产品,当前总量为" + queue.size());
        }
    }


}
