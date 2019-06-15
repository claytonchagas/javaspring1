package tasks.dao;

//import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tasks.modelo.Task;
//import tasks.modelo.Task2;

@Repository
public class JpaTaskDao2 implements TaskDao2{
//	public class JpaTaskDao2 {	
	@PersistenceContext
	EntityManager manager;
	
	public void inserir(Task task) {
		System.out.println(task.getDescricao());
		manager.persist(task);
	}
	
	public void edita(Task task) {
		manager.merge(task);
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> getTasks() {
		return manager.createQuery("select t from Task t").getResultList();
	}

	public Task getById(Long id) {
		return manager.find(Task.class, id);		
	}

	public void exclui(Task task) {
		Task taskASerExcluida = getById(task.getId());
		manager.remove(taskASerExcluida);
	}

	public void finaliza(Long id) {
		Task task = getById(id);
		task.setFinalizada(true);
//		task.setDataFinalizacao(Calendar.getInstance());
		task.setDataFinalizacao(null);
	}
}