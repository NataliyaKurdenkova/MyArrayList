import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] arrayValues;

    public ArrayIterator(E[] arrayValues) {
        this.arrayValues = arrayValues;
    }

    @Override
    public boolean hasNext() {
        return index< arrayValues.length;
    }

    @Override
    public E next() {
        return arrayValues[index++];
    }

}
