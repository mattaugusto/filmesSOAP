/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;
import br.edu.ifpb.tsi.pd.filmes.Filme;
import java.util.ArrayList;
import org.hibernate.Query;

/**
 *
 * @author Matheus 
 * @author Ronily
 */
public class Runner {
    
    public Runner() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void crud() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        Query q = session.createQuery(
           "from Filme where titulo = :filtro "
                   + "or diretor = :filtro "
                   + "or genero = :filtro "
                   + "or lancamento = :filtro"
        ).setParameter("filtro", "Constantine");
        System.out.println(q.list());
        
        
//        create(session);
//        read(session);

//        update(session);
//        read(session);
//
//        delete(session);
//        read(session);

        session.close();
    }

    private void delete(Session session) {
//        System.out.println("Deleting mondeo record...");
//        Car mondeo = (Car) session.get(Car.class, "mondeo");
//
//        session.beginTransaction();
//        session.delete(mondeo);
//        session.getTransaction().commit();
    }

    private void update(Session session) {
//        System.out.println("Updating mustang price...");
//        Car mustang = (Car) session.get(Car.class, "mustang");
//        mustang.setModel("mustang");
//        mustang.setPrice("£35,250.00");
//
//        session.beginTransaction();
//        session.saveOrUpdate(mustang);
//        session.getTransaction().commit();
    }

    private void create(Session session) {
        System.out.println("Criando Filme...");
        Filme filme = new Filme();
        filme.setId(1);
        filme.setTitulo("Constantine");
        filme.setGenero("Ação");
        filme.setDiretor("Francis Lawrence");
        filme.setLancamento("2005");
        
        session.beginTransaction();
        session.save(filme);
        session.getTransaction().commit();
    }

    private void read(Session session) {
        List<Filme> filmes = session.createQuery("from Filme").list();

        System.out.println("Lendo resultados de Filmes...");
        System.out.printf("%-30.30s  %-30.30s%n", "Título", "Lançamento");
        for (Filme f : filmes) {
            System.out.printf(
                    "%-30.30s  %-30.30s%n", 
                    f.getTitulo(), 
                    f.getLancamento()
            );
        }
    }
}
