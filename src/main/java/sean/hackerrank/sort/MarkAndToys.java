package sean.hackerrank.sort;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/mark-and-toys
public class MarkAndToys {

  static int maximumToys(int[] prices, int k) {
    Arrays.sort(prices);

    int numberOfToys = 0;
    int dollarsSpent = 0;
    for (int price : prices) {
      if (dollarsSpent + price <= k) {
        numberOfToys++;
        dollarsSpent += price;
      } else {
        break;
      }
    }
    return numberOfToys;
  }


}
