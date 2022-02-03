package pro.sky.java.course2lesson15;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList{

    private int lengthArray = 10;
    private int[] list;
    private int size = 0;

    public IntegerListImpl() {
        list = new int[lengthArray];
    }

    @Override
    public int add(int item) {
        if (item < 0) {
            throw new InvalidInputData();
        }
        list[size] = item;
        size++;
        if (size == lengthArray) {
            int[] timeArray = new int[(lengthArray += 10)];
            System.arraycopy(list, 0, timeArray, 0, size);
            list = timeArray;
        }
        return list[(size - 1)];
    }

    @Override
    public int add(int index, int item) {
        if (index < 0 || index >= size || item < 0) {
            throw new InvalidInputData();
        }
        int[] temporaryArray = new int[lengthArray];
        System.arraycopy(list, index, temporaryArray, (index + 1), (size - index));
        temporaryArray[index] = item;
        System.arraycopy(list, 0, temporaryArray, 0, index);
        list = temporaryArray;
        size++;
        if (size == lengthArray) {
            int[] timeArray = new int[(lengthArray += 10)];
            System.arraycopy(list, 0, timeArray, 0, size);
            list = timeArray;
        }
        return list[index];
    }

    @Override
    public int set(int index, int item) {
        if (index < 0 || index >= size || item < 0) {
            throw new InvalidInputData();
        }
        list[index] = item;
        return list[index];
    }

    @Override
    public int removeByValue(int item) {
        if (item < 0) {
            throw new InvalidInputData();
        }
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                while (i < (size - 1)) {
                    list[i] = list[(i + 1)];
                    i++;
                }
                list[(size - 1)] = 0;
                size--;
                return item;
            }
        }
        throw new ArgumentNotFoundException();
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidInputData();
        }
        int item = list[index];
        while (index < (size - 1)) {
            list[index] = list[(index + 1)];
            index++;
        }
        list[(size - 1)] = 0;
        size--;
        return item;
    }

    @Override
    public boolean contains(int item) {
        if (item < 0) {
            throw new InvalidInputData();
        }
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int item) {
        if (item < 0) {
            throw new InvalidInputData();
        }
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        if (item < 0) {
            throw new InvalidInputData();
        }
        for (int i = (size - 1); i >= 0; i--) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidInputData();
        }
        return list[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(list, otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        lengthArray = 10;
        size = 0;
        list = new int[lengthArray];
    }

    @Override
    public int[] toArray() {
        int[] timeArray = new int[lengthArray];
        System.arraycopy(list, 0, timeArray, 0, size);
        return timeArray;
    }
}
