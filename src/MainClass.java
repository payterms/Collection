/*
 * Created by MVG
 * (C) 2019 Moscow, Russia
 * */

import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        /*
         * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать, сколько раз встречается каждое слово.
         *
         * */
        String[] stringArray = {"AAAA", "ABBA", "ABAA", "AABA", "AAAA", "AABB", "AAAA", "BAAB", "AAAA", "BABB", "AABB", "AAAA", "BAAB", "AAAA", "BABB"};

        // Задание 1 .Вариант 1. Через ArrayList
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<Integer> counterList = new ArrayList<>();// список для хранения счетчиков
        // копируем в динамический массив
        for (int i = 0; i < stringArray.length; i++) {
            stringList.add(stringArray[i]);
        }
        int counter = 0;
        // анализируем на предмет повторов
        for (int i = 0; i < stringList.size(); i++) {
            counter = 1;
            for (int j = i + 1; j < stringList.size(); j++) {
                if (stringList.get(j).equals(stringList.get(i))) {
                    stringList.remove(j);   // удаляем повтор из списка
                    counter++;              // увеличиваем счетчик повтор для данного элемента
                }
            }
            counterList.add(i, counter);
            System.out.println(String.format("Элемент %s встречается %d раз(а)", stringList.get(i), counter));
        }

        // Задание 1 . Вариант 2. Через HashMap
        Map<String, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < stringArray.length; i++) {
            Integer counterForElement = stringMap.get(stringArray[i]);
            stringMap.put(stringArray[i], counterForElement == null ? 1 : counterForElement + 1);
        }
        System.out.println(stringMap);

        // Задание 2.
        PhoneBook testBook = new PhoneBook();

        testBook.add("Bond", "+1 123 456789");
        testBook.add("Bond", "+1 123 456780");
        testBook.add("Bush", "+1 123 456781");
        testBook.add("Bush", "+1 123 456781");
        testBook.add("Bush", "+1 123 456782");

        System.out.println("Bond:" + testBook.get("Bond"));
        System.out.println("Bush:" + testBook.get("Bush"));

    }
}



