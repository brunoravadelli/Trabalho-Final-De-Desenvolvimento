/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartconsertos;

/**
 *
 * @author Bruno Ravadelli
 */
public class Validacao {
    
    public Validacao() {
    }
    
    public boolean validaLogin (Usuario u){
        
        if (u.getLogin().equals("") || u.getSenha().equals("")){
            return false;
        }else {
            return true;
        }    
    }
    
    public boolean validaDefeito()
    
    
}
