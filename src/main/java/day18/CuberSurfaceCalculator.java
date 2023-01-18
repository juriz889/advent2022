package day18;

import java.util.Arrays;
import java.util.List;

public class CuberSurfaceCalculator {

    public int calcSurfaces(String input) {
        String[] split = input.split("\n");
        List<Cube> collect = Arrays.stream(split).map(e -> e.split(",")).map(numbers -> new Cube(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]))).toList();
        int result = 0;
        for (Cube cube : collect) {
            result += cube.getNumberOfUncovered(collect);
        }
        return result;
    }
}
