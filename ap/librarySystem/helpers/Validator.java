package ap.librarySystem.helpers;

public class Validator {

    public boolean Validate(String value, String condition) {

        return (value.matches(condition));

    }

}
