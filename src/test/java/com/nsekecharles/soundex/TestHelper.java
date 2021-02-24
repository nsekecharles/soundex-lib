package com.nsekecharles.soundex;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class TestHelper {

    public static Map<String, String>  getSoundexDataMap() {

        JSONArray words = fileReader("data.json");

        Map<String, String> result = (Map<String, String>) words.stream()
                .map(element -> new Content(((JSONObject) element).get("Mot").toString(), ((JSONObject) element).get("SoundexCode1").toString()))
                .collect(toMap(Content::getWord, Content::getCode));

        return result;
    }

    public static Map<String, String>  getSoundex2DataMap() {

        JSONArray words = fileReader("data.json");

        Map<String, String> result = (Map<String, String>) words.stream()
                .map(element -> new Content(((JSONObject) element).get("Mot").toString(), ((JSONObject) element).get("SoundexCode2").toString()))
                .collect(toMap(Content::getWord, Content::getCode));

        return result;
    }

    public static class Content {
        private final String word;
        private final String code;

        public Content(String word, String code) {
            this.word = word;
            this.code = code;
        }

        public String getWord() {
            return word;
        }

        public String getCode() {
            return code;
        }
    }

    private static JSONArray fileReader(String fileName) {
        JSONParser jsonParser = new JSONParser();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        final URL data = classloader.getResource(fileName);

        try (FileReader reader = new FileReader(data.getPath())) {
            Object obj = jsonParser.parse(reader);

            return (JSONArray) obj;

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
