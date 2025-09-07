package ap.finalExam;

public class Pen extends Product {

    private Color color;

    public Pen(ProductType productName, long price, Color color) {

        super(productName, price);

        this.color = color;

    }

    public String toString() {

        return "Pen{" +
                "color='" + color + '\'' +
                '}';

    }

}
