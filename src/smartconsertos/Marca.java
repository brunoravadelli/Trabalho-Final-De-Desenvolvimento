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
public class Marca {
    
    private int id;
    private String nomeMarca;

    public Marca() {
    }

    public Marca(int id, String nomeMarca) {
        this.id = id;
        this.nomeMarca = nomeMarca;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
    
    
    
}
