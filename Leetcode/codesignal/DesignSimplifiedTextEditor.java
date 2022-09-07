package codesignal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DesignSimplifiedTextEditor {

    /**
     * You will be provided a set of actions to perform. Once all actions are performed you will return the current state the system should be in after all actions in actions are performed.
     *
     * We will be operating on characters and the "state" of the system will be a string that we are building.
     *
     * These are the actions possible:
     * INSERT: Inserts a single character to the end of the string
     * BACKSPACE: Removes the last character in the string
     * UNDO: Reverses the most recent action
     *
     */
    static List<String> textEditOperations(String[] actions) {

        Stack<String> result = new Stack<String>();
        Stack<String[]> undo = new Stack<String[]>();
        List<String> output = new ArrayList<>();
        StringBuffer currString = new StringBuffer();

        for(String action : actions) {
            String[] actionSplit = action.split(" ");
            switch(actionSplit[0]) {
                case "INSERT":
                    result.push(actionSplit[1]);
                    undo.push(actionSplit);
                    currString.append(actionSplit[1]);
                    output.add(currString.toString());
                    break;
                case "BACKSPACE":
                    undo.push(new String[]{actionSplit[0], result.pop()});
                    currString.deleteCharAt(currString.length()-1);
                    output.add(currString.toString());
                    break;
                case "UNDO":
                    actionSplit = undo.pop();
                    if(actionSplit[0].equals("INSERT")) {
                        result.pop();
                        currString.deleteCharAt(currString.length()-1);
                    } else {
                        result.push(actionSplit[1]);
                        currString.append(actionSplit[1]);
                    }
                    output.add(currString.toString());
                    break;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        System.out.println(textEditOperations(new String[]{"INSERT a",
                "INSERT b",
                "UNDO",
                "BACKSPACE"}
        ));

        System.out.println(textEditOperations(new String[]{"INSERT a",
                "INSERT b",
                "UNDO",
                "BACKSPACE",
                "UNDO"}
        ));

        System.out.println(textEditOperations(new String[]{"INSERT a",
                "INSERT b",
                "UNDO"}
        ));
    }
}

