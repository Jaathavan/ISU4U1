import java.util.*; //Used for error checking

class Stack {
    private Node top;

    class Node {
        int info;
        Node link;

        Node(int i, Node n) {
            info = i;
            link = n;
        }
    }

    public void push(int item) {
        if (top == null)
            top = new Node(item, null);
        else
            top = new Node(item, top);
    }

    public int peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.info;
    }

    public int pop() {
        int value = top.info;
        top = top.link;
        return value;
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }
}