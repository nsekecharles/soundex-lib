package com.nsekecharles.soundex;



public class Soundex extends SoundexBase {

    private String NOTACCEPTEDLETTERS;

    public Soundex(String word) {
        super(word);
        this.NOTACCEPTEDLETTERS = String.format("%s|%s|%s", VOWELS, SPECVOWEL, DUMB);
    }


    @Override
    public  String getSoundExCode() {

        StringBuilder sb = new StringBuilder(4);

        //  Ajout du premier caractère du mot
        sb.append(super.getNotAccent(word.charAt(0)));

        if ((word.length() > 1)) {
            int code = 0;
            int prevCode = 0;

            //  Retrait des voyelles et des lettres dumb à l'exception du premier caractère
            word = word.substring(1).replaceAll(this.NOTACCEPTEDLETTERS, "");

            for (int i = 0; (i < word.length()); i++) {
                //  match du caractère à sa valeur
                switch (word.charAt(i)) {
                    case 'B':
                    case 'P':
                        code = 1;
                        break;
                    case 'C':
                        // case '�':
                    case 'K':
                    case 'Q':
                        code = 2;
                        break;
                    case 'D':
                    case 'T':
                        code = 3;
                        break;
                    case 'L':
                        code = 4;
                        break;
                    case 'M':
                    case 'N':
                        code = 5;
                        break;
                    case 'R':
                        code = 6;
                        break;
                    case 'G':
                    case 'J':
                        code = 7;
                        break;
                    case 'S':
                    case 'X':
                    case 'Z':
                        code = 8;
                        break;
                    case 'F':
                    case 'V':
                        code = 9;
                        break;
                }
                //  On ne peut pas ajouter le même code deux fois
                if ((code != prevCode)) {
                    sb.append(code);
                }

                //  Le code soundex ne peut pas avoir une taille de plus de 4 caractères
                if ((sb.length() == 4)) {
                    break;
                }

                prevCode = code;
            }

        }

        // on doit rajouter des 0 à des code de moins de 4 caractères
        return sb.append("0".repeat(4 - sb.length())).toString();
    }
}
