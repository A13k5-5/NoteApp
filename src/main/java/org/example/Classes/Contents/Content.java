package org.example.Classes.Contents;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Text.class, name = "Text"),
        @JsonSubTypes.Type(value = Image.class, name = "Image")
})

public abstract class Content {
    protected String type;
    protected final long id;
    public Content() {
        this.type = "Text";
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
    @JsonCreator
    public Content(@JsonProperty("type") String type) {
        this.type = type;
        this.id = System.currentTimeMillis();
    }
    public String getType() { return this.type; }
    public long getId() { return this.id; }
}
