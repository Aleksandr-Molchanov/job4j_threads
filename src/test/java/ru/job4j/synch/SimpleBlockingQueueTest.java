package ru.job4j.synch;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {

    @Test
    public void offer() throws InterruptedException {
        SimpleBlockingQueue queue = new SimpleBlockingQueue(10);
        Thread producer = new Thread(
                () -> {
                    try {
                        for (int i = 0; i < 10; i++) {
                            queue.offer(i);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        );
        Thread consumer = new Thread(
                () -> {
                    try {
                        for (int i = 0; i < 10; i++) {
                            queue.poll();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        );
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}