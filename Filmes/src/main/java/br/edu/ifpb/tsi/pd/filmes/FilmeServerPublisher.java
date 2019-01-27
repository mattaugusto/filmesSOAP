/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tsi.pd.filmes;

import javax.xml.ws.Endpoint;

/**
 *
 * @author Matheus 
 * @author Ronily
 */
public class FilmeServerPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8666/filme", new FilmeServerImpl());
    }
}
