/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tsi.pd.filmes;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


/**
 *
 * @author Matheus 
 * @author Ronily
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface FilmeServer {
    @WebMethod String lista();
    @WebMethod String cadastra(String titulo, String diretor, 
            String genero, String lancamento);
    @WebMethod String exclui(int id);
    @WebMethod String alteraTitulo(int id, String novoTitulo);
    @WebMethod String consulta(String titulo);
}
