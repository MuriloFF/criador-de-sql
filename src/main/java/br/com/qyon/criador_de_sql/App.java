package br.com.qyon.criador_de_sql;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.qyon.criador_de_sql.tabelas.qyonhub.Caracteristica;
import br.com.qyon.criador_de_sql.tabelas.qyonhub.CaracteristicasItem;
import br.com.qyon.criador_de_sql.tabelas.qyonhub.Empresa;
import br.com.qyon.criador_de_sql.tabelas.qyonhub.Grupo;
import br.com.qyon.criador_de_sql.tabelas.qyonhub.Mesa;
import br.com.qyon.criador_de_sql.tabelas.qyonhub.Produto;
import br.com.qyon.criador_de_sql.tabelas.qyonhub.ProdutoImagem;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		
		Configuration cfg = new Configuration().configure() //
				.addAnnotatedClass(Empresa.class) //
				.addAnnotatedClass(Grupo.class) //
				.addAnnotatedClass(Caracteristica.class) //
				.addAnnotatedClass(CaracteristicasItem.class) //
				.addAnnotatedClass(Produto.class) //
				.addAnnotatedClass(Mesa.class) //
				.addAnnotatedClass(ProdutoImagem.class) //
				;
		
		SessionFactory sessions = cfg.buildSessionFactory();
		try(Session session = sessions.openSession()) // open a new Session
		{
//			session.beginTransaction();
//			
//			Origem origem = new Origem();
//			origem.setDescricao("Mercado Livre Brasil");
//			origem.setLogo("https://www.mercadolivre.com.br/brandprotection/enforcement/images?src=logo-mlb.png");
//			origem.setAtivo(false);
//			session.persist(origem);
//			
//			session.getTransaction().commit();
		}
		
	}
}
