package Stack;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String c : tokens){
            if(!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")){
                stack.push(Integer.parseInt(c));
            }else{
                int b = stack.pop();
                int a = stack.pop();
                if(c.equals("+")){
                    stack.push(a + b); 
                }else if(c.equals("-")){
                    stack.push(a - b);
                }else if(c.equals("*")){
                    stack.push(a * b);
                }else{
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }
}