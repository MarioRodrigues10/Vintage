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
    private static CarrierController instance = null;

    public static CarrierController getInstance() {
        if (instance == null) {
            instance = new CarrierController();
        }
        return instance;
    }

    public void menu() {
        int option = CarrierView.getInstance().menu();

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
                AdminController.getInstance().menu();
                break;
        }
    }

    public void viewCarriers() {
        List<Carrier> carriers = CarrierListings.getInstance().getAllCarriers();

        // turn the carriers list into a list of strings
        List<String> carrierStrings = new ArrayList<String>();
        for (Carrier carrier : carriers) {
            carrierStrings.add(carrier.toString());
        }
        int carrierIndex = CarrierView.getInstance().viewCarriers(carrierStrings);

        if (carrierIndex == -1) {
            CarrierController.getInstance().menu();
        }
    }

    public void createCarrier() {
        Map<String, String> newCarrier = CarrierView.getInstance().createCarrier();

        boolean premium;
        if (newCarrier.get("premium") == "y") premium = true; else premium = false;

        Carrier carrier = new Carrier(newCarrier.get("name"), BigDecimal.valueOf(Double.parseDouble(newCarrier.get("profit"))), premium, Integer.parseInt(newCarrier.get("deliveryTime")));
        CarrierListings.getInstance().addCarrier(carrier);

        CarrierController.getInstance().menu();
    }

    public void deleteCarrier() {
        String carrierName = CarrierView.getInstance().deleteCarrier();

        CarrierListings.getInstance().removeCarrier(carrierName);
        CarrierView.getInstance().carrierDeleted();

        CarrierController.getInstance().menu();
    }
}
