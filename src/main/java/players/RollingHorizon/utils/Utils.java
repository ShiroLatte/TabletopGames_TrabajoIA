package players.RollingHorizon.utils;

import java.util.*;


@SuppressWarnings({"unused", "WeakerAccess"})
public class Utils
{
    // Takes an object from an array at random
    public static Object choice(Object[] elements, Random rnd)
    {
        return elements[rnd.nextInt(elements.length)];
    }

    // Takes an integer from an array at random
    public static int choice(int[] elements, Random rnd)
    {
        return elements[rnd.nextInt(elements.length)];
    }

    // Clamps 'val' between 'mim' and 'max'
    public static int clamp(int min, int val, int max)
    {
        if(val < min) return min;
        if(val > max) return max;
        return val;
    }


    // Ugh, a regex!
    public static String formatString(String str)
    {
        // 1st replaceAll: compresses all non-newline whitespaces to single space
        // 2nd replaceAll: removes spaces from beginning or end of lines
        return str.replaceAll("[\\s&&[^\\n]]+", " ").replaceAll("(?m)^\\s|\\s$", "");
    }

    //Normalizes a value between its MIN and MAX.
    public static double normalise(double a_value, double a_min, double a_max)
    {
        if(a_min < a_max)
            return (a_value - a_min)/(a_max - a_min);
        else    // if bounds are invalid, then return same value
            return a_value;
    }

    /**
     * Adds a small noise to the input value.
     * @param input value to be altered
     * @param epsilon relative amount the input will be altered
     * @param random random variable in range [0,1]
     * @return epsilon-random-altered input value
     */
    public static double noise(double input, double epsilon, double random)
    {
        if(input != -epsilon) {
            return (input + epsilon) * (1.0 + epsilon * (random - 0.5));
        }else {
            //System.out.format("utils.tiebreaker(): WARNING: value equal to epsilon: %f\n",input);
            return (input + epsilon) * (1.0 + epsilon * (random - 0.5));
        }
    }

    // Returns the index of the element in the array with the highest value.
    public static int argmax (double[] values)
    {
        int maxIndex = -1;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < values.length; i++) {
            double elem = values[i];
            if (elem > max) {
                max = elem;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    //Concatenates the elements of a String array into a String object, separated by ','
    public static String toStringArray(String[] array)
    {
        if (array != null && array.length > 0) {
            StringBuilder nameBuilder = new StringBuilder();

            for (String elem : array)
                nameBuilder.append(elem).append(",");

            nameBuilder.deleteCharAt(nameBuilder.length() - 1);

            return nameBuilder.toString();
        } else {
            return "";
        }
    }

    //Finds the maximum divisor of a value
    public static int findMaxDivisor(int value) {
        int divisor = 1;
        for (int i=1; i<=Math.sqrt(value)+1; i++) {
            if (value % i == 0) {
                divisor = i;
            }
        }
        return divisor;
    }

    //Sums all ints in an array and returns the sum
    public static int sumArray(int[] ar)
    {
        int sum = 0;
        for(int val : ar)
        {
            sum+=val;
        }
        return sum;
    }
}
