import java.util.Scanner;

/**
 * QuickSort быстрая сортировка
 */

// Реализация быстрой сортировки
public class QuickSort {

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

    // Функция меняет элементы местами
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * Эта функция принимает последний элемент в качестве PIVOT,
     * помещает этот элемент на свое место в массиве. А далее размещает элементы
     * ниже PIVOT - слева, а выше - справа.
     */
    static int partition(int[] arr, int low, int high) {

        // PIVOT
        int pivot = arr[high];

        // Индекс меньшего элемента из найденных до сих пор позиций
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // Если текущий элемент меньше чем PIVOT
            if (arr[j] < pivot) {

                // Увеличиваем индекс меньшего элемента
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /*
     * Основная функция реализаующая быструю сортировку(рекурсия)
     * arr[] --> Массив для сортировки
     * low --> начальный index
     * high --> конечный index
     */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi - PIVOT встает на своем место
            int pi = partition(arr, low, high);

            // Сортировка элементов до и после замены
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Отвечает за вывод
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}