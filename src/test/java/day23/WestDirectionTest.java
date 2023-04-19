package day23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WestDirectionTest {
    private GameMap gameMap;
    private WestDirection cut;

    @BeforeEach
    void setUp() {
        String mapString = """
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
        GameMapParser gameMapParser = new GameMapParser();
        this.gameMap = gameMapParser.parse(mapString);
        this.cut = new WestDirection();
    }

    @Test
    void mapHasSpace_canMove_true() {
        assertThat(cut.canMove(new Point(1, 1), gameMap)).isTrue();
    }

    @Test
    void mapHasNoSpace_canMove_false() {
        assertThat(cut.canMove(new Point(0, 0), gameMap)).isFalse();
    }

    @Test
    void hasElfToWest_canMove_false() {
        assertThat(cut.canMove(new Point(8, 0), gameMap)).isFalse();
    }

    @Test
    void hasElfToRightDown_canMove_false() {
        assertThat(cut.canMove(new Point(10, 0), gameMap)).isFalse();
    }
}