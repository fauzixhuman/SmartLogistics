@echo off
echo Mengkompilasi file Java...
if not exist "bin" mkdir bin
if not exist "bin\view" mkdir bin\view
if not exist "bin\style" mkdir bin\style

cd src
javac --module-path C:/javafx-sdk-21.0.11/lib --add-modules javafx.controls,javafx.fxml -d ..\bin AppMain.java controller\*.java model\*.java service\*.java
cd ..

copy "src\view\*.fxml" "bin\view\" > nul
copy "src\style\*.css" "bin\style\" > nul

echo Menjalankan aplikasi...
java --module-path C:/javafx-sdk-21.0.11/lib --add-modules javafx.controls,javafx.fxml -cp "bin" AppMain
pause
