package Practice2;

public class Electronics extends Goods {
    private int warrantyMonths;
    private double capacityKW;

    public Electronics(String productCode, String name, int quantity, double unitPrice, int warrantyMonths, double capacityKW) {
        super(productCode, name, quantity, unitPrice);
        this.warrantyMonths = Math.max(0, warrantyMonths);
        this.capacityKW = Math.max(0, capacityKW);
    }

    public int getWarrantyMonths() { return warrantyMonths; }
    public double getCapacityKW() { return capacityKW; }

    @Override
    public double getVATAmount() {
        return unitPrice * quantity * 0.10;
    }

    @Override
    public String measureConsumption() {
        if (quantity < 3) {
            return "Sold";
        }
        return "Not evaluated";
    }
}