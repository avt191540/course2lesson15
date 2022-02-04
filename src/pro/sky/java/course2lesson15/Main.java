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

//Генерация массива для выявления самой быстрой сортировки
        int[] arrayTest = new int[100000];
        for (int i = 0; i < arrayTest.length; i++)     {
            arrayTest[i] = (int)Math.round(Math.random() * 100000);
        }
        int[] arrayTestCopy1 = Arrays.copyOf(arrayTest, 99000);
        int[] arrayTestCopy2 = Arrays.copyOf(arrayTest, 99000);
        int[] arrayTestCopy3 = Arrays.copyOf(arrayTest, 100000);

//Сравнение сортировок по времени
        long start = System.currentTimeMillis();
        sortBabble(arrayTestCopy1);
        System.out.println("Time by sortBubble = " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        sortSelection(arrayTestCopy2);
        System.out.println("Time by sortSelection = " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        sortInsertion(arrayTestCopy3);
        System.out.println("Time by sortInsertion = " + (System.currentTimeMillis() - start));

        // Вызов переработанного метода contains,
        // который использует быструю сортировку и метод бинарного поиска
        System.out.println("Результат поиска в списке элемента: " + s3 + " - " + list.containsBinary(s3));

    }

    // Три метода сортировки массива
    public static void swapElements(int[] arr, int indexA, int indexB)  {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    public static void sortBabble(int[] arr)     {
        for (int i = 0; i < arr.length - 1; i++)    {
            for (int j = 0; j < arr.length - 1 - i; j++)    {
                if (arr[j] > arr[j + 1])    {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)   {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++)   {
                if (arr[j] < arr[minElementIndex])    {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortInsertion(int[] arr)   {
        for (int i = 1; i < arr.length; i++)   {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp)   {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

}
