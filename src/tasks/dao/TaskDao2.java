package tasks.dao;

import java.util.List;

import tasks.modelo.Task;
//import tasks.modelo.Task2;

public interface TaskDao2 {
	Task getById(Long id);
	List<Task> getTasks();
	void inserir(Task task);
	void edita(Task task);
	void exclui(Task task);
	void finaliza(Long id);
}