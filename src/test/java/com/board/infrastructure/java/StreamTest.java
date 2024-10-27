package com.board.infrastructure.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class StreamTest {

    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1, 2, 3);

        final boolean isResult = list.stream().allMatch(e -> e >= 2);

        assertFalse(isResult);
    }

}
