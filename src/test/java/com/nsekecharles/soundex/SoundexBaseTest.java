package com.nsekecharles.soundex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public abstract class SoundexBaseTest {

    protected final String word;
    private final String code;

    public SoundexBaseTest(String word, String code) {
        this.word = word;
        this.code = code;
    }

    @Test
    public void checkSoundexCode() {

        assertEquals(code, getSoundex().getSoundExCode());

    }

    protected abstract SoundexBase getSoundex();

}
