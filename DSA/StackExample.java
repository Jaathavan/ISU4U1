class StackExample {
    static int postFix(String str) {
        Stack myStack = new Stack();
        
        String[] expressionParts = str.split(" ");

        for (int i = 0; i < expressionParts.length; i++) {
            if (expressionParts[i] != "+" && expressionParts[i] != "-" && expressionParts[i] != "*" && expressionParts[i] != "/") {
                myStack.push(Integer.parseInt(expressionParts[i]));
            }
            else {
                int val1 = myStack.pop();
                int val2 = myStack.pop();

                if (expressionParts[i] == "+") {
                    myStack.push(val2+val1);
                }

                if (expressionParts[i] == "-") {
                    myStack.push(val2-val1);
                }

                if (expressionParts[i] == "*") {
                    myStack.push(val2*val1);
                }

                if (expressionParts[i] == "+") {
                    myStack.push(val2/val1);
                }
            }
        }

        return myStack.pop();
    }
    public static void main (String [] args) {
        Stack myStack = new Stack();
        myStack.push(3);
        myStack.push(6);
        myStack.push(9);
        
        myStack.pop();
      
        System.out.println(myStack.peek());
        System.out.println(postFix("2 3 1 * + 9 -"));
    }  
}
