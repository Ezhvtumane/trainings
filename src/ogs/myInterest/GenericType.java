package ogs.myInterest;

import java.util.ArrayList;
import java.util.List;

public class GenericType<T> {

    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String args[]) {
        GenericType<String> type = new GenericType<>();
        type.set("Pankaj"); //valid

        GenericType type1 = new GenericType(); //raw type
        type1.set("Pankaj"); //valid
        //type1.set(10); //valid and autoboxing support

        System.out.println(type1.get());
        type1.kek();
    }

    private void kek() {
        String s1 = "";
        Object o1 = new Object();
        o1 = s1;
        List<Integer> l1 = new ArrayList<>();
        List<Object> l2 = new ArrayList<>();
        List<?> l3 = new ArrayList<>();
        l3 = l1;
        l3 = l2;
        List<? extends Number> l4 = new ArrayList<>();
        l4 = l1;// ((List<Integer>) l4)
        //l2=l1; // List<Obj> != List<Str>
        o1 = l1;
        o1 = l2;

        List<? super Number> l5 = new ArrayList<>();
        l5.add(new Integer(5));
        l5.add(new Double(6));
        l5.forEach(System.out::println);
    }
}
