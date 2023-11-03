package Sem3;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Freelancer extends BaseWorker {
    /**
     * Часовая заработная ставка работника.
     */
    private final BigDecimal salaryRateOfHour;

    /**
     * Закрытый конструктор работника со свободным графиком работы.
     *
     * @param name             ФИО работника.
     * @param dateOfBirth      дата рождения работника.
     * @param salaryRateOfHour заработная ставка.
     */
    private Freelancer(String name, LocalDate dateOfBirth, BigDecimal salaryRateOfHour) {
        super(name, dateOfBirth);
        this.salaryRateOfHour = salaryRateOfHour;
    }

    /**
     * Метод создания нового работника со свободным графиком работы,
     * содержит логику проверки корректности вводимых данных.
     *
     * @param name             ФИО не менее трех символов.
     * @param dateOfBirth      дата рождения с ограничением не старше 70 и не младше 18 лет.
     * @param salaryRateOfHour заработная ставка, не может быть равной 0 или отрицательной.
     * @return объект работника.
     * @throws CreateWorkerExceptions собственное исключение при подаче некорректных данных.
     */
    public static Freelancer createFreelancer(String name, LocalDate dateOfBirth, BigDecimal salaryRateOfHour)
            throws CreateWorkerExceptions {
        if (name.length() < 3) throw new CreateWorkerExceptions("Не корректное ФИО сотрудника!");
        if (dateOfBirth.isBefore(maxYearOfBirth) || dateOfBirth.isAfter(minYearOfBirth))
            throw new CreateWorkerExceptions("Не корректное возраст сотрудника");
        if (salaryRateOfHour.compareTo(new BigDecimal(0)) <= 0)
            throw new CreateWorkerExceptions("Не корректное зарплатная ставка!");
        return new Freelancer(name, dateOfBirth, salaryRateOfHour);
    }

    /**
     * Метод расчета з/п работника
     * @return з/п
     */
    @Override
    public BigDecimal calculationPayment() {
        return salaryRateOfHour.multiply(new BigDecimal("20.8")).multiply(new BigDecimal(8));
    }

    @Override
    public String toString() {
        return String.format("Freelancer: %s, %s года рождения, Заработная плата: %s руб.",
                name, dateOfBirth, this.calculationPayment());
    }
}