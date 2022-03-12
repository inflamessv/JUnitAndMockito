package com.data.business;

import java.util.ArrayList;
import java.util.List;

import com.data.api.TodoService;

public class TodoBusinessImp {

	private TodoService todoService;
	
	 TodoBusinessImp(TodoService todoService) {
		this.todoService=todoService;
	}
	
	public List<String> retrieveTodosRelatedToString(String user){
		List<String> filteredTodos=new ArrayList<String>();
		List<String> allTodos=todoService.retrieveTodos(user);
		
		for(String todo:allTodos) {
			if(todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		
		return filteredTodos;
	}
}
