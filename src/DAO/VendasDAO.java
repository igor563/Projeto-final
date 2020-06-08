/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Vendas;
import utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ItemVenda;
/**
 *
 * @author pedro
 */
public class VendasDAO {
    
    public static boolean salvar(Vendas p) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Vendas (id_cliente, data_venda, valor_total) VALUES (?, ?, ?)"
                                                    , Statement.RETURN_GENERATED_KEYS);
            
            instrucaoSQL.setInt(1,p.getIdCliente());
            instrucaoSQL.setDate(2,new java.sql.Date(p.getDataVenda().getTime()));
            instrucaoSQL.setFloat(1,p.getValorTotal());
            
            int LinhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(LinhasAfetadas>0) {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if(generatedKeys.next()) {
                    p.setIdVenda(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID da venda");
                }
            }
            
            else {
                retorno = false;
            }
            
            instrucaoSQL = conexao.prepareStatement("INSERT INTO ItemVendas (id_venda, id_produto, quantidade) VALUES (?, ?, ?)"
                                                    , Statement.RETURN_GENERATED_KEYS);
            for(ItemVenda item : p.getListaItens()) {
                instrucaoSQL.setInt(1,p.getIdVenda());
                instrucaoSQL.setInt(1,item.getIdProduto());
                instrucaoSQL.setFloat(1,item.getQtdProduto());
                
                LinhasAfetadas = instrucaoSQL.executeUpdate();
            }
            
       
            
        } catch (SQLException | ClassNotFoundException ex) {
            
            System.out.println(ex.getMessage());
            retorno = false;
            
        } finally {
            
        try {
                if(instrucaoSQL !=null)
                    instrucaoSQL.close();
                
                GerenciadorConexao.fecharConexao();
                
            } catch (SQLException ex) {
           }
            
        }
        return retorno;
    }
    
}
