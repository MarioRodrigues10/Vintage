package vintage.controller;


import vintage.module.item.carrier.CarrierListings;
import vintage.module.order.OrderListings;
import vintage.module.user.UserListings;
import vintage.view.SerializationView;

public class SerializationController {

    public static void save() {
        String folderName = SerializationView.save();

        UserListings.getInstance().saveUsers(folderName);
        OrderListings.getInstance().saveOrders(folderName);
        CarrierListings.getInstance().saveCarriers(folderName);

        SerializationView.saved();

        AdminController.getInstance().menu();
    }

    public static void load() {
        String folderName = SerializationView.load();

        UserListings.getInstance().loadUsers(folderName);
        OrderListings.getInstance().loadOrders(folderName);
        CarrierListings.getInstance().loadCarriers(folderName);

        SerializationView.loaded();

        AdminController.getInstance().menu();
    }
}
