package Practice2;

import java.util.Date;

public class Food extends Goods {
    private Date manufactureDate;
    private Date expirationDate;
    private String supplier;

    public Food(String productCode, String name, int quantity, double unitPrice, Date manufactureDate, Date expirationDate, String supplier) {
        super(productCode, name, quantity, unitPrice);
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.supplier = supplier;
    }

    public Date getManufactureDate() { return manufactureDate; }
    public Date getExpirationDate() { return expirationDate; }
    public String getSupplier() { return supplier; }

    @Override
    public double getVATAmount() {
        return unitPrice * quantity * 0.05;
    }

    @Override
    public String measureConsumption() {
        Date now = new Date();
        if (quantity > 0 && expirationDate.before(now)) {
            return "Hard to sell";
        }
        return "Not evaluated";
    }
}