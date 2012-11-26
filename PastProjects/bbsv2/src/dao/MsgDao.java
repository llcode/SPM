package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import domain.Msg;
import domain.UserCount;

public class MsgDao {
private HibernateTemplate template;
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public List<Msg> acceptMsgList(Integer id){
		UserCount user=(UserCount) template.get(UserCount.class, id);
		List<Msg> list=new ArrayList(user.getToMsgs());
		return list;
	}
	
	
	public List<Msg> sendMsgList(Integer id){
		UserCount user=(UserCount) template.get(UserCount.class, id);
		List<Msg> list=new ArrayList(user.getFromMsgs());
		return list;
	}
	
	public void sendMsg(Msg msg,UserCount fUser,UserCount tUser){
		msg.setFromUser(fUser);
		msg.setToUser(tUser);
		template.save(msg);
	}
}
