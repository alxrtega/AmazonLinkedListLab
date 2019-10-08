//Alex Ortega

public class Order implements Comparable<Order>{
  
  String   productName; 
  double   productPrice;
  int      productQuantity;
  Order    next;
  
  public Order(){//Order()
    this.productName      = null;
    this.productPrice     = 0.0;
    this.productQuantity  = 0;
    this.next             = null;
  }
  
  public Order(String infoFromFile){//Order(String file)
    
    String[] token       = infoFromFile.split("\t");
    
    $(token[0]+"\t");    
    this.productName     = token[0];
    $(token[1]+"\t");
    this.productPrice    = Double.parseDouble(token[1]);
    $(token[2]+"\n");
    this.productQuantity = Integer.parseInt(token[2]);
    next                 = next;
  }
  
  public Order(String nameFromFile,
               double priceFromFile, 
               int quantityFromFile){//Order(file, price, quantity)
    
    this.productName       = nameFromFile; 
    this.productPrice      = priceFromFile;
    this.productQuantity   = quantityFromFile;
    this.next              = next;
  }
  
  public void setProductName(String setName){//setName
    this.productName = setName; 
  }
  
  public void setProductPrice(double setPrice){//setPrice
    this.productPrice = setPrice;
  }
  
  public void setProductQuantity(int setQuantity){//setQuantity
    this.productQuantity = setQuantity; 
  }
  
  public void setNext(Order next){//setNext
    this.next = next;
  }
  
  public String getProductName(){//getProductName
    return this.productName; 
  }
  
  public double getProductPrice(){//getProductPrice
    return this.productPrice; 
  }
  
  public int getProductQuantity(){//getProductQuantity
    return this.productQuantity; 
  }
  
  public Order getNext(){//getNext
    return this.next;
  }
  
  public double getTotalPerOrder(){//getTotal
    return this.productPrice * this.productQuantity; 
  }
  
  public String toString(){//toString
    String s = String.format("Order: %s, a total of $%.2f. ",
                             productName, getTotalPerOrder());
    return s; 
  }
  
  public int compareTo(Order o){//comapreTo
    if(this.productName.equals(o.getProductName())){
      if(this.getTotalPerOrder() > o.getTotalPerOrder())
        return 1;
      else if(this.getTotalPerOrder() < o.getTotalPerOrder())
        return -1;
      else 
        return 0;
    }
    else 
      return -1;
  }
  
  public boolean equals(Order t, Order o){
    if(t.getProductName().equals(o.getProductName() )
                          && t.getProductPrice() == o.getProductPrice())
      return true;
    return false;
  }
  
  public void $(String s){
    if(false)
      System.out.print(s);
  }
}