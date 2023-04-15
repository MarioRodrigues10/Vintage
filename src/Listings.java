import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Listings {
    private HashMap<UUID, Item[]> items;

    public Listings() {
        this.items = new HashMap<>();
    }

    public void addItem(User user, Item item) {
        this.items.put(item.getId(), item);
    }
}
