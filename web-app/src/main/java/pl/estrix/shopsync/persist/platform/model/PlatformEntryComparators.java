package pl.estrix.shopsync.persist.platform.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.estrix.shopsync.commons.core.domain.paging.Direction;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PlatformEntryComparators {

    @EqualsAndHashCode
    @AllArgsConstructor
    @Getter
    static class Key {
        String name;
        Direction dir;
    }

    static Map<PlatformEntryComparators.Key, Comparator<PlatformEntry>> map = new HashMap<>();

    static {
        map.put(new PlatformEntryComparators.Key("code", Direction.asc), Comparator.comparing(PlatformEntry::getCode));
        map.put(new PlatformEntryComparators.Key("code", Direction.desc), Comparator.comparing(PlatformEntry::getCode)
                .reversed());

        map.put(new PlatformEntryComparators.Key("id", Direction.asc), Comparator.comparing(PlatformEntry::getId));
        map.put(new PlatformEntryComparators.Key("id", Direction.desc), Comparator.comparing(PlatformEntry::getId)
                .reversed());

//        map.put(new Key("start_date", Direction.asc), Comparator.comparing(Employee::getStartDate));
//        map.put(new Key("start_date", Direction.desc), Comparator.comparing(Employee::getStartDate)
//                .reversed());
//
//        map.put(new Key("position", Direction.asc), Comparator.comparing(Employee::getPosition));
//        map.put(new Key("position", Direction.desc), Comparator.comparing(Employee::getPosition)
//                .reversed());
//
//        map.put(new Key("salary", Direction.asc), Comparator.comparing(Employee::getSalary));
//        map.put(new Key("salary", Direction.desc), Comparator.comparing(Employee::getSalary)
//                .reversed());
//
//        map.put(new Key("office", Direction.asc), Comparator.comparing(Employee::getOffice));
//        map.put(new Key("office", Direction.desc), Comparator.comparing(Employee::getOffice)
//                .reversed());
//
//        map.put(new Key("extn", Direction.asc), Comparator.comparing(Employee::getExtn));
//        map.put(new Key("extn", Direction.desc), Comparator.comparing(Employee::getExtn)
//                .reversed());
    }

    public static Comparator<PlatformEntry> getComparator(String name, Direction dir) {
        return map.get(new PlatformEntryComparators.Key(name, dir));
    }

    private PlatformEntryComparators() {
    }
}
