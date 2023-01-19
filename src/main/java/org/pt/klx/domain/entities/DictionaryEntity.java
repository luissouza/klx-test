package org.pt.klx.domain.entities;

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
public class DictionaryEntity {

  private Integer id;
  private String palavraOriginal;
  private String palavraTraduzida;

}