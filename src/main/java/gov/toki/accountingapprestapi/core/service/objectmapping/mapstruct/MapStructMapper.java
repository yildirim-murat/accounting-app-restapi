package gov.toki.accountingapprestapi.core.service.objectmapping.mapstruct;

public interface MapStructMapper<Source, Destination> extends ReversibleMapper<Source, Destination>, CollectionMapper<Source, Destination>, UpdateMapper<Source, Destination> {

    @Override
    Destination mapInto(Source source, @MappingTarget Destination destination);

}
