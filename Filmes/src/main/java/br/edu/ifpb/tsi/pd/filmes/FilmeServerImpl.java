/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tsi.pd.filmes;

import java.util.ArrayList;
import javax.jws.WebService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 *
 * @author Matheus 
 * @author Ronily
 */
@WebService(endpointInterface = "br.edu.ifpb.tsi.pd.filmes.FilmeServer")
public class FilmeServerImpl implements FilmeServer{
    SessionFactory sessionFactory = new AnnotationConfiguration()
            .configure()
            .buildSessionFactory();
    Session session = sessionFactory.openSession();
    
    @Override
    public ArrayList<String> ola(String ola){
        ArrayList teste = new ArrayList();
        teste.add(ola);
        teste.add(ola);
        return teste;
    }
    
    @Override
    public String cadastra(String titulo) {
        System.out.println("Criando Filme...");
        Filme filme = new Filme();
        filme.setTitulo(titulo);
//        filme.setGenero("Ação");
//        filme.setDiretor("Francis Lawrence");
//        filme.setLancamento("2005");
        
        session.beginTransaction();
        session.save(filme);
        session.getTransaction().commit();
        return Utils.convertFilmeToXML(filme);
    }

    @Override
    public String exclui(int id) {
        System.out.println("Excluindo Filme...");
        session.beginTransaction();
        Filme filme = (Filme) session.get(Filme.class, id);
        session.delete(filme);
        session.getTransaction().commit();        
        return Utils.convertFilmeToXML(filme);
    }

    @Override
    public String alteraTitulo(int id, String novoTitulo) {
        System.out.println("Alterando Título de Filme...");
        session.beginTransaction();
        Filme filme = (Filme) session.get(Filme.class, id);
        filme.setTitulo(novoTitulo);
        session.save(filme);
        session.getTransaction().commit();        
        return Utils.convertFilmeToXML(filme);
    }
    
    @Override
    public ResponseDataArrayList consulta(String filtro){
        session.beginTransaction();
        Query q = session.createQuery(
           "from Filme where titulo = :filtro "
                   + "or diretor = :filtro "
                   + "or genero = :filtro "
                   + "or lancamento = :filtro"
        ).setParameter("filtro", filtro);
        ArrayList<Filme> lista = (ArrayList<Filme>) q.list();
        ResponseDataArrayList response = new ResponseDataArrayList();
        response.setList(Utils.convertFilmesToXML(lista));
        return response;
    }
    
}
