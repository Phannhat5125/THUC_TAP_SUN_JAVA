package Practice2;

public abstract class Goods {
    protected String productCode;
    protected String name;
    protected int quantity;
    protected double unitPrice;

    public Goods(String productCode, String name, int quantity, double unitPrice) {
        this.productCode = productCode;
        this.name = name;
        this.quantity = Math.max(0, quantity);
        this.unitPrice = Math.max(0, unitPrice);
    }

    public String getProductCode() { return productCode; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }

    public abstract double getVATAmount();
    public abstract String measureConsumption();
}