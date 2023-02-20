package se.atg.service.harrykart.java.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LaneRound implements Serializable {
    private int lane;
    private double time;
    private int speed;
    private String horse;
}
