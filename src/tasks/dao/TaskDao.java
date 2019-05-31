package tasks.dao;

import tasks.jdbc.ConnectionFactory;
import tasks.modelo.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDao {
	
	private final Connection connection;

	public TaskDao() throws SQLException {
               this.connection = new ConnectionFactory().getConnection();
       }

	public void inserir(Task task) {
		String sql = "insert into tasks (descricao, finalizada) values (?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, task.getDescricao());
			stmt.setBoolean(2, task.isFinalizada());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
}

//public class JdbcTarefaDao {
//	private final Connection connection;
//
//	public JdbcTarefaDao() {
//               try {
//                       this.connection = new ConnectionFactory().getConnection();
//               } catch (SQLException e) {
//                       throw new RuntimeException(e);
//               }
//       }
//
//	public void adiciona(Tarefa tarefa) {
//		String sql = "insert into tarefas (descricao, finalizacao) values (?,?)";
//		PreparedStatement stmt;
//		try {
//			stmt = connection.prepareStatement(sql);
//			stmt.setString(1, tarefa.getDescricao());
//			stmt.setBoolean(2, tarefa.isFinalizacao());
//			stmt.execute();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public void remove(Tarefa tarefa) {
//
//		if(tarefa.getId() == null) {
//			throw new IllegalStateException("Id da tarefa não deve ser nula.");
//		}
//		
//		String sql = "delete from tarefas where id = ?";
//		PreparedStatement stmt;
//		try {
//			stmt = connection.prepareStatement(sql);
//			stmt.setLong(1, tarefa.getId());
//			stmt.execute();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public void altera(Tarefa tarefa) {
//		String sql = "update tarefas set descricao = ? where id = ?";
//		PreparedStatement stmt;
//		try {
//			stmt = connection.prepareStatement(sql);
//			stmt.setString(1, tarefa.getDescricao());
//			//stmt.setBoolean(2, tarefa.isFinalizacao());
//			//stmt.setDate(3, tarefa.getDataFinalizacao() != null ? new Date(tarefa.getDataFinalizacao().getTimeInMillis()) : null);
//			//stmt.setLong(2, tarefa.getId());
//			stmt.setLong(2, tarefa.getId());
//			stmt.execute();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public List<Tarefa> lista() {
//		try {
//			List<Tarefa> tarefas = new ArrayList<Tarefa>();
//			PreparedStatement stmt = this.connection.prepareStatement("select * from tarefas");
//
//			ResultSet rs = stmt.executeQuery();
//
//			while(rs.next()) {
//				//adiciona a tarefa na lista
//				tarefas.add(populaTarefa(rs));
//			}
//
//			rs.close();
//			stmt.close();
//
//			return tarefas;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	public Tarefa buscaPorId(Long id) {
//               
//               if(id == null) {
//                       throw new IllegalStateException("Id da tarefa não deve ser nula.");
//               }
//               
//               try {
//                       PreparedStatement stmt = this.connection.prepareStatement("select * from tarefas where id = ?");
//                       stmt.setLong(1, id);
//
//                       ResultSet rs = stmt.executeQuery();
//
//                       if(rs.next()) {
//                               return populaTarefa(rs);
//                       }
//
//                       rs.close();
//                       stmt.close();
//
//                       return null;
//               } catch (SQLException e) {
//                       throw new RuntimeException(e);
//               }
//       }
//	
//	public void finaliza(Long id) {
//               
//               if(id == null) {
//                       throw new IllegalStateException("Id da tarefa não deve ser nula.");
//               }
//               
//               String sql = "update tarefas set finalizacao = ?, dataFinalizacao = ? where id = ?";
//               PreparedStatement stmt;
//               try {
//                       stmt = connection.prepareStatement(sql);
//                       stmt.setBoolean(1, true);
//                       stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
//                       stmt.setLong(3, id);
//                       stmt.execute();
//               } catch (SQLException e) {
//                       throw new RuntimeException(e);
//               }
//       }
//
//	private Tarefa populaTarefa(ResultSet rs) throws SQLException {
//		Tarefa tarefa = new Tarefa();
//		
//		//popula o objeto tarefa
//		tarefa.setId(rs.getLong("id"));
//		tarefa.setDescricao(rs.getString("descricao"));
//		tarefa.setFinalizacao(rs.getBoolean("finalizacao"));
//		
//		//popula a data de finalizacao da tarefa, fazendo a conversao
//		Date data = rs.getDate("dataFinalizacao");
//		if(data != null) {
//			Calendar dataFinalizacao = Calendar.getInstance();
//			dataFinalizacao.setTime(data);
//			tarefa.setDataFinalizacao(dataFinalizacao);
//		}
//		return tarefa;
//	}
//}