package org.pt.klx.domain.dto.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DictionaryDto implements Serializable {


  private String palavraOriginal;
  private String palavraTraduzida;

  public String toJson() {
    try {
      return new ObjectMapper().writeValueAsString(this);
    } catch (final JsonProcessingException e) {
      e.printStackTrace();
      return "";
    }
  }
}
