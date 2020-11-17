/* Alex Ortega
 * The AmazonDocCom class will be responsible to handle each Order object
 * inside the AmazonDotCom shopping cart. 
*/

public class AmazonDotCom{  
  
  Order first, last;
  
  public boolean isEmpty(){ //isEmpty
    return first == null; 
  }
  
  public void add(Order s){ //add
    
    Order n = s;
    if(isEmpty())
      first = last = n;
    else{
      last.next = n;
      last = last.next;
    }
  }
  
  public Order findMostExpensiveOrder(){ //findMostExpensiveOrder
    return findMostExpensiveOrder(first);
  }  
  private Order findMostExpensiveOrder(Order check){

    Order expensive = check;
    while(check != null){
      if(check.getTotalPerOrder() > expensive.getTotalPerOrder()){
        expensive = check; 
        check = check.getNext();
      }
      check = check.getNext();
    }
    return expensive;
  }
  
  public Order findMostCheapestOrder(){ //findMostCheapestOrder
    return findMostCheapestOrder(first);
  }  
  private Order findMostCheapestOrder(Order check){
    
    Order cheapest = check;
    while(check != null){
      if(check.getTotalPerOrder() < cheapest.getTotalPerOrder()){
        cheapest = check; 
        check = check.getNext();
      }
      check = check.getNext();
    }
    return cheapest;
  }
  
  public void print(){ //print
    print(first); 
  }  
  private void print(Order ref){
    
    if(ref != null){
      System.out.println(ref);
      print(ref.next);
    }
  }
  
  public int getLength(){ //getLength
    return getLength(first);
  }  
  private int getLength(Order ref){
    
    while(ref != null){
      return 1 + getLength(ref.getNext());
    }
    return 0;
  }
  
  public void sortList(){ //sortList
    
    int size = getLength();
    Order[] order = new Order[size];
    Order ref     = first;
    
    for(int x = 0; x < size; x++){
      order[x] = ref;
      ref = ref.getNext();
    }
    sorting(order, 0);
    printArray(order);
  } 
  private void sorting(Order[] orderArray, int aux){ //sorting

    Order order = null;    
    for(int i = 1; i < orderArray.length; i++){
      order = orderArray[i];
      aux = i;
      while(aux > 0 && orderArray[aux-1].getProductName().charAt(0) > order.getProductName().charAt(0)){
        orderArray[aux] = orderArray[aux-1];
        aux--;
      }
      orderArray[aux] = order;
    }    
  }
  
  public boolean findOrder(Order t){ //findOrder
    return findOrder(t, first); 
  }
  private boolean findOrder(Order t, Order ref){
    if(ref != null){
      if(t.getProductName().equals(ref.getProductName()))
        return true;
      findOrder(ref.getNext());
    }
    return false;
  }
  
  public int countOccurrences(Order t){ //countOccurrences
    return countOccurrences(t, first); 
  }
  private int countOccurrences(Order t, Order ref){
    if(ref != null){
      if(t.getProductName().equals(ref.getProductName()))
        return 1 + countOccurrences(t, ref.getNext());
      return 0 + countOccurrences(t, ref.getNext());
    }
    return 0;
  }
  
  public void printArray(Order[] o){ //printArray
    for(Order x: o)
      System.out.println(x);
  }
}