package test;
import main.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    @Test
    void testPush() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push(10);
        stack.push(20);

        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
        assertThrows(IllegalArgumentException.class, ()-> stack.push(null));
    }
    @Test
    void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(1, stack.size());
        assertEquals(10, stack.pop());
        assertEquals(0, stack.size());
        assertThrows(IllegalStateException.class, stack::pop);
    }
    @Test
    void testPeek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());

        assertEquals(stack.peek(), stack.pop());
        //
        stack.pop();
        assertThrows(IllegalStateException.class, stack::peek);
    }
    @Test
    void testIsEmpty() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testToString() {
        Stack<Integer> stack = new Stack<>();
        assertEquals(stack.toString(), "[]");

        stack.push(10);
        stack.push(20);
        assertEquals(stack.toString(), "[20, 10]");

        stack.pop();
        assertEquals(stack.toString(), "[10]");

    }
}
