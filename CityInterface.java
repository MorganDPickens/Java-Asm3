package HW3Arrays;                                                                                                             // Morgan Pickens  5/27/2024
                                              // our Hw03 interface that was given for class
import java.util.Iterator;

public interface CityInterface<E> {
    public int getSize();
    public E get(int position);
    public void add(E value);
    public void addFront(E value);
    public void addSorted(E value);
    public int indexOf(E e);
    public boolean remove(E value);
    public void remove(int position);
    public boolean isEmpty();
    public Iterator<E> iterator();
}
