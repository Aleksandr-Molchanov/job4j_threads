package ru.job4j.io;

import java.io.*;
import java.util.function.Predicate;

public final class ParseFile {
    private final File file;

    public ParseFile(File file) {
        this.file = file;
    }

    public String content(Predicate<Character> filter) {
        String output = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int data;
            while ((data = reader.read()) > 0) {
                if (filter.test((char) data)) {
                    output += (char) data;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public String getContent() {
        return content(c -> true);
    }

    public String getContentWithoutUnicode() {
        return content(c -> c < 0x80);
    }
}