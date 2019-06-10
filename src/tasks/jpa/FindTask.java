package tasks.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tasks.modelo.Task2;

public class FindTask {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks9");
		EntityManager manager = factory.createEntityManager();
		
		Task2 resultTask = manager.find(Task2.class, 1L);
		System.out.println("Id e descrição da task pesquisada: "+resultTask.getId()+" / "+resultTask.getDescricao());
		
		manager.close();
	}
}