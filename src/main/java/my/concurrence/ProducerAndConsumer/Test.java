package my.concurrence.ProducerAndConsumer;

/**
 * Created by paul on 2015/7/9.
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {
//        Storage storage = new Storage(20);
        Storage2 storage = new Storage2(20);
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        Thread producer1 = new Thread(producer,"producer1");
        Thread producer2 = new Thread(producer,"producer2");
        Thread producer3 = new Thread(producer,"producer3");

        Thread consumer1 = new Thread(consumer,"consumer1");
        Thread consumer2 = new Thread(consumer,"consumer2");
        Thread consumer3 = new Thread(consumer,"consumer3");

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
        Thread.sleep(10000);
        consumer.setStop();
        producer.setStop();
    }
}
