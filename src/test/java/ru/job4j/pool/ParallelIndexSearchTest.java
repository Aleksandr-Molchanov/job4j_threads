package ru.job4j.pool;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParallelIndexSearchTest {

    @Test
    public void whenObjectSearchIs4ResultIs2() {
        Integer[] array = {2, 8, 4, 15, 25, 1, 34, 66, 43, 32, 11, 13};
        int rsl = ParallelIndexSearch.search(array, 4);
        assertThat(rsl, is(2));
    }

    @Test
    public void whenObjectIsNotFoundResultIsMinus1() {
        Character[] array = {'a', 'd', 'm', 'y', 'l', 's', 'e', 'w', 'q', 'o', 'n', 'b'};
        int rsl = ParallelIndexSearch.search(array, 'z');
        assertThat(rsl, is(-1));
    }
}