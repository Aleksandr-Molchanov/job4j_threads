package ru.job4j;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount {
    private final AtomicReference<Integer> count = new AtomicReference<>();

    public void increment() {
        int ref;
        int num;
        do {
            ref = get();
            num = ref++;
        } while (!count.compareAndSet(ref, num));
    }

    public int get() {
        return count.get();
    }
}