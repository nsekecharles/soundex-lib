package com.nsekecharles.soundex;


public abstract class SoundexBase {

    protected static final String VOWELS = "A|À|Â|Ä|E|É|È|Ê|Ë|I|Ï|Î|O|Ô|Ö|U|Ù|Û|Ü|Y";

    protected  static final String SPECVOWEL = "Y";

    protected  String DUMB = "H|W";

    protected String word;

    private String originalWord;

    public  int SOUNDEXCODELENGHT = 4;

    public SoundexBase(String word) {

        this.originalWord = word;

        if (word == null || "".equals(word)) {
            throw new IllegalArgumentException("\'word\' cannot be null nor empty");
        }

        this.word = word.trim().toUpperCase().replaceAll("(\\s*)(-*)", "");
    }


    public final String getOriginalWord()  {
        return this.originalWord;
    }

    public abstract String getSoundExCode();

    protected final char getNotAccent(char c) {
        switch (c) {
            case 'À':
            case 'Â':
            case 'Ä':
                return 'A';
            case 'Ç':
                return 'S';
            case 'É':
            case 'È':
            case 'Ê':
            case 'Ë':
                return 'E';
            case 'Ï':
            case 'Î':
                return 'I';
            case 'Ô':
            case 'Ö':
                return 'O';
            case 'Ù':
            case 'Û':
            case 'Ü':
                return 'U';
        }
        return c;
    }
}
