
import java.util.*;
//Необходимо написать свою реализацию коллекции на выбор LinkedList или ArrayList(можно оба варианта).
// Должны быть основные методы add, get, remove, addAll, остальное на ваше усмотрение
//Плюс написать реализацию сортировки пузырьком с флагом, который прекращает сортировку, если коллекция уже отсортирована.

//Задание с *: На тему дженериков.
// Для этих коллекций сделать конструктор который будет принимать другую коллекцию
// в качестве параметров и инициализироваться с элементами из этой коллекции.
// Вторая часть - сделать метод сортировки статическим, этот метод также будет принимать какую-то коллекцию и сортировать ее.
// (Аналогия Collections.sort()). Т.е подумать на тему какое ключевое слово(extends или super) будет лучше применить для этих двух задач.

public class MyArrayListImpl<E> implements MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 3;
    private int currentCapacity;
    private int size;
    private E[] arrays;
    private int currentIndex;

    public MyArrayListImpl() {
        currentCapacity = DEFAULT_CAPACITY;
        this.arrays = (E[]) new Object[currentCapacity];
        this.size = 0;
        this.currentIndex = 0;
    }

    public MyArrayListImpl(Collection<? extends E> collection) {
        currentCapacity = DEFAULT_CAPACITY;
        this.arrays = (E[]) collection.toArray();
        this.size = collection.size();
        this.currentIndex = collection.size();
    }

    @Override
    public void add(E element) {
        if (currentIndex >= currentCapacity) {
            currentCapacity = grow();
            E[] arraysNew = Arrays.copyOf(arrays, currentCapacity);
            arrays = arraysNew;
        }
        arrays[currentIndex++] = element;
        size++;

    }

    @Override
    public void add(int index, E element) {
        set(index, element);
    }

    @Override
    public void remove(int index) {
        if (index < arrays.length && index >= 0) {
            arrays[index] = null;
            size--;
        } else throw new IndexOutOfBoundsException("Используется недопустимый индекс");

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, E element) {
        if (index < arrays.length && index >= 0) {
            if (arrays[index] == null) size++;
            arrays[index] = element;

        } else throw new IndexOutOfBoundsException("Используется недопустимый индекс");
    }

    @Override
    public void addAll(Collection<? extends E> collection) {
        if (!collection.isEmpty()) {
            Object[] c = collection.toArray();
            for (Object e : c) {
                add((E) e);
            }
        }
    }


    @Override
    public E get(int index) {
        if (index < arrays.length && index >= 0) {
            return arrays[index];
        } else
            throw new IndexOutOfBoundsException("Используется недопустимый индекс");

    }

    @Override
    public int grow() {
        return (int) (currentCapacity * 1.75);
    }

    @Override
    public void clear() {
        arrays = null;
        size = 0;
        currentIndex = 0;
    }


    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(arrays);
    }

    @Override
    public String toString() {
        return Arrays.toString(arrays);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        Arrays.sort(arrays, 0, size(), c);
    }

    public static <E> void sort(MyArrayList<E> list, Comparator<? super E> c) {
        list.sort(c);
    }

    @Override
    public void bubbleSort() {
        int j;
        boolean flag = true;
        E temp;

        while (flag) {
            flag = false;
            for (j = 0; j < arrays.length - 1; j++) {
                if ((int) (arrays[j]) > (int) arrays[j + 1]) {
                    temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                    flag = true;
                }
            }
        }

    }

}