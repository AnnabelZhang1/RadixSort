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

  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i < buckets.length; i++){
      if (buckets[i] != null)
        original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    int len = 1;
    for (int i = 0; i < len; i++){
      for (int j = 0; j < data.size(); j++){
        int current = data.get(j);
        if (i == 0 && length(current) > len) //filing by digits
          len = length(current);
        int place = nth(current, i);
        if (buckets[place] == null)
          buckets[place] = new SortableLinkedList();
        buckets[place].add(current); //adds number to bucket
        data.remove(j); //deletes original one by one
        j--;
      }
      merge(data, buckets);
    }
  }
/*
  public static void radixSort(SortableLinkedList data){

  }
*/
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

    SortableLinkedList a = new SortableLinkedList();
    MyLinkedList b = new MyLinkedList();
    for (int i = 0; i < 5; i++)
      a.add(i);
    radixSortSimple(a);
    System.out.println(a);
  }
}
