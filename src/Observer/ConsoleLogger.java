package Observer;

public class ConsoleLogger implements InventoryObserver {
    @Override
    public void onInventoryChanged(String message) {
    	System.out.println("[LOG " + java.time.LocalTime.now() + "]: " + message);
    }
}
