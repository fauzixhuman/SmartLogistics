package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import model.Pengiriman;
import service.PrediksiService;

public class KlasifikasiController {

    @FXML
    private TextField txtBerat;
    @FXML
    private TextField txtPanjang;
    @FXML
    private TextField txtLebar;
    @FXML
    private TextField txtTinggi;

    @FXML
    private Label lblHasil;
    @FXML
    private Label lblError;

    private PrediksiService prediksiService = new PrediksiService();

    @FXML
    public void initialize() {
        lblHasil.setText("-");
        lblError.setText("");
    }

    @FXML
    private void handleKlasifikasi(ActionEvent event) {
        lblError.setText("");
        lblHasil.setText("Memproses...");

        try {
            if (txtBerat.getText().isEmpty() || txtPanjang.getText().isEmpty() ||
                txtLebar.getText().isEmpty() || txtTinggi.getText().isEmpty()) {
                throw new IllegalArgumentException("Semua field harus diisi.");
            }

            double berat = Double.parseDouble(txtBerat.getText());
            double panjang = Double.parseDouble(txtPanjang.getText());
            double lebar = Double.parseDouble(txtLebar.getText());
            double tinggi = Double.parseDouble(txtTinggi.getText());

            Pengiriman pengiriman = new Pengiriman(berat, panjang, lebar, tinggi);
            String hasil = prediksiService.prediksi(pengiriman);

            lblHasil.setText(hasil);
        } catch (NumberFormatException ex) {
            lblHasil.setText("-");
            lblError.setText("Input harus berupa angka.");
        } catch (IllegalArgumentException ex) {
            lblHasil.setText("-");
            lblError.setText(ex.getMessage());
        } catch (Exception ex) {
            lblHasil.setText("-");
            lblError.setText("Gagal memanggil mesin prediksi: " + ex.getMessage());
        }
    }
}
