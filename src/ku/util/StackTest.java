package ku.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

	private Stack stack;

	@Before
	public void setStack() {
		StackFactory.setStackType(1);
		stack = StackFactory.makeStack(5);
	}

	@After
	public void resetStack() {
		stack = null;
	}

	@Test
	public void checkNewCreatedEmptyStack() {
		assertTrue("Your Stack is not Empty", stack.isEmpty());
		assertFalse("Your Stack is not Empty", stack.isFull());
		assertEquals(0, stack.size());
	}

	@Test (expected = java.util.EmptyStackException.class)
	public void removeItemFromEmptyStack() {
		Assume.assumeTrue(stack.isEmpty());
		stack.pop();
	}

	@Test (expected = java.lang.IllegalStateException.class)
	public void pushToFullStack() {
		for(int x = 0; x<6; x++){
			stack.push(1);
		}
	}

	@Test (expected = java.lang.Exception.class)
	public void nullParameterPush() {
		stack.push(null);
	}

	@Test
	public void isFullMethodCorrect() {
		for(int x = 0; x<5; x++){
			stack.push(1);
		}
		assertTrue("isFull method is wrong!", stack.isFull());
	}
	
	@Test
	public void isEmptyMethodCorrecrt() {
		stack.push(1);
		assertFalse("isEmpty method is wrong!", stack.isEmpty());
	}

}
