package ap.exercises.ex4;

public class Main_EX4_E3_10 { // CashRegister

    private double totalPrice = 0;
    private String receipt = "Receipt:\n";

    public void addPurchasedItems(double price){

        totalPrice += price;
        receipt = receipt.concat(String.valueOf(price)).concat("\n");

    }

    public void printReceipt (){

        System.out.println(receipt);
        System.out.println("Total price: " + totalPrice);

    }

}
