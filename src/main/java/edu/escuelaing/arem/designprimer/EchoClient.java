/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.designprimer;

/**
 *
 * @author Jonathan Prieto
 */
import java.io.*;
import java.net.*;

public class EchoClient {

    public static void main(String[] args) throws Exception {
        URL google = new URL("https://immense-escarpment-48819.herokuapp.com/result?realNumber=1%2C2%2C3");
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            String respuesta = null;
            boolean flag = false;
            while ((inputLine = reader.readLine()) != null) {
                String[] lineas = inputLine.split(";");
                for (String s : lineas) {
                    System.out.println(s);
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

}
