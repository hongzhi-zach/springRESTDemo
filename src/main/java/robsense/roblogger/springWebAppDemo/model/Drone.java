package robsense.roblogger.springWebAppDemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Drone {
    @NotBlank
    private final String lable;
    private final UUID uuid;

    //using json annotation to identify properties within json object from API
    public Drone(@JsonProperty("lable") String lable,
                 @JsonProperty("id") UUID uuid) {
        this.lable = lable;
        this.uuid = uuid;
    }

    public String getLable() {
        return lable;
    }

    public UUID getUuid() {
        return uuid;
    }
}
//test