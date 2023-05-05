package day24;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RightMovingTest {
    @Test
    void rightIsWall_moveRight_reappear() {
        String game = """
                #....>#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Point point = new Point(0, 5);
        for (Character character : gameMap.getMapPoint(point).getCharacters()) {
            character.move(gameMap, point);
        }
        assertThat(gameMap.getMapPoint(new Point(0, 1)).getCharacters()).isEqualTo(List.of(new RightMoving()));
        assertThat(gameMap.getMapPoint(new Point(0, 5)).getCharacters()).isEqualTo(List.of());
    }

    @Test
    void rightIsSpace_moveRight_moveRight() {
        String game = """
                #.>....#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Point point = new Point(0, 2);
        assertThat(gameMap.getMapPoint(point).getCharacters()).isEqualTo(List.of(new RightMoving()));
        for (Character character : gameMap.getMapPoint(point).getCharacters()) {
            character.move(gameMap, point);
        }
        assertThat(gameMap.getMapPoint(new Point(0, 3)).getCharacters()).isEqualTo(List.of(new RightMoving()));
        assertThat(gameMap.getMapPoint(point).getCharacters()).isEqualTo(List.of());
    }
}