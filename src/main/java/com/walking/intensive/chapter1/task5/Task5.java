package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {

    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        if (isValidTriangle(a, b, c)) {
            double halfPerimeter = (a + b + c) / 2;
            return Math.sqrt((halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c)));
        }

        return -1;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (isValidTriangle(a, b, c)) {
            double height1 = getAreaByHeron(a, b, c) * 2 / a;
            double height2 = getAreaByHeron(a, b, c) * 2 / b;
            double height3 = getAreaByHeron(a, b, c) * 2 / c;

            double[] heights = {height1, height2, height3};
            Arrays.sort(heights);

            return heights;
        }

        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (isValidTriangle(a, b, c)) {
            double median1 = Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2)) / 2;
            double median2 = Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(c, 2) - Math.pow(b, 2)) / 2;
            double median3 = Math.sqrt(2 * Math.pow(b, 2) + 2 * Math.pow(c, 2) - Math.pow(a, 2)) / 2;

            double[] medians = {median1, median2, median3};
            Arrays.sort(medians);

            return medians;
        }

        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (isValidTriangle(a, b, c)) {
            double bisector1 = Math.sqrt((a * b * (a + b + c) * (a + b - c))) / (a + b);
            double bisector2 = Math.sqrt((a * c * (a + c + b) * (a + c - b))) / (a + c);
            double bisector3 = Math.sqrt((b * c * (b + c + a) * (b + c - a))) / (b + c);

            double[] bisectors = {bisector1, bisector2, bisector3};
            Arrays.sort(bisectors);

            return bisectors;
        }

        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (isValidTriangle(a, b, c)) {
            double cosineA = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);
            double angleRadiansA = Math.acos(cosineA);
            double angleDegreesA = Math.toDegrees(angleRadiansA);

            double cosineB = (Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c);
            double angleRadiansB = Math.acos(cosineB);
            double angleDegreesB = Math.toDegrees(angleRadiansB);

            double cosineC = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c);
            double angleRadiansC = Math.acos(cosineC);
            double angleDegreesC = Math.toDegrees(angleRadiansC);

            double[] angles = {angleDegreesA, angleDegreesB, angleDegreesC};
            Arrays.sort(angles);

            return angles;
        }

        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (isValidTriangle(a, b, c)) {
            double halfPerimeter = (a + b + c) / 2;
            return getAreaByHeron(a, b, c) / halfPerimeter;
        }

        return -1;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (isValidTriangle(a, b, c)) {
            return (a * b * c) / (4 * getAreaByHeron(a, b, c));
        }

        return -1;
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        if (isValidTriangle(a, b, c)) {
            double cosineA = (b * b + c * c - a * a) / (2.0 * b * c);
            double sineA = Math.sqrt(1 - cosineA * cosineA);

            return 0.5 * b * c * sineA;
        }

        return -1;
    }

    static boolean isValidTriangle(double a, double b, double c) {
        return ((a > 0 && b > 0 && c > 0) && (a + b > c && a + c > b && b + c > a));
    }
}
