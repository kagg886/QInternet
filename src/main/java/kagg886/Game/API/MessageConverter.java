package kagg886.Game.API;


import java.util.function.Consumer;

import kagg886.qinternet.Interface.MsgIterator;
import kagg886.qinternet.Message.MsgCollection;
import net.mamoe.mirai.message.data.At;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.SingleMessage;

public class MessageConverter {
	
	public static MsgCollection MessageChainToMsgCollection (MessageChain c) {
		MsgCollection p = new MsgCollection();
		
		c.stream().filter(At.class::isInstance).peek(new Consumer<SingleMessage>() {

			@Override
			public void accept(SingleMessage t) {
				At at = (At) t;
				p.putAt(at.getTarget());
			}
		});
		
		c.stream().filter(Image.class::isInstance).peek(new Consumer<SingleMessage>() {

			@Override
			public void accept(SingleMessage t) {
				Image i = (Image) t;
				p.putImage(i.getImageId());
			}
		});
		
		return p;
	}
	
	public static MessageChain MsgCollectionToMessageChain(MsgCollection c) {
		final MessageChain chain = new MessageChainBuilder().asMessageChain();
		c.iterator(new MsgIterator() {
			
			public void onXml(String arg0) {
				
			}
			
			public void onText(String arg0) {
				chain.plus(arg0);
				
			}
			
			public void onPtt(String arg0) {
				
			}
			
			public void onJson(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void onImage(String arg0) {
				
				
			}
			
			public void onAt(long arg0) {
				chain.plus(new At(arg0));
				
			}
		});
		return chain;
	}
}
