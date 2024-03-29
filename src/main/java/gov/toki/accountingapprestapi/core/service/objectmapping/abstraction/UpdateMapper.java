package gov.toki.accountingapprestapi.core.service.objectmapping.abstraction;

public interface UpdateMapper<Source, Destination> extends Mapper<Source, Destination> {

    Destination mapInto(Source source, Destination destination);

}
