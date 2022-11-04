package com.framework.unitests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyFristTest {


    @Test
    void myFirstTest () {
        int result = sum(2, 2);
        Assertions.assertEquals(4, result);

    }

    static int sum(int a, int b) {
        return a + b;
    }


}
