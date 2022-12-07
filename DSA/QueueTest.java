class QueueTest {
  public static void main (String [] args) {
//    Queue myQueue = new Queue();
//    myQueue.enqueue(1);
//    myQueue.enqueue(2);
//    myQueue.enqueue(3);
//    myQueue.enqueue(4);
//    myQueue.enqueue(5);
//    
//    myQueue.dequeue();
//    myQueue.dequeue();
//    myQueue.dequeue();
//    System.out.println(myQueue.peek());
    
    
    StackToQueue myStackToQueue = new StackToQueue();
    myStackToQueue.enqueue(1);
    myStackToQueue.enqueue(2);
    myStackToQueue.enqueue(3);
    myStackToQueue.enqueue(4);
    myStackToQueue.enqueue(5);
    
    myStackToQueue.dequeue();
    System.out.println(myStackToQueue.peek());
    
  }
}
