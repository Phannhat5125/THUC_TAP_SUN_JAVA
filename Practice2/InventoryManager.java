package Practice2;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Goods> goodsList;

    public InventoryManager() {
        goodsList = new ArrayList<>();
    }

    public boolean addGoods(Goods goods) {
        for (Goods g : goodsList) {
            if (g.getProductCode().equals(goods.getProductCode())) {
                return false; // Duplicate product code
            }
        }
        goodsList.add(goods);
        return true;
    }

    public int getQuantityByType(Class<?> type) {
        int total = 0;
        for (Goods g : goodsList) {
            if (type.isInstance(g)) {
                total += g.getQuantity();
            }
        }
        return total;
    }

    public double getTotalVATByType(Class<?> type) {
        double total = 0;
        for (Goods g : goodsList) {
            if (type.isInstance(g)) {
                total += g.getVATAmount();
            }
        }
        return total;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }
}