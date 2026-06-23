import sys
import time

def main():
    if len(sys.argv) < 5:
        print("Error: Argumen kurang. Butuh berat, panjang, lebar, tinggi", file=sys.stderr)
        sys.exit(1)
        
    try:
        berat = float(sys.argv[1])
        panjang = float(sys.argv[2])
        lebar = float(sys.argv[3])
        tinggi = float(sys.argv[4])
        
        # Simulate loading model .pkl and predicting
        time.sleep(1) # simulate processing time
        
        volume = panjang * lebar * tinggi
        
        # Dummy logic
        if berat > 10 or volume > 10000:
            print("Kargo")
        elif berat > 2:
            print("Reguler")
        else:
            print("Dokumen/Kecil")
            
    except ValueError:
        print("Error: Argumen harus berupa angka", file=sys.stderr)
        sys.exit(1)

if __name__ == "__main__":
    main()
