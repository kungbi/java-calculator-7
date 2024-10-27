package calculator.parser.util;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private final String defaultDelim;

    private Tokenizer() {
        this.defaultDelim = "";
    }

    public Tokenizer(String defaultDelim) {
        this.defaultDelim = defaultDelim;
    }

    public ArrayList<String> tokenize(String input, Character customDelimiter) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        String delimiter = defaultDelim;
        if (customDelimiter != null) {
            delimiter = defaultDelim + customDelimiter;
        }

        return new ArrayList<>(List.of(input.split("[" + delimiter + "]")));
    }
}
