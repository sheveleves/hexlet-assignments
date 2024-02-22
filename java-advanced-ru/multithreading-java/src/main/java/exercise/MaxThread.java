package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] arr;
    private int max;
    public MaxThread(int[] array) {
        arr = array;
    }

    @Override
    public void run() {
        max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
    }

    public int getMax() {
        return max;
    }
}
// END
