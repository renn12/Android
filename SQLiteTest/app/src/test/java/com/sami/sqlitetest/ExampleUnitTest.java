package com.sami.sqlitetest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        String ss = "★23";
        char f = ss.charAt(0);

        String sss = "";
        String s1 = sss.replaceAll(" ", "_");
        System.out.println((int)f);
    }
}