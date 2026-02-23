package in.rahul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rahul.model.ContactMessage;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, String> {

}
