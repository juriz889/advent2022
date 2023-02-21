package day22;

public interface FacingMover {
    int getScore();

    FacingMover rotate(String direction);

    Point move(Point start, int by);

}
