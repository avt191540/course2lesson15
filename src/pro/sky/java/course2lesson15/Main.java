package pro.sky.java.course2lesson15;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Для проверки
        int s1 = 11;
        int s2 = 22;
        int s3 = 33;
        int s4 = 44;
        int s5 = 55;
        int s6 = 66;
        int s7 = 77;

        IntegerList list = new IntegerListImpl();
        System.out.println("Добавлен в список - " + list.add(s1));
        System.out.println("Добавлен в список - " + list.add(s2));
        System.out.println("Добавлен в список - " + list.add(s3));
        System.out.println("Добавлен в список - " + list.add(s4));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("Добавлен в список по индексу 1: " + list.add(1, s5));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("По индексу: 2 установлен элемент: " + list.set(2, s6));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("Удален элемент: " + list.removeByValue(s6));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("Удален элемент с индексом: 2 - " + list.remove(2));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.contains(s5));
        System.out.println(list.indexOf(s3));
        System.out.println(list.lastIndexOf(s4));
        System.out.println(list.get(2));
    }
}
