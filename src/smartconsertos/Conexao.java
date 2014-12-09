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
private Connection conn = null;
    
    
    public Conexao(){
        try {
        Class.forName(lsNomClasse);
        conn = DriverManager.getConnection(lsCaminho,lsUsuario,lsSenha);
        } catch (SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void insereMarcas(Marca marca){
        try{
            String sqlQuery = "INSERT INTO marca (nome) VALUES ('" + marca.getNomeMarca()+ "')";            
            java.sql.Statement st = conn.createStatement();
            st.executeUpdate(sqlQuery);
            System.out.println("Celulares e marcas incluídos com sucesso ");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Marcas incluídas com sucesso!");
        }
    }
    
    public void inserirCelulares(Celular cel){
        
        try{
            String sqlQuery = "INSERT INTO celular (id_marca, valor, nome) VALUES ('" + cel.getMarca().getId()+ "',"
                    + cel.getValor()+ ",'"
                    + cel.getNome()+ "')";            
            java.sql.Statement st = conn.createStatement();
            st.executeUpdate(sqlQuery);
            System.out.println("Celular incluído com sucesso ");
        }catch(SQLException e){
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
            st.executeUpdate(sqlQuery);
             
            
            JOptionPane.showMessageDialog(null, "Defeito incluído com sucesso!");
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
    
    public ArrayList<Defeito> buscaDefeitos(int id){
        
        ArrayList <Defeito> defeitos =  new ArrayList<>();
        
        try {
            String sqlQuery = "SELECT * FROM defeito WHERE tipo_id = ?";            
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                defeitos.add(new Defeito(new TipoDefeito(id, null), rs.getString("descricao"), rs.getDouble("valor_conserto"), rs.getInt("prazo_conserto")));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
        
        return defeitos;
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
    
    public ArrayList<Marca> buscaTodasMarcas(){
        ArrayList<Marca> marcas = new ArrayList<>();
        
        try {
            String sqlQuery = "SELECT * FROM marca";
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Marca marca = new Marca();
                marca.setId(rs.getInt("id")); 
                marca.setNomeMarca(rs.getString("nome"));
                marcas.add(marca);
            }
            
        }catch (SQLException e){
            System.out.println(e);
        }
        System.out.println("Buscou todas as marcas!");
        return marcas;
    }
    
    public Marca buscaMarca(int id){
        
        Marca marca = new Marca();
        try {
            String sqlQuery = "SELECT * FROM marca WHERE id = ?";            
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){    
                marca.setId(rs.getInt("id")); 
                marca.setNomeMarca(rs.getString("nome"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
        
        return marca;
        
    }
    
    public Celular buscaCelular (int id, int id_marca){
        
        Celular cel = new Celular();
        try {
            String sqlQuery = "SELECT celular.*, marca.nome FROM \n" +
                "celular \n" +
                "left join celular on celular.id_marca = ? ;";
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            st.setInt(1, id_marca);
            ResultSet rs = st.executeQuery();
            if(rs.next()){    
                cel.setId(rs.getInt("id")); 
                cel.setNome(rs.getString("nome"));
                cel.setMarca(new Marca(rs.getInt("celular.id_marca"), "marca.nome"));
                cel.setValor(rs.getDouble("celular.valor"));
            }
            System.out.println("Celular buscado com sucesso id : " +id);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
        
        return cel;
        
    }
    
    public Tablet buscaTablet (int id, int id_marca){
        
        Tablet tab = new Tablet();
        try {
            String sqlQuery = "SELECT tablet.*, marca.nome FROM \n" +
                "tablet \n" +
                "left join tablet on tablet.id_marca = ? ;";
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            st.setInt(1, id_marca);
            ResultSet rs = st.executeQuery();
            if(rs.next()){    
                tab.setId(rs.getInt("id")); 
                tab.setNome(rs.getString("nome"));
                tab.setMarca(new Marca(rs.getInt("tablet.id_marca"), "marca.nome"));
                tab.setValor(rs.getDouble("tablet.valor"));
            }
            System.out.println("Tablet buscado com sucesso id : " +id);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
        
        return tab;
        
    }
    
    public ArrayList<Tablet> buscaTodoslTablets(Marca marca){
        ArrayList<Tablet> tablets = new ArrayList<>();
        
        try {
            String sqlQuery = "SELECT tablet.*, marca.nome FROM tablet" +
                    " left join marca on tablet.id_marca = marca.id" +
                    " where tablet.id_marca = ?";
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            st.setInt(1, marca.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Tablet tab = new Tablet();
                tab.setId(rs.getInt("tablet.id")); 
                tab.setNome(rs.getString("tablet.nome"));
                tab.setMarca(new Marca(rs.getInt("tablet.id_marca"), rs.getString("marca.nome")));
                tab.setValor(rs.getDouble("tablet.valor"));
                tablets.add(tab);
            }
            
        }catch (SQLException e){
            System.out.println(e);
        }
        System.out.println("Buscou todas as marcas!");
        return tablets;
    }
    
    public ArrayList<Celular> buscaTodosCelulares(Marca marca){
        ArrayList<Celular> celulares = new ArrayList<>();
        
        try {
            String sqlQuery = "SELECT celular.*, marca.nome FROM celular" +
                    " left join marca on celular.id_marca = marca.id" +
                    " where celular.id_marca = ?";
            PreparedStatement st = conn.prepareStatement(sqlQuery);
            st.setInt(1, marca.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Celular cel = new Celular();
                cel.setId(rs.getInt("celular.id")); 
                cel.setNome(rs.getString("celular.nome"));
                cel.setMarca(new Marca(rs.getInt("celular.id_marca"), rs.getString("marca.nome")));
                cel.setValor(rs.getDouble("celular.valor"));
                celulares.add(cel);
            }
            
        }catch (SQLException e){
            System.out.println(e);
        }
        System.out.println("Buscou todos os celulares!");
        return celulares;
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
