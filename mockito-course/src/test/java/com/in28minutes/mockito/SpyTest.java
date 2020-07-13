package com.in28minutes.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test_usingMock() {
		List arrayListMock = mock(ArrayList.class);
		
		assertEquals(0, arrayListMock.size());
		
		stub(arrayListMock.size()).toReturn(5);
		arrayListMock.add("Dummy"); // it doesn't change the size() return
		assertEquals(5, arrayListMock.size());
	}
	
	@Test
	public void test_usingSpy() {
		List arrayListSpy = spy(ArrayList.class);
		
		assertEquals(0, arrayListSpy.size());
		arrayListSpy.add("Dummy");
		assertEquals(1, arrayListSpy.size());
		arrayListSpy.remove("Dummy");
		assertEquals(0, arrayListSpy.size());
		

		stub(arrayListSpy.size()).toReturn(5);
		assertEquals(5, arrayListSpy.size());
		

		arrayListSpy.add("Dummy 2");
		verify(arrayListSpy).add("Dummy 2");
		verify(arrayListSpy, never()).clear();
	}

}
