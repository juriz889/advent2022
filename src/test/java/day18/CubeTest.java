package day18;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CubeTest {
    @Test
    void cubesWithOneConnection_getNumberOfUnconvered_5() {
        Cube cube1 = new Cube(1, 1, 1);
        Cube cube2 = new Cube(2, 1, 1);
        int num = cube1.getNumberOfUncovered(List.of(cube2));
        assertThat(num).isEqualTo(5);
    }

    @Test
    void cubesAreSame_getNumberOfUnconvered_0() {
        Cube cube1 = new Cube(1, 1, 1);
        Cube cube2 = new Cube(1, 1, 1);
        int num = cube1.getNumberOfUncovered(List.of(cube2));
        assertThat(num).isEqualTo(0);
    }
}