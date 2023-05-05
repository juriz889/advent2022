package day24;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {


    @Test
    void simpleMap_4tick_allBlizzardsMoved() {
        String game = """
                #.######
                #>>.<^<#
                #.<..<<#
                #>v.><>#
                #<^v^^>#
                ######.#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Game cut = new Game(gameMap);
        MapPosition positionAt;
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        positionAt = cut.getPositionAt(new Point(1, 3));
        assertThat(positionAt.getCharacters()).isEqualTo(List.of());
        Set<GameProgress> gameProgresses = cut.getGameProgress();
        assertThat(gameProgresses).contains(new GameProgress(new Point(1, 1), 4));
    }

    @Test
    void simpleMap_5tick_allBlizzardsMoved() {
        String game = """
                #.######
                #>>.<^<#
                #.<..<<#
                #>v.><>#
                #<^v^^>#
                ######.#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Game cut = new Game(gameMap);
        MapPosition positionAt;
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        positionAt = cut.getPositionAt(new Point(1, 3));
        assertThat(positionAt.getCharacters()).isEqualTo(List.of(new DownMoving()));
        Set<GameProgress> gameProgresses = cut.getGameProgress();
        assertThat(gameProgresses).contains(new GameProgress(new Point(1, 2), 5));
    }

    @Test
    void simpleMap_6tick_allBlizzardsMoved() {
        String game = """
                #.######
                #>>.<^<#
                #.<..<<#
                #>v.><>#
                #<^v^^>#
                ######.#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Game cut = new Game(gameMap);
        MapPosition positionAt;
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        positionAt = cut.getPositionAt(new Point(1, 3));
        assertThat(positionAt.getCharacters()).isEqualTo(List.of());
        Set<GameProgress> gameProgresses = cut.getGameProgress();
        assertThat(gameProgresses).contains(new GameProgress(new Point(1, 3), 6));
    }

    @Test
    void simpleMap_7tick_allBlizzardsMoved() {
        String game = """
                #.######
                #>>.<^<#
                #.<..<<#
                #>v.><>#
                #<^v^^>#
                ######.#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Game cut = new Game(gameMap);
        MapPosition positionAt;
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        positionAt = cut.getPositionAt(new Point(1, 3));
        assertThat(positionAt.getCharacters()).isEqualTo(List.of(new RightMoving(), new LeftMoving()));
        Set<GameProgress> gameProgresses = cut.getGameProgress();
        assertThat(gameProgresses).contains(new GameProgress(new Point(2, 3), 7));
    }

    @Test
    void simpleMap_8tick_allBlizzardsMoved() {
        String game = """
                #.######
                #>>.<^<#
                #.<..<<#
                #>v.><>#
                #<^v^^>#
                ######.#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Game cut = new Game(gameMap);
        MapPosition positionAt;
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        positionAt = cut.getPositionAt(new Point(1, 3));
        assertThat(positionAt.getCharacters()).isEqualTo(List.of(new RightMoving()));
        Set<GameProgress> gameProgresses = cut.getGameProgress();
        assertThat(gameProgresses).contains(new GameProgress(new Point(2, 2), 8));
    }

    @Test
    void simpleMap_9tick_allBlizzardsMoved() {
        String game = """
                #.######
                #>>.<^<#
                #.<..<<#
                #>v.><>#
                #<^v^^>#
                ######.#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Game cut = new Game(gameMap);
        MapPosition positionAt;
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        positionAt = cut.getPositionAt(new Point(1, 3));
        assertThat(positionAt.getCharacters()).isEqualTo(List.of(new LeftMoving(), new DownMoving()));
        Set<GameProgress> gameProgresses = cut.getGameProgress();
        assertThat(gameProgresses).contains(new GameProgress(new Point(1, 2), 9));
    }

    @Test
    void simpleMap_12tick_allBlizzardsMoved() {
        String game = """
                #.######
                #>>.<^<#
                #.<..<<#
                #>v.><>#
                #<^v^^>#
                ######.#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Game cut = new Game(gameMap);
        MapPosition positionAt;
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        positionAt = cut.getPositionAt(new Point(1, 3));
        assertThat(positionAt.getCharacters()).isEqualTo(List.of());
        Set<GameProgress> gameProgresses = cut.getGameProgress();
        assertThat(gameProgresses).contains(new GameProgress(new Point(2, 3), 12));
    }

    @Test
    void simpleMap_15tick_allBlizzardsMoved() {
        String game = """
                #.######
                #>>.<^<#
                #.<..<<#
                #>v.><>#
                #<^v^^>#
                ######.#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Game cut = new Game(gameMap);
        MapPosition positionAt;
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        positionAt = cut.getPositionAt(new Point(1, 3));
        assertThat(positionAt.getCharacters()).isEqualTo(List.of(new LeftMoving()));
        Set<GameProgress> gameProgresses = cut.getGameProgress();
        assertThat(gameProgresses).contains(new GameProgress(new Point(3, 5), 15));
    }

    @Test
    void simpleMap_18tick_allBlizzardsMoved() {
        String game = """
                #.######
                #>>.<^<#
                #.<..<<#
                #>v.><>#
                #<^v^^>#
                ######.#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Game cut = new Game(gameMap);
        MapPosition positionAt;
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        cut.tick();
        positionAt = cut.getPositionAt(new Point(1, 3));
        assertThat(positionAt.getCharacters()).isEqualTo(List.of());
        Set<GameProgress> gameProgresses = cut.getGameProgress();
        assertThat(gameProgresses).contains(new GameProgress(new Point(5, 6), 18));
    }

    @Test
    void simpleMap_solve_18() {
        String game = """
                #.######
                #>>.<^<#
                #.<..<<#
                #>v.><>#
                #<^v^^>#
                ######.#
                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Game cut = new Game(gameMap);
        assertThat(cut.solve()).isEqualTo(18);
    }

    @Test
    void puzzle_solve_puzzle() {
        String game = """
                #.########################################################################################################################
                #<<<^<^^>v<<^<^><><v<^<<.v^><<<v>><^v<vv>v<vv>^>>^^^^.>>^vv<^<<>^.vv.<>>v>v^>^<><.vv^v.^<^v>^vv<^vv<<>v<<>><<<v^^>v><<<^>#
                #>^^v><.<>>v.v.^>v^..>^<vv>v^><v^<<>v>>.^v^vv^^>.^><^>>^>vv>>v^>vvvv^v^vv<<^<^>^>^v<v^>><><v^^^<v.^v<>^.>v><vv.^<^^^^<>>>#
                #<<.><>v<>.v^<^^v<^^>.^.>>v.^^^v>^^^.<><.^.<>>^<>.v><^^^>^>^^^^><vv^.v^<<^v>v^^^<<<^<..^vv><.^v<vv^>>vv>v.><v^>>^<v^>>vv>#
                #.><^v.>^v>>vv><^>.>>>>>^.>>.>^v>v^>v^^>v^^..>^.^<^.v<>v<<<^^^.vvv>>.<>^vvv>>.^<^v^>^<^<vv>^>^.<>^<<>v.<<<.^<>^>.<v.vvv^>#
                #>><v<>.v><<^^vvv<<<^>^v^v><^>^<>>v.<.<>^<>vv>vv>^.v><<<^<v^vvv.<<<><^<^<^.^^vv>^v^^v<>>vv^<^.^v^v<v^>^.>.v>v^^<v<^<>^>v>#
                #>>><v<.>>v^<.^vvvv<v<^<<v>>v>vv.^><v^.>>vv><<.<^.^v>^^><>^<^v<vvvvv<<<<^^>..>>>v^^>.vv<>.^^^.<v>v^>>^>^^>v^v^^<.>>^^<.<>#
                #<<v>>v<>^><^v<>^>vvv..v.^.<^.v.vv^.<.v<>v>^<^v^<^>><.<>v^v>^<<^<v^^<v^<v^.<v><<<>^^<><>.v><^^^<<^<v>><vv<^<^.^<<^.^<<v>>#
                #>>>^^>v^>^>>v><<>^<v><>>^>.<v<<>v<>^<>^v.<<^.^^^^>^.v>v><v^>vv^^^.>v^<v^^v<<^.vv^>vvv>^>>v<.^^vv<<v.v..^v.^vvv.<.>^<^v>>#
                #><^vv^>>v.<^<v^^><v^>^><<<v^>v><v^^>><vv^><.>>^vv>><vv<^v^v^>^>>.vvvvvv<>>>.>^<vv^<vv<<<^^v^>.v><^.<<^<>^^>.^v><^^vv.^>>#
                #>..<<v<<>>.<^v<<.>v^<..^<^^v^>.><.<v>>v><<>^>>v<vvv>>v<v>.vvvv<.<<<^<^v>^<v^>>v.^v^<^v..^..<^<><>^<<>^>^<<^^.>^^<v<>v<><#
                #<v^v>v<^^<v>>vv^v<..^>v>>>.>^^<>>>^..>>>^<<^<^<>^<v>>^>>><^v^v^<.^<<<^v^.^^^<v>>><^^<>>><..vv.^.^<<v^v.>>^v^^><>><.v^>v>#
                #.<^^<v>v.<v<^.^v^<.v^vvv^vv^<..v<.>>>v<<>>vv>>^.>^.v>vv>.v^<<v^>>v.<^^<^<<>^^.^^>^>>^<^<<^^vv^^.<.><^.>^^<>v<.^v<>v><v<.#
                #>^.v^^><^<.>^v>v><>>>..>.v>vvv<<vv^.>v>.>v.<^vv.^>^vvv>.>v^v>>.>^^<<>>.^.>>>^>v<>v>v^^<>^<^.^><.vv^^<<.^v>>.>>>.^>^^^^^<#
                #..^>vv><^^.>>^^.<<<v..<<>^.<.<^^.v<<<^<<>><>v>v<^^^.<><^<<>v^^<^v^>^v>v<<^<<v<><<>.><..<^vv^<.><>^^><<.>>^.^v><>v^<^v>^>#
                #><<>v>.>^<<v>>>>>^>v..<vv<^<v>>^<<^v<v<<<<.v^>v.v<^>>>v.^><^><>.<>.^v><><<v>^^^^.<<.>^>><>.<<.<^<.^>..^>^.^>^v^v.<.^v>><#
                #><><^v.<<<<>>v<<<<^v<<^^<><<.>^^.^.^.<>vv<<<v>^<><^^<^>^>^^.v<^>>vv^v.>^.<<><vv>>.>.<><^<.<<>.v>.^>>>^<<>.<v>^^v^v^<>.<<#
                #<^>^v^>v^v.<^^>.^>^<<>.<.<<vvv>v>v^v^vvv>v^v^v<^^^<^>>v.^v.^>v><.^^^<>^>^^vv.v>>>^v<<>>^<^.v^>>>><v>v><^<.^v^v^^.<<>><^<#
                #>^>v.><v<^<><>><v<^^<^><<<<^v>^<v^>v<<>^>>.><v<v<^^>^<><><^<.<.<><v^^.^>>v^v^.>><vvvv^v^vv><<^<<^>.v>>>vv>v^v^^<v^^>^>><#
                #<<v^^>vv^^v.<<v<v<^><^v.>.<^v^>^^>^<^^v>>v<^^vv<>^v^.^v<>.<^^>^^v><>^^v.><.v^^>.<<.v^<v<^<>^<^><v^>.>^v>v<v<.>v<.<v.>.<<#
                #>^<<v^vv..vv^v><>>>^>v.>v^..^>^vv>^^>v^v<>.><v<<<<^><>v^.v^>.>^vv>vv>.>^<<.v<^^v^<<>^^^>^.<.v>^><.<^<^>>><.<<^^^>^<^<v<>#
                #<^><v<v><<<>v>>vv.>^<v>><>v>^.v^<v><<^<>>^<^^.<v<<vv>^v.v.<vv<^<<^>v>v.<<<v^><^^>.>>v>.<^vv.^v>^^^<><<^<>>><v^v>>>v<^>v>#
                #>>>^.v><<<>^v<.<.^><v>><>.<.<>v^v>>>^<^^vvv.vv<v<^^^>><^v>>>v>v<>v<v<vv^.^>v<>^>>>^<<v<vv^>><.v<^v<v^<.<>v>^>^><.>v<>.><#
                #<^<v>v.vv>vv^v<.>>.v.^..>^v<.v><>^<.^^<v><^.v^<v^vv^^v^<>>^<^><v.vvv^>.^v>><<>><<<>.<v^<^.<vv^.v<><v^v^>^v^>v<<v^>vv>^v>#
                #<><.v.^v>>><^.<.^<<v>^^><<^>>.^^.v>vv^^.v>^<<^^<<<^>>^>^>v..^v><>v<vv<<v^v<>>><v>^v<><.>v>v>v^^.^>>vv^v.vv<>v^<><^^><vv<#
                #<<v<v>^><^v^<^<v>><.v<.>^vv^>^<v^v>v<.vvv<v<^^>^^^^v^<<v^>v<v^vv>.^vv>v^.>>.^<.>>v<..^v.>^<<v<vvv^<..^<<>^^>v<<><^^><>>>#
                ########################################################################################################################.#
                                """;
        GameMapParser gameMapParser = new GameMapParser();
        GameMap gameMap = gameMapParser.parse(game);
        Game cut = new Game(gameMap);
        assertThat(cut.solve()).isEqualTo(277);
    }
}