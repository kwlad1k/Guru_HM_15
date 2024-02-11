package config;

import org.aeonbits.owner.Config;

public interface ProjectConfig extends Config {
    @Key("first.name")
    String firstName();

    @Key("last.name")
    String lastName();

    @Key("user.email")
    String userEmail();
}
