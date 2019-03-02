package lab.pkg6_joeldiaz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class mundo_disco {
    private String tortuga;
    private ArrayList<criatura> criaturas = new ArrayList();
    File archivo = null;

    public mundo_disco(String path) {
        this.archivo=new File(path);
    }
    

    public mundo_disco() {
        
    }

    public String getTortuga() {
        return tortuga;
    }

    public void setTortuga(String tortuga) {
        this.tortuga = tortuga;
    }

    public ArrayList<criatura> getCriaturas() {
        return criaturas;
    }

    public void setCriaturas(ArrayList<criatura> criaturas) {
        this.criaturas = criaturas;
    }
    
    public void escribirArchivo() throws IOException{
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw=new FileWriter(archivo, false);
            bw=new BufferedWriter(fw);
            for (criatura t: criaturas) {
                bw.write(t.getNombre()+"|");
                bw.write(t.getEnergia()+"|");
                bw.write(t.getAños()+"|");
                bw.write(t.getRegion()+"|");
                bw.write(t.getVivas()+"|--");
                for (int i = 0; i < t.getObjetos_magicos().size(); i++) {
                    bw.write(t.getObjetos_magicos().get(i)+"--");
                }
                bw.write("|");
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bw.close();
        fw.close();
    }
    
    public void cargarArchivo(){
        Scanner sc=null;
        Scanner sc2=null;
        criaturas =new ArrayList();
        if (archivo.exists()){
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("|");
                while(sc.hasNext()){
                    criatura x = new criatura(sc.next(), sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt());
                    String tH = sc.next();
                    ArrayList<String> obj = new ArrayList();
                    sc2 = new Scanner(tH);
                    sc2.useDelimiter("--");
                    sc2.next();
                    while(sc2.hasNext()){
                        obj.add(sc2.next());
                    }
                    x.setObjetos_magicos(obj);
                    criaturas.add(x);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
    
        public static String cifrado(String txt) {
        StringBuilder cifrado = new StringBuilder();
        int c = 4 % 26;
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) >= 'a' && txt.charAt(i) <= 'z') {
                if ((txt.charAt(i) + c) > 'z') {
                    cifrado.append((char) (txt.charAt(i) + c - 26));
                } else {
                    cifrado.append((char) (txt.charAt(i) + c));
                }
            } else if (txt.charAt(i) >= 'A' && txt.charAt(i) <= 'Z') {
                if ((txt.charAt(i) + c) > 'Z') {
                    cifrado.append((char) (txt.charAt(i) + c - 26));
                } else {
                    cifrado.append((char) (txt.charAt(i) + c));
                }
            }
        }
        return cifrado.toString();
    }

    public static String descifrado(String txt) {
        StringBuilder cifrado = new StringBuilder();
        int c = 4 % 26;
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) >= 'a' && txt.charAt(i) <= 'z') {
                if ((txt.charAt(i) - c) < 'a') {
                    cifrado.append((char) (txt.charAt(i) - c + 26));
                } else {
                    cifrado.append((char) (txt.charAt(i) - c));
                }
            } else if (txt.charAt(i) >= 'A' && txt.charAt(i) <= 'Z') {
                if ((txt.charAt(i) - c) < 'A') {
                    cifrado.append((char) (txt.charAt(i) - c + 26));
                } else {
                    cifrado.append((char) (txt.charAt(i) - c));
                }
            }
        }
        return cifrado.toString();
    }
    
}
