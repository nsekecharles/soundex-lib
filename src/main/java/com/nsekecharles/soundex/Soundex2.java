package com.nsekecharles.soundex;

public class Soundex2 extends SoundexBase {

    private String NOTACCEPTEDLETTERS;

    public Soundex2(String word) {
        super(word);
        this.NOTACCEPTEDLETTERS = String.format("%s|%s", VOWELS, DUMB);
    }

    @Override
    public String getSoundExCode() {
        StringBuilder sb = new StringBuilder();

        //  Remove the accents
        word.chars().forEach(c-> sb.append(getNotAccent((char) c)));

        String word  = sb.toString()
                .replace("GUI", "KI")
                .replace("GUE", "KE")
                .replace("GA", "KA")
                .replace("GO", "KO")
                .replace("GU", "K")
                .replace("CA", "KA")
                .replace("CO", "KO")
                .replace("CU", "KU")
                .replace("Q", "K")
                .replace("CC", "K")
                .replace("CK", "K");

        word = word.charAt(0) + word.substring(1).replaceAll(this.NOTACCEPTEDLETTERS, "A");

        word = word.replace("MAC", "MCC")
                .replace("ASA", "AZA")
                .replace("KN", "NN")
                .replace("PF", "FF")
                .replace("SCH", "SSS")
                .replace("PH", "FF")
                .replaceAll("([^C|^S])H", "$1")
                .replaceAll("([^A])Y", "$1")
                .replaceAll("(.*)[A|D|T|S]$", "$1");

        word = word.charAt(0) + word.substring(1).replace("A", "");

        word = word.replaceAll("(\\D)\\1+", "$1");

        return (word.length() > 4) ? word.substring(0, 4) : word.concat(" ".repeat(4 - word.length()));
    }
}

