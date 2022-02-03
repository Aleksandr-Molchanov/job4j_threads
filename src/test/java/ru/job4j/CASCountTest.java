package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CASCountTest {

    @Test
    public void when2ThreadsIncrementTheCounterBy3TheResultIs3() throws InterruptedException {
        CASCount cas = new CASCount();
        Thread thread1 = new Thread(
                () -> {
                    cas.increment();
                    cas.increment();
                }
        );
        Thread thread2 = new Thread(
                () -> {
                    cas.increment();
                }
        );
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(cas.get(), is(3));
    }

    @Test
    public void when2ThreadsIncrementTheCounterBy5TheResultIs5() throws InterruptedException {
        CASCount cas = new CASCount();
        Thread thread1 = new Thread(
                () -> {
                    cas.increment();
                    cas.increment();
                }
        );
        Thread thread2 = new Thread(
                () -> {
                    cas.increment();
                    cas.increment();
                    cas.increment();
                }
        );
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(cas.get(), is(5));
    }

    @Test
    public void whenTheCounterIsNotIncrementedTheResultIs0() throws InterruptedException {
        CASCount cas = new CASCount();
        assertThat(cas.get(), is(0));
    }
}