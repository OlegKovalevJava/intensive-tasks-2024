package com.walking.intensive.chapter1.task1;

/**
 * Реализуйте метод getAgeString(), который будет принимать параметром целое число (возраст) и возвращать строку
 * вида: "Вам N лет". Программа должна учитывать правила русского языка.
 *
 * <p>Пример верного исполнения кода: "Вам 5 лет", "Вам 4 года".
 * Пример неверной работы программы: "Вам 14 года".
 *
 * <p>Также необходимо учесть негативные сценарии. Например, попытку передать в метод невалидное значение - например,
 * отрицательное число. В таких случаях ожидается, что метод вернет строку "Некорректный ввод".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task1 {
    public static void main(String[] args) {

        int age = -1;
        int age1 = 0;
        int age2 = 4;
        int age3 = 5;
        int age4 = 14;
        int age5 = 11;

        System.out.println(getAgeString(age));
        System.out.println(getAgeString(age1));
        System.out.println(getAgeString(age2));
        System.out.println(getAgeString(age3));
        System.out.println(getAgeString(age4));
        System.out.println(getAgeString(age5));

    }

    static String getAgeString(int age) {

        if (age < 0) {
            return "Некорректный ввод";
        }

        int firstNumber = age % 10;
        int secondNumber = age % 100;

        if (firstNumber == 1 && secondNumber != 11) {
            return "Вам " + age + " год";
        }

        if ((firstNumber > 1) && (firstNumber <= 4) && ((secondNumber < 12) || (secondNumber > 14))) {
            return "Вам " + age + " года";
        }

        return "Вам " + age + " лет";
    }
}
