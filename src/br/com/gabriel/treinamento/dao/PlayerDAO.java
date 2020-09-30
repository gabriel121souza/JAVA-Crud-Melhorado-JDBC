package br.com.gabriel.treinamento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gabriel.treinamento.connectionFactory.ConnectionFactory;
import br.com.gabriel.treinamento.model.Player;

public class PlayerDAO {
	public void save(Player player) {

		String sql = "INSERT INTO players(nome, nick_jogo, idade, ello, level, competitivo) VALUES(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, player.getNome());
		pstm.setString(2, player.getNickJogo());
		pstm.setInt(3, player.getIdade());
		pstm.setString(4, player.getEllo());
		pstm.setInt(5, player.getLevel());
		pstm.setBoolean(6, player.isCompetitivo());
		pstm.execute();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}if(pstm != null) {
					pstm.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public List<Player> selectAll() {
		List<Player>players = new ArrayList<Player>();
		
		String sql = "SELECT * FROM players";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
		
			while(rset.next()) {
				Player player = new Player();
				player.setId(rset.getInt("id"));
				player.setNome(rset.getString("nome"));
				player.setNickJogo(rset.getString("nick_jogo"));
				player.setLevel(rset.getInt("level"));
				player.setEllo(rset.getString("ello"));
				player.setIdade(rset.getInt("idade"));
				player.setCompetitivo(rset.getBoolean("competitivo"));
				players.add(player);
				
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
					if (pstm!=null){
						pstm.close();
					}
					if (rset !=null) {
						rset.close();
					}
							
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			return players;
			}

	
	public Player selectById(int id) {
		Player player = new Player();
		String sql = "SELECT * FROM players WHERE id = ? ";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				player.setId(rset.getInt("id"));
				player.setNome(rset.getString("nome"));
				player.setNickJogo(rset.getString("nick_jogo"));
				player.setLevel(rset.getInt("level"));
				player.setEllo(rset.getString("ello"));
				player.setIdade(rset.getInt("idade"));
				player.setCompetitivo(rset.getBoolean("competitivo"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
					if(pstm!=null) {
						pstm.close();
					}
					if(rset != null) {
						rset.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		return player;
	}

	public void delete(int id) {
		String sql = "DELETE FROM players WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.executeUpdate();
		System.out.println("Foi apagado com sucesso");
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(conn != null) {
				conn.close();
			}if(pstm != null) {
				pstm.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
			}
		}
	}
	
	public void update(Player player, int id) {
		String sql = "UPDATE players SET nome = ?, nick_jogo = ?, ello = ?, level = ?, idade = ?, competitivo = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, player.getNome());
		pstm.setString(2, player.getNickJogo());
		pstm.setString(3, player.getEllo());
		pstm.setInt(4, player.getLevel());
		pstm.setInt(5, player.getIdade());
		pstm.setBoolean(6, player.isCompetitivo());
		
		System.out.println("usuario alterado com sucesso");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstm !=null) {
					pstm.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}