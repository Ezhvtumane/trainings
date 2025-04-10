package ogs.myInterest;

public class TryCatchFinally {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        try {
            throw  new RuntimeException();
            //return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }

    }

    public void kek() {
        int[] i = new int[1];
        try {
            System.out.println("try");
            i[2] = 0;// throw array
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catch");
            throw e;
        } finally {
            System.out.println("finally");
        }
    }
}
