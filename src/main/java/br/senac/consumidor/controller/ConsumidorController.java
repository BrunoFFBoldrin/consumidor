package br.senac.consumidor.controller;


import br.senac.consumidor.controller.request.ConsumidorRequest;
import br.senac.consumidor.controller.response.ConsumidorResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/consumidor")
public class ConsumidorController {


    private final RestTemplate restTemplate;

    public ConsumidorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/calcular-numeros")
    public ResponseEntity<ConsumidorResponse> calcularNumero(@RequestBody ConsumidorRequest request) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ConsumidorRequest> req = new HttpEntity<>(request, headers);

        String url = "http://localhost:8081/produtor/calcular-numeros";

        ResponseEntity<ConsumidorResponse> response = restTemplate
                .postForEntity(url, req, ConsumidorResponse.class);

        System.out.println("O resultado é: " + response.getBody());


        return response;
    }
}
