package ap.trainingCodes.quiz;

public class Pen extends Product{

    private String brand;
    private Color color;

    public Pen (String brand, double price, Color color, double discount){

        this.brand = brand;
        this.color = color;
        super.setPrice(price);
        super.setDiscount(discount);

    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    public Color getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public double getDiscount() {
        return super.getDiscount();
    }
}
