package kz.realcash.wildcard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WhatsAppMessageDto {
	String phoneNumber;
	String text;
	String orderCode;
	String orderStatus;
}
