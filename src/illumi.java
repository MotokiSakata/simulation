import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class illumi
{
	//机の座標
	static double px[] = {1.0, 2.2, 3.4, 1.0, 2.2, 3.4};
	static double py[] = {0.75, 0.75, 0.75, 1.45, 1.45, 1.45};
	//照明の座標
	static double lx[] = {0, 1.8, 3.6, 5.4, 0, 1.8, 3.6, 5.4, 0, 1.8, 3.6, 5.4};
	static double ly[] = {0, 0, 0, 0, 1.8, 1.8, 1.8, 1.8, 3.6, 3.6, 3.6, 3.6};

	static double calc(int C1,int C2,int C3,int C4,int C5,int C6,int C7,int C8,int C9,int C10,int C11,int C12,double px, double py)
	{
		return ((2/Math.sqrt(Math.pow(lx[0]-px, 2) + Math.pow(ly[0]-py, 2) + 4) * C1)/(Math.pow(lx[0]-px, 2) + Math.pow(ly[0]-py, 2) + 4)
				 +(2/Math.sqrt(Math.pow(lx[1]-px, 2) + Math.pow(ly[1]-py, 2) + 4) * C2)/(Math.pow(lx[1]-px, 2) + Math.pow(ly[1]-py, 2) + 4)
				 +(2/Math.sqrt(Math.pow(lx[2]-px, 2) + Math.pow(ly[2]-py, 2) + 4) * C3)/(Math.pow(lx[2]-px, 2) + Math.pow(ly[2]-py, 2) + 4)
				 +(2/Math.sqrt(Math.pow(lx[3]-px, 2) + Math.pow(ly[3]-py, 2) + 4) * C4)/(Math.pow(lx[3]-px, 2) + Math.pow(ly[3]-py, 2) + 4)
				 +(2/Math.sqrt(Math.pow(lx[4]-px, 2) + Math.pow(ly[4]-py, 2) + 4) * C5)/(Math.pow(lx[4]-px, 2) + Math.pow(ly[4]-py, 2) + 4)
				 +(2/Math.sqrt(Math.pow(lx[5]-px, 2) + Math.pow(ly[5]-py, 2) + 4) * C6)/(Math.pow(lx[5]-px, 2) + Math.pow(ly[5]-py, 2) + 4)
				 +(2/Math.sqrt(Math.pow(lx[6]-px, 2) + Math.pow(ly[6]-py, 2) + 4) * C7)/(Math.pow(lx[6]-px, 2) + Math.pow(ly[6]-py, 2) + 4)
				 +(2/Math.sqrt(Math.pow(lx[7]-px, 2) + Math.pow(ly[7]-py, 2) + 4) * C8)/(Math.pow(lx[7]-px, 2) + Math.pow(ly[7]-py, 2) + 4)
				 +(2/Math.sqrt(Math.pow(lx[8]-px, 2) + Math.pow(ly[8]-py, 2) + 4) * C9)/(Math.pow(lx[8]-px, 2) + Math.pow(ly[8]-py, 2) + 4)
				 +(2/Math.sqrt(Math.pow(lx[9]-px, 2) + Math.pow(ly[9]-py, 2) + 4) * C10)/(Math.pow(lx[9]-px, 2) + Math.pow(ly[9]-py, 2) + 4)
				 +(2/Math.sqrt(Math.pow(lx[10]-px, 2) + Math.pow(ly[10]-py, 2) + 4) * C11)/(Math.pow(lx[10]-px, 2) + Math.pow(ly[10]-py, 2) + 4)
				 +(2/Math.sqrt(Math.pow(lx[11]-px, 2) + Math.pow(ly[11]-py, 2) + 4) * C12)/(Math.pow(lx[11]-px, 2) + Math.pow(ly[11]-py, 2) + 4));
	}
	public static void main(String[] args)
	{
		int add = 100, T1=700, T2=500, T3=300, T4=900; 
		int Lx1 = 0, Lx2 = 0, Lx3=0, Lx4=0, Lx5=0, Lx6=0;
		int[] ans = new int[18];//0-11:cd,12-17:name
		double[] rl = new double[6];
		double ave,min=99999;
		int L9=0, L10=0, L11=0, L12=0;
		
		System.out.println("start");
		//シミュレーション
		for(int L1=800;L1<1000;L1+=add)
		{
			for(int L2=200;L2<700;L2+=add)
			{
				for(int L3=0;L3<500;L3+=add)
				{
					for(int L4=0;L4<200;L4+=add)
					{
						for(int L5=900;L5<2000;L5+=add)
						{
							for(int L6=400;L6<1500;L6+=add)
							{
								for(int L7=300;L7<1200;L7+=add)
								{
									for(int L8=300;L8<800;L8+=add)
									{
										Lx1 = (int)calc(L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,px[0],py[0]);
										Lx2 = (int)calc(L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,px[1],py[1]);
										Lx3 = (int)calc(L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,px[2],py[2]);
										Lx4 = (int)calc(L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,px[3],py[3]);
										Lx5 = (int)calc(L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,px[4],py[4]);
										Lx6 = (int)calc(L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,px[5],py[5]);
										
										rl[0]=Math.abs(Lx1-T1);
										rl[1]=Math.abs(Lx2-T2);
										rl[2]=Math.abs(Lx3-T3);
										rl[3]=Math.abs(Lx4-T4);
										rl[4]=Math.abs(Lx5-T1);
										rl[5]=Math.abs(Lx6-T2);
										ave=(rl[0]+rl[1]+rl[2]+rl[3]+rl[4]+rl[5])/px.length;
										if(ave<min)
										{
											min=ave;
											ans[0]=L1;ans[1]=L2;ans[2]=L3;ans[3]=L4;ans[4]=L5;ans[5]=L6;ans[6]=L7;ans[7]=L8;ans[8]=L9;
											ans[9]=L10;ans[10]=L11;ans[11]=L12;ans[12]=Lx1;ans[13]=Lx2;ans[14]=Lx3;ans[15]=Lx4;ans[16]=Lx5;ans[17]=Lx6;
										}
										if((T1-50<=Lx1&&Lx1<=T1+50)&&(T2-50<=Lx2&&Lx2<=T2+50)&&(T3-50<=Lx3&&Lx3<=T3+50)&&(T4-50<=Lx4&&Lx4<=T4+50)&&(T1-50<=Lx5&&Lx5<=T1+50)&&(T2-50<=Lx6&&Lx6<=T2+50))
										{
											System.out.println(" 照明1:"+ans[0]+" 照明2:"+ans[1]+" 照明3:"+ans[2]+" 照明4:"+ans[3]+" 照明5:"+ans[4]+" 照明6:"+ans[5]+" 照明7:"+ans[6]+" 照明8:"+ans[7]+" 照明9:"+ans[8]+" 照明10:"+ans[9]+" 照明11:"+ans[10]+" 照明12:"+ans[11]);
											System.out.println("前田:"+ans[12]+" 大島:"+ans[13]+" 吉田:"+ans[14]+" 市川:"+ans[15]+" 雨宮:"+ans[16]+" 宮崎:"+ans[17]);
										}
									
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("最小値 "+min);
		System.out.println("照明1:"+ans[0]+" 照明2:"+ans[1]+" 照明3:"+ans[2]+" 照明4:"+ans[3]+" 照明5:"+ans[4]+" 照明6:"+ans[5]+" 照明7:"+ans[6]+" 照明8:"+ans[7]+" 照明9:"+ans[8]+" 照明10:"+ans[9]+" 照明11:"+ans[10]+" 照明12:"+ans[11]);
		System.out.println("前田:"+ans[12]+" 大島:"+ans[13]+" 吉田:"+ans[14]+" 市川:"+ans[15]+" 雨宮:"+ans[16]+" 宮崎:"+ans[17]);
		System.out.println("end");
	}

}
