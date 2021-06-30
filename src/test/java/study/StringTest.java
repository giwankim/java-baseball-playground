package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void split_singleton() {
        String input = "1,";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String substr = input.substring(1, input.length() - 1);
        assertThat(substr).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String input = "abc";
        char result = input.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("위치 값을 벗어난 경우")
    void charAtOutOfBounds() {
        assertThatThrownBy(() -> {
            String input = "abc";
            input.charAt(4);
        }).isExactlyInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

}
