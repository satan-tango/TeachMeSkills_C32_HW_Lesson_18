package com.varkovich.lesson_18.task_1;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Создать коллекцию класса ArrayList наполнить ее элементами рандомными элементами типа Integer.
 * С помощью Stream'ов:
 * - Удалить дубликаты
 * - Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
 * - Каждый элемент умножить на 2
 * - Отсортировать и вывести на экран первых 4 элемента
 * - Вывести количество элементов в стриме
 * - Вывести среднее арифметическое всех чисел в стриме
 */
public class ApplicationRunner {

    public static void main(String[] args) {
        List<Integer> numbers = new Random()
                .ints(5, 10)
                .limit(100)
                .boxed().
                toList();

        System.out.println("Source array -> " + numbers);
        numbers = numbers.stream()
                .distinct()
                .map(item -> item * 2)
                .collect(Collectors.toList());

        System.out.println("After distinct  and element * 2 -> " + numbers);

        System.out.print("Filter: even elements and 7 <= element <= 17 -> ");
        numbers.stream()
                .filter(k -> k % 2 == 0)
                .filter(k -> k >= 7 && k <= 17)
                .forEach(k -> System.out.print(k + " "));

        int elementsAmount = (int) numbers
                .stream()
                .count();
        System.out.println("\nAmount of elements -> " + elementsAmount);

        int arithmeticMean = numbers.stream()
                .reduce(0, Integer::sum) / 2;

        System.out.println("Arithmetic mean -> " + arithmeticMean);

    }
}
