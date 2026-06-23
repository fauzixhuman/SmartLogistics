package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import model.Pengiriman;
import service.PrediksiService;

public class PrediksiController {

    @FXML
    private TextField txtKotaAsal;
    @FXML
    private TextField txtKotaTujuan;
    @FXML
    private ComboBox<String> cmbJenisPengiriman;
    @FXML
    private TextField txtBerat;
    @FXML
    private TextField txtJarakRute;
    @FXML
    private ComboBox<String> cmbSegmenPelanggan;

    @FXML
    private Label lblHasil;
    @FXML
    private Label lblError;

    private PrediksiService prediksiService = new PrediksiService();

    @FXML
    public void initialize() {
        lblHasil.setText("-");
        lblError.setText("");
        
        cmbJenisPengiriman.setItems(FXCollections.observableArrayList("Darat", "Udara", "Laut"));
        cmbSegmenPelanggan.setItems(FXCollections.observableArrayList("Individu", "Korporat"));
    }

    @FXML
    private void handlePrediksi(ActionEvent event) {
        lblError.setText("");
        lblHasil.setText("Memproses...");
        lblHasil.setStyle("-fx-text-fill: #ffa500; -fx-font-weight: bold; -fx-font-size: 24px;");

        try {
            if (txtKotaAsal.getText().isEmpty() || txtKotaTujuan.getText().isEmpty() ||
                txtBerat.getText().isEmpty() || txtJarakRute.getText().isEmpty() ||
                cmbJenisPengiriman.getValue() == null || cmbSegmenPelanggan.getValue() == null) {
                throw new IllegalArgumentException("Semua field harus diisi.");
            }

            String kotaAsal = txtKotaAsal.getText();
            String kotaTujuan = txtKotaTujuan.getText();
            String jenisPengiriman = cmbJenisPengiriman.getValue();
            double berat = Double.parseDouble(txtBerat.getText());
            double jarakRute = Double.parseDouble(txtJarakRute.getText());
            String segmenPelanggan = cmbSegmenPelanggan.getValue();

            Pengiriman pengiriman = new Pengiriman(kotaAsal, kotaTujuan, jenisPengiriman, berat, jarakRute, segmenPelanggan);
            String hasil = prediksiService.prediksi(pengiriman);

            lblHasil.setText(hasil);
            if (hasil.startsWith("Risiko Terlambat")) {
                lblHasil.setStyle("-fx-text-fill: #dc3545; -fx-font-weight: bold; -fx-font-size: 24px;");
            } else {
                lblHasil.setStyle("-fx-text-fill: #28a745; -fx-font-weight: bold; -fx-font-size: 24px;");
            }
        } catch (NumberFormatException ex) {
            lblHasil.setText("-");
            lblError.setText("Berat dan Jarak harus berupa angka.");
        } catch (IllegalArgumentException ex) {
            lblHasil.setText("-");
            lblError.setText(ex.getMessage());
        } catch (Exception ex) {
            lblHasil.setText("-");
            lblError.setText("Gagal memanggil mesin prediksi: " + ex.getMessage());
        }
    }
}
