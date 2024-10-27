package calculator.parser;

import calculator.parser.util.CustomDelimiterParser;
import calculator.parser.util.CustomDelimiterRemover;
import calculator.parser.util.Tokenizer;
import calculator.parser.util.TokensToIntConverter;
import java.util.List;

public class InputParser {
    private final CustomDelimiterParser delimiterParser;
    private final Tokenizer tokenizer;
    private final TokensToIntConverter intConverter;
    private final CustomDelimiterRemover customDelimiterRemover;

    public InputParser(String defaultDelimiter, String customDelimiterPrefix, String customDelimiterSuffix) {
        this.delimiterParser = new CustomDelimiterParser(customDelimiterPrefix, customDelimiterSuffix);
        this.tokenizer = new Tokenizer(defaultDelimiter);
        this.intConverter = new TokensToIntConverter();
        this.customDelimiterRemover = new CustomDelimiterRemover(customDelimiterPrefix, customDelimiterSuffix);
    }

    public List<Integer> parse(String input) {
        Character customDelimiter = delimiterParser.getDelimiter(input);
        String cleanedInput = customDelimiterRemover.remove(input);
        List<String> tokens = tokenizer.tokenize(cleanedInput, customDelimiter);
        return intConverter.convertToInt(tokens);
    }

}
