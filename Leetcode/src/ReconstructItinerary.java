package src;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> output = new ArrayList<>();
        Map<String, PriorityQueue<String>> lexicalOrderGraph = new HashMap<>();
        for(List<String> ticket : tickets) {
            if(!lexicalOrderGraph.containsKey(ticket.get(0))){
                lexicalOrderGraph.put(ticket.get(0), new PriorityQueue<String>());
            }
            lexicalOrderGraph.get(ticket.get(0)).add(ticket.get(1));
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()){
            while(lexicalOrderGraph.containsKey(stack.peek()) && !lexicalOrderGraph.get(stack.peek()).isEmpty()) {
                stack.push(lexicalOrderGraph.get(stack.peek()).poll());
            }
            output.add(0,stack.pop());
        }
        return output;
    }
}
