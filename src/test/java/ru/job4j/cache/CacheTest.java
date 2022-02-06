package ru.job4j.cache;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CacheTest {

    @Test
    public void whenModelAddedToCache() {
        Cache cache = new Cache();
        Base base = new Base(1, 1);
        assertTrue(cache.add(base));
    }

    @Test
    public void when2ModelsHaveSameID() {
        Cache cache = new Cache();
        Base base1 = new Base(1, 1);
        Base base2 = new Base(1, 1);
        assertTrue(cache.add(base1));
        assertFalse(cache.add(base2));
    }

    @Test
    public void whenModelSuccessfullyUpdatedInCache() {
        Cache cache = new Cache();
        Base base = new Base(1, 1);
        cache.add(base);
        Base newBase = new Base(1, 1);
        newBase.setName("Base");
        assertTrue(cache.update(newBase));
    }

    @Test(expected = OptimisticException.class)
    public void whenModelFailedToUpdate() {
        Cache cache = new Cache();
        Base base = new Base(1, 1);
        cache.add(base);
        Base newBase = new Base(1, 2);
        newBase.setName("Base");
        assertTrue(cache.update(newBase));
    }

    @Test
    public void whenModelRemovedFromCache() {
        Cache cache = new Cache();
        Base base = new Base(1, 1);
        cache.add(base);
        assertThat(cache.size(), is(1));
        cache.delete(base);
        assertThat(cache.size(), is(0));
    }
}