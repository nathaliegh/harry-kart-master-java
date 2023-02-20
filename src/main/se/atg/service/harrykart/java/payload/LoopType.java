package se.atg.service.harrykart.java.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@JacksonXmlRootElement(localName = "loop")
public final class LoopType {

    @JacksonXmlProperty(localName = "number", isAttribute = true)
    @JacksonXmlCData
    private int number;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "lane")
    private List<LaneType> lane;

}
