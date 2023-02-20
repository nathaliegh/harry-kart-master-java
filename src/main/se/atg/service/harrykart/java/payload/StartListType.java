package se.atg.service.harrykart.java.payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@JacksonXmlRootElement(localName = "startList")
public final class StartListType {

    @JacksonXmlElementWrapper(localName = "participant", useWrapping = false)
    private List<ParticipantType> participant;

}
