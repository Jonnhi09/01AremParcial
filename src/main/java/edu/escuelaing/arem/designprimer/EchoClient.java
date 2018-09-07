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
        URL heroku = new URL("http://localhost:4567/result?realNumber=1%2C2%2C3");
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(heroku.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

}
