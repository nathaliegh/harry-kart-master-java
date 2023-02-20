package se.atg.service.harrykart.java.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JacksonXmlRootElement(localName = "participant")
public final class ParticipantType {

    @JacksonXmlProperty(localName = "lane")
    @JacksonXmlCData
    private int lane;

    @JacksonXmlProperty(localName = "name")
    @JacksonXmlCData
    private String name;
    @JacksonXmlProperty(localName = "baseSpeed")
    @JacksonXmlCData
    private int baseSpeed;
    
}
