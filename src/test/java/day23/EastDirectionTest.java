package day23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EastDirectionTest {
    private GameMap gameMap;
    private EastDirection cut;

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
        this.cut = new EastDirection();
    }

    @Test
    void mapHasSpace_canMove_true() {
        assertThat(cut.canMove(new Point(1, 1), gameMap)).isTrue();
    }

    @Test
    void mapHasNoSpace_canMove_false() {
        assertThat(cut.canMove(new Point(12, 0), gameMap)).isFalse();
    }

    @Test
    void hasElfToRight_canMove_false() {
        assertThat(cut.canMove(new Point(6, 0), gameMap)).isFalse();
    }

    @Test
    void hasElfToRightDown_canMove_false() {
        assertThat(cut.canMove(new Point(8, 0), gameMap)).isFalse();
    }

    @Test
    void hasElfOnlyToRight_canMove_false() {
        assertThat(cut.canMove(new Point(4, 1), gameMap)).isFalse();
    }

}