package Main;
//用于接收用户输入内容，输出相应内容
public class IO {
//成员  输入串、输出串、相应数字
	String toText;
	String toCount;
	int Num;
	
	//用于生成输入时要显示的内容
	String toShowIn(String strIn)
	{
		if (toText==null)
			toText=strIn;
		else
		    toText += strIn;
		return toText;
	}
	
	//用于接收数字字符
	String forCount(String strNum)
	{
		if (toCount==null)
			toCount=strNum;
		else
			toCount += strNum;
		return toCount;
	}
	//用于生成输入的数字，此方法在Input之后
	int InputNum()
	{
		Num=Integer.valueOf(toCount);
		return Num;
	}
	
	//用于计算后要显示的内容
	String toShowOut()
	{
		toText=String.valueOf(Num);
		return toText;
	}
	
	//用于初始化相应内容
	void Initialization()
	{
		toText=null;
	}
	
	//用于响应退格的效果
	String Back_Space()
	{
		System.out.println(toText);
		if (toText==null)
			toText="0";
		else
			toText=toText.substring(0, toText.length()-1);
		
		return toText;
	}
}
