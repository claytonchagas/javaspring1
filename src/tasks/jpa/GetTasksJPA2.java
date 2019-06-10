package tasks.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import tasks.modelo.Task2;

public class GetTasksJPA2 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks9");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select t from Task2 as t where t.finalizada = :paramFinalizada");
		
		query.setParameter("paramFinalizada", true);
		
		@SuppressWarnings("unchecked")
		List<Task2> tasks = query.getResultList();
		
		for (Task2 task : tasks) {
			System.out.println(task.getDescricao());
		}
		
		manager.close();
		factory.close();
	}
}