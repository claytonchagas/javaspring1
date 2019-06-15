package tasks.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tasks.modelo.Task;

public class GetTasksJPA {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks9");
		EntityManager manager = factory.createEntityManager();
		
		@SuppressWarnings("unchecked")
		List<Task> tasks = manager.createQuery("select t from Task as t where t.finalizada = true").getResultList();
		for (Task task : tasks) {
			System.out.println(task.getDescricao());
		}
		
		manager.close();
		factory.close();
	}
}