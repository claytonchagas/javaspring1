package tasks.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tasks.modelo.Task;
//import tasks.modelo.Task2;

public class InsertTask {
	public static void main(String[] args) {
//		Task2 task = new Task2();
		Task task = new Task();
		task.setDescricao("estudar muito JPA e Hibernate");
		task.setFinalizada(true);
		task.setDataFinalizacao(Calendar.getInstance());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks9");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(task);
		manager.getTransaction().commit();
		
		System.out.println("Testando JPA e Hibernate");
		System.out.println("ID da task: "+task.getId());
		
		manager.close();
	}
}