package se.atg.service.harrykart.java.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import se.atg.service.harrykart.java.dto.LaneRound;
import se.atg.service.harrykart.java.payload.HarryKartType;
import se.atg.service.harrykart.java.payload.ParticipantType;
import se.atg.service.harrykart.java.response.HarryKartResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HarryKartService {

    private static final double trackLength = 1000.0;
    private final HarryKartResponse harryKartResponse;

    public HarryKartService(HarryKartResponse harryKartResponse) {
        this.harryKartResponse = harryKartResponse;
    }


    public String rankTheHorseRacing(HarryKartType harryKart) {
        if (Optional.of(harryKart).isEmpty()) return harryKartResponse.getDefaultResponse();
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        var laneRounds = getLaneRounds(harryKart);
        if (laneRounds.size() > 0) harryKartResponse.buildResponse(mapper, arrayNode, laneRounds);
        return harryKartResponse.getResponse(mapper, arrayNode);
    }


    @NotNull
    private ArrayList<LaneRound> getLaneRounds(HarryKartType harryKart) {
        var laneRounds = new ArrayList<LaneRound>();
        Optional.ofNullable(harryKart.getStartList())
                .ifPresent(
                        startListType ->
                                Optional.ofNullable(startListType.getParticipant())
                                        .ifPresent(p -> initializeLaneRounds(harryKart, laneRounds))
                );

        if (laneRounds.isEmpty() || harryKart.getNumberOfLoops() <= 0) return laneRounds;
        for (int i = 0; i < harryKart.getNumberOfLoops() - 1; i++) {
            manipulateLaneRounds(harryKart, laneRounds, i);
        }
        return laneRounds;
    }

    private void manipulateLaneRounds(HarryKartType harryKartType,
                                      ArrayList<LaneRound> laneRounds,
                                      int i) {
        harryKartType.getPowerUps()
                .getLoop()
                .get(i)
                .getLane()
                .stream()
                .forEach(laneType ->
                        laneRounds.stream().filter(laneRound ->
                                        laneRound.getLane() == laneType.getNumber())
                                .findFirst().ifPresent(laneRound -> {
                                            laneRound.setSpeed(laneRound.getSpeed() + laneType.getValue());
                                            laneRound.setTime(laneRound.getTime() + trackLength / laneRound.getSpeed());
                                        }
                                )
                );
    }

    private void initializeLaneRounds(HarryKartType harryKartType,
                                      ArrayList<LaneRound> laneRounds) {
        var participantTypes = harryKartType.getStartList().getParticipant()
                .stream()
                .sorted(Comparator.comparingInt(ParticipantType::getLane))
                .collect(Collectors.toList());
        participantTypes
                .stream()
                .forEach(participantType -> {
                    var laneRound = new LaneRound();
                    laneRound.setLane(participantType.getLane());
                    laneRound.setTime(trackLength / participantType.getBaseSpeed());
                    laneRound.setSpeed(participantType.getBaseSpeed());
                    laneRound.setHorse(participantType.getName());
                    laneRounds.add(laneRound);
                });
    }


}
