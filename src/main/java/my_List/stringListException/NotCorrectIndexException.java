package my_List.stringListException;

public class NotCorrectIndexException extends RuntimeException {
    public NotCorrectIndexException(String message) {
        super(message);
    }
}
