package model;

public class Product {
    private int id;
    private String name;
    private double price;
    private ItemType itemType;
    private int quantitySold;

    public Product() {
    }

    public Product(int id, String name, double price, ItemType itemType, int quantitySold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.itemType = itemType;
        this.quantitySold = quantitySold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    @Override
    public String toString() {
        return "model.Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", itemType=" + itemType.getValue() +
                ", quantitySold=" + quantitySold +
                '}';
    }
}
