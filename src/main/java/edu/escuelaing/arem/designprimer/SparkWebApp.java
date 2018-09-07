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
 * @author jonnhi
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
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "    <head>"
                + "        <title>Resul App</title>"
                + "        <meta charset=\"UTF-8\">"
                + "        <style>"
                + "            table {"
                + "                font-family: arial, sans-serif;"
                + "                border-collapse: collapse;"
                + "                width: 100%;"
                + "            }"
                + "            td, th {"
                + "                border: 1px solid #dddddd;"
                + "                text-align: center;"
                + "                padding: 8px;"
                + "            }"
                + "            tr:nth-child(even) {"
                + "                background-color: #dddddd;"
                + "            }"
                + "        </style>"
                + "    </head>"
                + "    <body>"
                + "        <h2>Estadísticos</h2>"
                + "        <p>La siguiente tabla contiene el resultado del máximo, mínimo, sumatoria y multiplicatoria del conjunto de datos dado.</p>"
                + "        <table>"
                + "            <tr>"
                + "                <th>Colección de números en formato JSON</th>"
                + "                <th>Maximo</th>"
                + "                <th>Minimo</th>"
                + "                <th>Sumatoria</th>"
                + "                <th>Multiplicatoria</th>"
                + "            </tr>"
                + "            <tr>"
                + "                <td>" + App.getNumbersList() + "</td>"
                + "                <td>" + App.getMax() + "</td>"
                + "                <td>" + App.getMin() + "</td>"
                + "                <td>" + App.getSumatoria() + "</td>"
                + "                <td>" + App.getMultiplicatoria() + "</td>"
                + "            </tr>"
                + "        </table>"
                + "        <br />"
                + "        <a href=\"/index\" title=\"Go to home\" align=center>Volver</a>"
                + "    </body>"
                + "</html>";
        return pageContent;
    }
}
