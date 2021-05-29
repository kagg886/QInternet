package kagg886.qinternet.Content;

public class Person
{
    protected long uin;
    protected String uinName;
	
	public Person(long uin,String uinName) {
		this.uin = uin;
		this.uinName = uinName;
	}
    
    public long getUin() {
        return uin;
    }
    
    public String getUinName() {
        return uinName;
    }
}
