package kz.realcash.wildcard.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsDto {
	private String count;
	@JsonProperty("item_id")
	private String itemId;
	@JsonProperty("id_shops")
	private String idShops;
}
