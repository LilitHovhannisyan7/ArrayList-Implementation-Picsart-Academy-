public interface MyList<E>
{
    int size();

    boolean isEmpty();

    boolean add(E element);

    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    boolean remove(E element);

    E remove(int index);

    boolean contains(E element);

    int indexOf(E element);

    int lastIndexOf(E element);

    void clear();

    E[] toArray();

    <T> T[] toArray(T[] array);

    MyList<E> subList(int fromIndex, int toIndex);

    boolean removeAll(MyList<?> otherList);

    boolean retainAll(MyList<?> otherList);

    boolean containsAll(MyList<?> otherList);

    boolean addAll(MyList<? extends E> otherList);

    boolean addAll(int index, MyList<? extends E> otherList);

    boolean equals(Object obj);

    int hashCode();

    String toString();

    int capacity();
}

