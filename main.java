public class Main {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();

        System.out.println(processor.isStrongPassword("AsykpaevaK"));
        System.out.println(processor.isStrongPassword("org&rea@"));

        System.out.println(processor.calculateDigits("There are 123 numbers."));

        System.out.println(processor.calculateWords("Hello, my name is Kyial"));

        System.out.println(processor.calculateExpression("(1 + (2 * 3) - 4) / 2"));
    }
}
