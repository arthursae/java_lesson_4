package lesson4;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
        /*
          Реализовать консольное приложение, которое:
          1. Принимает от пользователя и “запоминает” строки.
          2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
          3. Если введено revert, удаляет предыдущую введенную строку из памяти.
          4. Если введено exit, то программа завершается

              > - ввод в консоль (stdin), < - вывод на консоль (stdout)
              > java
              > python
              > c#
              > print
              < [c#, python, java]
              > revert
              > print
              < [python, java]
              > revert
              > revert
              > print
              < []
              > revert -> throw new NoSuchElementException
        */

        Deque<String> storage = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();

            if ("exit".equals(command)) {
                System.out.println("Программа завершена");
                break;
            }

            if ("print".equals(command)) {
                if (storage.size() == 0) {
                    System.err.println("Список пуст");
                }
                else {
                    System.out.println(storage);
                }
                continue;
            }

            if ("revert".equals(command)) {
                if (storage.size() > 0) {
                    storage.pollFirst();
                }
                else {
                    System.err.println("Список пуст");
                }
                continue;
            }

            if (!command.isEmpty()) {
                storage.addFirst(command);
            }
        }
    }
}
