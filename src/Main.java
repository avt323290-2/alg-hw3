import java.util.Random;
import java.util.Scanner;

/**
 * Класс представляет узел связного списка.
 */
class Node {
    int data;
    Node next;

    /**
     * Конструктор для создания узла списка с заданным значением.
     *
     * @param data значение узла
     */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Класс представляет односвязный связный список.
 */
class LinkedList {
    Node head;

    /**
     * Метод добавляет новый узел с заданным значением в конец списка.
     *
     * @param data значение нового узла
     */
    public void append(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        } else {
            Node last_node = head;
            while (last_node.next != null) {
                last_node = last_node.next;
            }
            last_node.next = new_node;
        }
    }

    /**
     * Метод выводит элементы списка в консоль.
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Метод разворачивает список.
     */
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node nextNode;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов в списке: ");
        int count = scanner.nextInt();

        LinkedList linkedList = new LinkedList();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int value = random.nextInt(100); // Генерация случайного числа от 0 до 99
            linkedList.append(value);
        }

        System.out.println("Исходный список:");
        linkedList.printList();

        linkedList.reverse();

        System.out.println("Развернутый список:");
        linkedList.printList();
    }
}
