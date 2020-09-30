package br.com.gabriel.treinamento.main;

import java.sql.SQLException;

import br.com.gabriel.treinamento.dao.PlayerDAO;
import br.com.gabriel.treinamento.model.Player;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Player player = new Player();
		PlayerDAO playerDao = new PlayerDAO();
		/*
		 * CREATE 
		
		player.setNome("Gabriel");
		player.setNickJogo("horus");
		player.setIdade(21);
		player.setLevel(150);
		player.setEllo("Lendario");
		player.setCompetitivo(true);
		
		playerDao.save(player);
		*/
		
		/*
		 * LER TODOs os Dados da tabela
		 
		try {
		for(Player p : playerDao.selectAll()) {
			System.out.println("PLAYER");
			System.out.println("ID: " + p.getId());
			System.out.println("Nome: " + p.getNome());
			System.out.println("Nick no Jogo: " + p.getNickJogo());
			System.out.println("Level: "+ p.getLevel());
			System.out.println("Ranking: "+ p.getEllo());
			System.out.println("idade: "+ p.getIdade());
			System.out.println("E do competitivo: " + p.isCompetitivo());
			System.out.println("______________________________________");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		 * READ POR ID
		 
		Player playerSelect = playerDao.selectById(2);
		System.out.println("PLAYER");
		System.out.println("ID: " + playerSelect.getId());
		System.out.println("Nome: " + playerSelect.getNome());
		System.out.println("Nick no Jogo: " + playerSelect.getNickJogo());
		System.out.println("Level: "+ playerSelect.getLevel());
		System.out.println("Ranking: "+ playerSelect.getEllo());
		System.out.println("idade: "+ playerSelect.getIdade());
		System.out.println("E do competitivo: " + playerSelect.isCompetitivo());
		System.out.println("______________________________________");
		
		*/
		Player playerUpdate = new Player();
		playerUpdate.setNickJogo("NoW_HORUS");
		playerDao.update(playerUpdate, 2);
		
		
		/*
		 * DELETE
		playerDao.delete(1);
		*/
	}
}
