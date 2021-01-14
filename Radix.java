public class Radix{

  public static int nth(int n, int col){
    int numplace = (int)Math.pow(10, col + 1);
    return Math.abs((n%numplace)/(numplace/10));
  }
/*
  public static int length(int n){

  }

  public static void merge(MyLinkedList original, MyLinkedList[]buckets){

  }

  //public static void merge(SortableLinkedList original, SortableLinkedList[]buckets)
*/
  public static void main(String[] args){
    System.out.println(nth(123, 1)); //2
    System.out.println(nth(-123, 1)); //2
    System.out.println(nth(123, 2)); //1
    System.out.println(nth(-123, 2)); //1
/*
    length(0); //1
    length(15); //2
    length(-10); //2
    length(5112); //4*/
  }
}
