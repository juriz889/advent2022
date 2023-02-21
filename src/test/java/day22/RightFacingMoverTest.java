package day22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RightFacingMoverTest {
    @Test
    void moveRight_rightMoved() {
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
        RightFacingMover rightFacingMover = new RightFacingMover(gameMap);
        Point move = rightFacingMover.move(new Point(9, 0), 10);
        assertThat(move).isEqualTo(new Point(10, 0));
    }

    @Test
    void moveRightMoreThanSpace_reappearOnOtherSide() {
        GameMap gameMap = new GameMap("""
                        ....
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
        RightFacingMover rightFacingMover = new RightFacingMover(gameMap);
        Point move = rightFacingMover.move(new Point(9, 0), 5);
        assertThat(move).isEqualTo(new Point(10, 0));
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
        RightFacingMover rightFacingMover = new RightFacingMover(gameMap);
        Point move = rightFacingMover.move(new Point(9, 0), 10);
        assertThat(move).isEqualTo(new Point(10, 0));
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
        RightFacingMover rightFacingMover = new RightFacingMover(gameMap);
        Point move = rightFacingMover.move(new Point(9, 0), 10);
        assertThat(move).isEqualTo(new Point(11, 0));
    }
}