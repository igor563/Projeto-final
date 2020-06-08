/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pedro
 */
public class Produto {
    
    private static int qtdProdutosCriados;
    
    private int Id;
    private String nome;
    private String qtd;
    private String preco;
    private String numero;
    
    public Produto() {
        qtdProdutosCriados++;
        this.Id = qtdProdutosCriados++;
    }
    
    public Produto(String nome, String qtd, String preco, String numero) {
        
        qtdProdutosCriados++;
        this.Id = qtdProdutosCriados++;
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
        this.numero = numero;
    }
    
    public Produto(int Id, String pNome, String pQtd, String pPreco, String pNumero) {
        
        this.Id = Id;
        this.nome = pNome;
        this.qtd = pQtd;
        this.preco = pPreco;
        this.numero = pNumero;
    }
    
    public int getId() {
        return Id;
    }
    
    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String pNome) {
        this.nome = pNome;
    }
    
    public String getQtd() {
        return qtd;
    }
    
    public void setQtd(String pQtd) {
        this.qtd = pQtd;
    }
    
    public String getPreco() {
        return preco;
    }
    
    public void setPreco(String pPreco) {
        this.preco = pPreco;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String pNumero) {
        this.numero = pNumero;
    }
}
