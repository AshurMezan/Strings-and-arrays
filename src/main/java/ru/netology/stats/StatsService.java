package ru.netology.stats;

import org.jetbrains.annotations.NotNull;

// Комментарии делал для себя, чтобы не запутаться
public class StatsService {

    public int calculateSum(int @NotNull [] purchases) { // Здесь мы считаем сумму продаж
        int sum = 0; //Ноль потому что в будущем с этой переменной можно проводить любые операции
        for (int purchase : purchases) {
            sum += purchase;
        }
        return sum;
    }

    public double calculateAverageSum(int[] purchases) { // Здесь считается средняя сумма в месяц
        double sum = calculateSum(purchases); //Здесь вызываем метод вычисления суммы продаж
        double averageSum = sum / purchases.length;
        return averageSum;
    }

    public int calculateMaxMonth(int @NotNull [] purchases) {  // Здесь считаю максимальные продажи
        int maxMonth = 0;
        for (int i = 1; i < purchases.length; i++) {

            if (purchases[maxMonth] <= purchases[i]) {
                maxMonth = i;
            }
        }

        maxMonth += 1;
        return maxMonth;
    }

    public int calculateMinMonth(int @NotNull [] purchases) { // Здесь указан номер месяца с максимальными продажами
        int minMonth = 0;
        for (int i = 1; i < purchases.length; i++) {
            if (purchases[minMonth] >= purchases[i]) {
                minMonth = i;
            }
        }
        minMonth += 1;
        return minMonth;
    }

    public int calculateCounterUnderAverage(int[] purchases) { // Здесь находим количество месяцев, когда продаж меньше среднего
        int counter = 0;
        double averageSum = calculateAverageSum(purchases);
        for (int purchase : purchases) {
            if (purchase < averageSum) {
                counter += 1;
            }
        }
        return counter;
    }

    public int calculateCounterUpperAverage(int[] purchases) { // Здесь считаем количество месяцев, когда продаж больше среднего
        int counter = 0;
        double averageSum = calculateAverageSum(purchases);
        for (int purchase : purchases) {
            if (purchase > averageSum) {
                counter += 1;
            }
        }
        return counter;
    }
}