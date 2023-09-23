package br.com.agencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agencia.factory.ConnectionFactory;
import br.com.agencia.model.Viagem;

public class ViagemDAO {
	public void salvarViagem(Viagem viagem) {
		String sql = "INSERT INTO viagem(destino, preco, data_ida, data_volta, descricao, adicional, tipo_pacote) VALUES (?,?,?,?,?,?,?)";
		
		//Ainda não existe a conexão
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//tentativa de conexão com o banco
		try {
			// Cria a conexão com o BD chamando a classe Connection Factory
			conn = ConnectionFactory.createConnectionToMySQL();
			// passando a string de execução sql 
			pstm = conn.prepareStatement(sql);
			
			// Adiciona os 3 valores esperados pela Query
			pstm.setString(1, viagem.getDestino());
			pstm.setDouble(2, viagem.getPreco());
			pstm.setString(3, viagem.getData_ida() );
			pstm.setString(4, viagem.getData_volta());
			pstm.setString(5, viagem.getDescricao());
			pstm.setString(6, viagem.getAdicional());
			pstm.setString(7, viagem.getTipo_pacote());
			
			//Execução da query
			pstm.execute();
		} catch(Exception e) {
			// Caso der alguma exception, ele mostra no console
			e.printStackTrace();
		} finally {
			try {
				// Fecha as conexões caso for != de null
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<Viagem> getViagens(){
		String sql = "SELECT * FROM viagem";
		
		//Preparação da list para receber os dados
		List<Viagem> viagens = new ArrayList<Viagem>();
		
		//Conexão com o BD
		Connection conn = null;
		PreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do BD *** SELECT ***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			// Enquanto o rset tiver dados para percorrer
			while(rset.next()) {
				Viagem viagem = new Viagem();
				
				//Recuperação dos dados separadamente
				viagem.setId(rset.getInt("id"));
				viagem.setDestino(rset.getString("destino"));
				viagem.setPreco(rset.getDouble("preco"));
				viagem.setData_ida(rset.getString("data_ida"));
				viagem.setData_volta(rset.getString("data_volta"));
				viagem.setDescricao(rset.getString("descricao"));
				viagem.setAdicional(rset.getString("adicional"));
				viagem.setTipo_pacote(rset.getString("tipo_pacote"));
				
				viagens.add(viagem);
			}
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null) {
				rset.close();
				}
				if(pstm!=null) {
				pstm.close();
				}
				if(conn!=null) {
				conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return viagens;
	}
	
	
	public void atualizarViagem(Viagem viagem) {
		String sql = "UPDATE viagem SET destino=?, preco=?, data_ida=?, data_volta=?, descricao=?, adicional=?, tipo_pacote=?"+"WHERE id=? ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Conexão com o BD
			conn = ConnectionFactory.createConnectionToMySQL();
			//Preparação da query
			pstm = conn.prepareStatement(sql);
			
			//destino, preco, data_ida, data_volta, descricao, adicional
			//Adicionar os valores a atualizar
			pstm.setString(1, viagem.getDestino());
			pstm.setDouble(2, viagem.getPreco());
			pstm.setString(3, viagem.getData_ida());
			pstm.setString(4, viagem.getData_volta());
			pstm.setString(5, viagem.getDescricao());
			pstm.setString(6, viagem.getAdicional());
			pstm.setString(7, viagem.getTipo_pacote());
			
			//Campo WHERE, onde pergunta qual o ID a ser editado
			pstm.setInt(8, viagem.getId());
			
			//Executa a query
			pstm.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {	
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deletarPorId(int id) {
		String sql = "DELETE FROM viagem WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<Viagem> separarPctConv() {
		String sql = "SELECT * FROM viagem WHERE tipo_pacote='convencional'";
		
		List<Viagem> viagensConv = new ArrayList<Viagem>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do BD *** SELECT ***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			// Enquanto o rset tiver dados para percorrer
			while(rset.next()) {
				Viagem viagemConv = new Viagem();
				
				//Recuperação dos dados separadamente
				viagemConv.setId(rset.getInt("id"));
				viagemConv.setDestino(rset.getString("destino"));
				viagemConv.setPreco(rset.getDouble("preco"));
				viagemConv.setData_ida(rset.getString("data_ida"));
				viagemConv.setData_volta(rset.getString("data_volta"));
				viagemConv.setDescricao(rset.getString("descricao"));
				viagemConv.setAdicional(rset.getString("adicional"));
				viagemConv.setTipo_pacote(rset.getString("tipo_pacote"));
				
				viagensConv.add(viagemConv);
			}
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null) {
				rset.close();
				}
				if(pstm!=null) {
				pstm.close();
				}
				if(conn!=null) {
				conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return viagensConv;
	}
	
	public List<Viagem> separarPctProm() {
		String sql = "SELECT * FROM viagem WHERE tipo_pacote='promocional'";
		
		List<Viagem> viagensProm = new ArrayList<Viagem>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do BD *** SELECT ***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			// Enquanto o rset tiver dados para percorrer
			while(rset.next()) {
				Viagem viagemProm = new Viagem();
				
				//Recuperação dos dados separadamente
				viagemProm.setId(rset.getInt("id"));
				viagemProm.setDestino(rset.getString("destino"));
				viagemProm.setPreco(rset.getDouble("preco"));
				viagemProm.setData_ida(rset.getString("data_ida"));
				viagemProm.setData_volta(rset.getString("data_volta"));
				viagemProm.setDescricao(rset.getString("descricao"));
				viagemProm.setAdicional(rset.getString("adicional"));
				viagemProm.setTipo_pacote(rset.getString("tipo_pacote"));
				
				viagensProm.add(viagemProm);
			}
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null) {
				rset.close();
				}
				if(pstm!=null) {
				pstm.close();
				}
				if(conn!=null) {
				conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return viagensProm;
	}
	
	public List<Viagem> getViagensById(int id){
		String sql = "SELECT * FROM viagem WHERE id=?";
		
		//Preparação da list para receber os dados
		List<Viagem> viagens = new ArrayList<Viagem>();
		
		//Conexão com o BD
		Connection conn = null;
		PreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do BD *** SELECT ***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			// Enquanto o rset tiver dados para percorrer
			while(rset.next()) {
				Viagem viagem = new Viagem();
				
				//Recuperação dos dados separadamente
				viagem.setId(rset.getInt("id"));
				viagem.setDestino(rset.getString("destino"));
				viagem.setPreco(rset.getDouble("preco"));
				viagem.setData_ida(rset.getString("data_ida"));
				viagem.setData_volta(rset.getString("data_volta"));
				viagem.setDescricao(rset.getString("descricao"));
				viagem.setAdicional(rset.getString("adicional"));
				viagem.setTipo_pacote(rset.getString("tipo_pacote"));
				
				viagens.add(viagem);
			}
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null) {
				rset.close();
				}
				if(pstm!=null) {
				pstm.close();
				}
				if(conn!=null) {
				conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return viagens;
	}
	
}

