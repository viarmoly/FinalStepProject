package org.danit.luckyfit;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.danit.luckyfit.entity.Status;

import java.io.IOException;

public class StatusDeserializer extends StdDeserializer<Status> {
  protected StatusDeserializer() {
    this(null);
  }

  protected StatusDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public Status deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    JsonNode node = jsonParser.getCodec().readTree(jsonParser);
    String name = node.get("name").asText();
    return new Status(name);
  }
}
