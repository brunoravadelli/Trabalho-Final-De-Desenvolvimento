/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartconsertos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Ravadelli
 */
public class Conexao {

private String lsNomClasse = "com.mysql.jdbc.Driver";
private String lsCaminho = "jdbc:mysql://localhost:3306/smartconsertos";
private String lsUsuario = "root";
private String lsSenha = "";
private JFrameInicio telaInicio = null;
private Connection conn = null;
    
    
    public Conexao(){
        try {
        Class.forName(lsNomClasse);
        conn = DriverManager.getConnection(lsCaminho,lsUsuario,lsSenha);
        } catch (SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void insereNoBanco(Usuario paciente){
        
    }
    
    public void AlteraNoBanco(Usuario paciente){
        
    }
    
    
    
    public boolean pesquisaLogin(Usuario usuario){
       
        int cont = 0;
        boolean resultado = false ;
        try {
            String sqlQuery = "SELECT *FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            st.setString(1, usuario.getLogin());
            st.setString(2, usuario.getSenha());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                resultado = true;
            }
            
        }catch (SQLException e){
            System.out.println(e);
        }
        
        return resultado;
    }
    
}
