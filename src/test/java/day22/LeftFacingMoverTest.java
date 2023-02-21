package day22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeftFacingMoverTest {
    @Test
    void moveLeft_leftMoved() {
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
        LeftFacingMover cut = new LeftFacingMover(gameMap);
        Point move = cut.move(new Point(11, 0), 2);
        assertThat(move).isEqualTo(new Point(9, 0));
    }

    @Test
    void moveLeftMoreThanSpace_reappearOnOtherSide() {
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
        LeftFacingMover cut = new LeftFacingMover(gameMap);
        Point move = cut.move(new Point(11, 0), 5);
        assertThat(move).isEqualTo(new Point(10, 0));
    }

    @Test
    void moveLeftIsWall_Stop() {
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
        LeftFacingMover cut = new LeftFacingMover(gameMap);
        Point move = cut.move(new Point(11, 0), 10);
        assertThat(move).isEqualTo(new Point(9, 0));
    }

    @Test
    void moveLeftToOtherSideButThereIsAWall_Stop() {
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
        LeftFacingMover cut = new LeftFacingMover(gameMap);
        Point move = cut.move(new Point(10, 0), 4);
        assertThat(move).isEqualTo(new Point(8, 0));
    }
}