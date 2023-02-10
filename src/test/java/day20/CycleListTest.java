package day20;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CycleListTest {
    @Test
    void inputList_firstMove_movedList() {
        String input = "1, 2, -3, 3, -2, 0, 4";
        CycleList cut = new CycleList(input);
        List<Integer> result = cut.move("1");
        assertThat(result).isEqualTo(List.of(2, 1, -3, 3, -2, 0, 4));
    }

    @Test
    void inputList_moveBy6_movedList() {
        String input = "1, 2, -3, 3, -2, 0, 4";
        CycleList cut = new CycleList(input);
        List<Integer> result = cut.move("6");
        assertThat(result).isEqualTo(List.of(1, 2, -3, 3, -2, 0, 4));
    }

    @Test
    void inputList_moveBy12_movedList() {
        String input = "1, 2, -3, 3, -2, 0, 4";
        CycleList cut = new CycleList(input);
        List<Integer> result = cut.move("12");
        assertThat(result).isEqualTo(List.of(1, 2, -3, 3, -2, 0, 4));
    }

    @Test
    void inputList_firstTwoMoves_movedList() {
        String input = "1, 2, -3, 3, -2, 0, 4";
        CycleList cut = new CycleList(input);
        List<Integer> result = cut.move("""
                1
                2""");
        assertThat(result).isEqualTo(List.of(1, -3, 2, 3, -2, 0, 4));
    }

    @Test
    void inputList_firstThreeMoves_movedList() {
        String input = "1, 2, -3, 3, -2, 0, 4";
        CycleList cut = new CycleList(input);
        List<Integer> result = cut.move("""
                1
                2
                -3""");
        assertThat(result).isEqualTo(List.of(1, 2, 3, -2, -3, 0, 4));
    }

    @Test
    void fourNumbers_allMoves_movedList() {
        String input = "1, 2, -3, 3, -2, 0, 4";
        CycleList cut = new CycleList(input);
        List<Integer> result = cut.move("""
                1
                2
                -3
                3""");
        assertThat(result).isEqualTo(List.of(1, 2, -2, -3, 0, 3, 4));
    }

    @Test
    void fiveNumbers_allMoves_movedList() {
        String input = "1, 2, -3, 3, -2, 0, 4";
        CycleList cut = new CycleList(input);
        List<Integer> result = cut.move("""
                1
                2
                -3
                3
                -2""");
        assertThat(result).isEqualTo(List.of(1, 2, -3, 0, 3, 4, -2));
    }

    @Test
    void sixNumbers_allMoves_movedList() {
        String input = "1, 2, -3, 3, -2, 0, 4";
        CycleList cut = new CycleList(input);
        List<Integer> result = cut.move("""
                1
                2
                -3
                3
                -2
                0""");
        assertThat(result).isEqualTo(List.of(1, 2, -3, 0, 3, 4, -2));
    }

    @Test
    void completeExample_allMoves_movedList() {
        String input = "1, 2, -3, 3, -2, 0, 4";
        CycleList cut = new CycleList(input);
        List<Integer> result = cut.move("""
                1
                2
                -3
                3
                -2
                0
                4""");
        assertThat(result).isEqualTo(List.of(1, 2, -3, 4, 0, 3, -2));
    }

    @Test
    void completeExample_allMoves_numberAt1000_2000_3000() {
        String input = "1, 2, -3, 3, -2, 0, 4";
        CycleList cut = new CycleList(input);
        cut.move("""
                1
                2
                -3
                3
                -2
                0
                4""");
        assertThat(cut.getNumberAtAfterZero(1000)).isEqualTo(4);
        assertThat(cut.getNumberAtAfterZero(2000)).isEqualTo(-3);
        assertThat(cut.getNumberAtAfterZero(3000)).isEqualTo(2);
    }
}