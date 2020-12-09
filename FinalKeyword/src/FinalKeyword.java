class Demo{
    final void m1(){
        System.out.println("i am in class demo");
        }
}
public class FinalKeyword {
    void m1(){
        System.out.println("i am in calss FinalKeyword");
    }
    public static void main(String[] args){
        Demo d1 = new Demo();
        d1.m1();
        FinalKeyword d2 =new FinalKeyword();
        d2.m1();
    }
}
/* final keyword can be used for variables, methods and classes.
if we don't want to use a particular method or calss then we use final keyword.
it is used to make any variable constant throughout the program.
*/