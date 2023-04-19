package day23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ElfTest {
    private GameMap gameMap;
    private Elf cut;

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
        this.cut = new Elf();
    }

    @Test
    void elfCanMoveToNorth_findNextPortion_positionToNorth() {
        assertThat(cut.findNextPosition(new Point(1, 1), gameMap)).isEqualTo(new Point(1, 0));
    }

    @Test
    void elfCannotMoveToNorth_findNextPortion_positionToSouth() {
        assertThat(cut.findNextPosition(new Point(3, 7), gameMap)).isEqualTo(new Point(3, 8));
    }

    @Test
    void elfCannotMove_findNextPortion_currentPosition() {
        assertThat(cut.findNextPosition(new Point(5, 5), gameMap)).isEqualTo(new Point(5, 5));
    }

    @Test
    void elfCanMoveCompleteCycle_findNextPortion_completeCycle() {
        assertThat(cut.findNextPosition(new Point(1, 8), gameMap)).isEqualTo(new Point(1, 7));
        assertThat(cut.findNextPosition(new Point(1, 7), gameMap)).isEqualTo(new Point(1, 8));
        assertThat(cut.findNextPosition(new Point(1, 8), gameMap)).isEqualTo(new Point(0, 8));
        assertThat(cut.findNextPosition(new Point(0, 8), gameMap)).isEqualTo(new Point(1, 8));
        assertThat(cut.findNextPosition(new Point(1, 8), gameMap)).isEqualTo(new Point(1, 7));
    }

}