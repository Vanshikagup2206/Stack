package Stack;

import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        int n = heights.length;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int poppedIndex = stack.pop();
                int height = heights[poppedIndex];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; 
                area = Math.max(area, height * width);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int poppedIndex = stack.pop();
            int height = heights[poppedIndex];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            area = Math.max(area, height * width);
        }

        return area;
    }
}