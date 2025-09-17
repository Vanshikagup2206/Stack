package Stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> nextGreater = new HashMap<>();

        // Step 2: Process nums2
        for(int x : nums2){
            while(!stack.isEmpty() && x > stack.peek()){
                int top = stack.pop();
                nextGreater.put(top, x);
            }

            stack.push(x);
        }

        // Step 3: Remaining elements have no next greater
        while(!stack.isEmpty()){
            int top = stack.pop();
            nextGreater.put(top, -1);
        }

        // Step 4: Build result for nums1
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = nextGreater.get(nums1[i]);
        }

        return result;
    }
}