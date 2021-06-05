package kagg886.qinternet.Content;

public class Person extends Content
{
    protected long uin;
    protected String uinName;
	protected int age;
	protected Sex sex;
	protected String area;
	
	public static enum Sex {
		BOY,GIRL;
	}
	
	public Person(long botQQ,long uin,String uinName,int age,Sex sex,String area) {
		super(botQQ);
		this.uin = uin;
		this.uinName = uinName;
		this.age = age;
		this.sex = sex;
		this.area = area;
	}
    
    public long getUin() {
        return uin;
    }
    
    public String getUinName() {
        return uinName;
    }
}
