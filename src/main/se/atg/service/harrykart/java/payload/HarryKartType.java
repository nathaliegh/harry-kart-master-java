package se.atg.service.harrykart.java.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@JacksonXmlRootElement(localName = "harryKartType")
public final class HarryKartType {

    @JacksonXmlProperty(localName = "numberOfLoops")
    @JacksonXmlCData
    private int numberOfLoops;
    @JacksonXmlElementWrapper(localName = "startList")
    private StartListType startList;
    @JacksonXmlElementWrapper(localName = "powerUps")
    private PowerUpsType powerUps;

}
