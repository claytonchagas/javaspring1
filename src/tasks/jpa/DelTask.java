package tasks.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tasks.modelo.Task;
//import tasks.modelo.Task2;

public class DelTask {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks9");
		EntityManager manager = factory.createEntityManager();
		
//		Task2 resultTask = manager.find(Task2.class, 1L);
//		Task2 resultTask = manager.find(Task2.class, 2L);
//		Task resultTask = manager.find(Task.class, 3L);
		Task resultTask = manager.find(Task.class, 1L);
		
		manager.getTransaction().begin();
		manager.remove(resultTask);
		manager.getTransaction().commit();
		
		System.out.println("Teste Del com JPA");
		System.out.println("ID da task: "+resultTask.getId());
		
		manager.close();
	}
}