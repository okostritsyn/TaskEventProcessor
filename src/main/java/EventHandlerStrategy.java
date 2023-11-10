public interface EventHandlerStrategy {
    void runStrategy(EventHandler handler,Object data) throws Exception;
}
