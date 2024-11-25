import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdPartyApiService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String THIRD_PARTY_API_URL = "https://api.thirdparty.com/resource";

    public String fetchDataFromThirdParty() {
        ResponseEntity<String> response = restTemplate.getForEntity(THIRD_PARTY_API_URL, String.class);
        return response.getBody(); // You can map the response body to a POJO if needed.
    }

    public String postDataToThirdParty(Object requestPayload) {
        ResponseEntity<String> response = restTemplate.postForEntity(THIRD_PARTY_API_URL, requestPayload, String.class);
        return response.getBody(); // Again, map to a POJO if required.
    }
}
