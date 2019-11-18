package com.profitsoft.task22;

import org.junit.Test;

import static org.junit.Assert.*;

public class CryptorTest {
    private Cryptor cryptor = new Cryptor();
    @Test
    public void encode() {
        assertEquals("|00 0 0 0 00 000 0 000|", cryptor.encode("G"));
    }

    @Test
    public void decode() {
        assertEquals("G", cryptor.decode("|00 0 0 0 00 000 0 000|"));
    }
}