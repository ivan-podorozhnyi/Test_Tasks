package test1;

import java.util.Scanner;

public class RoundedSquareRoot
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer:  ");

        try
        {
            int i = input.nextInt();
            roundedSquareRoot(i);
        }
        catch (Exception e)
        {
            System.out.println("Exception occurred:");
            e.printStackTrace();
        }
    }

    public static void roundedSquareRoot(double number)
    {
        double temp;

        //if the number given is a 0
        if (number == 0)
        {
            System.out.println("Square root of " + number + " = " + 0);
        }
        //if the number given is negative
        if (number < 0)
        {
            System.out.println("It's not possible to find a square root of a negative number");
        }
        //Newton Raphson method of finding square root
        //according to this method we must pass as many iterations as necessary until
        //we get equal numbers temp and squareRoot
        double squareRoot = number / 2;
        do
        {
            temp = squareRoot;
            squareRoot = (temp + (number / temp)) / 2;
        }
        while ((temp - squareRoot) != 0);

        System.out.println("Rounded down square root of " + (int) number + " is: " + (int) squareRoot);

    }
}
