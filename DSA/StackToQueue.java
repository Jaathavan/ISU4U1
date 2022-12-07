class StackToQueue {
  Stack myStack1 = new Stack();
  Stack myStack2 = new Stack();
  public void enqueue(int item) {
    while (!myStack1.isEmpty()) {
      myStack2.push(myStack1.pop());
    }
    myStack1.push(item);
    
    while (!myStack2.isEmpty()) {
      myStack1.push(myStack2.pop());
    }
  }
  
  public int dequeue() {
    int x = myStack1.peek();
    myStack1.pop();
    return x;
  }
  
   public int peek() {
    return myStack1.peek();
  }
}
