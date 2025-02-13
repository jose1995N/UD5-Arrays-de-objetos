public class ejercicio2 {
    public static void main(String args[]) {
      Customer[] arr = new Customer[2];
      arr[0] = new Customer(709270, "Robert");
      arr[1] = new Customer(709219, "Neal");
      arr[0].display();
      arr[1].display();
    }
  }
  class Customer {
    public int id;
    public String name;
    Customer(int id, String name) {
      this.id = id;
      this.name = name;
    }
    public void display() {
      System.out.println("Customer id is: " + id + " "
          + "and Customer name is: " + name);
    }
  }