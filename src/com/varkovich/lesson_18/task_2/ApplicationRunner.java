package com.varkovich.lesson_18.task_2;

import com.varkovich.lesson_18.task_2.model.Student;

import java.util.*;

/**
 * Создать коллекцию класса ArrayList со значениями имен всех студентов в группе
 * С помощью Stream'ов:
 * - Выбрать все имена, начинающиеся на любую букву, введенную с консоли (вне зависимости от верхнего/нижнего регистра букв)
 * - Отсортировать и вернуть первый элемент коллекции
 */
public class ApplicationRunner {

    public static void main(String[] args) {
        List<Student> students = fillListByStudents();
        System.out.println("Students ->" + students);

        boolean isCorrectInputByUser = false;
        LetterWrapper letter = new LetterWrapper();

        for (; ; ) {
            if (isCorrectInputByUser) {
                break;
            }

            System.out.print("Enter the letter -> ");
            letter.value = getLetterFromUser();

            if (letter.value.length() != 1) {
                System.out.println("Incorrect input, it must be a letter.");
                continue;
            }

            if (Character.isLetter(letter.value.charAt(0))) {
                isCorrectInputByUser = true;
            } else {
                System.out.println("Incorrect input, it must be a letter.");
            }
        }

        Optional<Student> result = students.stream()
                .filter(k -> k.getName().toLowerCase().charAt(0) == letter.value.toLowerCase().charAt(0))
                .sorted(Comparator.comparing(Student::getName))
                .findFirst();

        if (result.isPresent()) {
            System.out.println("Result -> " + result.get());
        } else {
            System.out.println("There is no such student");
        }
    }

    private static class LetterWrapper {
        String value;
    }

    public static List<Student> fillListByStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Dmitriy"));
        students.add(new Student("Ilya"));
        students.add(new Student("Bogdan"));
        students.add(new Student("Igor"));
        students.add(new Student("Marina"));
        students.add(new Student("Daniil"));
        students.add(new Student("Sultan"));
        students.add(new Student("Georgi"));
        students.add(new Student("Kirill"));
        students.add(new Student("Kate"));
        students.add(new Student("Dmitry"));
        students.add(new Student("Rita"));
        students.add(new Student("Vlad"));
        students.add(new Student("Sergio"));
        students.add(new Student("Oleg"));

        return students;
    }

    public static String getLetterFromUser() {
        Scanner console = new Scanner(System.in);

        return console.next();
    }

}
