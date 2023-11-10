public class EventHandlerStrategyImpl implements EventHandlerStrategy {
    @Override
    public void runStrategy(EventHandler handler, Object data) throws Exception {
        int maxRetries = 3;
        int retryCount = 0;
        final int interval = 1000;

        while (retryCount < maxRetries) {
            try {
                // Call the code that can potentially fail
                System.out.println("strategy fix interval");
                handler.doSomething(data);
                // If the code succeeds, break out of the loop
                break;
            } catch (Exception e) {
                // If the code fails, increment the retry count
                retryCount++;
                if (retryCount == maxRetries) {
                    // If the maximum number of retries has been reached, re-throw the exception
                    throw e;
                } else {
                    // If there are still retries left, wait for a short period of time before trying again
                    Thread.sleep(interval);
                }
            }
        }
    }
}



