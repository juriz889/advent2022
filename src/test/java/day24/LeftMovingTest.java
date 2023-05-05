package day24;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LeftMovingTest {
    @Test
    void leftIsWall_moveLeft_reappear() {
        String game = """
                #<.....#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Point point = new Point(0, 1);
        for (Character character : gameMap.getMapPoint(point).getCharacters()) {
            character.move(gameMap, point);
        }
        assertThat(gameMap.getMapPoint(new Point(0, 6)).getCharacters()).isEqualTo(List.of(new LeftMoving()));
        assertThat(gameMap.getMapPoint(new Point(0, 1)).getCharacters()).isEqualTo(List.of());
    }

    @Test
    void leftIsSpace_moveLeft_moveLeft() {
        String game = """
                #.<....#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Point point = new Point(0, 2);
        for (Character character : gameMap.getMapPoint(point).getCharacters()) {
            character.move(gameMap, point);
        }
        assertThat(gameMap.getMapPoint(new Point(0, 1)).getCharacters()).isEqualTo(List.of(new LeftMoving()));
        assertThat(gameMap.getMapPoint(point).getCharacters()).isEqualTo(List.of());
    }
}