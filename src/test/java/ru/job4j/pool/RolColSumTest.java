package ru.job4j.pool;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RolColSumTest {

    @Test
    public void sum() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RolColSum.Sums[] array = RolColSum.sum(matrix);
        int rowSum0 = array[0].getRowSum();
        int colSum0 = array[0].getColSum();
        int rowSum1 = array[1].getRowSum();
        int colSum1 = array[1].getColSum();
        int rowSum2 = array[2].getRowSum();
        int colSum2 = array[2].getColSum();
        assertThat(rowSum0, is(6));
        assertThat(colSum0, is(12));
        assertThat(rowSum1, is(15));
        assertThat(colSum1, is(15));
        assertThat(rowSum2, is(24));
        assertThat(colSum2, is(18));
    }

    @Test
    public void asyncSum() throws ExecutionException, InterruptedException {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RolColSum.Sums[] array = RolColSum.asyncSum(matrix);
        int rowSum0 = array[0].getRowSum();
        int colSum0 = array[0].getColSum();
        int rowSum1 = array[1].getRowSum();
        int colSum1 = array[1].getColSum();
        int rowSum2 = array[2].getRowSum();
        int colSum2 = array[2].getColSum();
        assertThat(rowSum0, is(6));
        assertThat(colSum0, is(12));
        assertThat(rowSum1, is(15));
        assertThat(colSum1, is(15));
        assertThat(rowSum2, is(24));
        assertThat(colSum2, is(18));
    }
}