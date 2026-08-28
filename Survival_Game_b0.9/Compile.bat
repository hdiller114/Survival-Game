@echo off
javac src\*.java -d bin
jar cfm Survival_Game_b0.9.jar MANIFEST.MF -C bin . textures
pause