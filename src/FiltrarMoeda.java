import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public URI buscaMoeda(String moeda) {
        var chave = "e762dbb13b74cf7d1c9c2055";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + chave + "/latest/USD");
        System.out.println("qual moeda desseja saber o valor? ");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(endereco)
                .GET()
                .build();
        try {
            HttpResponse<String> resposta = client.send(requisicao, HttpResponse.BodyHandlers.ofString());
            System.out.println(resposta.body());
            JsonElement elemento = JsonParser.parseString(resposta.body());
            JsonObject objectRoot = elemento.getAsJsonObject();
            double taxa = objectRoot.get("conversion_rates").getAsDouble();
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

}