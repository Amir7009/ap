package ap.trainingCodes.quiz;

public class Book extends Product {

    private String name;

    public Book (String name, double price, double discount){
        this.name = name;
        super.setPrice(price);
        super.setDiscount(discount);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    public String getName() {
        return name;
    }

    @Override
    public double getDiscount() {
        return super.getDiscount();
    }
}
