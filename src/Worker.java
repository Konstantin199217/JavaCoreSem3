package Sem3;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Worker extends BaseWorker {

    /**
     * Месячная заработная ставка работника.
     */
    private final BigDecimal salaryRateOfMonth;

    /**
     * Конструктор абстрактного класса.
     *
     * @param name              ФИО работника.
     * @param dateOfBirth       дата рождения работника.
     * @param salaryRateOfMonth Месячная заработная ставка работника.
     */
    protected Worker(String name, LocalDate dateOfBirth, BigDecimal salaryRateOfMonth) {
        super(name, dateOfBirth);
        this.salaryRateOfMonth = salaryRateOfMonth;
    }

    public static Worker createWorker(String name, LocalDate dateOfBirth, BigDecimal salaryRate)
            throws CreateWorkerExceptions {
        if (name.length() < 3) throw new CreateWorkerExceptions("Не корректное ФИО сотрудника!");
        if (dateOfBirth.isBefore(maxYearOfBirth) || dateOfBirth.isAfter(minYearOfBirth))
            throw new CreateWorkerExceptions("Не корректное возраст сотрудника");
        if (salaryRate.compareTo(new BigDecimal(0)) <= 0)
            throw new CreateWorkerExceptions("Не корректное зарплатная ставка!");
        return new Worker(name, dateOfBirth, salaryRate);
    }

    /**
     * Метод расчета з/п работника
     * @return з/п
     */
    @Override
    public BigDecimal calculationPayment() {
        return salaryRateOfMonth;
    }
    @Override
    public String toString() {
        return String.format("Работник: %s, %s года рождения, Заработная плата: %s руб.",
                name, dateOfBirth, this.calculationPayment());
    }
}
