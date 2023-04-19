package day23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NorthDirectionTest {

    private GameMap gameMap;

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

    }

    @Test
    void mapHasSpace_canMove_true() {
        NorthDirection cut = new NorthDirection();
        assertThat(cut.canMove(new Point(1, 1), gameMap)).isTrue();
    }

    @Test
    void mapHasNoSpace_canMove_false() {
        NorthDirection cut = new NorthDirection();
        assertThat(cut.canMove(new Point(0, 0), gameMap)).isFalse();
    }

    @Test
    void hasElfToLeftTop_canMove_false() {
        NorthDirection cut = new NorthDirection();
        assertThat(cut.canMove(new Point(8, 1), gameMap)).isFalse();
    }

    @Test
    void hasElfToRightTop_canMove_false() {
        NorthDirection cut = new NorthDirection();
        assertThat(cut.canMove(new Point(6, 1), gameMap)).isFalse();
    }

}