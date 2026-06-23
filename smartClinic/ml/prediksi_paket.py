import sys
import time
import random

def main():
    if len(sys.argv) < 7:
        print("Error: Argumen kurang. Butuh kota_asal, kota_tujuan, jenis_pengiriman, berat, jarak, segmen", file=sys.stderr)
        sys.exit(1)
        
    try:
        kota_asal = sys.argv[1]
        kota_tujuan = sys.argv[2]
        jenis_pengiriman = sys.argv[3]
        berat = float(sys.argv[4])
        jarak = float(sys.argv[5])
        segmen = sys.argv[6]
        
        # Simulate loading model .pkl and predicting
        time.sleep(1) # simulate processing time
        
        # Dummy logic based on distance and transport type
        probability = 85.0
        
        if jenis_pengiriman.lower() == "darat" and jarak > 1000:
            probability -= 40
        elif jenis_pengiriman.lower() == "laut":
            probability -= 20
        elif jenis_pengiriman.lower() == "udara":
            probability += 10
            
        if berat > 50:
            probability -= 15
            
        if segmen.lower() == "korporat":
            probability += 5
            
        probability = max(0.0, min(100.0, probability))
        probability += random.uniform(-5.0, 5.0) # add some randomness
        probability = max(0.0, min(100.0, probability))
        
        if probability >= 70:
            print(f"Aman - {probability:.1f}% Tepat Waktu")
        else:
            prob_telat = 100.0 - probability
            print(f"Risiko Terlambat - Potensi Telat {prob_telat:.1f}%")
            
    except ValueError:
        print("Error: Berat dan Jarak harus berupa angka", file=sys.stderr)
        sys.exit(1)

if __name__ == "__main__":
    main()
