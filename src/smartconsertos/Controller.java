package smartconsertos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controller {
    
    private Conexao conexao = new Conexao();
    ArrayList<Defeito> defeitos = new ArrayList<>();
    private ArrayList<Marca> marcas = new ArrayList<>();
    private ArrayList<Celular> celulares = new ArrayList<>();
    private Conexao con = new Conexao();
    private String[] celularesSamsung = {"Galaxy S5" , "Galaxy Note 4"};
    private String[] celularesSony = {"Xperia Z3" , "Xperia Z2"};
    private String[] celularesLG = {"G3" , "Nexus 5"};
    private String[] celularesApple = {"Iphone 6" , "Iphone 5S"};
    private String[] tabletsSamsung = {"Galaxy tab 3" , "Galaxy tab 4"};
    private String[] tabletsSony = {"Xperia Z3 tab" , "Xperia Z2 tab"};
    private String[] tablestsLG = {"G3 tab" , "Nexus 5 tab"};
    private String[] tabletsApple = {"Ipad 4" , "Ipad Air 2"};
    //private String[] cores =  {"preto", "branco", "vermelho","cinza"};
    
    public void atualizarTabelaDefeitos() {
        ArrayList <Defeito> defeitos = new ArrayList<>();
        defeitos = conexao.listarDefeitos();
        if (defeitos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado", "Consulta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Object[][] dados = new Object[defeitos.size()][4];
            for (int i = 0; i < defeitos.size(); i++) {
                dados[i][0] = defeitos.get(i).getTipoDefeito().getTipo();
                dados[i][1] = defeitos.get(i).getDescricao();
                dados[i][2] = defeitos.get(i).getValorConserto();
                dados[i][3] = defeitos.get(i).getTempoDeConserto();
            }
            JFrameCadastroDefeitos.modelDefeitos = new DefaultTableModel(dados, new Object[]{"Tipo de defeito", "Descrição", "Valor do Conserto", "Tempo de Conserto"});
            JFrameCadastroDefeitos.jTableDefeitos.setModel(JFrameCadastroDefeitos.modelDefeitos);            
        }
    }
    
    public void setarDefeitos() {
        this.defeitos = this.conexao.listarDefeitos();
    }
    
    public void insereMarcas(){
        String[] marcasCels = {"Samsung","Sony","LG","Apple"};
        for (int i=0; i<marcasCels.length; i++){
            int id = i +1;
            this.marcas.add(new Marca(id, marcasCels[i]));
        }
        
        for (Marca m : this.marcas){
            con.insereMarcas(m);
        }
    }
    
    public void insereCelulares(){
        ArrayList <Celular> cels = new ArrayList<>();
        // id_marca -- valor -- nome 
            //1 = samsung
            //2 = sony
            //3 = lg
            //4 = apple
        String [][]celulares = 
        {
            {"1","1880","Galaxy S5"},
            {"1","2478","Galaxy Note 4"},
            {"2","1900","Xperia Z3"},
            {"2","1489","Xperia Z2"},
            {"3","1363","LG G3"},
            {"3","1090","Nexus 5"},
            {"4","2879","Iphone 6"},
            {"4","1789","Iphone 5S"}
        };
        
        for (int i=0; i<celulares.length; i++){
            System.out.println("cel i : " +celulares[i][0]);
            cels.add(new Celular(i, celulares[i][2], new Marca(Integer.parseInt(celulares[i][0]), null), Integer.parseInt(celulares[i][1])));
        }
        
        for (Celular cel : cels){
            conexao.inserirCelulares(cel);
        }
        
    }
}
