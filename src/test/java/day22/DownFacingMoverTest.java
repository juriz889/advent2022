package day22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DownFacingMoverTest {
    @Test
    void moveDownIsWall_stop() {
        GameMap gameMap = new GameMap("""
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
        DownFacingMover rightFacingMover = new DownFacingMover(gameMap);
        Point move = rightFacingMover.move(new Point(9, 0), 10);
        assertThat(move).isEqualTo(new Point(9, 0));
    }

    @Test
    void moveDownMoreThanSpace_reappearOnOtherSide() {
        GameMap gameMap = new GameMap("""
                ...#.......#
                ........#...
                ..#....#....
                ..........#.
                        ...#....
                        .....#..
                        .#......
                        ......#.""");
        DownFacingMover rightFacingMover = new DownFacingMover(gameMap);
        Point move = rightFacingMover.move(new Point(0, 0), 5);
        assertThat(move).isEqualTo(new Point(0, 1));
    }

    @Test
    void moveRightIsBlank_Stop() {
        GameMap gameMap = new GameMap("""
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
        DownFacingMover rightFacingMover = new DownFacingMover(gameMap);
        Point move = rightFacingMover.move(new Point(9, 0), 10);
        assertThat(move).isEqualTo(new Point(9, 0));
    }

    @Test
    void moveRightIsWouldGoToStartButThereIsWall_Stop() {
        GameMap gameMap = new GameMap("""
                        #...
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
        DownFacingMover rightFacingMover = new DownFacingMover(gameMap);
        Point move = rightFacingMover.move(new Point(10, 0), 10);
        assertThat(move).isEqualTo(new Point(10, 6));
    }
}