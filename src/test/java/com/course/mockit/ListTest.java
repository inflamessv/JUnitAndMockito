package com.course.mockit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.awt.List;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockList_Size() {
		LinkedList list=mock(LinkedList.class);
		when(list.size()).thenReturn(3);
		assertEquals(3, list.size());
	}
	
	@Test
	public void letsMockingList_MultipleResults() {
		LinkedList lst=mock(LinkedList.class);
		when(lst.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, lst.size());
		assertEquals(3, lst.size());
	}

	@Test
	public void letsMockingList_AnyInt() {
		LinkedList lst=mock(LinkedList.class);
		when(lst.get(anyInt())).thenReturn("test");
		assertEquals("test", lst.get(anyInt()));
	}
	
	@Test
	public void letsMockingList_BDD_AnyInt() {
		//GIVEN
		LinkedList linkedList= mock(LinkedList.class);
		given(linkedList.get(anyInt())).willReturn("giovanni");
		
		//WHEN
		linkedList.get(0);
		
		//THEN
		//assertThat(linkedList.size(),is(0));
		assertThat("Giovanni", is(linkedList.get(0)));
	}
	
	@Test(expected = RuntimeException.class)
	public void letsMockingList_RuntimeException(){
		LinkedList lst=mock(LinkedList.class);
		when(lst.get(anyInt())).thenThrow(new RuntimeException("something"));
		lst.get(0);
	}
	
	@Test(expected = RuntimeException.class)
	public void letsMockingList_MixingUp() {
		LinkedList lst=mock(LinkedList.class);
		when(lst.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));
		lst.get(0);
	}
}
