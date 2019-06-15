package tasks.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tasks.modelo.Task;
//import tasks.modelo.Task2;

public class UpDateTask {
	public static void main(String[] args) {
		Task task = new Task();
		
		task.setId(2L);
		task.setDescricao("estudar muito mais JPA2 e Hibernate");
		task.setFinalizada(false);
		task.setDataFinalizacao(null);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks9");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(task);
		manager.getTransaction().commit();
		
		System.out.println("Testando JPA e Hibernate");
		System.out.println("ID da task: "+task.getId());
		
		manager.close();
	}
}