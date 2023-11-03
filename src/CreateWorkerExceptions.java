package Sem3;

public class CreateWorkerExceptions extends Exception {
    /**
     * Конструктор класса исключения, вызывает родительский конструктор класса RuntimeException
     * и передает в него сообщение для пользователя.
     *
     * @param message сообщение для пользователя.
     */
    public CreateWorkerExceptions(String message) {
        super(message);
    }
}

