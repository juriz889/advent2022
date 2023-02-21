package day22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PathParserTest {

    @Test
    void gameInput_parse_parsedGame() {
        String gameAndInstrcutions = """
                        ...#
                        .#..
                        #...
                        ....
                ...#.......#
                ........#...
                ..#....#....
                ..........#.
                        ...#....
                        .....#..
                        .#......
                        ......#.
                             
                10R5L5R10L4R5L5
                """;
        PathParser cut = new PathParser();
        PathGame game = cut.parsePath(gameAndInstrcutions);
        assertThat(game.getGame()).isEqualTo("""
                        ...#
                        .#..
                        #...
                        ....
                ...#.......#
                ........#...
                ..#....#....
                ..........#.
                        ...#....
                        .....#..
                        .#......
                        ......#.""");
        assertThat(game.getInstructions()).isEqualTo("10R5L5R10L4R5L5");
    }
}
