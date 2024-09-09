//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChessTraining {
    private static final String CHESS_COM_API_URL = "https://api.chess.com/pub/player/";

    public ChessTraining() {
    }

    public String ObtenerPartidasUsuario(String username) {
        String endpoint = "https://api.chess.com/pub/player/" + username + "/games/archives";
        StringBuffer response = new StringBuffer();

        try {
            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String inputLine;
                while((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                return response.toString();
            }

            System.out.println("Error de conexion API chess.com");
        } catch (IOException var9) {
            IOException e = var9;
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        ChessTraining training = new ChessTraining();
        String gamesData = training.ObtenerPartidasUsuario("magnuscarlsen");
        if (gamesData != null) {
            System.out.println("Datos obtenidos: " + gamesData);
        } else {
            System.out.println("No se han podido obtener datos de partidas.");
        }

    }
}