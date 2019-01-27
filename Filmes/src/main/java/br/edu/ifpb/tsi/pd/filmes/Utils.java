/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tsi.pd.filmes;

import com.thoughtworks.xstream.XStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Matheus & Ronily
 */
public class Utils {
    
    public static String convertFilmesToXML(ResponseDataFilmeList lista){
        XStream xstream = new XStream();
        xstream.alias("filme", Filme.class);
        xstream.alias("filmes", ResponseDataFilmeList.class);
        xstream.addImplicitCollection(ResponseDataFilmeList.class, "list");
        return xstream.toXML(lista);
    }
    
    public static String convertFilmeToXML(Filme filme){
        ArrayList<Filme> lista = new ArrayList<>();
        lista.add(filme);
        ResponseDataFilmeList response;
        response = new ResponseDataFilmeList(lista);
        return convertFilmesToXML(response);
    }
}
