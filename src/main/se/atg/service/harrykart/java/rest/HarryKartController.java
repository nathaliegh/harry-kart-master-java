package se.atg.service.harrykart.java.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.atg.service.harrykart.java.payload.HarryKartType;
import se.atg.service.harrykart.java.service.HarryKartService;

@RestController
@RequestMapping("/java/api")
public class HarryKartController {

    private final HarryKartService harryKartService;

    public HarryKartController(HarryKartService harryKartService) {
        this.harryKartService = harryKartService;
    }

    @PostMapping(path = "/play", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String playHarryKart(@RequestBody HarryKartType harryKartType) {
        return harryKartService.rankTheHorseRacing(harryKartType);
    }

}
