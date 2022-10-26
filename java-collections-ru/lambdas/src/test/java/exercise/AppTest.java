package exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testImige1() {

        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        String[][] expected = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"}
        };

        String[][] actual = App.enlargeArrayImage(image);
        assertThat(Arrays.deepEquals(actual, expected)).isEqualTo(true);
    }

    @Test
    void testEmpty() {

        String[][] image = {};

        String[][] actual = App.enlargeArrayImage(image);
        assertThat(image).isEmpty();
    }

    @Test
    void testImage2() {

        String[][] image = {
                {"*", "*", "*"},
                {"*", " ", "*"},
                {"*", "*", "*"},
        };

        String[][] expected = {
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*"}
        };

        String[][] actual = App.enlargeArrayImage(image);
        assertThat(Arrays.deepEquals(actual, expected)).isEqualTo(true);
    }
}
// END
