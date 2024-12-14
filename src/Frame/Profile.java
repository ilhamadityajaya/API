package Frame ;


import org.json.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import kelass.mahasiswa;


/**
 *
 * @author ASUS
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    public Profile() {
        initComponents();
        loadProfile();
    }
    void loadProfile() {
        tPoto.setIcon(null);
        JSONArray data = mahasiswa.getDataMhs();
        for (int i = 0; i < data.length(); i++) {
            JSONObject item = data.getJSONObject(i);
            if (i == mahasiswa.getBaris()) {
                tnim.setText(item.getString("mhs_nim"));
                tnama.setText(item.getString("mhs_nama"));
                tjeniskelamin.setText(item.getString("mhs_jk"));
                tttl.setText(item.getString("mhs_tempatlahir") + "," + item.getString("mhs_tanggallahir"));
                temail.setText(item.getString("mhs_email"));
                thp.setText(item.getString("mhs_hp"));

                if (item.has("mhs_foto") && !item.isNull("mhs_foto") && !item.getString("mhs_foto").isEmpty()) {
                    String dataFoto = item.getString("mhs_foto");

                    try {
                        if (dataFoto.startsWith("data:image")) {
                            String base64Data = dataFoto.split(",")[1];
                            byte[] imageBytes = Base64.getDecoder().decode(base64Data);
                            ByteArrayInputStream bas = new ByteArrayInputStream(imageBytes);
                            BufferedImage bmg = ImageIO.read(bas);
                            Image image = bmg.getScaledInstance(tPoto.getWidth(), tPoto.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon imic = new ImageIcon(image);
                            tPoto.setText(null);
                            tPoto.setIcon(imic);
                        } else {
                            URL url = new URL(dataFoto);
                            BufferedImage bmg = ImageIO.read(url);
                            Image image = bmg.getScaledInstance(tPoto.getWidth(), tPoto.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon imic = new ImageIcon(image);
                            tPoto.setText(null);
                            tPoto.setIcon(imic);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        tPoto.setText("Foto kosong");
                    }
                } else {
                    tPoto.setText("kosong");
                }

            }

        }

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tnim = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        tjeniskelamin = new javax.swing.JTextField();
        tttl = new javax.swing.JTextField();
        temail = new javax.swing.JTextField();
        thp = new javax.swing.JTextField();
        tPoto = new javax.swing.JLabel();
        tPrevious = new javax.swing.JButton();
        tNex = new javax.swing.JButton();
        tClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("NIM ");

        jLabel2.setText("NAMA");

        jLabel3.setText("JENIS KELAMIN");

        jLabel4.setText("TTL");

        jLabel5.setText("EMAILE ");

        jLabel6.setText("NOMER HP");

        tjeniskelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjeniskelaminActionPerformed(evt);
            }
        });

        temail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temailActionPerformed(evt);
            }
        });

        thp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thpActionPerformed(evt);
            }
        });

        tPoto.setText("jLabel7");
        tPoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tPrevious.setText("Provious");
        tPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPreviousActionPerformed(evt);
            }
        });

        tNex.setText("NEXT");
        tNex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNexActionPerformed(evt);
            }
        });

        tClose.setText("CLOSE");
        tClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCloseActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel8.setBackground(new java.awt.Color(0, 102, 255));
        jLabel8.setFont(new java.awt.Font("Sitka Text", 3, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("profile ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tnim, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tjeniskelamin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tttl, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(temail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thp, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tnama))
                        .addGap(74, 74, 74)
                        .addComponent(tPoto, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(tPrevious)
                .addGap(156, 156, 156)
                .addComponent(tNex)
                .addGap(204, 204, 204)
                .addComponent(tClose)
                .addContainerGap(151, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tnim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tjeniskelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tttl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(temail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(thp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tPrevious)
                            .addComponent(tNex)
                            .addComponent(tClose))
                        .addGap(101, 101, 101))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(tPoto, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tjeniskelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tjeniskelaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tjeniskelaminActionPerformed

    private void temailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_temailActionPerformed

    private void thpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thpActionPerformed

    private void tCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCloseActionPerformed
        // TODO add your handling code here:
dispose();
    }//GEN-LAST:event_tCloseActionPerformed

    private void tNexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNexActionPerformed
        // TODO add your handling code here:
 if(mahasiswa.getBaris()>=0 && mahasiswa.getBaris()<=mahasiswa.getDataMhs().length()){
            mahasiswa.setBaris(mahasiswa.getBaris()+1);
        loadProfile();
        }else{
     
 }

    }//GEN-LAST:event_tNexActionPerformed

    private void tPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPreviousActionPerformed
        // TODO add your handling code here:
 if(mahasiswa.getBaris()>0 && mahasiswa.getBaris()<=mahasiswa.getDataMhs().length()){
            mahasiswa.setBaris(mahasiswa.getBaris()-1);
            loadProfile();
        }
    }//GEN-LAST:event_tPreviousActionPerformed

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton tClose;
    private javax.swing.JButton tNex;
    private javax.swing.JLabel tPoto;
    private javax.swing.JButton tPrevious;
    private javax.swing.JTextField temail;
    private javax.swing.JTextField thp;
    private javax.swing.JTextField tjeniskelamin;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnim;
    private javax.swing.JTextField tttl;
    // End of variables declaration//GEN-END:variables

}
