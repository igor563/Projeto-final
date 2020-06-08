
package utils;

import com.sun.prism.paint.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validador {
    //validador obj = validador;
    //validar.nomeMetodo
    public static void ValidarNumeros(String pString) {
        try {
            int numero = Integer.parseInt(pString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, " Ocorreu um erro ao validar "+pString );
        }
    
}
    public static void ValidarNumeros(JTextField pTxt){
        
        try {
            int numero = Integer.parseInt(pTxt.getText());
        
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null," Erro ao converte "+pTxt.getText()+" Para Numero inteiro" );
            pTxt.setBackground(java.awt.Color.yellow);
        }finally{
            pTxt.setText("");
                    }
    }
   
    


}
