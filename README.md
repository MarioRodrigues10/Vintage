## Object Oriented Programming | Programação Orientada a Objetos
## Grade: 15/20 :star:

This project was developed during the second semester of the 2nd year.

The project purpose was to build a Vintage marketplace system that allows buying and selling of new and used items of various types. In the marketplace, registered users take on the roles of sellers or buyers. Sellers can add new items for sale, while buyers can choose to purchase available items. All purchases and sales are managed within this system. The items can be of various types, particularly clothing, footwear, accessories, and more. It is expected that the marketplace can be expanded to other product types in the future.

Each item has a common set of properties, and there are further specializations depending on the specific type of item. Each item is identified by a unique alphanumeric code (i.e., barcode).

Purchases of items are organized into orders, which are later shipped by various transport companies. For each completed order, Vintage charges a service guarantee fee to the seller, ensuring the security and satisfaction of buyers in case the orders are not delivered.

The Vintage system maintains control over the available stock of items, as well as the orders placed by buyers and the sales made by sellers.

It should be possible for a seller to publish their items for sale, and for a buyer to choose multiple items and place an order. When a seller publishes their items for sale, they also decide which shipping company will handle the delivery.

A buyer should be able to add multiple items to an order and complete the purchase. It should also be possible for the buyer to return the order, but only within 48 hours (which may be configurable) after the order has been delivered.

An important aspect to consider is that, in order to simulate the system as closely as possible to a real-world scenario, there is a need to progress through time. The system should be aware of the current date, and there should be a functionality to advance to a future date. Advancing time (simulated for practical and complexity reduction purposes) should trigger all pending actions, such as order deliveries and reduction of item stock.


## Installing and running the project


#### Cloning the repository
```bash
$ git clone git@github.com:MarioRodrigues10/Vintage.git
```

#### Compiling
```bash
$ cd Vintage
$ ./gradlew build
```

#### Running
```bash
$ java -cp build/classes/java/main vintage.Main
```

# Developed by:

- [Daniel Pereira](https://github.com/danielsp45)
- [Mário Rodrigues](https://github.com/MarioRodrigues10)
- [Pedro Sousa](https://github.com/Pdf0)

