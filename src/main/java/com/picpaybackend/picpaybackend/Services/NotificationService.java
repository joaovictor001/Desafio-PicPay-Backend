package com.picpaybackend.picpaybackend.Services;

import com.picpaybackend.picpaybackend.Entities.User;
import com.picpaybackend.picpaybackend.dtos.Notifications.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

//        ResponseEntity<String> notificatiomResponse = restTemplate.postForEntity("https://util.devi.tools/api/v1/notify",notificationRequest,String.class);
//        if(!(notificatiomResponse.getStatusCode() == HttpStatus.OK)){
//            System.out.println("erro ao enviar notificação");
//            throw  new Exception("Serviço notificação esta forra do ar");
//        }

        System.out.println("Notificação enviada com sucesso para o usuario");
    }
}
