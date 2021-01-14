public class Radix{

  public static int nth(int n, int col){
    int numplace = (int)Math.pow(10, col);
    return (Math.abs(n/numplace))%10;
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
    for (int i = 0; i < 10; i++)
      buckets[i] = new SortableLinkedList();

    for (int i = 0; i < len; i++){
      while (data.size() > 0){
        int current = data.remove(0);
        if (i == 0 && length(current) > len) //filing by digits
          len = length(current);
        int place = nth(current, i);
        if (current < 0)
          buckets[9 - place].add(current);
        else
          buckets[place].add(current);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList positives = new SortableLinkedList();
    SortableLinkedList negatives = new SortableLinkedList();
    while (data.size() > 0){
      int current = data.remove(0);
      if (current >= 0)
        positives.add(current);
      else
        negatives.add(current);
    }
    radixSortSimple(positives);
    radixSortSimple(negatives);
    negatives.extend(positives);
    data.extend(negatives);
  }

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
  }
}
