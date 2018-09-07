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
        URL google = new URL("https://immense-escarpment-48819.herokuapp.com/index");
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

}
