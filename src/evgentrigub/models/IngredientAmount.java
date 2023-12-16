package evgentrigub.models;

public class IngredientAmount {
    public int waterQuantity;
    public int milkQuantity;
    public int beansQuantity;

    public IngredientAmount(int waterQuantity, int milkQuantity, int beansQuantity) {
        this.waterQuantity = waterQuantity;
        this.milkQuantity = milkQuantity;
        this.beansQuantity = beansQuantity;
    }
}
