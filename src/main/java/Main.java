import java.util.Scanner;
import java.lang.Math;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        int taxEarnings;
        int taxEarningsMinusSpendings;
        int differenceTax;
        while (true) {
            System.out.println("""
                    1. Добавить новый доход
                    2. Добавить новый расход
                    3. Выбрать систему налогооблажения""");

            String input = scanner.next();
            if (!input.isEmpty()) {
                if ("end".equals(input)) {
                    break;
                }
                int inputInt = Integer.parseInt(input.trim());

                switch (inputInt) {
                    case 1 -> {
                        System.out.println("Введите сумму дохода: ");
                        int earning = scanner.nextInt();
                        earnings = earnings + earning;
                        System.out.println(earnings);

                    }
                    case 2 -> {
                        System.out.println("Введите сумму расхода: ");
                        int spending = scanner.nextInt();
                        spendings = spendings + spending;
                        System.out.println(spendings);


                    }
                    case 3 -> {
                        taxEarnings = taxEarnings(earnings);
                        taxEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);
                        differenceTax = differenceTax(taxEarnings, taxEarningsMinusSpendings);
                        if (taxEarnings < taxEarningsMinusSpendings) {
                            System.out.println("Мы советуем вам УСН доходы\n" +
                                    "Ваш налог составит:" + taxEarnings + "рублей \n" +
                                    "Налог на другой системе:" + taxEarningsMinusSpendings + "рублей \n" +
                                    "Экономия:" + differenceTax + "рублей");
                        }
                        if (taxEarnings > taxEarningsMinusSpendings) {
                            System.out.println("Мы советуем вам УСН доходы минус расходы\n" +
                                    "Ваш налог составит:" + taxEarningsMinusSpendings + "рублей \n" +
                                    "Налог на другой системе:" + taxEarnings + "рублей \n" +
                                    "Экономия:" + differenceTax + "рублей");
                        }
                    }
                    default -> System.out.println("Такой операции нет");
                }

            }

        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;

    }
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        return Math.max(tax, 0);
    }

    public static int differenceTax(int taxEarnings, int taxEarningsMinusSpendings) {
        return Math.abs(taxEarnings - taxEarningsMinusSpendings);
    }
}

