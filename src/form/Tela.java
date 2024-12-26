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
        setTitle("Hoje é " + new Data().DataCompleta(true) + "!");
        setLocation(300,150);
        setResizable(false);
        
    }
    
    public void Enter(boolean nao_e_teste){
        
        this.aply = nao_e_teste;
        
    }
    
    private String Number(int num, int max){
        
        String txt = "";
        
        if(num < 10 && max >= 10){
            txt += "0";
        }
        
        if(num < 100 && max >= 100){
            txt += "0";
        }
        
        if(num < 1000 && max >= 1000){
            txt += "0";
        }
        
        txt += num;
        
        return txt;
        
    }
    
    private void Converter(String file){
        
        String ouput = file.substring(0, file.lastIndexOf("\\")+1);
        String files = file.substring(file.lastIndexOf("\\")+1);
        String name = files.substring(0, files.lastIndexOf("."));
        String ext = files.substring(files.lastIndexOf(".")+1);
        
        if(ext.equalsIgnoreCase("csv")){
            
            csv orm = new csv(file);
            
            int max_track = 0;
            
            String htm = "<html>\n<head>\n<title>";
            htm += name;
            htm += "</title>\n";
            htm += "<meta charset=\"utf-8\" />\n";
            htm += "</head>\n";
            htm += "<body style=\"background-color:black;\">\n";
            
            if(orm.Tot() >= 0){
                
                for(int x = 0; x < orm.Tot(); x++){
                    
                    if(orm.Tot(x) >= 0){
                        
                        Numero track = new Numero(orm.Read(x, 3));
                        
                        if(track.Num() > max_track){
                            max_track = track.Num();
                        }
                        
                        htm += "\n<!-- \"";
                        
                        if(orm.Read(x, 0).isBlank()){
                            htm += orm.Read(x, 10);
                        } else {
                            htm += Registro.Select(orm.Read(x, 0),orm.Read(x, 1).isBlank() ? 60 : 30);
                        }
                        
                        htm += "\"";
                        
                        if(orm.Read(x, 1).isBlank()){
                            
                            htm += " -->";
                            
                        } else {
                            
                            htm += " -- \"";
                            htm += Registro.Select(orm.Read(x, 1), 40);
                            htm += "\" -->\n";
                            
                        }
                        
                        htm += "<div style=\"overflow-x:visible;";
                        
                        if(x == 0){
                            htm += "margin-top:10%;";
                        }
                        
                        if(x == orm.Tot()-1){
                            htm += "margin-bottom:100px;";
                        }
                        
                        htm += "margin-left:10%;margin-right:10%;\">";
                        
                        if(x > 0){
                            
                            htm += "<div style=\"width:100%;height:10%;";
                            htm += "background-color:darkcyan;margin-top:10%;";
                            htm += "\"></div>";
                            
                        }//if(x > 0)

                        boolean vld = track.Val() && track.Num() > 0;
                        boolean track_max = vld && track.Num() < 1000;
                            
                        htm += "<p style=\"color:darkcyan;";

                        if(track_max){
                            htm += "font-size:20vw;";
                        } else {
                            htm += "font-size:15vw;";
                        }

                        htm += "font-weight:bold;";

                        htm += "text-align:center;";

                        if(track_max){
                            htm += "letter-spacing:15vw;";
                        } else {
                            htm += "letter-spacing:10vw;";
                        }

                        htm += "\">";

                        if(track.Num() < 10 && vld){

                            htm += "00";
                            htm += track.Num();

                        } else if(track.Num() < 100 && vld){

                            htm += "0";
                            htm += track.Num();

                        } else if(track.Num() < 1000 && vld){

                            htm += track.Num();

                        } else if(vld){

                            htm += "+999";

                        } else {

                            htm += "---";

                        }//if(track.Num() < 10)
                            
                        htm += "</p>";
                        
                        if(!orm.Read(x, 0).isBlank()){
                            
                            htm += "<div style=\"width:100%;height:5%;";
                            htm += "background-color:darkcyan;margin-top:10%;";
                            htm += "\"></div>";
                            htm += "<p style=\"margin-top:10%;";
                            htm += "font-size:calc(10px + 3vw);";
                            htm += "text-align:center;color:white;";
                            htm += "font-weight:900;\">";
                            htm += Registro.Select(orm.Read(x, 0),25);
                            htm += "</p>";
                            
                        }//if(orm.Read(x, 0).isBlank())
                        
                        if(orm.Read(x, 1).isBlank()){
                            
                            htm += "<div style=\"width:100%;height:5%;";
                            htm += "background-color:darkcyan;margin-top:10%;";
                            htm += "\"></div>";
                            htm += "<p style=\"margin-top:10%;";
                            htm += "font-size:4vw;";
                            htm += "color:darkcyan;text-align:center;";
                            htm += "font-weight:normal;\">";
                            htm += "Artista<br/>Desconhecido</p>";
                            
                        } else {//if(orm.Read(x, 1).isBlank())
                            
                            htm += "<div style=\"width:100%;height:5%;";
                            htm += "background-color:darkcyan;margin-top:10%;";
                            htm += "\"></div>";
                            htm += "<p style=\"margin-top:10%;";
                            htm += "font-size:calc(10px + 3vw);";
                            htm += "color:white;text-align:center;";
                            htm += "font-weight:bold;\">";
                            htm += Registro.Title(orm.Read(x, 1),"<br/>");
                            htm += "</p>";
                            
                        }//if(orm.Read(x, 1).isBlank())
                        
                        htm += "<div style=\"width:100%;height:5%;";
                        htm += "background-color:darkcyan;margin-top:10%;";
                        htm += "\"></div>";
                        htm += "<p style=\"margin-top:10%;";
                        htm += "font-size:calc(10px + 3vw);";
                        htm += "text-align:center;color:white;";
                        htm += "font-weight:900;\">";
                        
                        Numero temp_track = new Numero(orm.Read(x, 6));
                        
                        Hora temp = new Hora(temp_track.Num(), false);
                        
                        htm += temp.getNodeHora(true);
                        
                        htm += "</p>";
                        
                        htm += "</div>";
                        
                        if(orm.Read(x, 0).isBlank()){
                            
                            htm += "<!-- \"";
                            htm += orm.Read(x, 10);
                            
                        } else {
                            
                            htm += "\n<!-- \"";
                            htm += orm.Read(x, 10);
                            
                        }
                        
                        htm += "\" -->\n";
                        
                    }//if(orm.Tot(x) >= 0)
                    
                }//for(int x = 0; x < orm.Tot(); x++)
                
            } else {//if(orm.Tot() >= 0)
                
                htm += "<p style=\"margin-left:10%;";
                htm += "font-size:calc(10px + 1vw);color:white;\">";
                htm += file;
                htm += "</p>";
                
            }//if(orm.Tot() >= 0) - 1
            
            htm += "</body>\n";
            htm += "</html>";
            
            if(orm.Tot() >= 0){
                
                htm += "\n\n<!-- Arquivo \"";
                htm += name;
                htm += "\" --";
                
                String indo = "";
                
                for(int i = 0; i < orm.Tot(); i++){
                    
                    htm += "\n";
                    
                    Numero track = new Numero(orm.Read(i, 3));
                    
                    if(track.Num() > 0 && track.Num() < 1000){
                        
                        int arq_local;
                        
                        if(orm.Read(i, 10).contains(".")){
                            arq_local = orm.Read(i, 10).indexOf(".");
                        } else {
                            arq_local = orm.Read(i, 10).length();
                        }
                        
                        htm += "Faixa ";
                        
                        htm += Number(track.Num(),max_track);
                        
                        htm += ";";
                        
                        htm += orm.Read(i, 10).substring(0, arq_local);

                    } else {//if(track.Num() > 0 && track.Num() < 1000)
                        
                        htm += orm.Read(i, 10);
                        
                    }//if(track.Num() > 0 && track.Num() < 1000)
                    
                    htm += ";";

                    if(orm.Read(i, 0).isBlank()){
                        
                        String origin[] = orm.Read(i,8).split(" ");
                        
                        Data orn =  new Data(origin[0]);
                        
                        if(orn.Val()){
                            
                            htm += orn.DataCompleta(true);
                            
                        } else {//if(orn.Val())
                            
                            htm += "Sem Título";
                            
                        }//if(orn.Val())
                        
                    } else {//if(orm.Read(i, 0).isBlank())

                        htm += orm.Read(i, 0);
                        
                    }//if(orm.Read(i, 0).isBlank())

                    if(!orm.Read(i, 1).isBlank()){
                        
                        htm += ";";
                        htm += orm.Read(i, 1);

                    }//if(!orm.Read(i, 1).isBlank())
                    
                    Numero number_track = new Numero(orm.Read(i, 6));
                    
                    Hora duraction_track = new Hora(number_track.Num(), false);
                    
                    if(number_track.Val() && number_track.Num() > 0){
                        
                        htm += ";";
                        htm += duraction_track.getHora(true);
                        
                    }

                    if(!orm.Read(i, 2).isBlank() && !orm.Read(i, 2).equalsIgnoreCase(indo)){
                        
                        htm += ";";
                        htm += orm.Read(i, 2);
                        indo = orm.Read(i, 2);

                    }//if(!orm.Read(i, 2).isBlank())
                    
                }//for(int i = 0; i < orm.Tot(); i++)
                
                htm += "\n";
                
            }//if(orm.Tot() >= 0) - 2
            
            Data d = new Data();
            Hora h = new Hora(true);
            
            String out = ouput;
            
            out += d.Load();
            
            out += " - ";
            
            if(h.getHora().getHour() < 10){
                out += "0";
            }
            
            out += h.getHora().getHour();
            
            out += "h";
            
            if(h.getHora().getMinute() < 10){
                out += "0";
            }
            
            out += h.getHora().getMinute();
            
            out += "m";
            
            if(h.getHora().getSecond() < 10){
                out += "0";
            }
            
            out += h.getHora().getSecond();
            
            out += "s - ";
            
            out += name;
            
            html export = new html(out,htm);
            
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
