package se.atg.service.harrykart.java.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JacksonXmlRootElement(localName = "lane")
public final class LaneType {

    @JacksonXmlProperty(localName = "number", isAttribute = true)
    @JacksonXmlCData
    private int number;

    @JacksonXmlCData
    @JacksonXmlText
    private int value;
    
}
