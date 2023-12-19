package com.ruby.leetcode;


import java.util.*;
import java.util.stream.Collectors;

/**
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.
 * <p>
 * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
 * <p>
 * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
 * Otherwise, they will leave it and go to the queue's end.
 * This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
 * <p>
 * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
 * Output: 0
 * Explanation:
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
 * - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
 * - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
 * - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
 * - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
 * - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
 * Hence all students are able to eat.
 * Example 2:
 * <p>
 * Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i] is 0 or 1.
 * students[i] is 0 or 1.
 */
public class CountStudents {
    public int countstudentsHungry(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQueue = Arrays.stream(students).boxed().collect(Collectors.toCollection(LinkedList::new));
        Deque<Integer> sandWitchStack = Arrays.stream(sandwiches).boxed().collect(Collectors.toCollection(LinkedList::new));
        int hungryStudents = 0;
        do {
            if (studentsQueue.peek() != null && studentsQueue.peek().equals(sandWitchStack.peek())) {
                hungryStudents = 0;
                sandWitchStack.pop();
                studentsQueue.poll();
            } else {
                hungryStudents++;
                studentsQueue.offer(studentsQueue.poll());
            }
        } while (hungryStudents != studentsQueue.size());
        return hungryStudents;
    }

    public int countstudentsServed(int[] students, int[] sandwiches) {
        int circulars=0;
        int squares =0;
        for (int student : students) {
            if (student == 0) {
                circulars++;
            } else {
                squares++;
            }
        }
        int servedStudents =0;
        while (circulars >= 0 && squares >=0 && servedStudents < sandwiches.length){
                if(sandwiches[servedStudents] == 0){
                    if(circulars == 0){
                        break;
                    }
                    circulars--;
                }else{
                    if(squares == 0){
                        break;
                    }
                    squares--;
                }
            servedStudents++;
        }

        return sandwiches.length - servedStudents;
    }

    public static void main(String[] args) {
        CountStudents students = new CountStudents();
        int result = students.countstudentsHungry(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1});
        System.out.printf("number of students hungry are %d%n", result);
        result = students.countstudentsHungry(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1});
        System.out.printf("number of students hungry are %d%n", result);

        result = students.countstudentsServed(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1});
        System.out.printf("number of students hungry are %d%n", result);
        result = students.countstudentsServed(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1});
        System.out.printf("number of students hungry are %d%n", result);


    }
}
