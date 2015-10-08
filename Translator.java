import java.util.*;

public class Translator{
	public static void main (String [] args)
	{
	//--------------------------------------------------------page table-------------------------------------------------------------------
	String n[] = new String[64];
	String o[] = new String[64];
	 int nu =1;
	 char alpha = 'a';
	for(int j=0;j<=8;j++)
	{	
		n[j]=""+nu;
		++nu;
	}
	for(int j=9;j<=14;j++)
	{
		n[j]=""+alpha;
		alpha++;
	}
	for(int j=15;j<=30;++j)
	{
		n[j]=""+1;
	}
	for(int j=31;j<=46;++j)
	{
		n[j]=""+2;
	}
	for(int j=47;j<=62;++j)
	{
		n[j]=""+3;
	}
	n[63]=""+4;
	
	
	nu = 0;
	alpha ='a';
	for(int j=0;j<=9;j++)
	{	
		o[j]=""+nu;
		++nu;
	}
	for(int j=10;j<=15;j++)
	{
		o[j]=""+alpha;
		alpha++;
	}
	nu = 0;
	alpha ='a';
	for(int j=16;j<=25;j++)
	{	
		o[j]=""+nu;
		++nu;
	}
	for(int j=26;j<=31;j++)
	{
		o[j]=""+alpha;
		alpha++;
	}
	nu = 0;
	alpha ='a';
	for(int j=32;j<=41;j++)
	{	
		o[j]=""+nu;
		++nu;
	}
	for(int j=42;j<=47;j++)
	{
		o[j]=""+alpha;
		alpha++;
	}
	nu = 0;
	alpha ='a';
	for(int j=48;j<=57;j++)
	{	
		o[j]=""+nu;
		++nu;
	}
	for(int j=58;j<=63;j++)
	{
		o[j]=""+alpha;
		alpha++;
	}
	int m=0;
	/*while(m<64)
	{
		System.out.println(n[m]+" index:"+m);
		++m;
	}*/
	
	int p=0;
	ArrayList<String> address = new ArrayList<String>();
	for(int i=0;i<=14;++i)
	{		
		address.add("0x"+n[p]);
		++p;
	}
	p=15;
	int r=0;
	for(int i=15;i<=30;++i)
	{
		address.add("0x"+n[p]+o[r]);
		++p;
		++r;
	}
	p=31;
	r=15;
	for(int i=31;i<=46;++i)
	{
		address.add("0x"+n[p]+o[r]);
		++p;
		++r;
	}
	int ab=47;
	int u=30;
	for(int i=47;i<62;++i)
	{
		address.add("0x"+n[ab]+o[u]);
		++ab;
		++u;
	}
	address.add("0x"+'3'+o[45]);
	//printing table here...	
	p=0;
	System.out.println("----------------------PAGE TABLE----------------------\n");
	for(String obj: address)
	{
		String st = Integer.toHexString(p);
		System.out.println("Logical:"+obj+"          |      "+"	   Physical : 0x"+st);
		++p;
	}
	System.out.println("-----------------------------------------------------");
//-----------------------------------------------------------------END----------------------------------------------------------------------

	Scanner in = new Scanner(System.in);
	int i=0;
	int k =0;
	int count=0;
 	String a[] = new String[7];
	System.out.println("Enter the address\n");
	while(i<=6)
		{
		a[i] = in.nextLine();
		++i;
		}
	System.out.print("Input address:");
	while(k<=6)
		{
		System.out.print(a[k]);
		++k;
		}
	System.out.println();
	String b[] = new String[4];
	String c[] = new String[5];
	for(int j =0;j<=3;j++)
		{
		b[j] = a[j];
		}
	count =2;
	c[0]="0";
	c[1]="x";	
	for(i=4;i<=6;i++)
		{
		c[count]=a[i];
		++count;
		}
	System.out.print("VirtualPage frame number:");
	i=0;
	while(i<=3)
		{
		System.out.print(b[i]);
		++i;
		}
	System.out.println();
	System.out.print("Page offset:");
	i=0;
	while(i<=4)
		{	
		System.out.print(c[i]);
		++i;	
		}
	System.out.println();
	String uoi = ""+b[0]+b[1]+b[2]+b[3];
	int y = address.indexOf(uoi);
	String mut = Integer.toHexString(y); 
	String uty = ""+c[0]+c[1]+mut+c[2]+c[3]+c[4];
	System.out.println("Physical page frame number:"+"0x"+mut);
	System.out.println("Physical address:"+uty);
		
}
}