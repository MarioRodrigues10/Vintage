package vintage.controller;

import vintage.module.item.Item;
import vintage.module.item.carrier.CarrierListings;
import vintage.module.order.receipt.Receipt;
import vintage.module.others.Address;
import vintage.module.user.User;
import vintage.module.user.UserListings;
import vintage.view.CarrierView;
import vintage.module.item.carrier.Carrier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarrierController {

    public static void menu() {
        int option = CarrierView.menu();

        switch (option) {
            case 1:
                viewCarriers();
                break;
            case 2:
                createCarrier();
                break;
            case 3:
                deleteCarrier();
                break;
            case 4:
                break;
            case 5:
                AdminController.menu();
                break;
        }
    }

    public static void viewCarriers() {
        List<Carrier> carriers = CarrierListings.getInstance().getAllCarriers();

        // turn the carriers list into a list of strings
        List<String> carrierStrings = new ArrayList<String>();
        for (Carrier carrier : carriers) {
            carrierStrings.add(carrier.toString());
        }
        int carrierIndex = CarrierView.viewCarriers(carrierStrings);

        if (carrierIndex == -1) {
            CarrierController.menu();
        }
    }

    public static void createCarrier() {
        Map<String, String> newCarrier = CarrierView.createCarrier();

        boolean premium;
        if (newCarrier.get("premium") == "y") premium = true; else premium = false;

        Carrier carrier = new Carrier(newCarrier.get("name"), BigDecimal.valueOf(Double.parseDouble(newCarrier.get("profit"))), premium, Integer.parseInt(newCarrier.get("deliveryTime")));
        CarrierListings.getInstance().addCarrier(carrier);

        CarrierController.menu();
    }

    public static void deleteCarrier() {
        String carrierName = CarrierView.deleteCarrier();

        CarrierListings.getInstance().removeCarrier(carrierName);
        CarrierView.carrierDeleted();

        CarrierController.menu();
    }
}
