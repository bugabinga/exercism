import java.util.Arrays;

/**
 * Write a program that can tell you if a triangle is equilateral, isosceles, or scalene.
 * Created by oliver on 12/28/16.
 */
class Triangle {
    private final double xSide;
    private final double ySide;
    private final double zSide;

    Triangle(final double xSide, final double ySide, final double zSide) throws TriangleException {
        this.xSide = xSide;
        this.ySide = ySide;
        this.zSide = zSide;

        if (xSide <= 0 || ySide <= 0 || zSide <= 0)
            throw new TriangleException();

        //The goal is to compare the largest side with the sum of the other two.
        //To achieve this, we sort the sides, so that the largest side is last.
        final double[] sides = new double[]{xSide, ySide, zSide};
        Arrays.sort(sides);
        if (sides[2] >= sides[1] + sides[0])
            throw new TriangleException();
    }

    TriangleKind getKind() {
        if (xSide == ySide && ySide == zSide)
            return TriangleKind.EQUILATERAL;

        if (xSide == ySide || ySide == zSide || xSide == zSide)
            return TriangleKind.ISOSCELES;

        return TriangleKind.SCALENE;
    }
}
