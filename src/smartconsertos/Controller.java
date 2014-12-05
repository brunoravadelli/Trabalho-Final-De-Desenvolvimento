package smartconsertos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controller {
    
    private Conexao conexao = new Conexao();
    ArrayList<Defeito> defeitos = new ArrayList<>();
    
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
}
