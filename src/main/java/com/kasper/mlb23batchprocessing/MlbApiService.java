package com.kasper.mlb23batchprocessing;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MlbApiService {
    private static final String api_url="https://mlb23.theshow.com";
    private WebClient webclient;

    public void runMlbApiService() {
        webclient = WebClient.builder().build();

        // Find number of pages
        MlbTheShowItemsApiResponse response = callMlbApi(0).block();
        AtomicInteger sharedInt = new AtomicInteger(0);

        if (response != null) {
            int numOfPages = response.getTotal_pages();

            for (int i = 0; i < numOfPages; i++) {
                int thisPageNum = i;
                callMlbApi(thisPageNum)
                        .subscribe(
                                apiResponse -> {
                                    System.out.println("######## PAGE NUM " + thisPageNum + " ########");
                                    apiResponse.getItems()
                                            .forEach(System.out::println);
                                    sharedInt.addAndGet(1);
                                }
                        );
            }

            while (sharedInt.get() < numOfPages) {
                // DO NOTHING
            }
        }

    }


    private Mono<MlbTheShowItemsApiResponse> callMlbApi(int pageNum) {
        return webclient
                .get()
                .uri(constructUrl(pageNum))
                .retrieve()
                .bodyToMono(MlbTheShowItemsApiResponse.class);
    }

    private static String constructUrl(int pageNum) {
        return UriComponentsBuilder.fromUriString(api_url)
                .pathSegment("apis", "items.json")
                .queryParam("type", "mlb_card")
                .queryParam("page", pageNum)
                .toUriString();
    }
}
