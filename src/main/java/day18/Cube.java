package day18;

import java.util.List;

public final class Cube {
    private final int x;
    private final int y;
    private final int z;
    private final List<CubeSurface> surfaces;

    public Cube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        CubeSurface front = CubeSurface.builder().withBottomLeft(new Point(x, y, z)).withTopLeft(new Point(x, y + 1, z)).withBottomRight(new Point(x + 1, y, z)).withTopRight(new Point(x + 1, y + 1, z)).build();
        CubeSurface rear = CubeSurface.builder().withBottomLeft(new Point(x, y, z + 1)).withTopLeft(new Point(x, y + 1, z + 1)).withBottomRight(new Point(x + 1, y, z + 1)).withTopRight(new Point(x + 1, y + 1, z + 1)).build();


        CubeSurface bottom = CubeSurface.builder().withBottomLeft(new Point(x, y, z)).withTopLeft(new Point(x, y, z + 1)).withBottomRight(new Point(x + 1, y, z)).withTopRight(new Point(x + 1, y, z + 1)).build();
        CubeSurface top = CubeSurface.builder().withBottomLeft(new Point(x, y + 1, z)).withTopLeft(new Point(x, y + 1, z + 1)).withBottomRight(new Point(x + 1, y + 1, z)).withTopRight(new Point(x + 1, y + 1, z + 1)).build();

        CubeSurface left = CubeSurface.builder().withBottomLeft(new Point(x, y, z + 1)).withTopLeft(new Point(x, y + 1, z + 1)).withBottomRight(new Point(x, y, z)).withTopRight(new Point(x, y + 1, z)).build();
        CubeSurface right = CubeSurface.builder().withBottomLeft(new Point(x + 1, y, z)).withTopLeft(new Point(x + 1, y + 1, z)).withBottomRight(new Point(x + 1, y, z + 1)).withTopRight(new Point(x + 1, y + 1, z + 1)).build();
        surfaces = List.of(front, rear, top, bottom, left, right);
    }

    public int getNumberOfUncovered(List<Cube> otherCubes) {
        int result = 0;
        for (CubeSurface surface : surfaces) {
            boolean hasOverlap = false;
            for (Cube otherCube : otherCubes) {
                if (this == otherCube) {
                    continue;
                }
                for (CubeSurface cubeSurface : otherCube.surfaces) {
                    if (surface.equals(cubeSurface)) {
                        hasOverlap = true;
                        break;
                    }
                }
            }
            if (!hasOverlap) {
                result++;
            }

        }
        return result;
    }
}
