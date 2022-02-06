package pl.estrix.shopsync.persist.setting.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAppSetting is a Querydsl query type for AppSetting
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAppSetting extends EntityPathBase<AppSetting> {

    private static final long serialVersionUID = -1845264184L;

    public static final QAppSetting appSetting = new QAppSetting("appSetting");

    public final StringPath code = createString("code");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath type = createString("type");

    public final StringPath value = createString("value");

    public QAppSetting(String variable) {
        super(AppSetting.class, forVariable(variable));
    }

    public QAppSetting(Path<? extends AppSetting> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAppSetting(PathMetadata metadata) {
        super(AppSetting.class, metadata);
    }

}

