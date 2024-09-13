package org.cristianvelasquezp;

import java.util.*;

public class ArrayListPractice implements PrintExamples {

    public void printExamples(){
        /*
         * ArrayList implementations
         *
         * Complexity of operations:
         * 1) Access: O(1)
         *    Description: Accessing or modifying an element by index is a constant time operation
         *                 because is directly accessed the underlying array.
         * 2) Add(append): O(1)
         *    Description: Adding an element to the end of the list is generally a constant-time operation.
         *                 However, if the underlying array needs to be resized, the complexity can temporarily
         *                 become O(n), where n is the number of elements in the list.
         *                 The amortized complexity remains O(1) because resizing happens infrequently.
         *
         * 3) Add(insert at index): O(n)
         *    Description: Inserting an element at a specific index requires shifting all subsequent elements to
         *                 the right, which takes linear time.
         *
         * 4) Remove: O(n)
         *    Description: Removing an element by index requires shifting all subsequent elements to the left,
         *                 which takes linear time.
         *
         * 5) Remove (by value: O(n)
         *    Description: Removing an element by value requires searching for the element, which takes linear time,
         *                 and then shifting elements, which also takes linear time.
         *
         * 6) Contains: O(n)
         *    Description: Checking if the list contains a specific element requires a linear search through the list
         *
         * 7) Size: O(1)
         *    Description: Retrieving the size of the list is a constant-time operation.
         *
         * */

        List<String> listOfCountriesArrayList = new ArrayList<>();
        // Adding elements to the ArrayList
        listOfCountriesArrayList.add("Colombia");
        listOfCountriesArrayList.add("Peru");
        listOfCountriesArrayList.add("Ecuador");
        listOfCountriesArrayList.add("Venezuela");
        listOfCountriesArrayList.add("Chile");
        listOfCountriesArrayList.add("Colombia"); // Duplicate element
        System.out.println("ArrayList: " + listOfCountriesArrayList);

        // Adding element at a specific index
        listOfCountriesArrayList.add(2, "Argentina");
        System.out.println("ArrayList: " + listOfCountriesArrayList);

        // Replacing element at a specific index
        listOfCountriesArrayList.set(0, "Brazil");
        System.out.println("ArrayList: " + listOfCountriesArrayList);

        // Removing element at a specific index
        listOfCountriesArrayList.remove(1);
        System.out.println("ArrayList: " + listOfCountriesArrayList);

        // Removing element by value
        listOfCountriesArrayList.add("Chile");
        listOfCountriesArrayList.remove("Chile"); // Removes the first occurrence of the element
        System.out.println("ArrayList: " + listOfCountriesArrayList);

        // Getting element at a specific index
        System.out.println("ArrayList: " + listOfCountriesArrayList.get(2));

        // Getting the index of an element
        System.out.println("ArrayList: " + listOfCountriesArrayList.indexOf("Ecuador"));

        // Getting the last index of an element
        listOfCountriesArrayList.add("Venezuela");
        System.out.println("ArrayList: " + listOfCountriesArrayList);
        System.out.println("ArrayList: " + listOfCountriesArrayList.lastIndexOf("Venezuela")); // Returns the last occurrence of the element

        // Getting the size of the ArrayList
        System.out.println("ArrayList Size: " + listOfCountriesArrayList.size());

        // Checking if the ArrayList contains an element
        System.out.println("ArrayList contains 'Peru': " + listOfCountriesArrayList.contains("Peru"));
        System.out.println("ArrayList contains 'Colombia': " + listOfCountriesArrayList.contains("Colombia"));

        // Checking if the ArrayList is empty
        System.out.println("Is ArrayList empty: " + listOfCountriesArrayList.isEmpty());

        // Removing all elements from the ArrayList
        listOfCountriesArrayList.clear();
        System.out.println("ArrayList after remove all values: " + listOfCountriesArrayList);

        // Checking if the ArrayList is empty after remove all values
        System.out.println("Is ArrayList empty: " + listOfCountriesArrayList.isEmpty());


        // Iterating over the ArrayList using for loop

        List<String> countries = new ArrayList<>();
        countries.add("Colombia");
        countries.add("Peru");
        countries.add("Ecuador");
        countries.add("Venezuela");
        countries.add("Chile");

        // enhanced for loop
        System.out.println("Enhanced for loop");
        for (String country : countries) {
            System.out.println("Country: " + country);
        }

        // for loop
        System.out.println("For loop");
        for (int i = 0; i < countries.size(); i++) {
            System.out.println("Country: " + countries.get(i));
        }

        // Iterating over the ArrayList using forEach
        System.out.println("ForEach");
        countries.forEach(country -> System.out.println("Country: " + country));

        // Iterating over the ArrayList using Iterator
        System.out.println("Iterator");
        Iterator<String> iterator = countries.iterator();
        while (iterator.hasNext()) {
            var country = iterator.next();
            // Iterator let you use the remove method to modify the list while iterating
            if (country.equals("Peru")) {
                iterator.remove();
            }else {
                System.out.println("Country: " + country);
            }
        }

        // Sorting the ArrayList
        countries.add("Peru");
        countries.add("Argentina");

        // Sorting the ArrayList in ascending order using Collections.sort() method
        System.out.println("ArrayList before sorting: " + countries);
        Collections.sort(countries);
        System.out.println("ArrayList after sorting in ascending order: " + countries);

        // Sorting the ArrayList in descending order using Collections.sort() method
        Collections.sort(countries, Collections.reverseOrder());
        System.out.println("ArrayList after sorting in descending order: " + countries);

        // Sorting the ArrayList in ascending order using ArrayList.sort() method
        countries.sort(Comparator.naturalOrder());
        System.out.println("ArrayList after sorting in ascending order: " + countries);

    }
}
