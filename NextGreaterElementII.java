package Stack;

import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Initialize all elements in result to -1
        for(int i = 0; i < n; i++){
            result[i] = -1;
        }

        Stack<Integer> stack = new Stack<>(); // Stack to store indices of numbers waiting for next greater

        // Step 2: Loop through array twice to handle circular nature
        for(int i = 0; i < 2 * n; i++){
            int cur = nums[i % n]; // Current number, using modulo for circular traversal

            // Step 3: Resolve all numbers in stack that are smaller than current
            while(!stack.isEmpty() && nums[stack.peek()] < cur){
                int poppedIndex = stack.pop(); // Get index of number that has found its next greater
                result[poppedIndex] = cur;     // Update result
            }

            // Step 4: During first pass, push index to stack (second pass only checks)
            if(i < n){
                stack.push(i);
            }
        }

        // Step 5: Remaining indices in stack have no next greater element → already -1

        return result; // Return the filled result array
    }
}