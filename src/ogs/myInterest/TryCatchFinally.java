package ogs.myInterest;

public class TryCatchFinally {
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
