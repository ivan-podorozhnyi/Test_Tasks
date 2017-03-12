package LineWithoutCrossings;

import java.util.Arrays;

public class Main
{


    public static void main(String[] args)
    {
        Point center = new Point(0, 0);
        Point[] anArray = randomArray();
        System.out.println("Random array with Points: ");
        System.out.println(Arrays.toString(anArray));
        sortPointsClockwise(anArray, center);
        System.out.println("Sorted array with Points without self-crossing sorted clockwise: ");
        System.out.println(Arrays.toString(anArray));
    }

    //method creates an array with random Points
    public static Point[] randomArray()
    {
        Point[] newArray = new Point[10];
        for (int i = 0; i < newArray.length; i++)
        {
            newArray[i] = new Point((int) (Math.random() * 21) - 11, (int) (Math.random() * 21) - 11);
        }
        return newArray;
    }

    // method is sorting points counter-clockwise order
    public static void sortPointsClockwise(Point[] points, Point center)
    {

        for (int i = 0; i < points.length - 1; i++)
        {
            Point lowest = points[i]; //temporary variable which is closest to center point
            int currentIndex = i;

            for (int j = i + 1; j < points.length; j++)
            {
                //one by one we check every point with next one and sort an array
                if (comparePoint(lowest, points[j], center))
                {
                    lowest = points[j];
                    currentIndex = j;
                }
            }

            if (currentIndex != i)
            {
                points[currentIndex] = points[i];
                points[i] = lowest;
            }
        }

    }
    //sorting points in the sequence of (-X:Y)->(-X:-Y)->(X:-Y)->(X:Y)
    public static boolean comparePoint(Point a, Point b, Point center)
    {

        if (a.getX() - center.getX() >= 0 && b.getX() - center.getX() < 0)
        {
            return true;
        }
        if (a.getX() - center.getX() < 0 && b.getX() - center.getX() >= 0)
        {
            return false;
        }
        if (a.getX() - center.getX() == 0 && b.getX() - center.getX() == 0)
        {
            if (a.getY() - center.getY() >= 0 || b.getY() - center.getY() >= 0)
            {
                return a.getY() > b.getY();
            }
            return b.getY() > a.getY();
        }

        // compute the cross product of vectors (center -> a) x (center -> b)
        double det = (a.getX() - center.getX()) * (b.getY() - center.getY()) - (b.getX() - center.getX()) * (a.getY() - center.getY());
        if (det < 0)
        {
            return true;
        }
        if (det > 0)
        {
            return false;
        }
        // if det=0, points a and b are on the same line from the center
        // check which point is closer to the center
        double d1 = (a.getX() - center.getX()) * (a.getX() - center.getX()) + (a.getY() - center.getY()) * (a.getY() - center.getY());
        double d2 = (b.getX() - center.getX()) * (b.getX() - center.getX()) + (b.getY() - center.getY()) * (b.getY() - center.getY());
        return d1 > d2;
    }
}
