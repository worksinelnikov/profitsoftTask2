package com.profitsoft.task21;

import org.junit.Test;

import static org.junit.Assert.*;

public class VowelParseTest {
    private VowelParse vowelParse = new VowelParse();

    @Test
    public void interviewRecursion() {
        assertEquals("h*e*ll*o", vowelParse.interviewRecursionTest("hello"));
        assertEquals("h*e*a*l*o", vowelParse.interviewRecursionTest("healo"));
        assertEquals("a*bc", vowelParse.interviewRecursionTest("abc"));
        assertEquals("o*a*b", vowelParse.interviewRecursionTest("oab"));
    }
}