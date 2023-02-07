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
    void initList () {
        this.list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    }
    @Test
    void take_test1() {
        List<Integer> extended = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> actual = App.take(list, 2);
        Assertions.assertEquals(extended, actual);
    }
    @Test
    void take_test2() {
        List<Integer> extended = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> actual = App.take(list, 5);
        Assertions.assertEquals(extended, actual);
    }
    @Test
    void take_test3() {
        List<Integer> extended = new ArrayList<>(Arrays.asList());
        List<Integer> actual = App.take(list, 0);
        Assertions.assertEquals(extended, actual);
    }
    @Test
    void take_test4() {
        List<Integer> extended = new ArrayList<>(Arrays.asList());
        List<Integer> actual = App.take(list, -1);
        Assertions.assertEquals(extended, actual);
    }
}
