package questao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Main {

	private static final Scanner SCANNER = new Scanner(System.in);
	public static void main(String[] args) throws SQLException {

		boolean busca = true;
		Conexao con = new Conexao();

		while (busca) {
			try (Connection connection = con.getConnection()) {
				System.out.println("ESCOLHA A FORMA DE EXIBICAO");
				System.out.println("Informe quantos filmes quer ver na sua pagina");
				int filmePagina = SCANNER.nextInt();
				System.out.println("Qual pagina quer que seja exibida?");
				int pagina = SCANNER.nextInt();
				int filmeIn = ((pagina * filmePagina) - filmePagina);
				try (PreparedStatement stm = connection.prepareStatement("SELECT * FROM filmes LIMIT ?, ?;",
						Statement.RETURN_GENERATED_KEYS)) {
					stm.setInt(1, filmeIn);
					stm.setInt(2, filmePagina);
					stm.execute();
					ResultSet rst = stm.getResultSet();

					while (rst.next()) {
						int id = rst.getInt("ID");
						System.out.println("id: " + id);
						String nome = rst.getString("NOME");
						System.out.println("Nome: " + nome);
						String descricao = rst.getString("DESCRICAO");
						System.out.println("Descricao: " + descricao);
						int ano = rst.getInt("ANO");
						System.out.println("Ano: " + ano + "\n");
					}

				} catch (Exception e) {
					System.out.println("Problema na resolução da expressão SQL");
					e.printStackTrace();

				}
			} catch (Exception e) {
				System.out.println("Erro conexao");
				e.printStackTrace();
			}
			
			System.out.println("Quer fazer outra analise?");
			System.out.println("1 - Executar novamente");
			System.out.println("2 - Finalizar \n");
			int execAgain = SCANNER.nextInt();
			if (execAgain == 2) {
				System.out.println("Encerrando");
				break;
			}
		}
	}
}