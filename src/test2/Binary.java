package test2;

import java.util.Arrays;
import java.util.Scanner;

public class Binary
{
    public static void main(String[] args)
    {
        int[] array = {5, 10, 1, 8, 12, 15, 11, 28, 0, 9};
        System.out.println("Unsorted array is:");
        System.out.println(Arrays.toString(array));
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an index in array:  ");

        try
        {
            int index = array[input.nextInt()-1];
            Arrays.sort(array);
            System.out.println("Sorted array is:");
            System.out.println(Arrays.toString(array));
            System.out.println("Your number is:");

            //Binary search method works much better than "for each" loop
            //the main idea is to choose the middle element in array and compare with searchable number
            //and there can be three cases: 1) this element is equal, smaller or bigger than searchable number
            //so we don't need to search for our element in that part of array which is smaller
            //we pass as many iterations as necessary until we find our element
            System.out.println(array[Arrays.binarySearch(array, index)]);

        }
        catch (Exception e)
        {
            System.out.println("Exception occurred:");
            e.printStackTrace();
        }
    }
}