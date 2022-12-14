import java.util.Scanner;

/**
 * QuickSort быстрая сортировка(метод Хоара})
 */

// Реализация быстрой сортировки
public class QuickSortHoar {

    // Точка входа. Отвечает за последовательность алгоритма.
    public static void main(String[] args) {
        System.out.println();
        int size = getValue("Введите длину массива: ");
        int[] arr = create(size);
        fill(arr);

        System.out.println();
        System.out.println("QuickSort быстрая сортировка");
        System.out.println();
        System.out.println("Несортированный массив");
        printArray(arr);
        System.out.println();

        quickSort(arr, 0, size - 1);

        System.out.println("Сортированный массив");
        printArray(arr);
    }

    // Отвечает за прием длины от пользователя
    static int getValue(String text) {
        Scanner input = new Scanner(System.in);
        System.out.println(text);
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        return size;
    }

    // Отвечает за создание массива заданной длины
    static int[] create(int count) {
        int array[] = new int[count];
        return array;
    }

    // Отвечает за заполнение массива рандомными значениями
    static void fill(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 40) - 10);
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return; //завершить выполнение, если длина массива равна 0

        if (low >= high)
            return; //завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            //меняем местами
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    // Отвечает за вывод
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}    