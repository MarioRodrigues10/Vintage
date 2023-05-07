package seeds;

import vintage.module.item.*;
import vintage.module.item.carrier.Carrier;
import vintage.module.user.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemSeeder {

    private Random random = new Random();
    private final int MAX_OWNERS = 5;

    public List<Item> generateItems(int n) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int itemType = random.nextInt(3);
            switch (itemType) {
                case 0:
                    items.add(generateBag());
                    items.get(i).getUser().addItem(items.get(i));
                    break;
                case 1:
                    items.add(generateShoes());
                    items.get(i).getUser().addItem(items.get(i));
                    break;
                case 2:
                    items.add(generateTShirt());
                    items.get(i).getUser().addItem(items.get(i));
                    break;
            }
        }
        return items;
    }

    private Bag generateBag() {
        UserSeeder userSeeder = new UserSeeder();
        CarrierSeeder carrierSeeder = new CarrierSeeder();
        Carrier carrier = carrierSeeder.seedCarriers(1).get(0);
        User owner = userSeeder.seedUsers(1).get(0);
        return new Bag("A nice bag", owner, "Louis Vuitton", random.nextInt(10),
                BigDecimal.valueOf(random.nextInt(500) + 500), random.nextInt(MAX_OWNERS + 1),
                random.nextInt(10) + 1, "Cotton", random.nextInt(5) + 2016, carrier);
    }

    private Shoes generateShoes() {
        UserSeeder userSeeder = new UserSeeder();
        User owner = userSeeder.seedUsers(1).get(0);
        CarrierSeeder carrierSeeder = new CarrierSeeder();
        Carrier carrier = carrierSeeder.seedCarriers(1).get(0);
        return new Shoes("A nice pair of shoes", owner, "Nike", random.nextInt(10) + 1,
                BigDecimal.valueOf(random.nextInt(300) + 100), random.nextInt(MAX_OWNERS + 1),
                random.nextDouble() * (12 - 5) + 5, random.nextBoolean(), "Black",
                random.nextInt(5) + 2016, carrier);
    }

    private TShirt generateTShirt() {
        UserSeeder userSeeder = new UserSeeder();
        User owner = userSeeder.seedUsers(1).get(0);
        CarrierSeeder carrierSeeder = new CarrierSeeder();
        Carrier carrier = carrierSeeder.seedCarriers(1).get(0);
        return new TShirt("A nice t-shirt", owner, "Adidas", random.nextInt(10) + 1,
                BigDecimal.valueOf(random.nextInt(100) + 50), random.nextInt(MAX_OWNERS + 1),
                TShirt.Size.values()[random.nextInt(TShirt.Size.values().length)],
                TShirt.Pattern.values()[random.nextInt(TShirt.Pattern.values().length)], carrier);
    }

}
