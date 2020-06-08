/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Vendas;
import DAO.VendasDAO;
import java.util.ArrayList;
import java.util.Date;
import model.ItemVenda;
/**
 *
 * @author pedro
 */
public class VendasController {
    
    public static boolean salvar(int idCliente, Date dataVenda, float ValorTotal, ArrayList<String[]> listaitens) {
        Vendas objVendas = new Vendas();
        
        objVendas.setIdCliente(idCliente);
        objVendas.setDataVenda(new Date());
        objVendas.setValorTotal(ValorTotal);
        listaitens = new ArrayList<>();
        
        for(String[] ItemVenda : listaitens) {
            ItemVenda objItemVenda = new ItemVenda();
            objItemVenda.setIdProduto(ItemVenda[0]);
            
            listaitens.add(objVendas);
        }
        objVendas.setListaItens(listaitens);
        
        return VendasDAO.salvar(objVendas);
    }
}
