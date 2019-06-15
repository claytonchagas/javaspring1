package tasks.controller;

import javax.transaction.Transactional;

//import java.io.IOException;
//import java.util.Date;
//import java.text.SimpleDateFormat;

//import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.ResponseBody;

//import tasks.dao.TaskDao;
import tasks.dao.TaskDao2;
import tasks.modelo.Task;
//import tasks.modelo.Task2;

@Transactional
@Controller
public class TasksController {
	
	@Autowired
	@Qualifier("jpaTaskDao2")
//	@Qualifier("taskDao")
	TaskDao2 dao;

////	private final TaskDao dao;
//	private final TaskDao2 dao;
//
//	@Autowired
////	@Qualifier("jpaTaskDao2")
////	public TasksController(TaskDao dao) {
//	public TasksController(TaskDao2 dao) {
//		//	public TasksController() {
//		//		dao = new TaskDao();
//		this.dao = dao;
//
//	}
	
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
		System.out.println(task.getDescricao());
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
//		return "tasks/get-tasks-jquery-1"; //atualiza status para "Finalizada" on_the_fly, mas precisa do refresh para atualizar a data
//		return "tasks/get-tasks-jquery-2"; //não precisa do refresh para atualizar a data, mas carrega tudo com a função "reload"
//		return "tasks/get-tasks-jquery-3"; //não precisa carregar tudo
		return "tasks/get-tasks-jquery-4";
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


//	@ResponseBody //para não precisar injetar o Status 200 no response, tendo que utilizar um HttpServletResponse como parâmetro
//	@RequestMapping("finalizatask")
//	public void finaliza(Long id) {
//		dao.finaliza(id); //so isso no jquery-1.jsp e jquery-2.jsp
//	}

	
//	@RequestMapping("finalizatask")
//	// Preenche a data de forma automatica no jquery-3.jsp, mas muito baixo nível: HTTP
//	public void finaliza(Long id, HttpServletResponse response) throws IOException {
//		dao.finaliza(id);
//		Date dataFinalizacao = (Date) dao.getById(id).getDataFinalizacao().getTime();
//		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataFinalizacao);
//		response.getWriter().write(data);
//		response.setStatus(200);
//	}

	
//	@RequestMapping("finalizatask")
//	// Preenche a data de forma automatica no jquery-3.jsp, atualizando a coluna <td> de data injetando "data-finalizada.jsp" no jquery-3.jsp
//	public String finaliza(Long id, Model model) {
//		dao.finaliza(id);
//		model.addAttribute("task", dao.getById(id));
//		return "tasks/data-finalizada";
//	}

	
	@RequestMapping("finalizatask")
	// Preenche a data de forma automatica no jquery-4.jsp, atualizando todos os campos de <tr> de uma vez injetando "data-finalizada2.jsp" no jquery-4.jsp
	public String finaliza(Long id, Model model) {
		dao.finaliza(id);
		model.addAttribute("task", dao.getById(id));
		return "tasks/data-finalizada2";
	}
}