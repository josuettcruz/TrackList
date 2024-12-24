/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import file.*;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class Tela extends javax.swing.JFrame {
    
    private boolean aply = false;

    /**
     * Creates new form Tela
     */
    public Tela() {
        
        initComponents();
        setVisible(true);
        setLocation(300,150);
        
    }
    
    public void Enter(boolean nao_e_teste){
        
        this.aply = nao_e_teste;
        
    }
    
    private void Converter(String file){
        
        String ouput = file.substring(0, file.lastIndexOf("\\")+1);
        String files = file.substring(file.lastIndexOf("\\")+1);
        String name = files.substring(0, files.lastIndexOf("."));
        String ext = files.substring(files.lastIndexOf(".")+1);
        
        if(ext.equalsIgnoreCase("csv")){
            
            csv orm = new csv(file);
            
            String htm = "<html>\n<head>\n<title>";
            htm += name;
            htm += "</title>\n";
            htm += "<meta charset=\"utf-8\" />";
            htm += "</head>\n";
            htm += "<body style=\"background-color:black;\">\n";
            
            if(orm.Tot() >= 0){
                
                for(int x = 0; x < orm.Tot(); x++){
                    
                    if(orm.Tot(x) >= 0){
                        
                        cod tx = new cod();
                        
                        tx.toInteger(orm.Read(x, 3));
                        
                        htm += "<div style=\"overflow-x:visible;";
                        
                        if(x == 0){
                            htm += "margin-top:10%;";
                        }
                        
                        if(x == orm.Tot()-1){
                            htm += "margin-bottom:20%;";
                        }
                        
                        htm += "margin-left:10%;margin-right:10%;\">";
                        
                        if(x > 0){
                            
                            htm += "<div style=\"width:100%;height:10%;";
                            htm += "background-color:darkcyan;margin-top:10%;";
                            htm += "\"></div>";
                            
                        }//if(x > 0)
                        
                        if(tx.Int() < 10){
                            
                            htm += "<p style=\"color:darkcyan;";
                            htm += "font-size:15vw;font-weight:bold;";
                            htm += "text-align:center;";
                            htm += "letter-spacing:2vw;\">00";
                            htm += tx.Int();
                            htm += "</p>";
                            
                        } else if(tx.Int() < 100){
                            
                            htm += "<p style=\"color:darkcyan;";
                            htm += "font-size:15vw;font-weight:bold;";
                            htm += "text-align:center;";
                            htm += "letter-spacing:2vw;\">0";
                            htm += tx.Int();
                            htm += "</p>";
                            
                        } else if(tx.Int() < 1000){
                            
                            htm += "<p style=\"color:darkcyan;";
                            htm += "font-size:15vw;font-weight:bold;";
                            htm += "text-align:center;";
                            htm += "letter-spacing:2vw;\">";
                            htm += tx.Int();
                            htm += "</p>";
                            
                        } else {
                            
                            htm += "<p style=\"color:darkcyan;";
                            htm += "font-size:15vw;font-weight:bold;";
                            htm += "text-align:center;";
                            htm += "letter-spacing:2vw;\">---</p>";
                            
                        }//if(tx.Int() < 10)
                        
                        htm += "<div style=\"width:100%;height:5%;";
                        htm += "background-color:darkcyan;margin-top:10%;";
                        htm += "\"></div>";
                        htm += "<p style=\"margin-top:10%;";
                        htm += "font-size:calc(10px + 3vw);";
                        htm += "text-align:center;color:white;";
                        htm += "font-weight:900;\">";
                        if(orm.Read(x, 0).isBlank()){
                            htm += "Sem Título";
                        } else {
                            htm += orm.Read(x, 0).replace(" (", "<br/>(").replace(".", "<span style=\"color:darkcyan;font-size:1.2em;\">.</span>").replaceAll(" - ", "<br/>").replaceFirst(": ", ":<br/>");
                        }
                        htm += "</p>";
                        
                        if(orm.Read(x, 1).isBlank()){
                            
                            htm += "<div style=\"width:100%;height:5%;";
                            htm += "background-color:darkcyan;margin-top:10%;";
                            htm += "\"></div>";
                            htm += "<p style=\"margin-top:10%;";
                            htm += "font-size:calc(10px + 3vw);";
                            htm += "color:darkcyan;text-align:center;";
                            htm += "font-weight:500;\">Artista<br/>Desconhecido</p>";
                            
                        } else {
                            
                            htm += "<div style=\"width:100%;height:5%;";
                            htm += "background-color:darkcyan;margin-top:10%;";
                            htm += "\"></div>";
                            htm += "<p style=\"margin-top:10%;";
                            htm += "font-size:calc(10px + 3vw);";
                            htm += "color:white;text-align:center;";
                            htm += "font-weight:500;\">";
                            htm += orm.Read(x, 1).replace(" e ", "<br/><span style=\"margin-left:.5em;margin-right:.5em;color:darkcyan;\">&</span><br/>").replace(" (", "<br/>(").replaceAll(" - ", "<br/>");
                            htm += "</p>";
                            
                        }
                        
                        htm += "</div>\n";
                        
                    }//if(orm.Tot(x) >= 0)
                    
                }//for(int x = 0; x < orm.Tot(); x++)
                
            } else {//if(orm.Tot() >= 0)
                
                htm += "<p style=\"margin-left:10%;font-size:calc(10px + 1vw);color:white;\">";
                htm += file;
                htm += "</p>";
                
            }//if(orm.Tot() >= 0) - 1
            
            htm += "</body>\n";
            htm += "</html>";
            
            if(orm.Tot() >= 0){
                
                htm += "\n\n<!-- ";
                htm += name;
                htm += " --";
                
                for(int i = 0; i < orm.Tot(); i++){
                    
                    htm += "\n";

                    if(orm.Read(i, 10).isBlank()){
                        
                        htm += "SOUND";

                    } else {
                        
                        htm += orm.Read(i, 10);
                        
                    }
                    
                    htm += ";";

                    if(orm.Read(i, 0).isBlank()){

                        htm += "Sem Título";
                        
                    } else {

                        htm += orm.Read(i, 0);
                        
                    }

                    if(!orm.Read(i, 1).isBlank()){
                        
                        htm += ";";
                        htm += orm.Read(i, 1);

                    }//if(!orm.Read(i, 1).isBlank())

                    if(!orm.Read(i, 2).isBlank()){
                        
                        htm += ";";
                        htm += orm.Read(i, 2);

                    }//if(!orm.Read(i, 2).isBlank())
                    
                }//for(int i = 0; i < orm.Tot(); i++)
                
            }//if(orm.Tot() >= 0) - 2
            
            cod dg = new cod();
            
            html export = new html(ouput + name + "_" + dg.Date(false) + "_" + dg.Time(false),htm);
            
            System.out.println(aply ? export.Export() : export.Ready("\n"));
            
        } else {
            
            JOptionPane.showMessageDialog(null, "O arquivo:\n\"" + 
                    name + 
                    "\"\nNão é .CSV", 
                    "Só aceita .CSV", 
                    JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }//Converter(String file)

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        file = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileMouseClicked(evt);
            }
        });
        file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileActionPerformed(evt);
            }
        });
        file.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fileKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fileKeyPressed
        
        //String code = file.getCurrentDirectory().getName();
        //System.out.println(code);
        
    }//GEN-LAST:event_fileKeyPressed

    private void fileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileMouseClicked
        
        //String code = file.getCurrentDirectory().getName();
        //System.out.println(code);
        
    }//GEN-LAST:event_fileMouseClicked

    private void fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileActionPerformed
        
        //dispose();
        
        try{
            
            String files = file.getSelectedFile().toString();
            
            if(files.contains(".") && files.contains("\\")){
                
                Converter(files);
                
            } else {
                
                JOptionPane.showMessageDialog(null, "Só aceita CSV", 
                        "Arquivo Inválido", 
                        JOptionPane.INFORMATION_MESSAGE);
                
            }//if(files.contains(".") && files.contains("\\"))
            
        }catch(HeadlessException ev){
            
            JOptionPane.showMessageDialog(null, "HeadlessException\n" +  
                    ev.getMessage().replaceAll(" \"","\n").replaceAll("\" ","\n"), 
                    "Código: " + ev.hashCode(), 
                    JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ev){
            
           System.out.println(ev.getLocalizedMessage());
            
        }finally{
            
            System.exit(0);
            
        }
        
    }//GEN-LAST:event_fileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser file;
    // End of variables declaration//GEN-END:variables

    private void JOptionPane(Object object, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
