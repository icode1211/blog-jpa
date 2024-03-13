package com.estsoft.blogjpa.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ExampleAPIClient {

    public String fetchDataFromApi(String apiUrl) {
        // RestTemplate : HTTP 통신을 위한 도구
        // 외부 도메인으로부터 데이터를 가져오거나 전송할 때 사용
        RestTemplate restTemplate = new RestTemplate();

        // API로 GET 요청을 보냈고, ResponseEntity<String>으로 json 응답 받음
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {  //HTTP status code 200 체크
            return responseEntity.getBody();
        } else {
            log.error("Failed to fetch data from API. Status code: " + responseEntity.getStatusCodeValue());
            return null;
        }
    }
}
