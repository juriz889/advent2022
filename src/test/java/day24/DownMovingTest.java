package day24;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DownMovingTest {
    @Test
    void downIsWall_moveDown_reappear() {
        String game = """
                #######
                #....^#
                #v....#
                #######
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Point point = new Point(2, 1);
        assertThat(gameMap.getMapPoint(point).getCharacters()).isEqualTo(List.of(new DownMoving()));
        for (Character character : gameMap.getMapPoint(point).getCharacters()) {
            character.move(gameMap, point);
        }
        assertThat(gameMap.getMapPoint(new Point(1, 1)).getCharacters()).isEqualTo(List.of(new DownMoving()));
        assertThat(gameMap.getMapPoint(point).getCharacters()).isEqualTo(List.of());
    }

    @Test
    void upIsSpace_moveUp_moveUp() {
        String game = """
                #######
                #v...^#
                #.....#
                #######
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Point point = new Point(1, 1);
        assertThat(gameMap.getMapPoint(point).getCharacters()).isEqualTo(List.of(new DownMoving()));
        for (Character character : gameMap.getMapPoint(point).getCharacters()) {
            character.move(gameMap, point);
        }
        assertThat(gameMap.getMapPoint(new Point(2, 1)).getCharacters()).isEqualTo(List.of(new DownMoving()));
        assertThat(gameMap.getMapPoint(point).getCharacters()).isEqualTo(List.of());
    }
}