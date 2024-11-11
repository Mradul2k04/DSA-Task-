class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
        
    }
    
    public int pop() {
        int temp=0;
        while(!q1.isEmpty()){
        temp =q1.peek();      
        q2.add(q1.poll());
        }
        while(q2.size()>1){
            q1.add(q2.poll());
        }
        q2.poll();
        return temp;
    }
    
    public int top() {
        int temp=0;
        while(!q1.isEmpty()){
        temp =q1.peek();      
        q2.add(q1.poll());
        }
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        q2.poll();
        return temp;
    }
    
    public boolean empty() {
        if(q1.size()==0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */