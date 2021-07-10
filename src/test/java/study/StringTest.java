package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split_by_comma() {
        assertThat("1,2".split(",")).containsExactly("1","2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void substring() {
        String text = "(1,2)";
        String actual = text.substring(1, text.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> "abc".charAt(4))
            .withMessageMatching("String index out of range: \\d+");
    }
}
