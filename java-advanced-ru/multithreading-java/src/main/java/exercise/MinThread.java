package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] arr;
    private int min;
    public MinThread(int[] array) {
        arr = array;
    }

    @Override
    public void run() {
        min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
    }

    public int getMin() {
        return min;
    }
}
// END
