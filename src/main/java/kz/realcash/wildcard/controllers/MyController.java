package kz.realcash.wildcard.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.realcash.wildcard.dto.TokenDTO;
import kz.realcash.wildcard.dto.UserCRMDTO;
import kz.realcash.wildcard.dto.WhatsAppMessageDto;
import kz.realcash.wildcard.service.WhatsappMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/wildcard")
@RequiredArgsConstructor
public class MyController {

	private final ObjectMapper objectMapper;
	private final WhatsappMessageService whatsappMessageService;

	@PostMapping(value = "/whatsapp/send-message")
	public @ResponseBody
	void sendWhatsapp(@RequestBody List<WhatsAppMessageDto> whatsAppMessageDtos) {
		whatsappMessageService.send(whatsAppMessageDtos);
	}

	@PostMapping(value = "/users/login")
	public @ResponseBody
	UserCRMDTO sendToken(@RequestBody TokenDTO tokenDTO) {
		var text = "text";
		var user = new UserCRMDTO();
		user.setToken("ItsTokeb=n");
		user.setLogin("whatsapp");
		user.setId("12");
		try {
			text = objectMapper.writeValueAsString(tokenDTO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//var time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		log.info(text);
		//System.out.printf(String.valueOf(text));
		return user;
	}
}
