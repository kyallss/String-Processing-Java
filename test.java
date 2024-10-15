package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {
    StringProcessor processor = new StringProcessor();

    @Test
    void isStrongPassword() {
            assertTrue(processor.isStrongPassword("StrongP@ss1"));
            assertFalse(processor.isStrongPassword("weakp@ss1"));
            assertFalse(processor.isStrongPassword("StrongPass@"));
            assertFalse(processor.isStrongPassword("StrongPass1"));
    }

    @Test
    void calculateDigits() {
        assertEquals(4, processor.calculateDigits("There are 1234 numbers"));
        assertEquals(0, processor.calculateDigits("No digits here"));
    }

    @org.junit.jupiter.api.Test
    void calculateWords() {
        assertEquals(5, processor.calculateWords("This is a simple sentence"));
        assertEquals(0, processor.calculateWords(""));
    }

    @org.junit.jupiter.api.Test
    void calculateExpression() {
        assertEquals(5.0, processor.calculateExpression("2 + 3"), 0.001);
        assertEquals(14.0, processor.calculateExpression("2 * (3 + 4)"), 0.001);
    }
}
