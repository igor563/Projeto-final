/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Cliente;
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
public class ClienteDAO {
    
    public static boolean cadastrar(Cliente p) {
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            String URL = "jdbc:mysql://localhost:3306/loja?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            
            instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome,data_nascimento,CPF,sexo,endereco,CEP,cidade,uf,email,celular) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                                                     , Statement.RETURN_GENERATED_KEYS);
            
            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setString(2, p.getData());
            instrucaoSQL.setString(3, p.getCPF());
            instrucaoSQL.setString(4, p.getSexo());
            instrucaoSQL.setString(5, p.getEndereco());
            instrucaoSQL.setString(6, p.getCEP());
            instrucaoSQL.setString(7, p.getCidade());
            instrucaoSQL.setString(8, p.getUF());
            instrucaoSQL.setString(9, p.getEmail());
            instrucaoSQL.setString(10, p.getCelular());
            
            int LinhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(LinhasAfetadas>0) {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if(generatedKeys.next()) {
                    p.setID(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID do cliente");
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
    
    public static boolean alterar(Cliente p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            String URL = "jdbc:mysql://localhost:3306/loja?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            
            instrucaoSQL = conexao.prepareStatement("UPDATE cliente SET nome = ?, data_nascimento = ?, CPF = ?, sexo = ?, endereco = ?, CEP = ?, cidade = ?, uf = ?, email = ?, celular = ? WHERE id_cliente = ?");
            
            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setString(2, p.getData());
            instrucaoSQL.setString(3, p.getCPF());
            instrucaoSQL.setString(4, p.getSexo());
            instrucaoSQL.setString(5, p.getEndereco());
            instrucaoSQL.setString(6, p.getCEP());
            instrucaoSQL.setString(7, p.getCidade());
            instrucaoSQL.setString(8, p.getUF());
            instrucaoSQL.setString(9, p.getEmail());
            instrucaoSQL.setString(10, p.getCelular());
            instrucaoSQL.setInt(11, p.getId());
            
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
            
            instrucaoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");
            
            instrucaoSQL.setInt(1, pId);
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
            }
            else{
                retorno = false;
            }
            
            
        }catch (SQLException | ClassNotFoundException ex) {
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
    
    public static ArrayList<Cliente> consultarCliente() {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            String URL = "jdbc:mysql://localhost:3306/loja?useTimezone=true&serverTimezone=UTC&useSSL=false";
            
            conexao = DriverManager.getConnection(URL, "root", "");
            
            instrucaoSQL = conexao.prepareStatement("SELECT * from Cliente");
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()) {
                
                Cliente objCliente = new Cliente();
                objCliente.setID(rs.getInt("Id_cliente"));
                objCliente.setNome(rs.getString("nome"));
                objCliente.setData(rs.getString("data_nascimento"));
                objCliente.setCPF(rs.getString("CPF"));
                objCliente.setSexo(rs.getString("sexo"));
                objCliente.setEndereco(rs.getString("endereco"));
                objCliente.setCEP(rs.getString("CEP"));
                objCliente.setCidade(rs.getString("cidade"));
                objCliente.setUF(rs.getString("uf"));
                objCliente.setEmail(rs.getString("email"));
                objCliente.setCelular(rs.getString("celular"));
                
                listaCliente.add(objCliente);
                
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaCliente = null;
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
        return listaCliente;
    }
    
    public static ArrayList<Cliente> consultarCliente(String pNome) {
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
       ArrayList<Cliente> listaCliente = new ArrayList<Cliente>(); 
       
       try {
           
           conexao = GerenciadorConexao.abrirConexao();
           instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ?;");
           
           instrucaoSQL.setString(1,"%" + pNome + '%' );
           
           rs = instrucaoSQL.executeQuery();
           
           while(rs.next()) {
               
               Cliente objCliente = new Cliente();
                objCliente.setID(rs.getInt("Id_cliente"));
                objCliente.setNome(rs.getString("nome"));
                objCliente.setData(rs.getString("data_nascimento"));
                objCliente.setCPF(rs.getString("CPF"));
                objCliente.setSexo(rs.getString("sexo"));
                objCliente.setEndereco(rs.getString("endereco"));
                objCliente.setCEP(rs.getString("CEP"));
                objCliente.setCidade(rs.getString("cidade"));
                objCliente.setUF(rs.getString("uf"));
                objCliente.setEmail(rs.getString("email"));
                objCliente.setCelular(rs.getString("celular"));
                
                listaCliente.add(objCliente);
           }
           
       }catch (SQLException | ClassNotFoundException ex) {
           System.out.println(ex.getMessage());
            listaCliente = null;
            
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
       return listaCliente;
    }
}    
    
    

    
