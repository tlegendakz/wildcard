package kz.realcash.wildcard.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.realcash.wildcard.dto.WhatsAppMessageDto;
import kz.realcash.wildcard.entity.WhatsappMessage;
import kz.realcash.wildcard.repositories.WhatsappMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class WhatsappMessageService {
	private final ObjectMapper objectMapper;
	private final WhatsappMessageRepository whatsappMessageRepository;

	public void send(List<WhatsAppMessageDto> whatsAppMessageDtos){
		var text = "text";
		var ids = whatsAppMessageDtos.stream()
				.map(WhatsAppMessageDto::getOrderCode)
				.map(String::valueOf)
				.collect(Collectors.joining(","));
		try {
			text = objectMapper.writeValueAsString(whatsAppMessageDtos);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		var time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		log.info(text);
		log.info(String.valueOf(time + " = " + whatsAppMessageDtos.size() + " = " + ids));
		whatsAppMessageDtos.forEach(messageDto -> {
					WhatsappMessage message = new WhatsappMessage();

					message.setText( messageDto.getText() );
					message.setOrdercode(messageDto.getOrderCode());
					message.setPhonenumber(messageDto.getPhoneNumber());
					message.setOrderstatus(messageDto.getOrderStatus());
					message.setCreateDate(LocalDateTime.now());
					whatsappMessageRepository.save(message);
				}
		);


		//System.out.printf(String.valueOf(text));
	}
}
