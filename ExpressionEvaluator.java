package eg.edu.alexu.csd.datastructure.stack.cs_77;

public class ExpressionEvaluator {
	public String infixToPostfix(String expression) {
		Stack s1=new Stack();
		Stack s2=new Stack();

		for(int i=0;i<expression.length();i++) {
			if(s1.isEmpty()) {
			if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'||expression.charAt(i)=='/'||expression.charAt(i)=='(')
				{s1.push(expression.charAt(i));	
		}
			else
			{
				s2.push(expression.charAt(i));
			
			}
			}
			else {
				if(expression.charAt(i)=='(') {
					s1.push(expression.charAt(i));	
				}
				else if(expression.charAt(i)=='+') {
					Object o=s1.peek();
			
					if((char) o=='-') {
						s2.push(s1.pop());
					}
					
					else if((char) o=='+') {
						s2.push(s1.pop());
					}
					else if((char) o=='*') {
						s2.push(s1.pop());
					
					}
					else if((char) o=='/') {
						s2.push(s1.pop());
					}
					////////////////////////////////////////////////
					if(!s1.isEmpty()) {
						o=s1.peek();
						if((char) o=='+') {
							s2.push(s1.pop());
						}
						else if((char) o=='-') {
							s2.push(s1.pop());
						}	
					}
					s1.push(expression.charAt(i));
				}
			///////////////////////////////////////////
				
				else if(expression.charAt(i)=='-') {
					Object o=s1.peek();
				
						if((char) o=='+') {
							s2.push(s1.pop());
						}
						else if((char) o=='-') {
							s2.push(s1.pop());
						}
						else if((char) o=='*') {
							s2.push(s1.pop());
						}
						else if((char) o=='/') {
							s2.push(s1.pop());
						}
			////////////////////////////////////////////////
						if(!s1.isEmpty()) {
							o=s1.peek();
							if((char) o=='+') {
								s2.push(s1.pop());
							}
							else if((char) o=='-') {
								s2.push(s1.pop());
							}	
						}
						s1.push(expression.charAt(i));
					}
				///////////////////////////////////////////
				else if(expression.charAt(i)=='*') {
					Object o=s1.peek();
					if((char) o=='*') {
						s2.push(s1.pop());
					}
					if((char) o=='/') {
						s2.push(s1.pop());
					}
					s1.push(expression.charAt(i));
				}
				else if(expression.charAt(i)=='/') {
					Object o=s1.peek();
					if((char) o=='*') {
						s2.push(s1.pop());
					}
					if((char) o=='/') {
						s2.push(s1.pop());
					}
					s1.push(expression.charAt(i));
				}
				else if(expression.charAt(i)==')') {
				
					while((char)s1.peek()!='(')
					{	if((char)s1.peek()!='(')s2.push(s1.pop());
					}
					s1.pop();
			
				}else {
				s2.push(expression.charAt(i));
		
			}
			}
			
		}
		int l1=s1.size();
	for(int i=0;i<l1;i++) {
if((char)s1.peek()!='(')
		s2.push(s1.pop());
	}

	int l=s2.size();
char [] c=new char[l];
for(int i=0;i<l;i++) {
	c[i]=(char)s2.pop();
}  int   temp;
for(int i=0;i<(l/2);i++){
    temp=c[i];
  c[i]=c[l-1-i];
c[l-1-i]=(char) temp;}
String str=String.valueOf(c);
	return str;
	}
	public int evaluate(String expression) {

		Stack s1=new Stack();
		char [] c=new char[expression.length()];
		for(int i=0;i<expression.length();i++) {
			c[i]=expression.charAt(i);
		}
		
		for(int i=0;i<expression.length();i++) {
			if(Character.isDigit(c[i])) {
				int charac=(int)c[i]-48;
				s1.push(charac);
			}
			else {
				if(c[i]=='-') {
					int t1 =(int) s1.pop();
					int t2=(int)s1.pop();
					s1.push(t2-t1);
			
					}
				else if(c[i]=='+') {
					int t1 =(int) s1.pop();
					int t2=(int)s1.pop();
					s1.push(t2+t1);
	
					}
				else if(c[i]=='/') {
					int t1 =(int) s1.pop();
					int t2=(int)s1.pop();
					s1.push(t2/t1);

					}
				else if(c[i]=='*') {
					int t1 =(int) s1.pop();
					int t2=(int)s1.pop();
					s1.push(t2*t1);
				
					}
			}
			
		}
	return (int) s1.pop();
}}
