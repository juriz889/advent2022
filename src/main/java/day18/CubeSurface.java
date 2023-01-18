package day18;

import java.util.Objects;
import java.util.Set;

public class CubeSurface {
    private final Point bottomLeft;
    private final Point bottomRight;
    private final Point topLeft;
    private final Point topRight;
    private final Set<Point> points;

    private CubeSurface(Point bottomLeft, Point bottomRight, Point topLeft, Point topRight) {
        this.bottomLeft = Objects.requireNonNull(bottomLeft);
        this.bottomRight = Objects.requireNonNull(bottomRight);
        this.topLeft = Objects.requireNonNull(topLeft);
        this.topRight = Objects.requireNonNull(topRight);
        points = Set.of(bottomLeft, bottomRight, topLeft, topRight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeSurface that = (CubeSurface) o;
        return this.points.equals(((CubeSurface) o).points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.points);
    }

    public static CubeSurfaceBuilder builder() {
        return new CubeSurfaceBuilderImpl();
    }

    public interface CubeSurfaceBuilder {
        CubeSurfaceBuilder withBottomLeft(Point point);

        CubeSurfaceBuilder withBottomRight(Point point);

        CubeSurfaceBuilder withTopLeft(Point point);

        CubeSurfaceBuilderFinal withTopRight(Point point);
    }

    public interface CubeSurfaceBuilderFinal {
        CubeSurface build();
    }

    private static class CubeSurfaceBuilderImpl implements CubeSurfaceBuilder, CubeSurfaceBuilderFinal {
        private Point bottomLeft;
        private Point bottomRight;
        private Point topLeft;
        private Point topRight;

        @Override
        public CubeSurfaceBuilder withBottomLeft(Point point) {
            this.bottomLeft = point;
            return this;
        }

        @Override
        public CubeSurfaceBuilder withBottomRight(Point point) {
            this.bottomRight = point;
            return this;
        }

        @Override
        public CubeSurfaceBuilder withTopLeft(Point point) {
            this.topLeft = point;
            return this;
        }

        @Override
        public CubeSurfaceBuilderFinal withTopRight(Point point) {
            topRight = point;
            return this;
        }

        @Override
        public CubeSurface build() {
            return new CubeSurface(bottomLeft, bottomRight, topLeft, topRight);
        }
    }
}
