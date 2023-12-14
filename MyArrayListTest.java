import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayListImpl();
        myArrayList.add("qwerty");
        System.out.println("size " + myArrayList.size());
        myArrayList.add("asdfg");
        myArrayList.add("pghjkl");
        System.out.println("size " + myArrayList.size());
        System.out.println(myArrayList);
        myArrayList.add(2, "abnmjn");
        System.out.println("size " + myArrayList.size());
        System.out.println("myArrayList " + myArrayList);
        System.out.println("1 elemetn " + myArrayList.get(1));
        myArrayList.set(0, "zxvcc");
        System.out.println("myArrayList " + myArrayList);
        myArrayList.add("iuj46hj");
        System.out.println("myArrayList " + myArrayList);

        myArrayList.set(4, "thgfg");
        System.out.println("myArrayList " + myArrayList);
        System.out.println("size " + myArrayList.size());
        System.out.println("--------------------------------------");
        myArrayList.sort((o1, o2) -> o1.compareTo(o2));

        ArrayIterator<String> iterator = (ArrayIterator<String>) myArrayList.iterator();

        System.out.println("Sort myArrayList :");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        myArrayList.remove(3);
        System.out.println(myArrayList);
        System.out.println("size " + myArrayList.size());
        System.out.println("--------------------------------------");

        List<Integer> integers = new ArrayList<>();
        integers.add(78);
        integers.add(63);
        integers.add(657);
        integers.add(147);
        integers.add(111);

        MyArrayList<Integer> myArrayList2 = new MyArrayListImpl<>(integers);
        System.out.println(myArrayList2);
        System.out.println("size " + myArrayList2.size());

        MyArrayList<Integer> myArrayList4 = new MyArrayListImpl();
        myArrayList4.add(56);
        System.out.println("myArrayList4 " + myArrayList4);
        System.out.println("size " + myArrayList4.size());

        myArrayList4.addAll(integers);
        System.out.println("myArrayList4 unsorted" + myArrayList4);
        System.out.println("size " + myArrayList4.size());

        MyArrayListImpl.sort(myArrayList4, (o1, o2) -> o1 - o2);
        System.out.println("myArrayList4 sorted " + myArrayList4);


        System.out.println("Clear myArrayList: ");
        myArrayList.clear();
        System.out.println("myArrayList " + myArrayList);

        System.out.println("--------------------------------------");
        integers.add(16);
        integers.add(19);
        integers.add(25);
        integers.add(1);
        integers.add(29);

        MyArrayList<Integer> myArrayList3 = new MyArrayListImpl<>(integers);
        System.out.println(myArrayList3);
        myArrayList3.bubbleSort();
        System.out.println(myArrayList3);


    }
}
