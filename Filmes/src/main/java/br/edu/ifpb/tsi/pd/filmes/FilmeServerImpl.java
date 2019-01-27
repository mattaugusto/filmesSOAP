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
    public String get(int id){
        session.beginTransaction();
        Filme filme = (Filme) session.get(Filme.class, id);
        return Utils.convertFilmeToXML(filme);
    }
    
    @Override
    public String lista(){
        session.beginTransaction();
        Query q = session.createQuery("from Filme");
        ArrayList<Filme> lista = (ArrayList<Filme>) q.list();
        ResponseDataFilmeList response;
        response = new ResponseDataFilmeList(lista);
        return Utils.convertFilmesToXML(response);
    }
    
    @Override
    public String cadastra(String titulo, String diretor, 
            String genero, String lancamento) {
        System.out.println("Criando Filme...");
        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setDiretor(diretor);
        filme.setGenero(genero);
        filme.setLancamento(lancamento);
        
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
        
        ArrayList<Filme> lista = new ArrayList<>();
        lista.add(filme);
        ResponseDataFilmeList response;
        response = new ResponseDataFilmeList(lista);
        return Utils.convertFilmesToXML(response);
    }

    @Override
    public String altera(int id, String titulo, String diretor, 
            String genero, String lancamento) {
        System.out.println("Alterando Filme...");
        session.beginTransaction();
        Filme filme = (Filme) session.get(Filme.class, id);
        filme.setTitulo(titulo);
        filme.setDiretor(diretor);
        filme.setGenero(genero);
        filme.setLancamento(lancamento);
        session.save(filme);
        session.getTransaction().commit();        
        return Utils.convertFilmeToXML(filme);
    }
    
    @Override
    public String consulta(String filtro){
        session.beginTransaction();
        Query q = session.createQuery(
           "from Filme where titulo = :filtro "
                   + "or diretor = :filtro "
                   + "or genero = :filtro "
                   + "or lancamento = :filtro"
        ).setParameter("filtro", filtro);
        ArrayList<Filme> lista = (ArrayList<Filme>) q.list();
        ResponseDataFilmeList response;
        response = new ResponseDataFilmeList(lista);
        return Utils.convertFilmesToXML(response);
    }
    
}
