package src.premium;

import java.util.Stack;

public class ExpressionTreeWithEvaluate {
}

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */
//https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/
abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class NumNode extends Node {
    int val;
    public NumNode(int val) {
        this.val = val;
    }

    public int evaluate() {
        return val;
    }
}

abstract class OpNode extends Node {
    Node left;
    Node right;

    public OpNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}

class AddOpNode extends OpNode {
    public AddOpNode(Node left, Node right) {
        super(left, right);
    }
    public int evaluate() {
        return this.left.evaluate() + this.right.evaluate();
    }
}

class SubOpNode extends OpNode {
    public SubOpNode(Node left, Node right) {
        super(left, right);
    }
    public int evaluate() {
        return this.left.evaluate() - this.right.evaluate();
    }
}

class MultiplyOpNode extends OpNode {
    public MultiplyOpNode(Node left, Node right) {
        super(left, right);
    }

    public int evaluate() {
        return this.left.evaluate() * this.right.evaluate();
    }
}

class DivideOpNode extends OpNode {
    public DivideOpNode(Node left, Node right) {
        super(left, right);
    }
    public int evaluate() {
        return this.left.evaluate() / this.right.evaluate();
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> st = new Stack<>();
        for(String token : postfix) {
            if (Character.isDigit(token.charAt(0))) {
                st.push(new NumNode(Integer.parseInt(token)));
            } else {
                Node right = st.pop();
                Node left = st.pop();
                st.push(buildNode(token, left, right));
            }
        }
        return st.peek();
    }

    private Node buildNode(String op, Node left, Node right) {
        switch(op) {
            case "+":
                return new AddOpNode(left, right);
            case "-":
                return new SubOpNode(left, right);
            case "*":
                return new MultiplyOpNode(left, right);
            case "/":
                return new DivideOpNode(left, right);
            default:
                return null;
        }
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
