package pl.estrix.shopsync.persist.platform.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlatformEntry is a Querydsl query type for PlatformEntry
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlatformEntry extends EntityPathBase<PlatformEntry> {

    private static final long serialVersionUID = 1473799317L;

    public static final QPlatformEntry platformEntry = new QPlatformEntry("platformEntry");

    public final StringPath code = createString("code");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QPlatformEntry(String variable) {
        super(PlatformEntry.class, forVariable(variable));
    }

    public QPlatformEntry(Path<? extends PlatformEntry> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlatformEntry(PathMetadata metadata) {
        super(PlatformEntry.class, metadata);
    }

}

