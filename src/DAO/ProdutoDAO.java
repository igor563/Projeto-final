/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Produto;
import utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class ProdutoDAO {
    
    public static boolean cadastrar(Produto p) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            String URL = "jdbc:mysql://localhost:3306/loja?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Produto (nome_produto, numero, quantidade, preco) VALUES (?, ?, ?, ?)"
                                                    , Statement.RETURN_GENERATED_KEYS);
            
            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setString(2, p.getNumero());
            instrucaoSQL.setString(3, p.getQtd());
            instrucaoSQL.setString(4, p.getPreco());
            
            int LinhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(LinhasAfetadas>0) {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if(generatedKeys.next()) {
                    p.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID do produto");
                }
            }
            else {
                retorno = false;
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
    
    public static boolean atualizar(Produto p) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try  {
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            String URL = "jdbc:mysql://localhost:3306/loja?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            
            instrucaoSQL = conexao.prepareStatement("UPDATE produto SET nome_produto = ?, numero = ?, quantidade = ?, preco = ? WHERE Id_produto = ?");
            
            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setString(2, p.getNumero());
            instrucaoSQL.setString(3, p.getQtd());
            instrucaoSQL.setString(4, p.getPreco());
            instrucaoSQL.setInt(5, p.getId());
            
            int LinhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(LinhasAfetadas>0) {
                retorno = true;
            }
            else {
                retorno = false;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                GerenciadorConexao.fecharConexao();
                
              } catch (SQLException ex) {
             }
        }
        return retorno;
    }
    
    public static boolean excluir(int pId) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            String URL = "jdbc:mysql://localhost:3306/loja?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Produto WHERE id_produto = ?");
            
            instrucaoSQL.setInt(1, pId);
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
            }
            else{
                retorno = false;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                GerenciadorConexao.fecharConexao();
                
                
              } catch (SQLException ex) {
             }
        }
        
        return retorno;
    }
    
    public static ArrayList<Produto> consultarProduto() {
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            String URL = "jdbc:mysql://localhost:3306/loja?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            
            instrucaoSQL = conexao.prepareStatement("SELECT * from Produto");
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()) {
                
                Produto objProduto = new Produto();
                objProduto.setId(rs.getInt("id_produto"));
                objProduto.setNome(rs.getString("nome_produto"));
                objProduto.setNumero(rs.getString("numero"));
                objProduto.setQtd(rs.getString("quantidade"));
                objProduto.setPreco(rs.getString("preco"));
                
                listaProduto.add(objProduto);
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaProduto = null;
        } finally {
            try {
                if(rs!=null)
                    rs.close();                
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                
                GerenciadorConexao.fecharConexao();
                        
              } catch (SQLException ex) {
             }
        }
        return listaProduto;
    }
    
    public static ArrayList<Produto> consultarProduto(String pNome) {
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
           instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE nome_produto LIKE ?;");
           
           instrucaoSQL.setString(1,"%" + pNome + '%' );
           
           rs = instrucaoSQL.executeQuery();
           
           while(rs.next()) {
                
                Produto objProduto = new Produto();
                objProduto.setId(rs.getInt("id_produto"));
                objProduto.setNome(rs.getString("nome_produto"));
                objProduto.setNumero(rs.getString("numero"));
                objProduto.setQtd(rs.getString("quantidade"));
                objProduto.setPreco(rs.getString("preco"));
                
                listaProduto.add(objProduto);
            }
           
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaProduto = null;
        } finally {
            try {
                if(rs!=null)
                    rs.close();                
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                GerenciadorConexao.fecharConexao();
                
                        
              } catch (SQLException ex) {
             }
        }
        return listaProduto;
    }
}