package gov.toki.accountingapprestapi.core.service.objectmapping.abstraction;

public interface CollectionMapper<Source, Destination> extends Mapper<Source, Destination> {

    default List<Destination> mapCollection(Collection<? extends Source> sourceCollection) {
        if (sourceCollection == null) return new ArrayList<>();
        List<Destination> destinations = new ArrayList<>(sourceCollection.size());
        for (Source source : sourceCollection)
            destinations.add(map(source));
        return destinations;
    }

    default List<Destination> mapArray(Source[] sourceArray) {
        if (sourceArray == null) return new ArrayList<>();
        List<Destination> destinations = new ArrayList<>(sourceArray.length);
        for (Source source : sourceArray)
            destinations.add(map(source));
        return destinations;
    }

}
