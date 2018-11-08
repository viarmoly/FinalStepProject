package org.danit.luckyfit;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.danit.luckyfit.entity.Product;

import java.io.IOException;

public class ProductDeserializer extends StdDeserializer<Product> {
  protected ProductDeserializer() {
    this(null);
  }

  protected ProductDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public Product deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    JsonNode node = jsonParser.getCodec().readTree(jsonParser);
    String name = node.get("name").asText();
    return new Product(name);
  }
}
