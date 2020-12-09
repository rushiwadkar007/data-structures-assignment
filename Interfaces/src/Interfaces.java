import java.util.*;
public class Interfaces implements  I1, I2 {


    public void show(int i, int j){
        int add = i+j;
        System.out.println(add);
        System.out.println("Interfaces have all the abstract methods.");
    }
    public void display(){
        System.out.println("Multiple inheritance in Java is impossible but we can implement it in the case of Interfaces.");
    }
    public void create(){
        System.out.println("Interfaces are so easy to use");
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        int j = input.nextInt();


        Interfaces T1 = new Interfaces();
        Interfaces1 T2 = new Interfaces1();

        T1.display();
        T1.show(i, j);
        T2.show(i, j);
        T1.create();
        T2.create();
    }
}
class Interfaces1 implements  I1{
    public void show(int i, int j){
        System.out.println("Enter the values of i and j in a serial manner ");
        int sum  = i+j;
        System.out.println("sum of i and j is "+sum);
    }
    public void create(){
        System.out.println("null");
    }

}
interface  I1{
    void show(int i, int j);
    void create();
}
interface  I2{
    void show(int m, int n);
    void display();
    void create();
}
