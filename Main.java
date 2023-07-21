public class  Main
{
    public static void main(String [] args)
    {
        Integer [] arr = {7, 5, 4, 1};
        Integer [] arr1 = {17, 89, 47, 87, 917};
        Integer [] arr2 = {17, 89, 1007};
        MyArrayList<Integer> list = new MyArrayList<Integer>(arr);
        MyList<Integer> list1 = new MyArrayList<>(arr1);
        MyList <Integer> list2 = new MyArrayList<>(arr2);


        //add(element)
        list.add(8);

        //add(index, element)
        list.add(1, 17);

        //size()
        System.out.println("The size of the list: " + list.size());

        //get(index)
        System.out.println("The 4th element of the list: " + list.get(4));

        //capacity()
        System.out.println("The capacity of the list: " + list.capacity());

        //addAll(list)
        list.addAll(list1);

        for(int i = 0; i < list.size(); ++i)
        {
            System.out.print(list.get(i) + " ");            // 7 17 89 47 87 917 17 5 4 1 8 17 89 47 87 917 9
        }

        System.out.println("The size of the list: " + list.size());
        System.out.println("The 4th element of the list: " + list.get(4));
        System.out.println("The capacity of the list: " + list.capacity());


        //addAll(index, list)
        list.addAll(1, list1);

        for(int i = 0; i < list.size(); ++i)
        {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("The size of the list: " + list.size());
        System.out.println("The 4th element of the list: " + list.get(4));
        System.out.println("The capacity of the list: " + list.capacity());

        //contains(element)
        System.out.println(list.contains(917));

        //hashcode()
        System.out.println(list.hashCode());

        //containsAll(list)
        System.out.println(list.containsAll(list1));
        System.out.println(list.containsAll(list2));

        //equals()
        System.out.println(list.equals(list1));

        //indexOf(element)
        System.out.println(list.indexOf(87));

        //isEmpty()
        System.out.println(list.isEmpty());

        //lastIndexOf(element)
        System.out.println(list.lastIndexOf(87));

        //sublist(index1,index2)
        list2 = list.subList(1, 7);
        for(int i = 0; i < list2.size(); ++i)
        {
            System.out.print(list2.get(i) + " ");
        }

        //set(index, element)
        list.set(1, 7777);
        System.out.println();
        for(int i = 0; i < list.size(); ++i)
        {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //retainAll(list)
        list.retainAll(list1);
        for(int i = 0; i < list.size(); ++i)
        {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //toArray()
        Object [] array = list.toArray(); // harc inchu Object?
        for(int i = 0; i < array.length; ++i)
        {
              System.out.print(array[i] + " ");
        }

        //toArray(T[] arr)
        System.out.println();
        Object [] argList = new Object[3];
        Object [] array1 = list.toArray(argList);
        for(int i = 0; i < array1.length; ++i)
        {
            System.out.print(array1[i] + " ");
        }
        System.out.println();

        //toString()
        System.out.println(list.toString());

        //remove(index)
        list.remove(1);
        System.out.println();
        for(int i = 0; i < list.size(); ++i)
        {
            System.out.print(list.get(i) + " ");
        }

        //remove(element)
        list.remove(Integer.valueOf(47));
        System.out.println();
        for(int i = 0; i < list.size(); ++i)
        {
            System.out.print(list.get(i) + " ");
        }

        //clear()
        list.clear();
        System.out.println();
        for(int i = 0; i < list.size(); ++i)
        {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(list.size());

    }
}


