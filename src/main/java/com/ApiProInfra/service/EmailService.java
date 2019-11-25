package com.ApiProInfra.service;

import org.springframework.mail.SimpleMailMessage;

import com.ApiProInfra.models.Cliente;
import com.ApiProInfra.models.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
