package day23;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MapParserTest {
    @Test
    void mapIsString_parse_parsedMap() {
        String mapString = """
                ..............
                ..............
                .......#......
                .....###.#....
                ...#...#.#....
                ....#...##....
                ...#.###......
                ...##.#.##....
                ....#..#......
                ..............
                ..............
                ..............
                                """;
        GameMapParser cut = new GameMapParser();
        GameMap gameMap = cut.parse(mapString);
        assertThat(gameMap).isNotNull();
        assertThat(gameMap.getPosition(new Point(0, 0))).isEqualTo(Space.INSTANCE);
        assertThat(gameMap.getPosition(new Point(7, 2))).isInstanceOf(Elf.class);
    }
}