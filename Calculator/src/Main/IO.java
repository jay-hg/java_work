package Main;
//���ڽ����û��������ݣ������Ӧ����
public class IO {
//��Ա  ���봮�����������Ӧ����
	String toText;
	String toCount;
	int Num;
	
	//������������ʱҪ��ʾ������
	String toShowIn(String strIn)
	{
		if (toText==null)
			toText=strIn;
		else
		    toText += strIn;
		return toText;
	}
	
	//���ڽ��������ַ�
	String forCount(String strNum)
	{
		if (toCount==null)
			toCount=strNum;
		else
			toCount += strNum;
		return toCount;
	}
	//����������������֣��˷�����Input֮��
	int InputNum()
	{
		Num=Integer.valueOf(toCount);
		return Num;
	}
	
	//���ڼ����Ҫ��ʾ������
	String toShowOut()
	{
		toText=String.valueOf(Num);
		return toText;
	}
	
	//���ڳ�ʼ����Ӧ����
	void Initialization()
	{
		toText=null;
	}
	
	//������Ӧ�˸��Ч��
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
