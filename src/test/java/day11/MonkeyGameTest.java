package day11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonkeyGameTest {
    @Test
    void sampleInput_game_result() {
        String input = """
                Monkey 0:
                  Starting items: 79, 98
                  Operation: new = old * 19
                  Test: divisible by 23
                    If true: throw to monkey 2
                    If false: throw to monkey 3

                Monkey 1:
                  Starting items: 54, 65, 75, 74
                  Operation: new = old + 6
                  Test: divisible by 19
                    If true: throw to monkey 2
                    If false: throw to monkey 0

                Monkey 2:
                  Starting items: 79, 60, 97
                  Operation: new = old * old
                  Test: divisible by 13
                    If true: throw to monkey 1
                    If false: throw to monkey 3

                Monkey 3:
                  Starting items: 74
                  Operation: new = old + 3
                  Test: divisible by 17
                    If true: throw to monkey 0
                    If false: throw to monkey 1""";
        MonkeyGame cut = new MonkeyGame();
        long result = cut.simulate20Rounds(input);
        assertThat(result).isEqualTo(10605);
    }

    @Test
    void sampleInputPart2_game_result() {
        String input = """
                Monkey 0:
                  Starting items: 79, 98
                  Operation: new = old * 19
                  Test: divisible by 23
                    If true: throw to monkey 2
                    If false: throw to monkey 3

                Monkey 1:
                  Starting items: 54, 65, 75, 74
                  Operation: new = old + 6
                  Test: divisible by 19
                    If true: throw to monkey 2
                    If false: throw to monkey 0

                Monkey 2:
                  Starting items: 79, 60, 97
                  Operation: new = old * old
                  Test: divisible by 13
                    If true: throw to monkey 1
                    If false: throw to monkey 3

                Monkey 3:
                  Starting items: 74
                  Operation: new = old + 3
                  Test: divisible by 17
                    If true: throw to monkey 0
                    If false: throw to monkey 1""";
        MonkeyGame cut = new MonkeyGame();
        long result = cut.simulate10000Rounds(input);
        assertThat(result).isEqualTo(2713310158L);
    }

    @Test
    void puzzleInput_game_result() {
        String input = """
                Monkey 0:
                  Starting items: 59, 65, 86, 56, 74, 57, 56
                  Operation: new = old * 17
                  Test: divisible by 3
                    If true: throw to monkey 3
                    If false: throw to monkey 6

                Monkey 1:
                  Starting items: 63, 83, 50, 63, 56
                  Operation: new = old + 2
                  Test: divisible by 13
                    If true: throw to monkey 3
                    If false: throw to monkey 0

                Monkey 2:
                  Starting items: 93, 79, 74, 55
                  Operation: new = old + 1
                  Test: divisible by 2
                    If true: throw to monkey 0
                    If false: throw to monkey 1

                Monkey 3:
                  Starting items: 86, 61, 67, 88, 94, 69, 56, 91
                  Operation: new = old + 7
                  Test: divisible by 11
                    If true: throw to monkey 6
                    If false: throw to monkey 7

                Monkey 4:
                  Starting items: 76, 50, 51
                  Operation: new = old * old
                  Test: divisible by 19
                    If true: throw to monkey 2
                    If false: throw to monkey 5

                Monkey 5:
                  Starting items: 77, 76
                  Operation: new = old + 8
                  Test: divisible by 17
                    If true: throw to monkey 2
                    If false: throw to monkey 1

                Monkey 6:
                  Starting items: 74
                  Operation: new = old * 2
                  Test: divisible by 5
                    If true: throw to monkey 4
                    If false: throw to monkey 7

                Monkey 7:
                  Starting items: 86, 85, 52, 86, 91, 95
                  Operation: new = old + 6
                  Test: divisible by 7
                    If true: throw to monkey 4
                    If false: throw to monkey 5""";
        MonkeyGame cut = new MonkeyGame();
        long result = cut.simulate20Rounds(input);
        assertThat(result).isEqualTo(58322);
    }

    @Test
    void puzzleInput_game10000Rounds_result() {
        String input = """
                Monkey 0:
                  Starting items: 59, 65, 86, 56, 74, 57, 56
                  Operation: new = old * 17
                  Test: divisible by 3
                    If true: throw to monkey 3
                    If false: throw to monkey 6

                Monkey 1:
                  Starting items: 63, 83, 50, 63, 56
                  Operation: new = old + 2
                  Test: divisible by 13
                    If true: throw to monkey 3
                    If false: throw to monkey 0

                Monkey 2:
                  Starting items: 93, 79, 74, 55
                  Operation: new = old + 1
                  Test: divisible by 2
                    If true: throw to monkey 0
                    If false: throw to monkey 1

                Monkey 3:
                  Starting items: 86, 61, 67, 88, 94, 69, 56, 91
                  Operation: new = old + 7
                  Test: divisible by 11
                    If true: throw to monkey 6
                    If false: throw to monkey 7

                Monkey 4:
                  Starting items: 76, 50, 51
                  Operation: new = old * old
                  Test: divisible by 19
                    If true: throw to monkey 2
                    If false: throw to monkey 5

                Monkey 5:
                  Starting items: 77, 76
                  Operation: new = old + 8
                  Test: divisible by 17
                    If true: throw to monkey 2
                    If false: throw to monkey 1

                Monkey 6:
                  Starting items: 74
                  Operation: new = old * 2
                  Test: divisible by 5
                    If true: throw to monkey 4
                    If false: throw to monkey 7

                Monkey 7:
                  Starting items: 86, 85, 52, 86, 91, 95
                  Operation: new = old + 6
                  Test: divisible by 7
                    If true: throw to monkey 4
                    If false: throw to monkey 5""";
        MonkeyGame cut = new MonkeyGame();
        long result = cut.simulate10000Rounds(input);
        assertThat(result).isEqualTo(13937702909L);
    }
}