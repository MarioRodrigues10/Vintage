package vintage.order.receipt;

import vintage.item.Item;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

/**
 * Defines a Receipt
 */
public interface Receipt {
    public UUID getId();
    public UUID getOrderID();
    public BigDecimal getTotalPrice();
    public List<Item> getItems();
    public LocalDate getEmissionDate();
    public void setTotalPrice(BigDecimal totalPrice);
    public void setItems(List<Item> items);
    public void setEmissionDate(LocalDate emissionDate);
    public void addItem(Item item);
}
