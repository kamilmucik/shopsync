package pl.estrix.shopsync.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VersionDto {

    private String version;

    public VersionDto setVersion(String version) {
        if (version == null) {
            throw new IllegalArgumentException("Planet name given was invalid");
        }
        this.version = version;
        return this;
    }

    public String getVersion() {
        return version;
    }

}
