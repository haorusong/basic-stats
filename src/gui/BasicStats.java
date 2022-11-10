package gui;

import java.util.*;

/**
 * A simple class to compute basic, descriptive statistics.
 */
public class BasicStats {

  public static void main(String... args) {
    System.out.println("Let's do some basic statistics...");
  }

  /**
   * Compute the mean of an array of numbers.
   */
  public static double mean(double... numbers) {
    double sum = 0;
    for (double num : numbers) {
      sum += num;
    }
    return sum / numbers.length;
  }

  /**
   * Compute the median of an array of numbers.
   */
  public static double median(double... numbers) {
    Arrays.sort(numbers);

    int size = numbers.length;
    double median = 0.0;

    if (size > 0) {
      if (size % 2 == 0) {
        median = (numbers[size >> 1] + numbers[(size >> 1) - 1]) / 2;
      } else {
        median = numbers[size >> 1];
      }
    }

    return median;
  }

  /**
   * Compute the max of an array of numbers.
   */
  public static double max(double... numbers) {

    int size = numbers.length;
    int i;

    double max = numbers[0];

    for (i = 1; i < numbers.length; i++)
      if (numbers[i] > max)
        max = numbers[i];

    return max;
  }

  /**
   * Compute the mode of an array of numbers.
   */
  public static double mode(double... numbers) {
    double mode = 0.0;
    int modeCount = 0;

    for (double num : numbers) {

      int count = 0;

      for (double otherNum : numbers) {
        if (num == otherNum) {
          count++;
        }
      }

      if (count > modeCount) {
        modeCount = count;
        mode = num;
      }

    }

    return mode;
  }

  public static double[] getArrayDouble(ArrayList<Double> doubles) {
    double[] result = new double[doubles.size()];

    // O(n) iteration to convert result
    for (int i = 0; i < doubles.size(); i++) {
      result[i] = doubles.get(i);
    }

    return result;
  }
}
