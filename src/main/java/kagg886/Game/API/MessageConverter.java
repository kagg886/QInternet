package kagg886.Game.API;


import java.io.File;
import java.util.function.Consumer;

import kagg886.qinternet.Interface.MsgIterator;
import kagg886.qinternet.Message.MsgCollection;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.message.data.At;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.SingleMessage;
import net.mamoe.mirai.utils.ExternalResource;

public class MessageConverter {
	
	public static MsgCollection MessageChainToMsgCollection (MessageChain c) {
		MsgCollection p = new MsgCollection();
		
		p.putText(c.contentToString());
		
		c.stream().filter(At.class::isInstance).forEach(new Consumer<SingleMessage>() {

			@Override
			public void accept(SingleMessage t) {
				At at = (At) t;
				p.putAt(at.getTarget());
			}
		});
		
		c.stream().filter(Image.class::isInstance).forEach(new Consumer<SingleMessage>() {

			@Override
			public void accept(SingleMessage t) {
				Image i = (Image) t;
				p.putImage(Image.queryUrl(i));
			}
		});
		return p;
	}
	
	public static MessageChain MsgCollectionToMessageChain(MsgCollection c,Contact contact) {
		MessageChainBuilder chain = new MessageChainBuilder();
		c.iterator(new MsgIterator() {
			
			public void onXml(String arg0) {
				
			}
			
			public void onText(String arg0) {
				chain.add(arg0);
				
			}
			
			public void onPtt(String arg0) {
				
			}
			
			public void onJson(String arg0) {
				
			}
			
			public void onImage(String arg0) {
				chain.add(ExternalResource.uploadAsImage(new File(arg0), contact));
			}
			
			public void onAt(long arg0) {
				chain.add(new At(arg0));
				
			}
		});
		return chain.build();
	}
}
