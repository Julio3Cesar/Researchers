package br.com.loucadora.nostalgicstore.nostalgicstore.models.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {

	private List<String> messages;
	
	
	public ErrorResponse() {
		this.messages = new ArrayList<>();
	}
	
	public List<String> getMessages() {
		return messages;
	}

	public ErrorResponse preconditionFailed(Set<ConstraintViolation<?>> constraintViolations) {
		Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
		while (iterator.hasNext()) {
			messages.add(iterator.next().getMessageTemplate());
		}
		return this;
	}
}