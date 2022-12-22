package org.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        reversList();
//        newList();
        cancelTheLastOperation();
    }

    /**
     * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
     */
    private static void reversList(){
        LinkedList<Integer> listNumberRevers = new LinkedList<>();
        LinkedList<Integer> listNumber = newListNumber(0, 10);

        for (int i = listNumber.size()-1; i >= 0; i--) {
            listNumberRevers.add(listNumber.get(i));
        }

        printList(listNumber, listNumberRevers);
    }
    private static void printList(LinkedList<Integer> listNumber , LinkedList<Integer> listNumberRevers) {
        System.out.println("Before: " + listNumber);
        System.out.println("After: " + listNumberRevers);
    }

    private static LinkedList<Integer> newListNumber(int min, int max){
        LinkedList<Integer> listNumber = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            listNumber.add(randInt(min, max));
        }
        return listNumber;
    }

    private static int randInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * 2. Реализуйте очередь с помощью LinkedList со следующими методами:
     * enqueue() - помещает элемент в конец очереди,
     * dequeue() - возвращает первый элемент из очереди и удаляет его,
     * first() - возвращает первый элемент из очереди, не удаляя.
     */
    private static void newList() {
        Deque<Integer> list = newListNumber(11, 33);
        printList(list);
    }

    private static void printList( Deque<Integer> list) {
        System.out.println("Before: " + list);
        System.out.println();
        enqueue(101, list);
        System.out.println("Enqueue 101 :" + list);
        System.out.println();
        System.out.println("First elm: " + dequeue(list));
        System.out.println("Dequeue first elm: " + list);
        System.out.println();
        System.out.println("First elm: " + peekFirst(list));
        System.out.println("Peek First: " + list);
    }

    private static void enqueue(int elm, Deque<Integer> list){
        list.addLast(elm);
    }

    private static int dequeue(Deque<Integer> list) {;
        return list.pollFirst();
    }

    private static int peekFirst(Deque<Integer> list) {
        return list.peekFirst();
    }

    /**
     * 3. В калькулятор добавьте возможность отменить последнюю операцию.
     */


    private static void cancelTheLastOperation() {
        Deque<Integer> queue = new LinkedList<>();
        boolean flag = true;
        while (flag) {
            int num = calculator();
            queue.addLast(num);
            System.out.println(queue);
            System.out.println("Для отмены действия введите 'отмена'");
            System.out.println("Для выхода из калькулятора введите 'выход'");
            Scanner scanner = new Scanner(System.in);
            String back = scanner.next();

            if (back.equals("отмена")) {
                queue.pollFirst();
            }
            if (back.equals("выход")) {
                flag = false;
            }
        }
    }
    public static int calculator() {
        System.out.print("Введите число а: ");
        Scanner Number = new Scanner(System.in);
        int a = Number.nextInt();

        System.out.print("Введите действие (+,-,*,/): ");
        char c = Number.next().charAt(0);

        System.out.print("Введите число b: ");
        int b = Number.nextInt();

        if(c == '+') {
            String str = String.format("%d + %d = %d", a, b, (a+b));
            System.out.println(str);
            return a+b;
        } else if (c == '-') {
            String str = String.format("%d - %d = %d", a, b, (a-b));
            System.out.println(str);
            return a-b;
        } else if (c == '*') {
            String str = String.format("%d * %d = %d", a, b, (a*b));
            System.out.println(str);
            return a*b;
        } else if (c == '/') {
            String str = String.format("%d / %d = %d", a, b, (a/b));
            System.out.println(str);
            return a/b;
        } else {
            String str = "Ошибка ввода";
            System.out.println(str);
            return 0;
        }
    }


}