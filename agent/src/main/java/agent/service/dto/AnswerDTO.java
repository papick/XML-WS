package agent.service.dto;

public class AnswerDTO {

	private String sender;
	private String receipient;
	private String text;
	private String idMessage;

	public AnswerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceipient() {
		return receipient;
	}

	public void setReceipient(String receipient) {
		this.receipient = receipient;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public AnswerDTO(String sender, String receipient, String text) {
		super();
		this.sender = sender;
		this.receipient = receipient;
		this.text = text;
	}

}
