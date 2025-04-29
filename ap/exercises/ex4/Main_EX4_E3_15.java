package ap.exercises.ex4;

public class Main_EX4_E3_15 { // LetterPrinter

    public static void main(String[] args) {

        Letter l = new Letter("John", "Mary" );

        l.addLine("I am sorry we must part.");
        l.addLine("I wish you all the best.");

        System.out.println(l.getText());

    }

}

class Letter {

    private String to, letter = "Dear ";

    public Letter(String from, String to){

        letter = letter.concat(from + ":\n\n");
        this.to = to;

    }

    public void addLine(String line){

        letter = letter.concat(line).concat("\n");

    }

    public String getText(){

        return letter.concat("\nSincerely,\n\n" + to);

    }

}
