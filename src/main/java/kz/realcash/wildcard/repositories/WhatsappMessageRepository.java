package kz.realcash.wildcard.repositories;

import kz.realcash.wildcard.entity.WhatsappMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WhatsappMessageRepository  extends JpaRepository<WhatsappMessage, UUID> {
}
