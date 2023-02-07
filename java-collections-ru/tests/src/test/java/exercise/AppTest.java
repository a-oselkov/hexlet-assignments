package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AppTest {
    List<Integer> list;
    @BeforeEach
    void initList() {
        this.list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    }
    @Test
    void takeTest() {
        List<Integer> extended1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> actual1 = App.take(list, 2);
        Assertions.assertEquals(extended1, actual1);

        List<Integer> extended2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> actual2 = App.take(list, 5);
        Assertions.assertEquals(extended2, actual2);

        List<Integer> extended3 = new ArrayList<>(Arrays.asList());
        List<Integer> actual3 = App.take(list, 0);
        Assertions.assertEquals(extended3, actual3);

        List<Integer> extended4 = new ArrayList<>(Arrays.asList());
        List<Integer> actual4 = App.take(list, -1);
        Assertions.assertEquals(extended4, actual4);
    }
}
