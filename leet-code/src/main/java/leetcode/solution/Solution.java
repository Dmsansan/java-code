package leetcode.solution;

import java.util.Stack;

/**
 * @author siss
 * @date 2020/7/2  13:44
 */
public class Solution {

    public static void main(String[] args) {
//        int[][] matrix = new int[3][3];
//        matrix[0][0] = 1;
//        matrix[0][1] = 2;
//        matrix[0][2] = 3;
//
//        matrix[1][0] = 4;
//        matrix[1][1] = 5;
//        matrix[1][2] = 6;
//
//        matrix[2][0] = 7;
//        matrix[2][1] = 8;
//        matrix[2][2] = 9;
//
//        int target = 22;
//        boolean res = findNumberIn2DArray(matrix, target);
//        System.out.println(res);

//        String s = "In the world";
//        String s1 = replaceSpace(s);
//        System.out.println(s1);
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);

        ListNode node = new ListNode(2);
        node.next = head;
        int[] ints = reversePrint(node);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    public static String replaceSpace(String s) {
        String replace = s.replace(" ", "%20");
        return replace;
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }



}
