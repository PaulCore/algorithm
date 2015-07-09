package my.concurrence.ProducerAndConsumer;

/**
 * Created by paul on 2015/7/9.
 */
public interface Storage {
    void producer(int num);
    void consumer(int mum);
}
