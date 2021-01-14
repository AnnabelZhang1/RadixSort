public class Radix{

  public static int nth(int n, int col){
    int numplace = (int)Math.pow(10, col + 1);
    return Math.abs((n%numplace)/(numplace/10));
  }

  public static int length(int n){
    n = Math.abs(n);
    if (n != 0)
      return (int)Math.floor(Math.log10(n))+1;
    else
      return 1;
  }

  public static void merge(MyLinkedList original, MyLinkedList[]buckets){
    for (int i = 0; i < buckets.length; i++){
      if (buckets[i] != null)
        original.extend(buckets[i]);
    }
  }
  //public static void merge(SortableLinkedList original, SortableLinkedList[]buckets)

  public static void main(String[] args){
    System.out.println(nth(123, 1)); //2
    System.out.println(nth(-123, 1)); //2
    System.out.println(nth(123, 2)); //1
    System.out.println(nth(-123, 2)); //1

    System.out.println();

    System.out.println(length(0)); //1
    System.out.println(length(15)); //2
    System.out.println(length(-10)); //2
    System.out.println(length(5112)); //4

    System.out.println();

    MyLinkedList a = new MyLinkedList();
    MyLinkedList b = new MyLinkedList();
    for (int i = 0; i < 5; i++)
      a.add(i+"");
    for (int i = 5; i < 10; i++)
      b.add(i+"");
/*    merge(a, b);
    System.out.println(a);*/
  }
}
