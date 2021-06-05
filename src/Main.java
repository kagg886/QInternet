import java.util.*;
import kagg886.qinternet.Message.GroupMemberPack;
import kagg886.qinternet.exceptions.IllegalInputVarException;
import kagg886.qinternet.QInternet;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.Content.Member;
import kagg886.qinternet.exceptions.PermissionException;

public class Main {
	
	public static void main(String[] args) throws IllegalInputVarException {
		GroupAPI a = new GroupAPI() {

			@Override
			public long getBotQQ() {
				return 0;
			}

			@Override
			public void exit(long gid) {
			}

			@Override
			public void setAllmute(long gid, boolean status) throws PermissionException {
			}

			@Override
			public void sendMsg(long gid, MsgCollection ary) {
			}

			@Override
			public Member getMember(long gid, long qq) {
				return null;
			}

			@Override
			public ArrayList<Long> getMembers(long gid) {
				return null;
			}
		};
		System.out.println(a.toString());
		QInternet.initGroupAPI(3405637452L, a);
		System.out.println(QInternet.getGroupAPI(3405637452L).toString());
		
	}
    
}
