package seeds;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import vintage.item.carrier.Carrier;

public class CarrierSeeder {

    private static final BigDecimal SMALL = new BigDecimal("5.0");
    private static final BigDecimal MEDIUM = new BigDecimal("10.0");
    private static final BigDecimal LARGE = new BigDecimal("15.0");
    private static final BigDecimal TAX = new BigDecimal("0.1");
    private static final String[] CARRIER_NAMES = {"FedEx", "UPS", "DHL", "USPS", "Amazon"};
    private static final int[] DELIVERY_TIMES = {1, 2, 3, 4, 5, 6, 7};
    private static final boolean[] PREMIUM_STATUS = {true, false};

    public static List<Carrier> seedCarriers(int numCarriers) {
        List<Carrier> carriers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < numCarriers; i++) {
            Carrier carrier = new Carrier();
            carrier.setName(CARRIER_NAMES[rand.nextInt(CARRIER_NAMES.length)]);
            carrier.setProfit(new BigDecimal(rand.nextInt(50) + 1));
            carrier.setDeliveryTime(DELIVERY_TIMES[rand.nextInt(DELIVERY_TIMES.length)]);
            carrier.setPremium(PREMIUM_STATUS[rand.nextInt(PREMIUM_STATUS.length)]);
            carriers.add(carrier);
        }
        return carriers;
    }
}
