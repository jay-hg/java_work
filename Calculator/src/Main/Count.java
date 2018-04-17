package Main;
//用于计算结果
public class Count {
//成员 输入数、输出数
	int firstNum=0;
	int secondNum=0;
	String sympol;
	
//方法 加减乘除 响应符号
	int Add()
	{
		secondNum += firstNum;
		return secondNum;
	}
	
	int Subtract()
	{
		secondNum -= firstNum;
		return secondNum;
	}
	
	int Multiply()
	{
		secondNum *= firstNum;
		return secondNum;
	}
	
	int Divide()
	{
		secondNum /= firstNum;
		return secondNum;
	}
	
	void ResponseSympol(String sign)
	{
		sympol=sign;
		Action.io.toCount=null;
		secondNum=firstNum;
	}
	
	void NumInitialization()
	{
		firstNum=0;
		secondNum=0;
	}
	
	int compute ()
	{
		if (sympol.equals("Add"))
		{
			Add();
		}
		else if (sympol.equals("Sub"))
		{
			Subtract();
		}
		else if (sympol.equals("Mul"))
		{
			Multiply();
		}
		else if (sympol.equals("Div"))
		{
			Divide();
		}
		Action.io.toCount=null;
		return secondNum;
	}
}
