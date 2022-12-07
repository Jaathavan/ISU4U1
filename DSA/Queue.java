import java.util.NoSuchElementException;
class Queue
{
  private Node front;
  private Node rear;
  class Node
  {
    int info;
    Node link;
    Node (int i, Node n)
    {
      info = i;
      link = n;
    }
  }
  
  public void enqueue (int item)
  {
    Node temp = new Node(item, null);
    if (rear == null)
//queue was empty
      front = rear = temp;
    else
//add node at the rear of the queue
      rear = rear.link = temp;
  }
  
  public int dequeue () {
    if (rear == null) throw new NoSuchElementException();
    int num = front.info;
    front = front.link;
    return num;
  }
  
  public int peek() {
    if (rear == null) throw new NoSuchElementException();
    return front.info;
  }
}
