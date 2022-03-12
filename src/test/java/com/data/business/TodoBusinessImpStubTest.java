package com.data.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.data.api.TodoService;
import com.data.api.TodoServiceStub;

public class TodoBusinessImpStubTest {

	@Test
	public void test() {
		TodoService todoServiceStub=new TodoServiceStub();
		TodoBusinessImp todoBusinessimpl=new TodoBusinessImp(todoServiceStub);
		List<String>filteredTodos=todoBusinessimpl.retrieveTodosRelatedToString("dummy");
		assertEquals(2, filteredTodos.size());	
	}

}
