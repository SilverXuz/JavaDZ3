import java.util.Scanner;

/**
 * HeapSort сортировка кучей(пирамидальная)
 */

// Реализация пирамидальной сортировки на Java
public class HeapSort {
    
    // Точка входа. Отвечает за последовательность алгоритма.
    public static void main(String[] args) {
        System.out.println();
        int size = getValue("Введите длину массива: ");
        int[] arr = create(size);
        fill(arr);

        System.out.println();
        System.out.println("HeapSort сортировка кучей(пирамидальная)");
        System.out.println();
        System.out.println("Несортированный массив");
        printArray(arr);
        System.out.println();

        HeapSort ob = new HeapSort();
        ob.sort(arr);

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

    // Отвечает за сортировку
    public void sort(int arr[]) {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи   
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
    // индексом в arr[]. n - размер кучи
    void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

           // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

          // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
       // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

          // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }

    // Отвечает за вывод
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}