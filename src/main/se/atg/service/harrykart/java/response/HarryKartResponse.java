package se.atg.service.harrykart.java.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import se.atg.service.harrykart.java.dto.LaneRound;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class HarryKartResponse {

    public void buildResponse(ObjectMapper mapper,
                              ArrayNode arrayNode,
                              ArrayList<LaneRound> laneRounds) {
        AtomicInteger index = new AtomicInteger();
        index.getAndIncrement();
        laneRounds = (ArrayList<LaneRound>) laneRounds.stream()
                .sorted(Comparator.comparingDouble(LaneRound::getTime))
                .limit(3)
                .collect(Collectors.toList());

        laneRounds.forEach(laneRound -> {
            var rank = mapper.createObjectNode();
            rank.put("position", index.getAndIncrement());
            rank.put("horse", laneRound.getHorse());
            arrayNode.add(rank);
        });
    }

    @NotNull
    public String getDefaultResponse() {
        return "{\n" +
                "   \"ranking\": [   ]\n" +
                "}";
    }

    public String getResponse(ObjectMapper mapper, ArrayNode arrayNode) {
        try {
            var responseObject = mapper.createObjectNode();
            responseObject.put("ranking", arrayNode);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseObject);
        } catch (JsonProcessingException e) {
            return getDefaultResponse();
        }
    }

}
