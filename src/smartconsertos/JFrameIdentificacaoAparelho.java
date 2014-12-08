/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartconsertos;

import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class JFrameIdentificacaoAparelho extends javax.swing.JFrame {
    
    private Conexao con = new Conexao();
    private Controller controller = new Controller();
    private String gadget;
    private Object[] cores = {"Preto", "Branco", "Azul", "Vermelho"};
    private ArrayList<Celular> cels = null;
    private ArrayList<Tablet> tabs = null;
    private Celular celEscolhido = null;
    private Tablet tabEscolhido = null;
    private Marca marcaEscolhida = null;
    private TipoDefeito defeitoEscolhido = null;

    public JFrameIdentificacaoAparelho(Aparelho aparelho) {
        this.controller.insereMarcas();
        this.controller.insereCelulares();
        this.gadget = aparelho.getTipo();
        ArrayList<Marca> marcas = con.buscaTodasMarcas();
        ArrayList<TipoDefeito> tipos = con.buscaTodosTipoDefeitos();
        initComponents();
        for (Marca marca : marcas){
            this.jComboBoxMarca.addItem(marca.getNomeMarca());
        }
        this.cels = con.buscaTodosCelulares(marcas.get(0));
        for (Celular celular : this.cels){
            this.jComboBoxNomeAparelho.addItem(celular.getNome());
        }
        for (TipoDefeito tipo : tipos){
            this.jComboBoxTipoDefeito.addItem(tipo.getTipo());
        }
        for (int i =0; i<cores.length; i++){
            this.jComboBoxCor.addItem(cores[i]);
        }
        
        this.setVisible(true);
        
    }
    public JFrameIdentificacaoAparelho(){
        
    }

    public JComboBox getComboBoxMarcas(){
        return jComboBoxMarca;
    }
    public JComboBox getComboBoxCelulares(){
        return jComboBoxNomeAparelho;
    }
    public JComboBox getComboBoxTipoDefeito(){
        return jComboBoxTipoDefeito;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioGroupTipoGadget = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxMarca = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCor = new javax.swing.JComboBox();
        jComboBoxNomeAparelho = new javax.swing.JComboBox();
        jButtonPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTipoDefeito = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButtonAvancarParaOrcamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seu Aparelho");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Marca aparelho:");

        jComboBoxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcaActionPerformed(evt);
            }
        });

        jLabel3.setText("Cor:");

        jLabel4.setText("Nome aparelho:");

        jComboBoxNomeAparelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNomeAparelhoActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo de defeito:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxNomeAparelho, 0, 107, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxCor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxTipoDefeito, 0, 166, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jButtonPesquisar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxNomeAparelho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxTipoDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jButtonPesquisar)
                .addContainerGap())
        );

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonAvancarParaOrcamento.setText("Avançar");
        jButtonAvancarParaOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvancarParaOrcamentoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Se seu aparelho está com esse problema ele provavelmente está ...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAvancarParaOrcamento))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonAvancarParaOrcamento))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAvancarParaOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvancarParaOrcamentoActionPerformed
        // TODO add your handling code here:
        if (gadget.equals("celular")){
            new JFrameOrcamento(this.celEscolhido);
        }
        else{
            new JFrameOrcamento(this.tabEscolhido);
        }
        this.dispose();
        
    }//GEN-LAST:event_jButtonAvancarParaOrcamentoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new JFrameInicio();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxNomeAparelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNomeAparelhoActionPerformed
        // TODO add your handling code here:
        if (jComboBoxMarca.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Desculpe mas você precisa selecionar uma marca antes");
        }else{
            int id_aparelho = jComboBoxNomeAparelho.getSelectedIndex();
            
            if (cels == null){
                System.out.println("cels está nulo!");
            }
             
            if (gadget.equals("celular")) {
                for (Celular cel : this.cels){
                    if (cel.getId() == id_aparelho){
                        this.celEscolhido = cel;
                        System.out.println("cel escolhido " + this.celEscolhido.getNome());
                    } 
                }
                //System.out.println("Celular escolhido : " +celEscolhido.getNome());
            }
            else {
                for (Tablet tab : this.tabs){
                    if (tab.getId() == id_aparelho){
                        this.tabEscolhido = tab;
                    } 
                }
                //System.out.println("Tablet escolhido : " +tabEscolhido.getNome());
            }
            
            
            
        }
        
        
    }//GEN-LAST:event_jComboBoxNomeAparelhoActionPerformed

    private void jComboBoxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcaActionPerformed
            System.out.println("Marca selecionada: "+jComboBoxMarca.getSelectedIndex());
            System.out.println("Gadget escolhido: " +this.gadget);
            this.marcaEscolhida = con.buscaMarca(jComboBoxNomeAparelho.getSelectedIndex() + 1);
            if (this.gadget.equals("celular")){
                this.cels = con.buscaTodosCelulares(this.marcaEscolhida);
                for (Celular c : this.cels){
                    jComboBoxNomeAparelho.removeAllItems();
                    jComboBoxNomeAparelho.addItem(c.getNome());
                }
            }else{
               this.tabs = con.buscaTodoslTablets(this.marcaEscolhida);
               for (Tablet tab : this.tabs){
                    jComboBoxNomeAparelho.removeAllItems();
                    jComboBoxNomeAparelho.addItem(tab.getNome());
               }
            }
    }//GEN-LAST:event_jComboBoxMarcaActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        jTextPane1.setText(con.buscaTipoDefeito(jComboBoxTipoDefeito.getSelectedIndex()+1).getTipo());
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup RadioGroupTipoGadget;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAvancarParaOrcamento;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox jComboBoxCor;
    private javax.swing.JComboBox jComboBoxMarca;
    private javax.swing.JComboBox jComboBoxNomeAparelho;
    private javax.swing.JComboBox jComboBoxTipoDefeito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}

