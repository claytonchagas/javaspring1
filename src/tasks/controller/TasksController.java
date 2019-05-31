package tasks.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import tasks.dao.TaskDao;
import tasks.modelo.Task;

@Controller
public class TasksController {
	@RequestMapping("novatask")
	public String form() {
		return "tasks/form-tasks";
	}
	
	@RequestMapping("cadastratask")
	public String cadastra(@Valid Task task, BindingResult result) throws SQLException {
		
		if (result.hasFieldErrors("descricao")) {
			return "tasks/form-tasks";
		}
//		if (task.getDescricao() == null || task.getDescricao().equals("")) {
//			return "tasks/form-tasks";
//		}
		TaskDao dao = new TaskDao();
		dao.inserir(task);
		return "tasks/task-cadastrada";
	}
	
}
