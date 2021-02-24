package com.nsekecharles.soundex;


import org.junit.runners.Parameterized.Parameters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SoundexTest extends SoundexBaseTest {

    public SoundexTest(String word, String code) {
        super(word, code);
    }

    @Parameters(name = "{0} should have soundexCode --> {1}" )
    public static List<Object> data() {

        final Map<String, String> soundexDataMap = TestHelper.getSoundexDataMap();

        return soundexDataMap
                .keySet().stream()
                .map(k-> new Object[] { k, soundexDataMap.get(k) })
                .collect(Collectors.toList());

    }

    @Override
    protected SoundexBase getSoundex() {
        return new Soundex(word);
    }
}