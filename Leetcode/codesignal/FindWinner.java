package codesignal;

import java.util.Stack;

/*Given an array A, delete the adjacent pair of the same value from A at each step (A == A[i+1],
 remove the pair of ( i, i+1) from A). Game starts from Player 1, one step at a time. If there are no numbers to delete, the game is over.
 The one who takes the last step wins. The question asks to return who won. */
public class FindWinner {

    static int winner(int[] inputArray){

        Stack<Integer> stack = new Stack<>();
        for(int val : inputArray){
            if(!stack.isEmpty() && stack.peek() == val) stack.pop();
            else stack.push(val);
        }
        return ((inputArray.length-stack.size())/2)%2 == 1 ?1 : 2;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,0,1,0,0,1,0,0,0};
        int player = winner(input);
        System.out.println(player);
    }
}
