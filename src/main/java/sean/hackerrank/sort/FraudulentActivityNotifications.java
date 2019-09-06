package sean.hackerrank.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.hackerrank.com/challenges/fraudulent-activity-notifications
public class FraudulentActivityNotifications {

  static int activityNotifications(int[] expenditure, int d) {

    int warningDays = 0;
    if (expenditure.length > d) {
      List<Integer> sorted = new ArrayList<>(d);
      Queue<Integer> values = new LinkedList<>();
      for (int i = 0; i < d; i++) {
        int value = expenditure[i];
        insertIntoSortedCollection(sorted, value);
        values.offer(value);
      }
      for (int i = d; i < expenditure.length; i++) {
        int value = expenditure[i];
        double median = pickMedian(sorted);
        if ((double) value / 2 >= median) {
          warningDays++;
        }
        removeFromSortedCollection(sorted, values.poll());
        insertIntoSortedCollection(sorted, value);
        values.offer(value);
      }
    }
    return warningDays;

  }

  private static void removeFromSortedCollection(List<Integer> sorted, int value) {
    int position = Collections.binarySearch(sorted, value);
    sorted.remove(position);
  }

  private static int insertIntoSortedCollection(List<Integer> sorted, int value) {
    int position = Collections.binarySearch(sorted, value);
    if (position < 0) {
      position = -1 * position - 1;
    }
    sorted.add(position, value);
    return position;
  }

  static double pickMedian(List<Integer> sortedList) {
    int size = sortedList.size();
    if (size % 2 == 0) {
      return ((double) sortedList.get(size / 2) + (double) sortedList.get(size / 2 - 1)) / 2;
    } else {
      return sortedList.get(size / 2);
    }
  }

}
