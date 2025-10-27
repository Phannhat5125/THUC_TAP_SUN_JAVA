package Practice2;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        InventoryManager inv = new InventoryManager();

        // THUC PHAM
        Date manuDate = Date.from(LocalDate.of(2025, 9, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date expDate = Date.from(LocalDate.of(2025, 10, 15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        inv.addGoods(new Food("F01", "Milk", 10, 2.5, manuDate, expDate, "Vinamilk"));

        // DIEN TU 
        inv.addGoods(new Electronics("E01", "Fan", 2, 500, 12, 0.5));

        // DO SU 
        Date arrivalDate = Date.from(LocalDate.of(2025, 10, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        inv.addGoods(new Crockery("C01", "Bowl Set", 60, 20, "Phan Nhat", arrivalDate));

        //DANH SACH 
        displayAll(inv);
    }

    public static void displayAll(InventoryManager inv) {
        System.out.println("DANH SACH HANG HOA SIEU THI:");
        for (Goods g : inv.getGoodsList()) {
            System.out.println("------------------------------");
            System.out.println("Ma hang: " + g.getProductCode());
            System.out.println("Ten hang: " + g.getName());
            System.out.println("So luong: " + g.getQuantity());
            System.out.println("Don gia: " + g.getUnitPrice());
            System.out.println("VAT: " + g.getVATAmount());
            System.out.println("Tieu thu: " + g.measureConsumption());
            if (g instanceof Food) {
                Food f = (Food) g;
                System.out.println("Ngay san xuat: " + f.getManufactureDate());
                System.out.println("Ngay het han: " + f.getExpirationDate());
                System.out.println("Nha cung cap: " + f.getSupplier());
            } else if (g instanceof Electronics) {
                Electronics e = (Electronics) g;
                System.out.println("Bao hanh (thang): " + e.getWarrantyMonths());
                System.out.println("Cong suat (KW): " + e.getCapacityKW());
            } else if (g instanceof Crockery) {
                Crockery c = (Crockery) g;
                System.out.println("Nha san xuat: " + c.getManufacturer());
                System.out.println("Ngay nhap kho: " + c.getArrivalDate());
            }
        }
    }
}