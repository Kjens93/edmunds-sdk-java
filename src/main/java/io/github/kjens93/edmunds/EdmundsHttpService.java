package io.github.kjens93.edmunds;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.github.kjens93.edmunds.utils.EdmundsException;
import lombok.Setter;
import lombok.extern.java.Log;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;

/**
 * Created by kjensen on 11/20/16.
 */
@Log
class EdmundsHttpService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Setter
    private String protocol = "https";
    @Setter
    private String baseUrl = "api.edmunds.com";
    @Setter
    private String apiKey;
    @Setter
    private int retries = 3;
    private static final Random random = new Random();

    EdmundsHttpService() {
    }

    EdmundsHttpService(String apiKey) {
        this.apiKey = apiKey;
    }

    <T> T getOne(final Class<T> clazz, final String endpoint, final Map<String, Object> parameters) throws EdmundsException {
        Map<String, Object> params = prepare(parameters);
        String json = get(endpoint, params, retries);
        return deserialize(clazz, json);
    }

    private String get(String endpoint, Map<String, Object> parameters, int retries) throws EdmundsException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme(protocol);
        builder.setHost(baseUrl);
        builder.setPath(endpoint);
        try {
            try {
                String url = builder.build().toString();
                HttpResponse<JsonNode> response = Unirest.get(url)
                        .queryString(parameters)
                        .asJson();
                if (response.getStatus() == 200)
                    return response.getBody().toString();
                else
                    throw deserialize(EdmundsException.class, response.getBody().toString());
            } catch (UnirestException | URISyntaxException e) {
                throw new EdmundsException(e);
            }
        } catch (EdmundsException e) {
            if (retries > 0) {
                log.log(Level.INFO, "Exception raised from HTTP request\n" + e.getMessage() + "\nRetrying...");
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                return get(endpoint, parameters, --retries);
            } else
                throw e;
        }
    }

    private Map<String, Object> prepare(Map<String, Object> parameters) {
        parameters = parameters != null ? parameters : new HashMap<>();
        parameters.put("api_key", apiKey);
        parameters.put("fmt", "json");
        parameters.entrySet().removeIf(e -> e.getValue() == null);
        parameters.entrySet().stream()
                .filter(e -> !(e.getValue() instanceof String))
                .filter(e -> !(e.getValue() instanceof Number))
                .filter(e -> !(e.getValue() instanceof Boolean))
                .forEach(e -> e.setValue(e.getValue().toString()));
        return parameters;
    }

    private <T> T deserialize(Class<T> clazz, String json) throws EdmundsException {
        try {
            return objectMapper.readerFor(clazz).readValue(json);
        } catch (IOException e) {
            throw new EdmundsException(e);
        }
    }

}
