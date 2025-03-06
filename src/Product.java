public class Product {
    String name;
    int price;
    ProductType productType;

    public Product(String name, int price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public ProductType getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", productType=" + productType +
                '}';
    }
}
