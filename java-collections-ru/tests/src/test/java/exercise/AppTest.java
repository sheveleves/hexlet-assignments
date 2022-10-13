package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> actualListOne = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> actualListTwo = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> actualListZero = new ArrayList<>();

        assertThat(App.take(list, 3)).isEqualTo(actualListOne)
                .isNotNull()
                .isNotEmpty();
        assertThat(App.take(list, 10)).isEqualTo(actualListTwo)
                .isNotNull()
                .isNotEmpty();
        assertThat(App.take(list, 0)).isEqualTo(actualListZero)
                .isNotNull()
                .isEmpty();
        assertThat(App.take(list, -4)).isEqualTo(actualListZero)
                .isNotNull()
                .isEmpty();
        // END
    }
}
