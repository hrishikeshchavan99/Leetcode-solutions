class MyQueue {
    private Stack<Integer> inp = new Stack();
    private Stack<Integer> out = new Stack();
    
    public MyQueue() {
        
    }
    
    public void push(int x) {
        if (!out.isEmpty())
            shiftStack(out, inp);
        inp.push(x);
    }
    
    public int pop() {
        shiftStack(inp, out);        
        return out.pop();
    }
    
    public int peek() {
        shiftStack(inp, out);
        return out.peek();
    }
    public void shiftStack(Stack inp, Stack out){
        while (!inp.isEmpty()){
            out.push(inp.pop());
        }
    }
    
    public boolean empty() {
        return inp.isEmpty() && out.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */