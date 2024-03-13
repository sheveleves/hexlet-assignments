package exercise;

class SafetyList {
    // BEGIN
    private int[] array = new int[10];
    private int count = 0;

    public synchronized void add(int item) {
            if ((count + 1) == array.length) {
                int[] newArray = new int[(count + 1) * 2];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }
            array[count] = item;
            count++;
    }

    public int get(int num) {
        return array[num];
    }

    public int getSize() {
        return count;
    }
    // END
}
