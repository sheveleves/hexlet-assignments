package exercise;

import java.util.Map;
import java.util.logging.Logger;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] array) {
        MaxThread maxThread = new MaxThread(array);
        MinThread minThread = new MinThread(array);
        maxThread.start();
        LOGGER.info("Thread " + maxThread.getName() + "started");
        LOGGER.info("Thread " + minThread.getName() + "started");
        minThread.start();

        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Thread " + maxThread.getName() + "finished");
        LOGGER.info("Thread " + maxThread.getName() + "finished");


        Map<String, Integer> result = Map.of("max", maxThread.getMax(), "min", minThread.getMin());
        return result;
    }
    // END
}
