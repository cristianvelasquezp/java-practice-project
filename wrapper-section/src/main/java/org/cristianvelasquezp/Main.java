package org.cristianvelasquezp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*
         * Each primitive data type has a corresponding wrapper class in Java.
         * The wrapper classes are part of the java.lang package,
         * which is imported by default into all Java programs.
         * byte -> Byte
         * short -> Short
         * int -> Integer
         * long -> Long
         * float -> Float
         * double -> Double
         * char -> Character
         * boolean -> Boolean
         *
         */

        // Creating a wrapper object approach 1 ( THIS IS NOT RECOMMENDED BECAUSE IT IS DEPRECATED)

        Integer myInt = new Integer(100);
        Byte myByte = new Byte((byte) 10);
        Short myShort = new Short((short) 5);
        Long myLong = new Long(1000000000);
        Float myFloat = new Float(5.75f);
        Double myDouble = new Double(19.98);
        Character myChar = new Character('A');
        Boolean myBoolean = new Boolean(true);

        System.out.println("Printing wrapper objects created using approach 1");
        System.out.println("Approach 1: " + myInt);
        System.out.println("Approach 1: " + myByte);
        System.out.println("Approach 1: " + myShort);
        System.out.println("Approach 1: " + myLong);
        System.out.println("Approach 1: " + myFloat);
        System.out.println("Approach 1: " + myDouble);
        System.out.println("Approach 1: " + myChar);
        System.out.println("Approach 1: " + myBoolean);

        // Creating a wrapper object approach 2 ( THIS IS RECOMMENDED)
        // This is called as autoboxing
        Integer myInt2 = 100;
        Byte myByte2 = 10;
        Short myShort2 = 5;
        Long myLong2 = 1000000000L;
        Float myFloat2 = 5.75f;
        Double myDouble2 = 19.98;
        Character myChar2 = 'A';
        Boolean myBoolean2 = true;

        System.out.println("--------------------------------------------");
        System.out.println("Printing wrapper objects created using approach 2");
        System.out.println("Approach 2: " + myInt2);
        System.out.println("Approach 2: " + myByte2);
        System.out.println("Approach 2: " + myShort2);
        System.out.println("Approach 2: " + myLong2);
        System.out.println("Approach 2: " + myFloat2);
        System.out.println("Approach 2: " + myDouble2);
        System.out.println("Approach 2: " + myChar2);
        System.out.println("Approach 2: " + myBoolean2);

        // Creating a wrapper object approach 3 ( THIS IS RECOMMENDED)
        // I is also called as boxing
        Integer myInt3 = Integer.valueOf(100);
        Byte myByte3 = Byte.valueOf((byte) 10);
        Short myShort3 = Short.valueOf((short) 5);
        Long myLong3 = Long.valueOf(1000000000);
        Float myFloat3 = Float.valueOf(5.75f);
        Double myDouble3 = Double.valueOf(19.98);
        Character myChar3 = Character.valueOf('A');
        Boolean myBoolean3 = Boolean.valueOf(true);

        System.out.println("--------------------------------------------");
        System.out.println("Printing wrapper objects created using approach 3");
        System.out.println("Approach 3: " + myInt3);
        System.out.println("Approach 3: " + myByte3);
        System.out.println("Approach 3: " + myShort3);
        System.out.println("Approach 3: " + myLong3);
        System.out.println("Approach 3: " + myFloat3);
        System.out.println("Approach 3: " + myDouble3);
        System.out.println("Approach 3: " + myChar3);
        System.out.println("Approach 3: " + myBoolean3);

        //Conversion from String to primitive data type
        String str = "123";
        int myInt4 = Integer.parseInt(str);
        byte myByte4 = Byte.parseByte(str);
        short myShort4 = Short.parseShort(str);
        long myLong4 = Long.parseLong(str);
        float myFloat4 = Float.parseFloat(str);
        double myDouble4 = Double.parseDouble(str);
        char myChar4 = str.charAt(0);
        boolean myBoolean4 = Boolean.parseBoolean("true");

        System.out.println("--------------------------------------------");
        System.out.println("Conversion from String to primitive data type");
        System.out.println("Converting String to primitive value using wrapper functions: " + myInt4);
        System.out.println("Converting String to primitive value using wrapper functions: " + myByte4);
        System.out.println("Converting String to primitive value using wrapper functions: " + myShort4);
        System.out.println("Converting String to primitive value using wrapper functions: " + myLong4);
        System.out.println("Converting String to primitive value using wrapper functions: " + myFloat4);
        System.out.println("Converting String to primitive value using wrapper functions: " + myDouble4);
        System.out.println("Converting String to primitive value using wrapper functions: " + myChar4);
        System.out.println("Converting String to primitive value using wrapper functions: " + myBoolean4);

        //Conversion from Wrapper object to primitive data type
        //It is also called as unboxing
        int myInt5 = myInt3.intValue();
        byte myByte5 = myByte3.byteValue();
        short myShort5 = myShort3.shortValue();
        long myLong5 = myLong3.longValue();
        float myFloat5 = myFloat3.floatValue();
        double myDouble5 = myDouble3.doubleValue();
        char myChar5 = myChar3.charValue();
        boolean myBoolean5 = myBoolean3.booleanValue();

        System.out.println("--------------------------------------------");
        System.out.println("Conversion from Wrapper object to primitive data type");
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myInt5);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myByte5);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myShort5);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myLong5);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myFloat5);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myDouble5);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myChar5);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myBoolean5);

        //This is called as unboxing
        int myInt6 = myInt3;
        byte myByte6 = myByte3;
        short myShort6 = myShort3;
        long myLong6 = myLong3;
        float myFloat6 = myFloat3;
        double myDouble6 = myDouble3;
        char myChar6 = myChar3;
        boolean myBoolean6 = myBoolean3;

        System.out.println("--------------------------------------------");
        System.out.println("Conversion from Wrapper object to primitive data type");
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myInt6);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myByte6);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myShort6);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myLong6);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myFloat6);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myDouble6);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myChar6);
        System.out.println("Converting Wrapper object to primitive value using wrapper functions: " + myBoolean6);


        //Null object when trying to convert to primitive data type will throw NullPointerException
        Integer myInt7 = null;
        try {
            int myInt8 = myInt7;
        } catch (NullPointerException e) {
            System.out.println("Null object when trying to convert to primitive data type will throw NullPointerException");
        }

        /*
         * Wrapper caching
         * The wrapper classes Byte, Short, Integer, Long, Character, and Boolean have an object cache.
         * The cache is used when the valueOf() method is called.
         * The cache is used when the valueOf() method is called with an integer between -128 and 127 as a parameter.
         * The cache improves performance and memory usage.
         * this cache was introduced in Java 5. because java team realized that most of the time we are using the same values
         * and these values are in range of -128 to 127.
         */

        Integer myInt9 = 100;
        Integer myInt10 = 100;
        System.out.println("--------------------------------------------");
        System.out.println("Wrapper caching");
        System.out.println("myInt9 == myInt10: " + (myInt9 == myInt10));

        Integer myInt11 = 1000;
        Integer myInt12 = 1000;
        System.out.println("myInt11 == myInt12: " + (myInt11 == myInt12));



    }
}