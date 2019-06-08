package tasks.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tasks.modelo.Task;

public class InsertTask {
	public static void main(String[] args) {
		Task task = new Task();
		task.setDescricao("teste JPA e Hibernate");
		task.setFinalizada(true);
		task.setDataFinalizacao(Calendar.getInstance());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(task);
		manager.getTransaction().commit();
		
		System.out.println("Testando JPA e Hibernate");
		
		manager.close();
		
	}

}
