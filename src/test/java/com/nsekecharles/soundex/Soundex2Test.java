package com.nsekecharles.soundex;

import org.junit.runners.Parameterized.Parameters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Soundex2Test extends SoundexBaseTest {

    public Soundex2Test(String word, String code) {
        super(word, code);
    }

    @Parameters(name = "{0} should have soundex2code --> {1}" )
    public static List<Object> data() {

        final Map<String, String> soundex2DataMap = TestHelper.getSoundex2DataMap();

        return soundex2DataMap
                .keySet().stream()
                .map(k-> new Object[] { k, soundex2DataMap.get(k) })
                .collect(Collectors.toList());

    }


    @Override
    protected SoundexBase getSoundex() {
        return new Soundex2(word);
    }
}