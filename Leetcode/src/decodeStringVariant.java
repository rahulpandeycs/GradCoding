package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//Asked in Cisco written
public class decodeStringVariant {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();

//        String s= "(ab){3}(cd){2}";
        String s= "(ab(c){3}d){2}";
        printString(s);

    }

    static void printString(String s){
        Stack<Integer> counts = new Stack<>();
        Stack<String> currentStrings = new Stack<>();

        String res = "";
        int i = 0;
        while(i < s.length()) {
           if(s.charAt(i) == '(') {
                currentStrings.push(res);
                res ="";
                i++;
            }else if(s.charAt(i) == '}' && !counts.isEmpty() && !currentStrings.isEmpty()){
                StringBuilder sb = new StringBuilder(currentStrings.pop());
                int timesToAdd = counts.pop();

                while(timesToAdd-- > 0){
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            }else if(s.charAt(i) == '{' && i+1 < s.length()){
                int num = 0;
                i++;
                while(Character.isDigit(s.charAt(i))) {
                    num = num*10 + (s.charAt(i) - '0');
                    i++;
                }
                counts.push(num);
            }else if(s.charAt(i) == ')'){
                i++;
            } else {
                res += s.charAt(i);
                i++;
            }
        }
        System.out.println(res);
    }
}
