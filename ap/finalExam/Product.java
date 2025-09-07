package ap.finalExam;

import java.util.Objects;

public class Product implements Comparable<Product> {

    private ProductType productName;
    private long price;

    public Product(ProductType productName, long price) {

        this.productName = productName;
        this.price = price;

    }

    @Override
    public int compareTo(Product otherProduct) {

        int priceCompare = Long.compare(this.price, otherProduct.price);

        if (priceCompare != 0){
            return priceCompare;
        }

        if (this.productName != otherProduct.productName)
            return (this.productName == ProductType.BOOK)? -1 : 0;
        else return priceCompare;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && productName == product.productName && this.toString().equals(product.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }

    public ProductType getProductName() {
        return productName;
    }

    public long getPrice() {
        return price;
    }

}
