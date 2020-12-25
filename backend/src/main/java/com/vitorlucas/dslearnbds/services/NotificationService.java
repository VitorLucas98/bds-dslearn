package com.vitorlucas.dslearnbds.services;

import java.time.Instant;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorlucas.dslearnbds.dto.NotificationDTO;
import com.vitorlucas.dslearnbds.entities.Deliver;
import com.vitorlucas.dslearnbds.entities.Notification;
import com.vitorlucas.dslearnbds.entities.User;
import com.vitorlucas.dslearnbds.observers.DeliverRevisionObserver;
import com.vitorlucas.dslearnbds.repositories.NotificationRepository;

@Service
public class NotificationService implements DeliverRevisionObserver {

	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private DeliverService deliverService;
	
	@PostConstruct
	private void initialize() {
		deliverService.subscribeDeliverRevisionObserver(this);
	}
	
	@Transactional(readOnly = true)
	public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pegeable){
		User user  = authService.authenticated();
		Page<Notification> page = repository.find(user, unreadOnly, pegeable);
		return page.map(x -> new NotificationDTO(x));
	}
	
	public void saveDeliverNotification(Deliver deliver) {
		Long sectionId = deliver.getLesson().getSection().getId();
		Long resourceId = deliver.getLesson().getSection().getResource().getId();
		Long offerId = deliver.getLesson().getSection().getResource().getOffer().getId();
		
		String route = "/offers/" + offerId + "/resources/" + resourceId + "/sections/" + sectionId;
		String text = deliver.getFeedback();
		Instant moment = Instant.now();
		User user = deliver.getEnrollment().getStudent();
		
		Notification not = new Notification(null, text, moment, false, route, user);
		repository.save(not);	
	}

	@Override
	public void onSaveRevision(Deliver deliver) {
		saveDeliverNotification(deliver);
		
	}
}
