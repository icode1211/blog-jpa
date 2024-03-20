package com.estsoft.blogjpa;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitTest {

    @Test
    public void test() {
        int a = 1;
        int b = 2;
        int sum = 3;

//        assertEquals(sum, a+b);      // JUnit5
        assertThat(a+b).isEqualTo(sum); // AssertJ
    }
}
