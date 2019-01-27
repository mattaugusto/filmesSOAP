/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tsi.pd.filmes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class ResponseDataFilmeList {
    
    private List<Filme> list;
    
    public ResponseDataFilmeList(ArrayList<Filme> list){
        this.list = list;
    }

    public void add(Filme filme){
        list.add(filme);
    }
}
