package kz.realcash.wildcard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "whatsapp_message", schema="public")
@Getter
@Setter
public class WhatsappMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "whatsapp_message_id_seq")
	@SequenceGenerator(name = "whatsapp_message_id_seq", sequenceName = "whatsapp_message_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Integer id;

	private String phonenumber;

	private String text;

	private String ordercode;

	private String orderstatus;

	@Column(name = "create_date")
	private LocalDateTime createDate;

}
