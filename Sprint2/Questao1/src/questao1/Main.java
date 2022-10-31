package questao1;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Main {

	static int idAtualiza = 0;
	static int idDeleta = 0;
	static int counter = 0;

	public static void main(String[] args) throws SQLException {
	boolean loop = true;
	Conexao con = new Conexao();

		while (loop) {
			System.out.println("1 - Cadastrar produtos");
			System.out.println("2 - Atualizar primeiro produto");
			System.out.println("3 - Apagar segundo produto cadastrado");
			System.out.println("0 - Finalizar \n");
			System.out.println("Escolha uma opcao:");
			String choiceMade = new Scanner(System.in).nextLine();
			
			switch (choiceMade) {
			case "1":
				try (Connection connection = con.buscaConexao()) {
					connection.setAutoCommit(false);
					counter = 0;
					idDeleta = 0;
					idAtualiza = 0;

					try (PreparedStatement stm = connection.prepareStatement(
							"INSERT INTO PRODUTO (nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?);",
							Statement.RETURN_GENERATED_KEYS)) {

						adicionarVariavel("Camiseta", "Camiseta DC Comics", 12, 49, stm);
						adicionarVariavel("Meias", "Meias Marvel", 2, 19, stm);
						adicionarVariavel("Bone", "Bone Adidas", 1, 20, stm);

						connection.commit();
						System.out.println("Produtos inseridos\n");
					}

					catch (Exception e) {
						System.out.println("Erro no envio");
						e.printStackTrace();
					}
				}
				break;
			case "2":
				if (idAtualiza == 0) {
					System.out.println(
							"Nenhum produto novo encontrado");
					break;
				} else {
					try (Connection connection = con.buscaConexao()) {
	
						try (PreparedStatement stm = connection.prepareStatement(
								"UPDATE PRODUTO SET nome = 'Calca Jeans', descricao = 'Calca Jeans Azul', quantidade = 6, preco = 99  WHERE ID = ?;", Statement.RETURN_GENERATED_KEYS)) {
							stm.setInt(1, idAtualiza);
							stm.execute();
							System.out.println("Produto atualizado\n");
						}
	
						catch (Exception e) {
							System.out.println("Problema encontrado");
							e.printStackTrace();
						}
					}
				}
				break;
			case "3":
				if (idDeleta == 0) {
					System.out.println(
							"Nenhum produto novo encontrado\"");
					break;
				} else {
					try (Connection connection = con.buscaConexao()) {

						try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?;")) {
							stm.setInt(1, idDeleta);
							stm.execute();

							Integer linhasModificadas = stm.getUpdateCount();
							if (linhasModificadas != 0) {
								System.out.println("Produto excluido");
							} else {
								System.out.println(
										"Produto ja excluido");
							}
						} catch (Exception e) {
							System.out.println("Erro");
							e.printStackTrace();
						}
					}
				}
				break;
			case "0":
				System.out.println("Encerrado");
				loop = false;
				break;
			}
			System.out.println("");
		}

	}

	private static void adicionarVariavel(String nome, String descricao, int quantidade, double preco,
			PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.setInt(3, quantidade);
		stm.setDouble(4, preco);
		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			counter++;
			Integer id = rst.getInt(1);
			
			if (counter == 1) {
				idAtualiza = id;
				System.out.println(idAtualiza);
			}
			if (counter == 2) {
				idDeleta = id;
			}
}
}
}