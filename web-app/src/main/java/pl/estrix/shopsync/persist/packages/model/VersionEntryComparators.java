package pl.estrix.shopsync.persist.packages.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.estrix.shopsync.commons.core.domain.paging.Direction;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public final class VersionEntryComparators {

    @EqualsAndHashCode
    @AllArgsConstructor
    @Getter
    static class Key {
        String name;
        Direction dir;
    }

    static Map<VersionEntryComparators.Key, Comparator<VersionEntry>> map = new HashMap<>();

    static {
        map.put(new VersionEntryComparators.Key("number", Direction.asc), Comparator.comparing(VersionEntry::getNumber));
        map.put(new VersionEntryComparators.Key("number", Direction.desc), Comparator.comparing(VersionEntry::getNumber)
                .reversed());

    }

    public static Comparator<VersionEntry> getComparator(String name, Direction dir) {
        return map.get(new VersionEntryComparators.Key(name, dir));
    }

    private VersionEntryComparators() {
    }
}
