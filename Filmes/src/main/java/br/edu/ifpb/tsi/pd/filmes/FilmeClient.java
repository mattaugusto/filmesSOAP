/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tsi.pd.filmes;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
/**
 *
 * @author Matheus 
 * @author Ronily
 */
public class FilmeClient {
    
    public static void main(String args[]) throws Exception {
        URL url = new URL("http://127.0.0.1:8666/filme?wsdl");
        QName qname = new QName(
                "http://filmes.pd.tsi.ifpb.edu.br/", 
                "FilmeServerImplService"
        );
        Service ws = Service.create(url, qname);
        System.out.println(ws);
        FilmeServer filme = ws.getPort(FilmeServer.class);

        System.out.println(filme.cadastra("ola"));
//        System.out.println((filme.consulta("Constantine")).getList());
//        System.out.println("Subtracao (5-1): " + calc.subtracao(5, 1));
//        System.out.println("Multiplicacao (5*1): " + calc.multiplicacao(5, 1));
//        System.out.println("Divisao (5/1): " + calc.divisao(5, 1));
    }
}
