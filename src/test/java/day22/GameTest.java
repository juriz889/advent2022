package day22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class GameTest {
    @Test
    void gameInitilized_getChartAt_correctChar() {
        Instructor instructor = new Instructor("10R5L5R10L4R5L5");
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
        Game game = new Game(instructor, gameMap);
        assertThat(game.run()).isEqualTo(6032);

    }

    @Test
    void game() {
        GameMap gameMap = new GameMap("""
                                                                  .................#..#........#...............#.#...#..........................#.................#...
                                                                  ............#......#....#.#..#........#...#....................#...#................................
                                                                  ..#.#....#................##...#..#.....#..#.......#.......#....#...............#.......#...........
                                                                  .....#.......#............#....................#..##.#...........#......#.........#.................
                                                                  ........##.........#........#..#.#.............#.....#...........#..............................#..#
                                                                  #..............#.....................#...............................................#...#...#......
                                                                  ..............................#.#....#...#.........#...#....................#...............#.......
                                                                  ........................#..#...#..............#.............#.............#...........#........#....
                                                                  ....#........................................#....#...........................#.................#...
                                                                  ................#.............#..........#...............................#......#....##..#..#..#....
                                                                  ........#..#..........#.......................#...#.........#.....#.#.#..#...............#.......##.
                                                                  ..#...#.......................#........#...#..#.....#.....###......#.......................#..#.#...
                                                                  .............#.......................#...............#..............#.#............#...............#
                                                                  .....#.................................#.........#.........#...................#......#.............
                                                                  ...#........##........###.............#..................#.................#.....#..................
                                                                  .......................#...#...#....#...........................#.........#..#.........#............
                                                                  ...............#.#............#...............#.......#...................#.....#......#............
                                                                  ..........##......#..............#.#.....#....#..........#..............##...............#..........
                                                                  ..............#...#....##...#................................#........#.#.....#.......#.............
                                                                  .#.................#..........#..........#....#......#..............#.#.#..............#....#.#.....
                                                                  ...#................#.#.#........###...#......#............#.............................#......#...
                                                                  ...............#..#.....#..........................#........................#.#.........#...........
                                                                  ......#.....#......#......#..#............#...#...................#..........#......#...............
                                                                  ....#...........#....................#............#................#................#..#.........#..
                                                                  #..........................#......#.....#..........#..........#........................#............
                                                                  #..............#...........#.#..........#....#..............#.#......#.......##.........#.........#.
                                                                  ............#.........#.............#.#.#..........................................#........#......#
                                                                  ........................................#....................#.........#......#..#......#.........#.
                                                                  ......##..#...##..#..............#.............#.#..#........#..........#.......#.#.................
                                                                  .......##...#..#..##..#...#........#........#.........#..#.#.......#.#.........##...#.......#.......
                                                                  ...................#.#..................#....#.#....#......................#.#.....#.....###....#...
                                                                  ........#..##................................#.#.#...............#....................##............
                                                                  .................................#......#####.....#.....#..........#..................#..........#..
                                                                  ............#....#......#.........#...#....#.....#......#...................#......#..#....#........
                                                                  ...#.#.................#..#.....#.........................#........#..................#....#........
                                                                  ............##.....#..#..#...................#...#.#....................................#...........
                                                                  ......#...#...............................................#..........#.........#.............#.....#
                                                                  ............#..........#....##...................#.#.......##...........................#.#.........
                                                                  #...##..#.....#....#.#.#......#.............#.................#...........#..............#.#........
                                                                  ..#...#..........#...................#...............................................#..#.......#...
                                                                  ...........#................#.........#...##.....#................#..#........................#.#...
                                                                  ..#...........#......................#...#...............#......#..............#...........#........
                                                                  .....#.....#.#.........#...#.........................#.#...........#.#.............#........#......#
                                                                  .....#.#...........#.#.#.....##.......................#........................#........#.....#...#.
                                                                  ..........#.#....#..........................##...............#..................#.......##......#...
                                                                  ....#..#.#......#....#..............#...#.......................#.......#.............#.............
                                                                  ..#.....#..............#............................###........#...........#....#....#.#...........#
                                                                  .....#...........#....#...........#.#....#..#....#.#.....................#....#..............#......
                                                                  ..............#...............#....................#.#..#..................#.#.....#.........#.#....
                                                                  .......................##...#.#.#..............#.....#..........#.............#.....#.........#.....
                                                                  ..#......................................##.......
                                                                  .......#...........#..........#......#............
                                                                  ......#....#.#..............................#.....
                                                                  ....#.............#..........#....#.....#.........
                                                                  ........................#.....#................#..
                                                                  ........................#.........................
                                                                  ..............#...#....#....#.....#...........#...
                                                                  .............#........#....#........#..#..........
                                                                  .......................................##.........
                                                                  ........#.#..#........................#...........
                                                                  .....................#.......#....................
                                                                  ...........#......................................
                                                                  ........................#.#.#.....................
                                                                  #...#...............................#.........#...
                                                                  .#..##.........#..........#..#..#.................
                                                                  ...#....#...#......#...............##.............
                                                                  ..#........#.......#...#...........#.....#........
                                                                  .##...........................#...#...............
                                                                  .........##......##.........#.........#.....#..#..
                                                                  .#...............................#..##............
                                                                  ...................#..............##....##........
                                                                  .........#.....#...........#...#......#......#.#..
                                                                  .......#............##....#..#.....#......#.......
                                                                  ..........#.#....#...................#....#.......
                                                                  ..........##.....................................#
                                                                  ..##.......................#......#.....#...#....#
                                                                  ..#........#..................#...................
                                                                  ......................................#.........#.
                                                                  .#...#...........#.#.....#.......#............#..#
                                                                  .......#..............#.#....................#....
                                                                  ...........................................#...#..
                                                                  .#...#..#.........#.......#.#.#..........##.......
                                                                  ##...........#.....#.....##..........#..........#.
                                                                  ......#.........#........#......#..........#......
                                                                  .##........#........#........#........#..#........
                                                                  .#....#.#.................##.#...#................
                                                                  .....#.........#......#..........#.......#....#...
                                                                  ................#.......##...........##..#...#..#.
                                                                  .................#......................#.#.#..###
                                                                  .....................#......#...............#.....
                                                                  ...#..#............#.#...........#...#............
                                                                  .................................................#
                                                                  .#....#.#.......#.........#............##.........
                                                                  .......#.................................#......#.
                                                                  ......#...........#...................#.#.........
                                                                  ..#..............##...#.......#....#..............
                                                                  ....#.....#......#......##............#...........
                                                                  ....................#.....#............#.#........
                                                                  ..#...#......#.........#......#.....##......#..#..
                                                                  ......#........#........#......#.............#..#.
                ....#.#...#...............#..#...#........#.............#....#.##...#...............#..###.#....#...
                ...............................#.........#............#.#.....................#.....#...........#...
                .#............#..................#...#......#.......#......#................#....#..................
                .......................#.............#...#..#..#.......#...#.#.............#...#.....#..............
                ....#....#.........#...........................#.........#..................#...........#.......#...
                .........#......#................#...#...............##...##............#....#....#..#..#..#..#.....
                ........#...##.............#...........#..........#.....#..#..........#......#...........#.......#..
                ...#......#.....#...........#.#..........#...#..#...#..#..#........#.#..............#.....#...#.....
                ....................#................#....#.#..........................................#.......#....
                .#........................#.................#.................#.....................................
                ..............................#........................#.#...#.........................#.#..........
                ...........................#..................................#.....#..#..........#.#.#.............
                ....##..............#...........##...#...#............#..........................#.....#......#....#
                ..#.........#..#..........................#........................#...##.....#..#...........#......
                #............#..#.##.............................#............................#.................#...
                ..........#.........................................................#..........................#....
                #...#...#.............#..#.................................#..............#.##.....#.........#......
                .........#.......#.#.#..#..............#.........#..#.......#................#............#.........
                #.............#....#.....#.........#........#...........................#...........................
                ...........#...............#.....#.........................................#..................#.....
                ........#...........#..#...#.#.....#.#..........#......##..........#........#..........#...#........
                ...........#..........................##.......................#.#..............#...................
                ............#.................#........................................#...................#........
                .................#...............#......#................#........#..#.....#........#...............
                ............#........#...#.#...................#........#.....#...................#.....#.........#.
                #..............#.................#.#..........##..........#..........#....#.......#..##..#.#.#..#...
                ..............#.....................................................................................
                .........#..............#...#...........#.#..........#...................#.##.......................
                ....##...#..#...#.............#..#..#.#..#........#.#.#.....#.#..#.#........#...#...................
                ......#.#.....#.....#.............##...#.................#.......#.#.................#..............
                ........##...............#.....................#.##...#..........#...##...#.........#....##......#..
                .#.#..#.#..................#.................................#......#..............#...#......#.....
                ............#.#..............................#..###.....#.............#......#.##............#......
                #..........#.#................##.......#......#...........................................#..#......
                ........................#.#................#..#.............#.....................................#.
                ................................................##....#.............#...#.........#.................
                ...#..#......#.#...#.#.....#....#............#......#.............#..................#..........#...
                ...#...#..#..........................#...............#.#.................#.#...#..##................
                .#...................................#.........#........#..#..#...........#.........................
                .#..#.....##...........#..#..#............#...#....................#.........#.......#......#.......
                .......#.........................##................................#..#...........#.................
                ..#....#....#.........#.#............#...#.#......#...#............#....#....#......................
                ..#.....##.......................#.........#.......#..#..........#..........#......#.....##..#...#..
                ........#..#.#......#..#.....................#..#..........#........#....#.............#...##.......
                ...#.#...............#...............#...#.............#.....#...........................#.......##.
                ..............#.#....#.............#..................##..#................#........#...#...##......
                ...................#.#.#.....#.#.......#..#.#....#.....###....#.#....#.#.............#..............
                ..........#.#...##...#......................................##.................#.......###.....#....
                ....#...#..............#.......#......................#.......#...........#...................#.....
                ........................#........#........#...................................#.#...................
                ...#....#....#..##...........................#....
                ...........#..............#..........#.#.......#..
                ..#.....##..#......#..........##..................
                ...................#........#..............#......
                ..#.........#.................#...#..#.......#..##
                ....#......#.........##................#..........
                ......#.#.......#.......................#....#.#.#
                ....#.#...........#..##..##..............#....#...
                .#..........#.....##..................#......#....
                ...................#.#.......##..#....#...........
                ...#......#................#...........#.....#....
                ....................##............................
                .#..#..#....#.............#...#..#.......#........
                .......#....#...#...#..##......#....#.............
                .##....#......#....................#.#..#..#.#....
                ...#......#.......................................
                .......#........#............#..........#..#......
                ...............#..#............#......#...........
                #.................#.....##................#..#...#
                ...............#.#......##...............#.....#..
                .#............................#.........#.........
                ................#....#.....#.........#...#........
                ......................#............#....#.........
                ...#.....##........#.......#......#...............
                #......#................#.......#.........#.....#.
                ...........................#.#...........##.......
                .........#..........#......#......................
                ....#........#..#.......#.#..#.....#..#..#...#....
                #...................#.............#.......##......
                ............#.........#........##....#.##..#......
                ................#.................#.#.............
                .....#.........#....#.....#..........#..........#.
                ..#.....#...............................#.#.......
                #.#.....#.................#..##..#.......#........
                .........#......................................#.
                ..........#................#.......#..............
                .........#.........#.......##..........#..........
                .........#...........#......................#.....
                ...#...#.........##.................#.........#...
                ............#......#.#...#.........#..#...........
                ...#................#.....#.......#............#..
                .....................................#........#...
                ..............#......................#.....#.....#
                ...#................#...#..........#......#.......
                ..#....................#..........#......#........
                ..#......#...........#.#.................#..#....#
                #...........#......#..................#...........
                .#.....#............#..####.....#.................
                .#......#...........................#.....##......
                ...#........#....###..............................""");
        Instructor instructor = new Instructor("""
                26L35R27L35R1L10L16L16L22L41R32R16L32L27R41R19R39R14L40R47R49R12R47R32L41R20R8R39R38L9L34R18L32R11L1L4R27R10L3R4R42L12L32L40R39L5R45L5L19L34L6L39R13R4L34R42R15R41R31R5L44L7L20R5L49R28R12R6L17L25L24L47L14L32R26L48L37R49L6R23R45L23R49L47L32R4L23R5R23L20L31L18R12R2R34L44R10R48R2L39L1R9R31L48L38R21L37R27L24R11R49R17L43L23R18R15L15R26R34L20L47R11L30R31R42R24R16L50L27R27R30R9L29R9R35R4R19R28R46R44L27L18R33L40L40L41R47R47R6L18L2R9R43L24R43L3R9R16R14L11R19R17L31R41R26R41L49L18R29L44L33R9L31L2L28R34R8L20L20R33L33L44L36R42L6R49L18R26L1L27L16R13L11R44L43R5R41R45L5L35R31L24L28L5L12R7L4R1L17L9R46R24L27L40R34R19L50L27L39R12R12R20L48R27R43L30L37L10L32R35R25R23L15L21R19R34R44L43R31L7R45R7R5R35R2R33L12L19L4R48R5R41R46R37L30L12L41L47R13R2L41L29R6L35L49R36L29R20R8R18L44R29L10R10R50R49R43R12R50L10L14R1R1R22R42L33L43L22R48L21L15L31R47R25R21R22R39R27L4L27R18R19L20L33L5R27L18R39L13R24R40R19R17R45R47R19R1R18R20L40L24L2R47R28L25L4L26L11L4R36L16R38R12L19R19L1R8L6L13L50R18L23L10L19L11L35L2R33R34R14L34R7R1L44L11R40L20R37R41R44R14R16R18R48L50R30L30L23L38R22L48L49R35R39R2L27L10R16L37L6L18L20L8R31L8L6R2L39R29L5L25L39L38L41L28L22R30L35L41R12L40R30L40R27L7R50R9R12L42R25L10R28L15R50R38L41L1R5R18L32L2L35R35L46L4L6R8L10R12L24R12R13L19R25L36R25L45L30L39R15L17L10L16L14L3L17L22R22R13R34L33R37L1R43L31R35R26R6L21R24R6L38R17R42R48R24L34L14R40R44R23L41R12R10L38L40L26R47L8R45R7L2L31L29L21R50L50L30L42L19R41R39R24L40L42R27L27L47L26R43L2R19R2L50L11L42L19R40R43L42L50R21L3R22L1L32R28L46L46R16L7R7L25L41R43R32R2R16L15L27R2R46R40L19L14R18L10L14R43R17R4R16L31R15R9R20L49L44R6R29R32L5L13R22R6L45L31L46L17R45L17R16L13L12L26R37L3R13L36R31R28R23R29R32L43L17L17R7R18R5R15L50L46L15R7L35L39R30L35R44L1R21L39R16L4L20R4R46R33L23R30L34R32L35R5R15R32R36L11L11L24L44L17R19R24R6R30R15L15R28R30R28L12R16R50L15L48R35R24R14L17R9R33R36L24R13R40L13L12L45L41R20R2R25L10R32L33L42L17L32R38R28L38R17R18L20R13R42R7L13L30L34R15L16L50R28R12L9L34L36L25L47R4L41R14L16R23R4L22L1R7L18R7R47R47L30R25L18R20L25L38L25R15L14L32R37L13R49R39L36L11L41R34L1L39L20L26R12L30L9L34L5L20R34R22L8R3L42R12L14L49L23R33L39L39L27R39R7L12R8R38L12L16R45R12R7R41L24R35R28L21R49R26L11R40R14R44R33R12L41R35R29L27L10R48R18R7L30L3L46R39R34L5R4L17R40R3L7L25L36R23R49R38R17R8L16R18L5R20R49L48R3L43R7R7L30R14L23L9R39R25R18R42R24L22R38L29R22R40R2R17R14R12L45L21L36L39L21R31L34L19L4R37L34R49L34R9L8L1R40L26R19R1L6R47L13R9R29L44R41L29L22R44R6R37L48R21L5R41L11R7R28R37L48L36R13R27L20L19R28L43L7R44R41R35L44L32L4L26R12L26R48L46L18R45R41L31L43R19R5L20L45R13R1R3L26L42R9L7R43R11R20L34R16R38L42L18L17R26L7R43L43R18R22R42R9R45L15L21R16L14R25L2R11L4R48R10R33R50R3R40R7R16L12L24L16R7R6L25R20R12L46R20L10R12R45R15R49L32R4L39R23L21L42L35R39R32L12L48L31L33R28L29L7L19L47R43R38L32L4R15L28R45R25R4L6R32R47L42R48L9L33L42R15R29L19L45L36L25R3R8R29L24L14R12L16L6L2L24L24R41L44R50R35L32L7L32R17L24R15L25R13R2L7L48R25R25R15L13L18R18L34L40L27L25L5L21R26L33R32L42R28R39R40L25R47L27L4R50R22R21R5R1R49R28R8L31L26L30L7R7L21L9R21R33L20L14R31L37L5R50L23R24L18L50R39R10R45L33L37L46R48L5R29R7R17R31L50R34L41L44L20L38L15R14L40R48R16L23L46L26R18R43R50L8L2L16L9L5L6L26R45L44R3L42R47R16R17L26L1L36R20L9L29L12R29R47L4R22R16R27R27L19L5L37R5R24R9L21L44L6L38L29R23L9L5L28R19R36L19L13L15R41R31R32L13R11L50R2R47L27L5L44R37L22L31R9L40R35L34L15L29L37R27R8R6L15L34R44R28R9R17R41L27R22R12L16L32L23R16R7R21R48L13R49L50R24L37L15L13L40L49L7L17L40L47R27L28R29R45R27R10R41L42L47L9L32R35R13L5L44L42L31L8L20R23L49R35R28R10R32L4L38R20L17L19R31R33R19L37L2R37R2R45R28R37R49L43R24L33L31R12R40L43L12L43R24R11R21L11L36R19R10R40R9R43L46R7L16L16R11R26R27R45L24R17R5L43R6R1R38R39L7R47R16R24R41L48L8L32L14R4R3R5L35L37R1L41L3L33R23L16R21R23R9L33L38R26R1L2L39L41R46R40L43L46R6L40R14L33R2L27R12R26R2R40R10R47R38L17L45L50L42R10R12R46L41R12R50R27L12L19R15R12R12R38R4L19R21R4L42R4L13L42L10R7R49R42R40R23L30R30L34R7R30R47R11R20L6R8R2L18R34L37L43L29L16L31R28L42R8L23R25R38L23R6R1L50R40L14L39R48L7L26R50R1R31R36R39R7R24R2R26R46R5L28R32L1L33L1R45R22R25L34L39R17R50L27R29L42R9R31R41R20L5L34R25L41L2L42L3L46L30L27R44R27L17L36L12R29L36L12L21R16L26L7L38R26L25L41L50R24R35R2R30L5R21R24R27L28L6R48L4R10R48L30L40R29L33L49L19R9L1L32L45L15L11L18R10R16R27R36L9L34L24R36R31L50L30R27L23L42R18R26L1L20R38L46L43L9L22R18L40L9L32L4L48R41L35L18L7L24R37R29R29R5R45L23L9R10R10L22R37L48L44L20R46L25R4R35R20L26L3L48L21R44R43L39R21R5L34L33R30L10R46R10L12R24L31R32L35L38L36R27R34R10L47R46R26L48R8R29R35R5L4L47L42L28L8L14L50L30L9L9L26L8R34R45R50R12L48R16R14R31R32R9L11L18R38L3L14R33R5L46L15L19L33L42L44R23L16R43R17R35R24L37R1L29R7L45R3R6R16L27L25L2L34R7L49L30R38R39L45L17R37R11R36L34L8L47R31L19R47R47L7R29L20R23L47R43R42R46R35L11R50R6L25R47R24L11L30R23L38L44L38R9L37R45L17R10R5R11L27L8R4L48L32L23L35L36R25R9L8R3R19R15L13L20L9R41L13L11L19R10L33L41R45R30L49L11R23R28R15L10L45R33R12L18R18L2L41R8L17L23R33L42R47L7R30L21L42L36R3R5L50R16R11R48R5L19L10R30L41R11L13R16R24L47L23L47R49R4R45R50L35R31R47L32L5L21R11R17L48R25R43R18R34L20L10L2L11L48R42R48R6L25R44L16R23R27R46L18R29R23L47R31R47L4R30L9R16L31R44L1R10L19R18L37R26L7R36R41R41L3L10L29L50L32R16R8L28R13L22L44R6L14R14L21R15R16L23L25R34L14R48L46L37L34R29L6R50L31L40R3R1L26L41L1L7L7L7R43R29R50R28R27L5R15R16R41R42R1R8R49R14L28L30L14R43L44L3R33R43R49R11R35R33L17R2R16L33L23R40R46R46R44R32R14R27L33L28L33L34R7L40R37L35L45R19R20L32R44R7R14R11L4L34R18L26L5R49L29R37R38R9R35R33L36R20R31R8L38R33L34R27R22R48R10L36R1R3L20L6R28L25R13L40L33R1L45L6R21L29L25L29L8L29L11R29L30R23R17L45L23L6L23L18L11R2L47R21R12R26L1L24R22L2R10R31R29L48R28R22L48L1R30L22R1R46R10R35L41L20L32L27L28R39R18L22L10L34L44L20R44L11L37L37L44L41R7R36R21R41L48R3R19L15L12R5R30L49L16R46R1L48L14R35R18R48L47L27L40R25R25L15L4L28L14R18R10R25L50R18L14L34R35R28R34L9R10L26L44L13L33R43L32L17R13L1L37L32R24R22L29L8R27R28L35R37L3R25""");
        Game game = new Game(instructor, gameMap);
        assertThat(game.run()).isEqualTo(47462);
    }
}