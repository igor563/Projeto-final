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
public class ItemVenda {
    

     private int idItemVenda;

     private int idVenda;

     private int idProduto;

     private int qtdProduto;

     private String valorUnitario;

        /**
         * @return the idItemVenda
         */
        public int getIdItemVenda() {
            return idItemVenda;
        }

        /**
         * @param idItemVenda the idItemVenda to set
         */
        public void setIdItemVenda(int idItemVenda) {
            this.idItemVenda = idItemVenda;
        }

        /**
         * @return the idVenda
         */
        public int getIdVenda() {
            return idVenda;
        }

        /**
         * @param idVenda the idVenda to set
         */
        public void setIdVenda(int idVenda) {
            this.idVenda = idVenda;
        }

        /**
         * @return the idProduto
         */
        public int getIdProduto() {
            return idProduto;
        }

        /**
         * @param idProduto the idProduto to set
         */
        public void setIdProduto(int idProduto) {
            this.idProduto = idProduto;
        }

        /**
         * @return the qtdProduto
         */
        public int getQtdProduto() {
            return qtdProduto;
        }

        /**
         * @param qtdProduto the qtdProduto to set
         */
        public void setQtdProduto(int qtdProduto) {
            this.qtdProduto = qtdProduto;
        }

        /**
         * @return the valorUnitario
         */
        public String getValorUnitario() {
            return valorUnitario;
        }

        /**
         * @param valorUnitario the valorUnitario to set
         */
        public void setValorUnitario(String valorUnitario) {
            this.valorUnitario = valorUnitario;
        }

    }

