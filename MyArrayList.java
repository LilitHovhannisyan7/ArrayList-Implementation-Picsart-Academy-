import java.util.Objects;


class WrongIndexException extends RuntimeException
{
    WrongIndexException()
    {
        System.out.println("Wrong index");
    }
}

class WrongElementException extends RuntimeException
{
    WrongElementException()
    {
        System.out.println("Wrong element");
    }
}

class WrongListException extends RuntimeException
{
    WrongListException()
    {
        System.out.println("Wrong list");
    }
}
public class MyArrayList <E> implements MyList<E>
{
    private E [] arr;
    private int size = 0;
    private int capacity = 10;

    public MyArrayList(E [] arr)
    {
        this.arr = (E[])new Object[this.capacity];
        for(int i = 0; i < arr.length; ++i)
        {
            this.arr[i] = arr[i];
        }
        this.size = arr.length;
    }


    public MyArrayList()
    {
        this.capacity = 10;
        this.arr = (E[])new Object[this.capacity];
        this.size = 0;
    }

    @Override
    public boolean add(E element)
    {
        if(this.size == this.capacity)
        {
            this.capacity = this.capacity * 2;
            E [] newArr = (E[]) new  Object [this.capacity];
            for(int i = 0; i < this.size; ++i)
            {
                newArr[i] = this.arr[i];
            }
            this.arr = newArr;
        }
        this.arr[this.size] = element;
        ++this.size;
        return true;

    }


    @Override
    public void add(int index, E element)
    {

        if(index < 0 || index >= this.size)
        {
            throw new WrongIndexException();
        }
        if(this.size == this.capacity)
        {
            this.capacity = this.capacity * 2;
            E [] newArr = (E[]) new Object [this.capacity];
            for(int i = 0; i < this.size; ++i)
            {
                newArr[i] = this.arr[i];
            }
            this.arr = newArr;
        }

        /* 1st solution
        for(int i = 0; i < this.size; ++i)
        {
            if(i == index)
            {

                for(int j = this.size - 2; j >= index; --j)
                {
                    int temp = arr[j + 1];                     // 7 8 9 4 1
                    arr[j + 1] = arr[j];                       // 7 8 9 4 0 1
                    arr[j] = temp;                             // 7 8 9 0 4 1
                                                               // 7 8 0 9 4 1
                }                                              // 7 0 8 9 4 1
                                                               // 7 17 8 9 4 1

                this.arr[index] = element;
                break;
            }
        }
        ++this.size;
        */

        //2nd Solution
        int newSize = this.size + 1;
        E [] arr1 = (E[]) new Object [newSize];
        int i = 0;
        int j = 0;
        for(; i < index; ++i)
        {
            arr1[j] = this.arr[i];
            ++j;

        }

        arr1[index] = (E) element;
        j = index + 1;
        for(; j < newSize; ++j)
        {
            arr1[j] = this.arr[i];
            ++i;
        }

        this.arr = arr1;
        this.size = newSize;


    }

    public E get(int index)
    {
        if(index < 0 || index >= this.size)
        {
            throw new WrongIndexException();
        }
        return this.arr[index];
    }



    public E set(int index, E element)
    {
        if(index < 0 || index >= this.size)
        {
            throw new WrongIndexException();
        }
        this.arr[index] = element;
        return arr[index - 1];
    }


    public boolean remove(E element)
    {
        if(!(this.contains(element)))
        {
            throw new WrongElementException();
        }
        for(int i = 0 ; i < this.size; ++i)
        {
            if(this.arr[i] == element)
            {
                for(int j = i; j < this.size - 1; ++j)
                {
                    this.arr[j] = this.arr[j + 1];
                }
                --this.size;
                return true;
            }
        }

        return false;
    }

    @Override
    public E remove(int index)
    {
        if(index < 0 || index >= this.size)
        {
            throw new WrongIndexException();
        }
        E temp = this.arr[index];
        for(int i = index; i < this.size - 1; ++i)  // 1 2 3 4 5 6 7
        {                                           // 1 2 4 5 6 7
            this.arr[i] = this.arr[i + 1];          // 1 2 4 4 5 6 7
        }                                           // 1 2 4 5 5 6 7
        --this.size;                                // 1 2 4 5 6 6 7
        return temp;                                // 1 2 4 5 6 7 7
                                                    // 1 2 4 5 6 7 7
    }

    @Override
    public int size()
    {
        return this.size;
    }


    public boolean isEmpty()
    {
        return this.size == 0;
    }



    @Override
    public boolean contains(E element)
    {
        for(int i = 0; i < this.size; ++i)
        {
            if(this.arr[i].equals(element))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E element)
    {
        if(!(this.contains(element)))
        {
            throw new WrongElementException();
        }
        for(int i = 0; i < this.size; ++i)
        {
            if(this.arr[i] == element)
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element)
    {
        if(!(this.contains(element)))
        {
            throw new WrongElementException();
        }
       for(int i = this.size - 1; i >= 0; --i)
       {
           if(this.arr[i] == element)
           {
               return i;
           }
       }
       return -1;
    }

    @Override
    public void clear()
    {
        for(int i = 0; i < this.size; ++i)
        {
            this.remove(i);
        }
        --this.size;
    }

    @Override
    public E[] toArray()
    {
        E [] array = (E[]) new Object[this.size];
        for(int i = 0; i < this.size; ++i)
        {
            array[i] = this.arr[i];
        }

        //return this.arr;
        return array;
    }

    @Override
    public <T> T[] toArray(T[] array)
    {
        if(array.length < this.size)
        {
            array = (T[])new Object[this.size];

        }
        for(int i = 0; i < this.size; ++i)
        {
            array[i] = (T) this.arr[i];
        }

        return array;
    }

    @Override
    public MyList<E> subList(int fromIndex, int toIndex)
    {
        if(fromIndex < 0 || fromIndex >= this.size || toIndex < 0 || toIndex >= this.size || fromIndex >= toIndex)
        {
            throw new WrongIndexException();
        }
        MyList<E> list = new MyArrayList<E>();
        for(int i = fromIndex + 1; i <= toIndex; ++i)
        {
            list.add(this.arr[i]);
        }
        return list;
    }

    @Override
    public boolean removeAll(MyList<?> otherList)
    {
        if(!(this.containsAll(otherList)))
        {
            throw new WrongListException();
        }
        int count = 0;
        for(int i = 0; i < this.size; ++i)
        {
            for(int j = 0; j < otherList.size(); ++j)
            {
                if(this.arr[i] == otherList.toArray()[j])
                {
                    this.remove(i);
                    ++count;
                }
            }
        }

        return count == 0;
    }

    @Override
    public boolean retainAll(MyList<?> otherList)
    {
        if(!(this.containsAll(otherList)))
        {
            throw new WrongListException();
        }
        int count = 0;
        if(this.containsAll(otherList))
        {
            this.arr = (E[]) otherList.toArray();
            this.size = otherList.size();
            ++count;
        }
        return count == 0;
    }

    @Override
    public boolean containsAll(MyList<?> otherList)
    {
        if(otherList.size() > this.size)
        {
            return false; // Exception
        }
        int count = 0;
        for(int i = 0; i < otherList.size(); ++i)
        {
            for(int j = 0; j < this.size; ++j)            // 7 17 89 47 87 917 17 5 4 1 8 17 89 47 87 917 9
            {                                            // 17, 89, 47, 87, 917
                if(arr[j].equals(otherList.toArray()[i]))
                {
                    ++count;
                    break;
                }
            }
        }
        return count == otherList.size();
    }

    @Override
    public boolean addAll(MyList<? extends E> otherList)
    {
        int j = 0;
        E [] arr1 = (E[]) new Object[this.size + otherList.size()];

        for(int i = 0; i < this.size; ++i)
        {
            arr1[i] = arr[i];
        }
        for(int i = this.size; i < otherList.size() + this.size; ++i)     // 7 8 9 4 7
        {                                                                 // 1 2 4 5 6 7 8 9
            arr1[i] = otherList.get(j);                               // 1 2 4 5 6 7 8 9 7 8 9 4 7
            ++j;
        }
        this.capacity = this.size + otherList.size();
        this.size = this.size + otherList.size();
        this.arr = arr1;

        return true;
    }


    @Override
    public boolean addAll(int index, MyList<? extends E> otherList)
    {
        if(index < 0 || index >= this.size)
        {
            throw new WrongIndexException();
        }
        int j = 0;
        int k = index;
        E [] newArr = (E[]) new Object[this.size + otherList.size()];  // 7 8 9 4 7
        for(int i = 0; i < index; ++i)                             // 1 2 4 5 6 7 8 9
        {                                                              // 1 2 4 7 8 9 4 7 5 6 7 8 9
            newArr[i] = this.arr[i];
        }

        for(int i = 0; i < otherList.size(); ++i)
        {
            newArr[k] = otherList.get(i);
            ++k;
        }

        for(int i = index; i < this.size; ++i)
        {
            newArr[k] = this.arr[i];
            ++k;
        }

        this.arr = newArr;
        this.capacity = this.size + otherList.size();
        this.size =  this.size + otherList.size();
        return true;
    }

    @Override
    public boolean equals(Object obj)
    {
        //return this.equals(obj);
        return this == obj;
    }
    @Override
    public int hashCode()
    {
        return Objects.hash((Object) this.arr);
    }


    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < this.size; ++i)
        {
            str.append(this.arr[i]);
        }
        return str.toString();
    }
    @Override
    public int capacity()
    {
        return this.capacity;
    }

}