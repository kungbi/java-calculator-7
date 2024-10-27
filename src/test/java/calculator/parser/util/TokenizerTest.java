package calculator.parser.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TokenizerTest {

    @Test
    @DisplayName("기본 구분자로 토큰화 성공")
    void tokenizeDefaultDelimiters() {
        // Given
        Tokenizer tokenizer = new Tokenizer(",:");

        // When
        List<String> tokens = tokenizer.tokenize("1,2,3", null);

        // Then
        List<String> expectedTokens = new ArrayList<>(List.of("1", "2", "3"));
        assertIterableEquals(expectedTokens, tokens);
    }

    @Test
    @DisplayName("콤마와 콜론을 구분자로 사용하여 토큰화 성공")
    void tokenizeCommaColon() {
        // Given
        Tokenizer tokenizer = new Tokenizer(",:");

        // When
        List<String> tokens = tokenizer.tokenize("1,2:3", null);

        // Then
        List<String> expectedTokens = new ArrayList<>(List.of("1", "2", "3"));

        // List의 값이 같은지 확인
        assertIterableEquals(expectedTokens, tokens);
    }

    @Test
    @DisplayName("빈 입력값 토큰화 시 빈 리스트 반환")
    void tokenizeEmptyInput() {
        Tokenizer tokenizer = new Tokenizer(",:");

        ArrayList<String> tokens = tokenizer.tokenize("", null);
        assertEquals(0, tokens.size());
    }

    @Test
    @DisplayName("null 입력값 토큰화 시 빈 리스트 반환")
    void tokenizeNullInput() {
        Tokenizer tokenizer = new Tokenizer(",:");

        List<String> tokens = tokenizer.tokenize(null, null);
        assertEquals(0, tokens.size());
    }

}
