package pl.estrix.shopsync.persist.packages.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVersionEntry is a Querydsl query type for VersionEntry
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVersionEntry extends EntityPathBase<VersionEntry> {

    private static final long serialVersionUID = -909268950L;

    public static final QVersionEntry versionEntry = new QVersionEntry("versionEntry");

    public final StringPath description = createString("description");

    public final StringPath enviroment = createString("enviroment");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath installer = createString("installer");

    public final StringPath number = createString("number");

    public final StringPath platform = createString("platform");

    public QVersionEntry(String variable) {
        super(VersionEntry.class, forVariable(variable));
    }

    public QVersionEntry(Path<? extends VersionEntry> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVersionEntry(PathMetadata metadata) {
        super(VersionEntry.class, metadata);
    }

}

