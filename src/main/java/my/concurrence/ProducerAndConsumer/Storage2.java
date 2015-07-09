package my.concurrence.ProducerAndConsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by paul on 2015/7/9.
 * use lock await signal
 */
public class Storage2 implements Storage {
    private int capacity;
    private Queue queue;

    private final Lock lock = new ReentrantLock();
    //库满
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();
    public Storage2(int capacity) {
        this.capacity = capacity;
        queue = new ArrayDeque(capacity);
    }

    public void producer(int num){
        lock.lock();
        while (queue.size() + num > capacity){
            System.out.println("storage当前容量不够" + Thread.currentThread().getName() + "需等待");
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < num; i++){
            queue.add(new Object());
        }
        System.out.println(Thread.currentThread().getName()+"向storage" + "添加" + num + "个产品,当前总量为" + queue.size());
        full.signalAll();
        empty.signalAll();
        lock.unlock();
    }

    public void consumer(int num){
        lock.lock();
            while (queue.size() < num){
                System.out.println("storage当前库存不够" + Thread.currentThread().getName() + "需等待");
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++){
                queue.remove();
            }
        System.out.println(Thread.currentThread().getName()+"向storage" + "消费" + num + "个产品,当前总量为" + queue.size());
        full.signalAll();
        empty.signalAll();
        lock.unlock();

        }

}
