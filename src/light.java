import java.io.IOException;
import java.io.PrintWriter;

public class light 
{
	public static void main(String args[])
	{
		int L1=0,L2=0,L3=0,Lx1=0,Lx2=0,H=2;
		int ans[] = new int[5];
		double w1=0.3,w2=0.9,w3=2.1,w4=1.5,w5=0.3,w6=0.9;//単位はm
		double d1,d2,d3,d4,d5,d6;
		double c1,c2,c3,c4,c5,c6;
		double tmp=40000,tmp2;
		d1=Math.sqrt(w1*w1+H*H);d2=Math.sqrt(w2*w2+H*H);d3=Math.sqrt(w3*w3+H*H);
		d4=Math.sqrt(w4*w4+H*H);d5=Math.sqrt(w5*w5+H*H);d6=Math.sqrt(w6*w6+H*H);
		c1=H/d1;c2=H/d2;c3=H/d3;c4=H/d4;c5=H/d5;c6=H/d6;
		//10cd刻みでloop，範囲は0~2000
		
		try
		{
			PrintWriter pw = new PrintWriter("Light.txt");
			for(int i=0;i<=2000;i++)
			{
				for(int j=0;j<=2000;j++)
				{
					for(int k=0;k<=2000;k++)
					{
						L1=i;L2=j;L3=k;
						Lx1 = (int) (c1*L1/(d1*d1)+c2*L2/(d2*d2)+c3*L3/(d3*d3));
						Lx2 = (int) (c4*L1/(d4*d4)+c5*L2/(d5*d5)+c6*L3/(d6*d6));
						if((380<Lx1&&Lx1<420)&&(665<Lx2&&Lx2<735))
						{
							tmp2=L1+L2+L3;
							if(tmp2<tmp)
							{
								ans[0]=L1; ans[1]=L2;ans[2]=L3;ans[3]=Lx1;ans[4]=Lx2;
								//System.out.println(tmp2+" "+L1+"cd "+L2+"cd "+L3+"cd "+Lx1+"lx "+Lx2+"lx ");
								tmp = tmp2;
								//pw.println(L1+ " " + L2 + " " + L3 + " " + Lx1 + " " + Lx2);
								
							}
							
						}
					}	
				}
			}
			System.out.println(ans[0]+"cd "+ans[1]+"cd "+ans[2]+"cd "+ans[3]+"lx "+ans[4]+"lx ");
			pw.println(ans[0]+" "+ans[1]+" "+ans[2]+" "+ans[3]+" "+ans[4]);
			pw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
