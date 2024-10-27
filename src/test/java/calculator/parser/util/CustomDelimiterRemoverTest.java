package calculator.parser.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.exception.IllegalArgumentExceptionEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomDelimiterRemoverTest {

    @Test
    @DisplayName("커스텀 구분자 제거 테스트")
    void remove() {
        // given
        CustomDelimiterRemover customDelimiterRemover = new CustomDelimiterRemover("//", "\\n");
        String input = "//;\\n1;2;3";

        // when
        String actual = customDelimiterRemover.remove(input);

        // then
        assertEquals("1;2;3", actual);
    }

    @Test
    @DisplayName("빈 문자열 테스트")
    void emptyString() {
        // given
        CustomDelimiterRemover customDelimiterRemover = new CustomDelimiterRemover("//", "\\n");
        String input = "";

        // when
        String actual = customDelimiterRemover.remove(input);

        // then
        assertEquals("", actual);
    }

    @Test
    @DisplayName("null 테스트")
    void nullString() {
        // given
        CustomDelimiterRemover customDelimiterRemover = new CustomDelimiterRemover("//", "\\n");
        String input = null;

        // when
        IllegalArgumentException exception = Assertions.assertThrowsExactly(IllegalArgumentException.class,
                () -> customDelimiterRemover.remove(input));

        // then
        assertEquals(IllegalArgumentExceptionEnum.NULL_INPUT.getMessage(), exception.getMessage());
    }

}