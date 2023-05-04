package vintage.item;

import vintage.user.User;
import vintage.user.UserSeeder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
                    break;
                case 1:
                    items.add(generateShoes());
                    break;
                case 2:
                    items.add(generateTShirt());
                    break;
            }
        }
        return items;
    }

    private Bag generateBag() {
        Bag bag = new Bag();
        UserSeeder userSeeder = new UserSeeder();
        bag.setDescription("A nice bag");
        bag.setBrand("Louis Vuitton");
        bag.setEvaluation(random.nextInt(10));
        bag.setPrice(BigDecimal.valueOf(random.nextInt(500) + 500));
        bag.setOwners(random.nextInt(MAX_OWNERS + 1));
        bag.setSize(random.nextInt(10) + 1);
        bag.setMaterial("Cotton");
        bag.setOwner(userSeeder.seedUsers(1).get(0));
        bag.setRelease(random.nextInt(5) + 2016);
        return bag;
    }

    private Shoes generateShoes() {
        Shoes shoes = new Shoes();
        UserSeeder userSeeder = new UserSeeder();
        shoes.setDescription("A nice pair of shoes");
        shoes.setBrand("Nike");
        shoes.setEvaluation(random.nextInt(10) + 1);
        shoes.setPrice(BigDecimal.valueOf(random.nextInt(300) + 100));
        shoes.setOwners(random.nextInt(MAX_OWNERS + 1));
        shoes.setSize(random.nextDouble() * (12 - 5) + 5);
        shoes.setLaces(random.nextBoolean());
        shoes.setColor("Black");
        shoes.setOwner(userSeeder.seedUsers(1).get(0));
        shoes.setRelease(random.nextInt(5) + 2016);
        return shoes;
    }

    private TShirt generateTShirt() {
        TShirt tShirt = new TShirt();
        UserSeeder userSeeder = new UserSeeder();
        tShirt.setDescription("A nice t-shirt");
        tShirt.setBrand("Adidas");
        tShirt.setEvaluation(random.nextInt(10) + 1);
        tShirt.setPrice(BigDecimal.valueOf(random.nextInt(100) + 50));
        tShirt.setOwners(random.nextInt(MAX_OWNERS + 1));
        tShirt.setSize(TShirt.Size.values()[random.nextInt(TShirt.Size.values().length)]);
        tShirt.setOwner(userSeeder.seedUsers(1).get(0));
        tShirt.setPattern(TShirt.Pattern.values()[random.nextInt(TShirt.Pattern.values().length)]);
        return tShirt;
    }
}
