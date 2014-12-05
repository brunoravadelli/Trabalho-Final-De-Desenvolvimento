/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartconsertos;

import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Ravadelli
 */
public class Validacao {
    
    Conexao con = new Conexao();
    
    public Validacao() {
    }
    
    public boolean validaLogin (Usuario u){
        
        if (u.getLogin().equals("") || u.getSenha().equals("")){
            return false;
        }else {
            return true;
        }    
    }
    
    public Defeito validaDefeito(int tipoDefeito, String descricao, String tempoConserto, String valorConserto){
        
        boolean lbResposta;
        Defeito defeito = null;
        TipoDefeito def = null;
        if (tipoDefeito > -1){
            def = con.buscaTipoDefeito(tipoDefeito + 1);
        }
        
        if (def == null || descricao.equals("") || valorConserto.equals("") || tempoConserto.equals("")){
            JOptionPane.showMessageDialog(null, "Campos nulos, por favo preencher!");
        }else {
            try {
                
                defeito = new Defeito(def, descricao, Double.parseDouble(valorConserto), Integer.parseInt(tempoConserto));
                System.out.println("Sistema criou defeito em memória");
                
            }catch (Exception e){
                JOptionPane.showConfirmDialog(null, "Campos inválidos!");
            }
        }
        return defeito;
    }
    
}
