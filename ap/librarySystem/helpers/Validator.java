package ap.librarySystem.helpers;

public class Validator {

    public static boolean Validate(String value, String condition) {

        return (value.matches(condition));

    }

}
