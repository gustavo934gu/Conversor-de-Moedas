import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FiltrarMoeda {

    public double buscaMoeda(String moeda) {

        String chave = System.getenv("API_KEY");
        URI endereco = URI.create(
                "https://v6.exchangerate-api.com/v6/" + chave + "/latest/USD"
        );

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(endereco)
                    .GET()
                    .build();

            HttpResponse<String> resposta = client.send(requisicao,
                    HttpResponse.BodyHandlers.ofString());

            JsonObject root = JsonParser.parseString(resposta.body())
                    .getAsJsonObject();

            return root.getAsJsonObject("conversion_rates")
                    .get(moeda)
                    .getAsDouble();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar moeda: " + moeda, e);
        }
    }
}
