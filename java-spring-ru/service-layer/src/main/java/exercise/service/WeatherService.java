package exercise.service;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import exercise.HttpClient;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import exercise.CityNotFoundException;
import exercise.repository.CityRepository;
import exercise.model.City;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class WeatherService {

    @Autowired
    CityRepository cityRepository;

    // Клиент
    HttpClient client = new HttpClient();;

    // При создании класса сервиса клиент передаётся снаружи
    // В теории это позволит заменить клиент без изменения самого сервиса
    WeatherService(HttpClient client) {
        this.client = client;
    }

    // BEGIN
    public Map<String, String> getWeather(City city) {
        Map<String, String> result = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        String responseGet = client.get("http://weather/api/v2/cities/" + city.getName());

        try {
            result = mapper.readValue(responseGet, Map.class);
        } catch (JsonProcessingException e) {
            return result;
        }
        return result;
    }
    // END
}
