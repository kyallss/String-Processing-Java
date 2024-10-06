package org.example;

public class TestStringProcessor {
    public class TestStringProcessor {
        public static void main(String[] args) {
            StringProcessor processor = new StringProcessor();

            System.out.println("isStrongPassword Tests:");
            System.out.println(processor.isStrongPassword("P@ssw0rd"));
            System.out.println(processor.isStrongPassword("Weakpass1!"));
            System.out.println(processor.isStrongPassword("12345678"));
            System.out.println(processor.isStrongPassword("password!"));
            System.out.println(processor.isStrongPassword("PASSWORD1"));

            System.out.println("\ncalculateDigits Tests:");
            System.out.println(processor.calculateDigits("There are 123 numbers.")); 
            System.out.println(processor.calculateDigits("No digits here!")); 
            System.out.println(processor.calculateDigits("1a2b3c4d5e")); 
            System.out.println(processor.calculateDigits("5 apples and 2 oranges.")); 
            System.out.println(processor.calculateDigits("The year is 2024.")); 

            System.out.println("\ncalculateWords Tests:");
            System.out.println(processor.calculateWords("Hello world, welcome to Java!")); 
            System.out.println(processor.calculateWords("    ")); 
            System.out.println(processor.calculateWords("One word.")); 
            System.out.println(processor.calculateWords("   Multiple   spaces    in   between   words.")); 
            System.out.println(processor.calculateWords("")); 

            System.out.println("\ncalculateExpression Tests:");
            System.out.println(processor.calculateExpression("2 + 3 * 4")); 
            System.out.println(processor.calculateExpression("(1 + 2) * 3")); 
            System.out.println(processor.calculateExpression("10 / 2 + 5")); 
            System.out.println(processor.calculateExpression("100 - (20 + 30)")); 
            System.out.println(processor.calculateExpression("5 * (3 + 2) - 10 / 2")); 
        }
    }

}
