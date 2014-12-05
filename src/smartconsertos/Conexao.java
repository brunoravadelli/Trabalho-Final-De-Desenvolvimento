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
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.util.locale.provider.TimeZoneNameUtility;

/**
 *
 * @author Bruno Ravadelli
 */
public class Conexao {

private String lsNomClasse = "com.mysql.jdbc.Driver";
private String lsCaminho = "jdbc:mysql://localhost:3306/smart";
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
    
    public void inserir(Defeito defeito){
        
        try {
            
            
            //String sqlQuery = "INSERT INTO defeito (descricao, valor_conserto, prazo_conserto, tipo_id) VALUES ('?',?,?,?)";            
            String sqlQuery = "INSERT INTO defeito (descricao, valor_conserto, prazo_conserto, tipo_id) VALUES ('" + defeito.getDescricao() + "',"
                    + defeito.getValorConserto() + ","
                    + defeito.getTempoDeConserto() + ","
                    + defeito.getTipoDefeito().getId() + ")";            
            java.sql.Statement st = conn.createStatement();
            
            /*
            -- não funciona --
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            st.setString(1, defeito.getDescricao());
            st.setDouble(2, defeito.getValorConserto());
            st.setInt(3, defeito.getTempoDeConserto());
            st.setInt(4, defeito.getTipoDefeito().getId());
            */
            st.executeUpdate(sqlQuery);
             
            
            JOptionPane.showMessageDialog(telaInicio, "Defeito incluído com sucesso!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public TipoDefeito buscaTipoDefeito(int id){
        
        TipoDefeito tipo = new TipoDefeito();
        try {
            String sqlQuery = "SELECT * FROM tipo WHERE id = ?";            
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){    
                tipo.setId(rs.getInt("id")); 
                tipo.setTipo(rs.getString("tipo"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
        
        return tipo;
        
    }
    
    public ArrayList<Defeito> listarDefeitos(){
        ArrayList<Defeito> defeitos = new ArrayList<>();
        
        try {
            String sqlQuery = "SELECT defeito.*, tipo.tipo FROM \n" +
                "defeito \n" +
                "left join tipo on defeito.tipo_id = tipo.id;";
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                TipoDefeito tipo = new TipoDefeito(rs.getInt("defeito.tipo_id"), rs.getString("tipo.tipo"));                
                Defeito d = new Defeito(tipo, rs.getString("defeito.descricao"), rs.getDouble("defeito.valor_conserto"), rs.getInt("defeito.prazo_conserto"));
                d.setId(rs.getInt("defeito.id"));
                defeitos.add(d);
            }
            
        }catch (SQLException e){
            System.out.println(e);
        }
        
        
        return defeitos;
    }
    
    public ArrayList<TipoDefeito> buscaTodosTipoDefeitos(){
        
        ArrayList<TipoDefeito> tipos =  new ArrayList<>();
        
        try {
            String sqlQuery = "SELECT *FROM tipo";
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                TipoDefeito tipo = new TipoDefeito();
                tipo.setId(rs.getInt("id")); 
                tipo.setTipo(rs.getString("tipo"));
                tipos.add(tipo);
            }
            
        }catch (SQLException e){
            System.out.println(e);
        }
        
        return tipos;
    }
    
    public boolean excluir(int id) {
        String sqlQuery = "DELETE FROM DEFEITO WHERE ID = " + id;
        java.sql.Statement st;
        try {
            st = this.conn.createStatement();
            st.executeUpdate(sqlQuery);
            JOptionPane.showMessageDialog(null, "Excluído com sucesso", "Registro Excluído", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void alteraDefeito(Defeito d){

        String sql = "UPDATE defeito SET descricao = ? , valor_conserto = ?, prazo_conserto = ? , tipo_id = ?  WHERE id = ?" ;
         
        try{
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, d.getDescricao());
            st.setDouble(2, d.getValorConserto());
            st.setInt(3, d.getTempoDeConserto());
            st.setInt(4, d.getTipoDefeito().getId());
            st.setInt(5, d.getId());
            //SALVA E FECHA
            st.execute();
            st.close();
            JOptionPane.showMessageDialog(null, "Defeito alterado com sucesso!");
        }
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public boolean pesquisaLogin(Usuario usuario){
       
        int cont = 0;
        boolean resultado = false ;
        try {
            String sqlQuery = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";
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
