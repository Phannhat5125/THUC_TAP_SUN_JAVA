package Practice2;

import java.util.Date;

public class Crockery extends Goods {
    private String manufacturer;
    private Date arrivalDate;

    public Crockery(String productCode, String name, int quantity, double unitPrice, String manufacturer, Date arrivalDate) {
        super(productCode, name, quantity, unitPrice);
        this.manufacturer = manufacturer;
        this.arrivalDate = arrivalDate;
    }

    public String getManufacturer() { return manufacturer; }
    public Date getArrivalDate() { return arrivalDate; }

    @Override
    public double getVATAmount() {
        return unitPrice * quantity * 0.10;
    }

    @Override
    public String measureConsumption() {
        Date now = new Date();
        long diff = (now.getTime() - arrivalDate.getTime()) / (1000 * 60 * 60 * 24);
        if (quantity > 50 && diff > 10) {
            return "Slow sale";
        }
        return "Not evaluated";
    }
}