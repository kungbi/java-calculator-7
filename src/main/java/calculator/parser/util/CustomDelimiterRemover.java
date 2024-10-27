package calculator.parser.util;

import calculator.exception.ExceptionUtils;
import calculator.exception.IllegalArgumentExceptionEnum;

public class CustomDelimiterRemover {
    final String delimPrefix;
    final String delimSuffix;

    private CustomDelimiterRemover() {
        this.delimPrefix = "";
        this.delimSuffix = "";
    }

    public CustomDelimiterRemover(String delimPrefix, String delimSuffix) {
        this.delimPrefix = delimPrefix;
        this.delimSuffix = delimSuffix;
    }

    public String remove(String input) {
        if (input == null) {
            ExceptionUtils.throwIllegalArgException(IllegalArgumentExceptionEnum.NULL_INPUT);
        }

        int startIndex = input.indexOf(delimPrefix);
        int endIndex = input.indexOf(delimSuffix, startIndex + 1);

        if (endIndex != -1) {
            return input.substring(0, startIndex) + input.substring(endIndex + delimSuffix.length());
        }

        return input;
    }
}
