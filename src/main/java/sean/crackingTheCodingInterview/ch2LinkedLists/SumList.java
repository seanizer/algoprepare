package sean.crackingTheCodingInterview.ch2LinkedLists;

/*
Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
Output: 9 - > 1 -> 2. That is, 912.
 */
public class SumList {

    static LinkedList<Integer> sum(LinkedList<Integer> left, LinkedList<Integer> right) {
        int leftIntValue = toInt(left);
        int rightIntValue = toInt(right);
        return toList(leftIntValue + rightIntValue);
    }

    private static LinkedList<Integer> toList(int i) {
        String s = String.valueOf(i);
        LinkedList<Integer> list = new LinkedList<>(Integer.parseInt("" + s.charAt(0)));
        for (int j = 1; j < s.length(); j++) {
            list.add(Integer.parseInt("" + s.charAt(j)));
        }
        return list;
    }

    private static int toInt(LinkedList<Integer> list) {
        int value = 0;
        for (Integer integer : list) {
            value = value * 10 + integer;
        }
        return value;
    }

}
