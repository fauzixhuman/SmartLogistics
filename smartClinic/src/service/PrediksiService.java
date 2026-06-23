package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrediksiService {

    public String prediksi(model.Pengiriman pengiriman) throws Exception {
        // Prepare the python command
        String pythonCmd = "python"; // Assume python is in PATH
        String scriptPath = "ml/prediksi_paket.py";
        
        // Use ProcessBuilder to execute the Python script with arguments
        ProcessBuilder pb = new ProcessBuilder(
            pythonCmd,
            scriptPath,
            String.valueOf(pengiriman.getBerat()),
            String.valueOf(pengiriman.getPanjang()),
            String.valueOf(pengiriman.getLebar()),
            String.valueOf(pengiriman.getTinggi())
        );
        
        Process process = pb.start();
        
        // Read the output
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }
        
        // Read errors if any
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        StringBuilder errorOutput = new StringBuilder();
        while ((line = errorReader.readLine()) != null) {
            errorOutput.append(line);
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new Exception("Gagal memanggil mesin prediksi. Python exit code: " + exitCode + ". Error: " + errorOutput.toString());
        }

        return output.toString().trim();
    }
}
