package tasks.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;

import tasks.dao.TaskDao;
import tasks.modelo.Task;

@Controller
public class TasksController {
	
	private final TaskDao dao;

	@Autowired
	public TasksController(TaskDao dao) {
//	public TasksController() {
//		dao = new TaskDao();
		this.dao = dao;
		
	}
	
	
	@RequestMapping("novatask")
	public String form() {
		return "tasks/form-tasks";
	}

	
	@RequestMapping("cadastratask")
	public String cadastra(@Valid Task task, BindingResult result) {
		if (result.hasFieldErrors("descricao")) {
			return "tasks/form-tasks";
		}
		//		if (task.getDescricao() == null || task.getDescricao().equals("")) {
		//			return "tasks/form-tasks";
		//		}
		dao.inserir(task);
		return "tasks/task-cadastrada";
	}

	
	@RequestMapping("gettasks")
	//	public ModelAndView getTasks() {
	//		TaskDao dao = new TaskDao();
	//		List<Task> tasks = dao.getTasks();
	//		
	//		ModelAndView mv = new ModelAndView("pages/get-tasks");
	//		mv.addObject("tasks",tasks);
	//		return mv;
	public String getTasks(Model model) {
		model.addAttribute("tasks", dao.getTasks());
//		return "tasks/get-tasks";		
//		return "tasks/get-tasks-jquery-1"; //precisa do refresh para atualizar a data
		return "tasks/get-tasks-jquery-2"; //não precisa do refresh para atualizar a data
	}

	
	@RequestMapping("excluitask")
	public String exclui(Task task) {
		dao.exclui(task);
		//redirecionameto client side
		return "redirect:gettasks";
		//redirecionameto server side
		//return "forward:tasks/get-tasks";
	}
	
	
	@RequestMapping("buscatask")
	public String busca(Long id, Model model) {
		model.addAttribute("task", dao.getById(id));
		return "tasks/busca-task";
	}
	
	
	@RequestMapping("editatarefa")
	public String edita(Task task) {
		dao.edita(task);
		return "redirect:gettasks";
	}
	
	
	@ResponseBody
	@RequestMapping("finalizatask")
//	public void finaliza(Long id) {
	public void finaliza(Long id) {
		dao.finaliza(id); //so isso na primeira e segunda versão do ajax
	}
}