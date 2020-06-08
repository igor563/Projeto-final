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
public class Cliente {
    
    private static int qtdClientesCriados;
    
    private int id;
    private String nome;
    private String cpf;
    private String data;
    private String sexo;
    private String endereco;
    private String cidade;
    private String CEP;
    private String UF;
    private String email;
    private String celular;
    
    public String getCPF() {
        return cpf;
    }
    
    public String getCPFSomenteNumeros() {
        return cpf.replace(".", "").replace("-", "");
    }
    
    public void setCPF(String pCPF) {
        this.cpf = pCPF;
    }
    
    public Cliente() {
        qtdClientesCriados++;
        this.id = qtdClientesCriados;
    }
    
    public Cliente(String nome, String cpf, String data, String sexo, String endereco, String cidade, String CEP, String UF, String email, String celular) {
        qtdClientesCriados++;
        this.id = qtdClientesCriados;
        this.nome = nome;
        this.cpf = cpf;
        this.data = data;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cidade = cidade;
        this.CEP = CEP;
        this.UF = UF;
        this.email = email;
        this.celular = celular;
    }
    
    public Cliente(int id, String pNome, String pCPF, String pData, String pSexo, String pEndereco, String pCidade, String pCEP, String pUF, String pEmail, String pCelular) {
        this.id = id;
        this.nome = pNome;
        this.cpf = pCPF;
        this.data = pData;
        this.sexo = pSexo;
        this.endereco = pEndereco;
        this.cidade = pCidade;
        this.CEP = pCEP;
        this.UF = pUF;
        this.email = pEmail;
        this.celular = pCelular;
    }
    
    public int getId() {
        return id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String pNome) {
        this.nome = pNome;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String pData) {
        this.data = pData;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String pSexo) {
        this.sexo = pSexo;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String pEndereco) {
        this.endereco = pEndereco;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String pCidade) {
        this.cidade = pCidade;
    }
    
    public String getCEP() {
        return CEP;
    }
    
    public void setCEP(String pCEP) {
        this.CEP = pCEP;
    }
    
    public String getUF() {
        return UF;
    }
    
    public void setUF(String pUF) {
        this.UF = pUF;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String pEmail) {
        this.email = pEmail;
    }
    
    public String getCelular() {
        return celular;
    }
    
    public void setCelular(String pCelular) {
        this.celular = pCelular;
    }
}
