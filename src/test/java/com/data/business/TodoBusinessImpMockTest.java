package com.data.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.data.api.TodoService;
import com.data.api.TodoServiceStub;

public class TodoBusinessImpMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		
		TodoService todoServiceMock=mock(TodoService.class);		
		List<String>todos=Arrays.asList("Learn Spring MVC","Learn Spring","Learn to dance");
		
		when(todoServiceMock.retrieveTodos("dummy")).thenReturn(todos);
		
		TodoBusinessImp todoBusinessimpl=new TodoBusinessImp(todoServiceMock);		
		List<String>filteredTodos=todoBusinessimpl.retrieveTodosRelatedToString("dummy");
		
		assertEquals(2, filteredTodos.size());	
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		//GIVEN
		TodoService todoServiceMock=mock(TodoService.class);		
		List<String>todos=Arrays.asList("Learn Spring MVC","Learn Spring","Learn to dance");		
		given(todoServiceMock.retrieveTodos("dummy")).willReturn(todos);
		TodoBusinessImp todoBusinessimpl=new TodoBusinessImp(todoServiceMock);
		//WHEN
		List<String>filteredTodos=todoBusinessimpl.retrieveTodosRelatedToString("dummy");		
		//THEN	
		assertThat(filteredTodos.size(),is(2));	
	}

}
