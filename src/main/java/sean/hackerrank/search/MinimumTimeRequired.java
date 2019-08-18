package sean.hackerrank.search;

import java.util.Arrays;

// https://www.hackerrank.com/challenges/minimum-time-required
public class MinimumTimeRequired {

  static long minTime(long[] machines, long goal) {
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    for (long machine : machines) {
      min = Math.min(min, machine);
      max = Math.max(max, machine);
    }
    long minday = (long) Math.ceil(((double) goal / (double) machines.length) * (double) min);
    long maxday = (long) Math.ceil(((double) goal / (double) machines.length) * (double) max);
    while (minday < maxday) {
      long currday = (maxday + minday) / 2;
      long sum = Arrays.stream(machines).map(l -> currday / l).sum();

      if (sum >= goal) {
        maxday = currday;
      } else {
        minday = currday + 1;
      }
    }
    return minday;
  }
}
