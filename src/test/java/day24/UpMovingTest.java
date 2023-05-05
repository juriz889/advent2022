package day24;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UpMovingTest {
    @Test
    void upIsWall_moveUp_reappear() {
        String game = """
                #######
                #^...^#
                #.....#
                #######
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Point point = new Point(1, 1);
        for (Character character : gameMap.getMapPoint(point).getCharacters()) {
            character.move(gameMap, point);
        }
        assertThat(gameMap.getMapPoint(new Point(2, 1)).getCharacters()).isEqualTo(List.of(new UpMoving()));
        assertThat(gameMap.getMapPoint(new Point(1, 1)).getCharacters()).isEqualTo(List.of());
    }

    @Test
    void upIsSpace_moveUp_moveUp() {
        String game = """
                #######
                #....^#
                #^....#
                #######
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Point point = new Point(2, 1);
        assertThat(gameMap.getMapPoint(point).getCharacters()).isEqualTo(List.of(new UpMoving()));
        for (Character character : gameMap.getMapPoint(point).getCharacters()) {
            character.move(gameMap, point);
        }
        assertThat(gameMap.getMapPoint(new Point(1, 1)).getCharacters()).isEqualTo(List.of(new UpMoving()));
        assertThat(gameMap.getMapPoint(point).getCharacters()).isEqualTo(List.of());
    }
}