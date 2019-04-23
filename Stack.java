package eg.edu.alexu.csd.datastructure.stack.cs_77;

public class Stack {
int capacity=10;
Object stack[]=new Object [capacity];
int length=0;
public void push(Object data) {
	if(size()==capacity) {
		expand();
	}
	stack[length++]=data;
	
}
private void expand() {
	int l=size();
	capacity=2*capacity;
	Object[] nstack=new Object[capacity];
	System.arraycopy(stack, 0, nstack, 0, l);
	stack=nstack;
}
public void show() {
	for(int i=0;i<length;i++) {
		
		System.out.print(stack[i]+" ");
	}
}
public Object pop() {
	if(isEmpty()) {
	System.out.println("stack isEmpty");	
	return 0;
	}
	Object data=stack[--length];
	stack[length]=0;
	return data;
}
public Object peek() {
	Object data=stack[--length];
	length++;
	return data;
}
public int size() {
	return length;
}
public boolean isEmpty(){
	if(length==0)return true;
	else return false;
}
}
