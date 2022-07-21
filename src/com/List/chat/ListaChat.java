
package com.List.chat;

import java.util.ArrayList;
import java.util.List;
import com.Message.chat.Message;


public class ListaChat {

	private List<Message> messages = new ArrayList<>();
	
	
	private List<Message> listUser = new ArrayList<>();
	
	public ListaChat() {
		
		
		messages.add(new Message(1, 1, "cesar", "carlos", "22/06/2022 10:10 0000", "Hola Galo. Como estas?"));
		messages.add(new Message(1, 2, "carlos", "cesar", "22/06/2022 10:11 0000", "Hola Cesar.. a los anhos"));
		messages.add(new Message(1, 3, "cesar", "carlos", "22/06/2022 10:12 0000", "Necesito que prestes dinero.. tendras??"));
		messages.add(new Message(1, 4, "carlos", "cesar", "22/06/2022 10:13 0000", "claro!! Cuanto quieres??"));
		listUser.add(new Message(1, "carlos", "10:13 a.m", "claro!! Cuanto quieres??"));
		
		messages.add(new Message(2, 5, "Felipe", "cesar", "22/06/2022 10:10 0000", "Hola como estas.."));
		messages.add(new Message(2, 6, "cesar", "Felipe", "22/06/2022 10:11 0000", "Muy bien gracias???"));
		messages.add(new Message(2, 7, "Felipe", "cesar", "22/06/2022 10:11 0000", "Cuidate mucho..."));
		listUser.add(new Message(2, "Felipe", "10:11 a.m", "Hola..."));
		
		messages.add(new Message(3, 8, "julissa", "cesar", "22/06/2022 10:10 0000", "Que tal..."));
		messages.add(new Message(3, 9, "cesar", "julissa", "22/06/2022 10:11 0000", "Todo bien"));
		messages.add(new Message(3, 10, "julissa", "cesar", "22/06/2022 10:11 0000", "Que tengas una linda tarde..."));
		listUser.add(new Message(3, "julissa", "08:30 a.m", "Que tengas una linda tarde..."));
		
		messages.add(new Message(4, 11, "jorman", "cesar", "22/06/2022 10:10 0000", "Que tal buenas tardes.."));
		messages.add(new Message(4, 12, "cesar", "jorman", "22/06/2022 10:11 0000", "Hola buenas tardes"));
		messages.add(new Message(4, 13, "jorman", "cesar", "22/06/2022 10:11 0000", "Holiss todo bien..."));
		listUser.add(new Message(4, "jorman", "20:45 p.m", "Holiss todo bien..."));
		
		messages.add(new Message(5, 14, "walter", "cesar", "22/06/2022 10:10 0000", "Me puedes ayudar en matematicas.."));
		messages.add(new Message(5, 15, "cesar", "walter", "22/06/2022 10:11 0000", "Si claro???"));
		messages.add(new Message(5, 16, "walter", "cesar", "22/06/2022 10:11 0000", "Ma�ana por la tarde..."));
		listUser.add(new Message(5, "walter", "22:00 p.m", "Ma�ana por la tarde..."));
		
		messages.add(new Message(6, 17, "luis", "cesar", "22/06/2022 10:10 0000", "Me puedes enviar tu parte del trabajo.."));
		messages.add(new Message(6, 18, "cesar", "luis", "22/06/2022 10:11 0000", "Mas luego te la envio"));
		messages.add(new Message(6, 19, "luis", "cesar", "22/06/2022 10:11 0000", "Listo gracias..."));
		listUser.add(new Message(6, "luis", "09:28 a.m", "Listo gracias..."));
		
	}
	
	public List<Message> getMessage(String from, String to){
		List<Message> result = new ArrayList<>();
		
		for(Message msg: messages) {
			if((msg.getFrom().equals(from) && msg.getTo().equals(to))
					|| (msg.getFrom().equals(to) && msg.getTo().equals(from))) {
				result.add(msg);
			}
		}
		
		return result;
	}
	
	
	
	
	public List<Message> getUser(){
		List<Message> result = new ArrayList<>();
		
		for(Message us : listUser) {
			result.add(us);
		   }
		
		return result;
	    }
	
	
}
	
	
	
	/*public List<Message1> getMessage1(String from, String to){
		List<Message1> result1 = new ArrayList<>();
		
		for(Message1 msg1: messages) {
			if((msg1.getFrom().equals(from) && msg1.getTo().equals(to))
					|| (msg1.getFrom().equals(to) && msg1.getTo().equals(from))) {
				result1.add(msg1);
			}
		}
		
		return result1;
	}
	
	
	
	
	public List<Message1> getUser1(){
		List<Message1> result1 = new ArrayList<>();
		
		for(Message1 us: messages) {
			result1.add(us);
		   }
		
		return result1;
	    }
	*/
	
	