/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tsi.pd.filmes;

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
    
    public static String convertFilmeToXML(Filme filme){
        String xmlResult = "";
        StringWriter sw = new StringWriter();
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Filme.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(filme, sw);
            xmlResult = sw.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(FilmeServerImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return xmlResult;
    }
    
    public static ArrayList convertFilmesToXML(ArrayList<Filme> lista){
        ArrayList xmlResult = new ArrayList();
        StringWriter sw = new StringWriter();
        for (Filme filme : lista) {
            JAXBContext context;
            try {
                context = JAXBContext.newInstance(Filme.class);
                Marshaller m = context.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
                m.marshal(filme, sw);
                xmlResult.add(sw.toString());
            } catch (JAXBException ex) {
                Logger.getLogger(FilmeServerImpl.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return xmlResult;
    }
}
