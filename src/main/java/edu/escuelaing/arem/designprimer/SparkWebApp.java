package edu.escuelaing.arem.designprimer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.escuelaing.arem.app.App;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

/**
 *
 * @author Jonathan Prieto
 */
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/index", (req, res) -> index(req, res));
        get("/result", (req, res) -> result(req, res));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e.on localhost)
    }

    private static String index(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "    <head>"
                + "        <title>App</title>"
                + "        <meta charset=UTF-8>"
                + "    </head>"
                + "    <body>"
                + "        <h2>Estadísticos</h2>"
                + "        <p>La siguiente aplicación web calcula el máximo, mínimo, sumatoria y multiplicatoria de un conjunto de números reales.<br /> Éstos se podrán ingresar en el siguiente campo, separándolos por “ , “ e.g., 21,3,5,9,...</p>"
                + "        <form action=/result>"
                + "            Conjunto de números:<br>"
                + "            <input type=text name=realNumber value= ><br><br>"
                + "            <input type=submit value=Calcular>"
                + "        </form>"
                + "    </body>"
                + "</html>";
        return pageContent;
    }

    private static String result(Request req, Response res) {
        String numbers = req.queryParams("realNumber");
        App.calculate(numbers);
        String pageContent = App.getNumbersList() + ";" + App.getMax() + ";" + App.getMin() + ";" + App.getSumatoria() + ";" + App.getMultiplicatoria();
        return pageContent;
    }
}
