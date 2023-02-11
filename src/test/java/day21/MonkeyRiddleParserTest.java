package day21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class MonkeyRiddleParserTest {
    @Test
    void input_parse_parseResult() {
        String input = """
                root: pppw + sjmn
                dbpl: 5
                cczh: sllz + lgvd
                zczc: 2
                ptdq: humn - dvpt
                dvpt: 3
                lfqf: 4
                humn: 5
                ljgn: 2
                sjmn: drzm * dbpl
                sllz: 4
                pppw: cczh / lfqf
                lgvd: ljgn * ptdq
                drzm: hmdt - zczc
                hmdt: 32""";
        MonkeyRiddleParser cut = new MonkeyRiddleParser();
        MonkeyRiddle parse = cut.parse(input);
        assertThat(parse).isNotNull();
        assertThat(parse.getInstructionFor("root")).isEqualTo("pppw + sjmn");
        assertThat(parse.getInstructionFor("sllz")).isEqualTo("4");
    }
}