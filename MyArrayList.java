import java.util.Collection;
import java.util.Comparator;

public interface MyArrayList<E> extends Iterable<E> {
    void add(E element);

    void add(int index, E element);

    void remove(int index);

    int size();

    void set(int index, E e);

    void addAll(Collection<? extends E> collection);

    E get(int index);

    int grow();

    void clear();

    void sort(Comparator<? super E> c);

    void bubbleSort();

}
