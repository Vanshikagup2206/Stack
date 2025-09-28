package Stack;

import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                //Whenever problem asks “how far until next greater element”,
                //the answer = distance in indexes → (nextIndex - currentIndex)
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}