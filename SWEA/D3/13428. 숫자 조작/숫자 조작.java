import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            String n = sc.next();
            int max = findMaxAfterOneSwap(n);
            int min = findMinAfterOneSwap(n);
            System.out.println("#" + tc + " " + min + " " + max);
        }
    }

    private static int findMaxAfterOneSwap(String n) {
        char[] numChars = n.toCharArray();
        int max = Integer.parseInt(n);

        for (int i = 0; i < numChars.length; i++) {
            for (int j = i + 1; j < numChars.length; j++) {
                swap(i, j, numChars);
                if (numChars[0] != '0') {
                    max = Math.max(max, Integer.parseInt(new String(numChars)));
                }
                swap(i, j, numChars); // Swap back to restore original order
            }
        }
        return max;
    }

    private static int findMinAfterOneSwap(String n) {
        char[] numChars = n.toCharArray();
        int min = Integer.parseInt(n);

        for (int i = 0; i < numChars.length; i++) {
            for (int j = i + 1; j < numChars.length; j++) {
                swap(i, j, numChars);
                if (numChars[0] != '0') {
                    min = Math.min(min, Integer.parseInt(new String(numChars)));
                }
                swap(i, j, numChars); // Swap back to restore original order
            }
        }
        return min;
    }

    private static void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
