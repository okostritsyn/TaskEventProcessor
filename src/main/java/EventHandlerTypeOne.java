public class EventHandlerTypeOne implements EventHandler {
    @Override
    public void doSomething(Object data) throws Exception {
        throw new Exception("Some error occurred");
        //System.out.println("get data to do sth " + data);
    }
}
