package org.cristianvelasquezp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListPractice implements PrintExamples{
    @Override
    public void printExamples() {

        /*
         * Collection is an API that lets you store and manipulate groups of objects in different data structures.
         * In collections, you can store objects of any type, but you can't store primitive types. you can use wrapper classes instead.
         * Collection interface is the root interface of the Java Collections Framework and this interface extends the Iterable interface.
         *
         * List, Queue, and Set are the three main interfaces that extend the Collection interface.
         *
         * List: is an ordered collection that allows duplicate elements. It is an interface that extends Collection.
         * ArrayList, LinkedList, and Vector are the three main classes that implement the List interface.
         *
         * Queue: is an ordered collection that allows duplicate elements. It is an interface that extends Collection.
         * PriorityQueue, ArrayDeque, and LinkedList are the three main classes that implement the Queue interface.
         *
         * Set: is a collection that does not allow duplicate elements. It is an interface that extends Collection.
         * HashSet, LinkedHashSet, and TreeSet are the three main classes that implement the Set interface.
         *
         * */

        /*
         * List implementations
         */

        //Immutable Lists

        List<Integer> mutableList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("Mutable List: " + mutableList);

        mutableList.add(6);
        System.out.println("Mutable List after add values" + mutableList);

        //Immutable list from java 9
        List<Integer> immutableListJ9 = List.of(1,2,3,4,5);
        System.out.println("Immutable List from Java 9: " + immutableListJ9);

        try {
            immutableListJ9.add(6);
            immutableListJ9.set(1,6); // This is not allowed in List.of
        } catch (UnsupportedOperationException exception) {
            System.out.println("When try to add value to immutableListJ9 you get the next exception: " + exception);
        }

        //Immutable list before java 9
        List<Integer> immutableList = Arrays.asList(1,2,3,4,5);
        System.out.println("Immutable List before Java 9: " + immutableList);

        immutableList.set(1,6); // This is allowed in Arrays.asList

        System.out.println("Immutable List before Java 9 after add values" + immutableList);
        try {
            immutableList.add(6);
        } catch (UnsupportedOperationException exception) {
            System.out.println("When try to add value to immutableList you get the next exception: " + exception);
        }

        //Immutable list before java 9 option 2
        List<Integer> immutableListOption2 = new ArrayList<>();
        immutableListOption2.add(1);
        immutableListOption2.add(2);
        immutableListOption2.add(3);
        immutableListOption2.add(4);
        immutableListOption2.add(5);
        System.out.println("Immutable List before Java 9 option 2: " + immutableListOption2);

        immutableListOption2 = Collections.unmodifiableList(immutableListOption2);

        try {
            immutableListOption2.add(6);
        } catch (UnsupportedOperationException exception) {
            System.out.println("When try to add value to immutableListOption2 you get the next exception: " + exception);
        }




    }
}
