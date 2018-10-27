
package com.ruby.puzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * created by Ruby Jha on 10/19/2018
 * The car manufacturer Honda holds their distribution system in the form of a tree (not necessarily binary).
 * The root is the company itself, and every node in the tree represents a car distributor that receives cars
 * from the parent node and ships them to its children nodes.
 * The leaf nodes are car dealerships that sell cars direct to consumers.
 * In addition, every node holds an integer that is the cost of shipping a car to it.
 *
 * Take for example the tree below:
 *
 *   0 -> 5 -> 4
 *   0 -> 6 -> 5
 *   0 -> 6 > 1
 *   0 -> 3 -> 2 -> 1 -> 1
 *   0 -> 3 -> 0 ->10
 *
 *   A path from Honda’s factory to a car dealership, which is a path from the root to a leaf in the tree,
 *   is called a Sales Path. The cost of a Sales Path is the sum of the costs for every node in the path.
 *   For example, in the tree above one Sales Path is 0→3→0→10, and its cost is 13 (0+3+0+10).
 *
 *   Honda wishes to find the minimal Sales Path cost in its distribution tree. Given a node rootNode, write a function getCheapestCost that calculates the minimal Sales Path cost in the tree.
 *   Implement your function in the most efficient manner and analyze its time and space complexities.
 *
 *   For example:  Given the rootNode of the tree in diagram above
 *   Your function would return: 7 since it’s the minimal Sales Path cost (there are actually two Sales Paths in the tree whose cost is 7: 0→6→1 and 0→3→2→1→1)
 *
 *   Constraints:
 *    [time limit] 5000ms
 *   [input] Node rootNode
 *     0 ≤ rootNode.cost ≤ 100000
 *   [output] integer
 */
public class SalesPathAlgorithm {

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static class SalesPath {


        int getCheapestCost(Node rootNode) {
            int currentCost = rootNode.cost;
            if(rootNode.children==null){
                return currentCost;
            }else{
                List<Integer> allPathsCost = new ArrayList<>();
                iterateNodePath(rootNode , rootNode.cost , allPathsCost) ;
                  return  allPathsCost.stream().min(Comparator.comparing(Integer::valueOf)).get() ;
            }

        }
    }

    static private void iterateNodePath(Node rootNode , Integer costSoFar , List<Integer> allPathsCost){

        if(rootNode.children==null){
            costSoFar= costSoFar +rootNode.cost;
            allPathsCost.add(costSoFar);
        }else{
            int pathCosts[] = new int[rootNode.children.length];
            for(int i=0; i< rootNode.children.length; i++){
                iterateNodePath(rootNode.children[i] , costSoFar+rootNode.cost , allPathsCost);
            }
        }

    }


    public static void main(String[] args) {
        SalesPathAlgorithm question1 = new SalesPathAlgorithm();
        Node root = new Node(0);

        ArrayList<Node> rootChildren = new ArrayList<>();
        Node level2Node1 = new Node(5);
        Node level2Node2 = new Node(3);
        Node level2Node3 = new Node(6);
        rootChildren.add(level2Node1);
        rootChildren.add(level2Node2);
        rootChildren.add(level2Node3);
        root.children = rootChildren.toArray(new Node[rootChildren.size()]);

        Node level3Node1 = new Node(4);
        ArrayList<Node> level2Node1Children = new ArrayList<>();
        level2Node1Children.add(level3Node1);
        level2Node1.children = level2Node1Children.toArray(new Node[level2Node1Children.size()]);

        Node level3Node2 = new Node(2);
        Node level3Node3 = new Node(0);
        ArrayList<Node> level2Node2Children = new ArrayList<>();
        level2Node2Children.add(level3Node2);
        level2Node2Children.add(level3Node3);
        level2Node2.children = level2Node2Children.toArray(new Node[level2Node2Children.size()]);

        Node level3Node4 = new Node(1);
        Node level3Node5 = new Node(5);
        ArrayList<Node> level2Node3Children = new ArrayList<>();
        level2Node3Children.add(level3Node4);
        level2Node3Children.add(level3Node5);
        level2Node3.children = level2Node3Children.toArray(new Node[level2Node3Children.size()]);

        Node level4Node1 = new Node(1);
        ArrayList<Node> level3Node2Children = new ArrayList<>();
        level3Node2Children.add(level4Node1);
        level3Node2.children = level3Node2Children.toArray(new Node[level3Node2Children.size()]);

        Node level4Node2 = new Node(10);
        ArrayList<Node> level3Node3Children = new ArrayList<>();
        level3Node3Children.add(level4Node2);
        level3Node3.children = level3Node3Children.toArray(new Node[level3Node3Children.size()]);

        Node level5Node1 = new Node(1);
        ArrayList<Node> level4Node1Children = new ArrayList<>();
        level4Node1Children.add(level5Node1);
        level4Node1.children = level4Node1Children.toArray(new Node[level4Node1Children.size()]);

        SalesPath salesPath = new SalesPath();
        int ret = salesPath.getCheapestCost(root);

        System.out.println(ret);
    }
}

