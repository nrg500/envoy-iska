package com.infosupport.booking;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class BookingController {

    @GetMapping("/booking")
    public String getBooking(HttpServletRequest request) throws URISyntaxException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("http://127.0.0.1/room");
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-request-id", request.getHeader("x-request-id"));
        headers.set("x-b3-traceid", request.getHeader("x-b3-traceid"));
        headers.set("x-b3-spanid", request.getHeader("x-b3-spanid"));
        headers.set("x-b3-parentspanid", request.getHeader("x-b3-parentspanid"));
        headers.set("x-b3-sampled", request.getHeader("x-b3-sampled"));
        headers.set("x-b3-flags", request.getHeader("x-b3-flags"));
        headers.set("x-ot-span-context", request.getHeader("x-ot-span-context"));
        HttpEntity entity = new HttpEntity(headers);
        Thread.sleep(100 + (int)Math.random()*200);

        ResponseEntity<String> hotelRoom = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        String result = "";
        if(hotelRoom.getStatusCode() == HttpStatus.OK){
            result += "Congratulations, we found you a room ! :" + hotelRoom.getBody();
        } else {
            result += "Sorry, we could not find you a room.";
        }
        return result;
    }


    @GetMapping("/health")
    public String getHealth(){
        return "Ok";
    }
}
