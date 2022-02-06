package pl.estrix.shopsync.commons.core.domain;

public enum Channel {
    /**
     * Mobile
     */
    MOBILE("MOBILE"),
    /**
     * Internet
     */
    WWW("WWW"),
    /**
     * Other channel
     */
    OTHER("OTHER");

    private String name;

    Channel(String name) {
        this.name = name;
    }

    /**
     * Returns the Channel instance based on the given channel name. Method returns {@code null} when the
     * name parameter is {@code null}.
     *
     * @param name the channel name
     * @return the channel instance
     */
    public static Channel fromName(String name) {
        if (name == null) {
            return null;
        }
        switch (name) {
            case "MOBILE":
                return MOBILE;
            case "WWW":
                return WWW;
            case "OTHER":
                return OTHER;
        }
        throw new IllegalStateException("Could not map given name to Channel type, name: " + name);
    }

    public String getName() {
        return name;
    }
}
