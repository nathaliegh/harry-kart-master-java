package se.atg.service.harrykart.java.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.ToString;

import java.util.List;


@Getter
@ToString
@JacksonXmlRootElement(localName = "powerUps")
public final class PowerUpsType {

    @JacksonXmlElementWrapper(localName = "loop", useWrapping = false)
    private List<LoopType> loop;
}
