package day17;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RockTest {
    @Test
    void testCollisition() {

        char[][] dimension = new char[3][3];
        dimension[0][0] = '.';
        dimension[0][1] = '#';
        dimension[0][2] = '.';
        dimension[1][0] = '#';
        dimension[1][1] = '#';
        dimension[1][2] = '#';
        dimension[2][0] = '.';
        dimension[2][1] = '#';
        dimension[2][2] = '.';
        Rock rock = new Rock(dimension);
        List<char[]> game = new ArrayList<>();
        char[] firstline = new char[7];
        firstline[0] = '#';
        char[] secondline = new char[7];
        secondline[0] = '#';
        char[] thirdline = new char[7];
        thirdline[0] = '#';
        game.add(firstline);
        game.add(secondline);
        game.add(thirdline);
        boolean hasCollision = rock.hasCollision(0, 0, game);
        assertThat(hasCollision).isTrue();
    }
}