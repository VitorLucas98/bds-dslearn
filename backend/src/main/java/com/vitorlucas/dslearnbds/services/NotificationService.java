package com.vitorlucas.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vitorlucas.dslearnbds.dto.NotificationDTO;
import com.vitorlucas.dslearnbds.entities.Notification;
import com.vitorlucas.dslearnbds.entities.User;
import com.vitorlucas.dslearnbds.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pegeable){
		User user  = authService.authenticated();
		Page<Notification> page = repository.find(user, unreadOnly, pegeable);
		return page.map(x -> new NotificationDTO(x));
	}
}
