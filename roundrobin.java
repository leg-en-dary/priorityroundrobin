import java.util.Scanner;

class logicforround
{
		int i,j,n;
		int pid[],bt[],wt[],tat[],copy_bt[],quantum;
		boolean done;
		Scanner scan=new Scanner(System.in);
		logicforround()
		{
			i=j=n=0;
			pid = new int[100];
			wt = new int[100];
			tat = new int[100];
			bt = new int[100];
			copy_bt = new int[100];
		}
	
		public void accept()
		{
			System.out.println("Enter the number of proceess :- ");
			n=scan.nextInt();
			
			for(i=0;i<n;i++)
			{
				pid[i]=i+1;
			}
		
			System.out.println("Enter burst Time :-");
		
			for(i=0;i<n;i++)
			{
				bt[i]=scan.nextInt();
			}	
			
			System.out.println("Enter quantum");
			quantum=scan.nextInt();
			calwt();
			caltat();
		}
		
		public void display()
		{
			System.out.println("table");
			System.out.println("pid\tbt\twt\ttat");
			
			for(i=0;i<n;i++)
			{
				System.out.println(pid[i]+"\t"+"\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]);
			}			
		}

		public void calwt()
		{
			for(i=0;i<n;i++)
			{
					copy_bt[i]=bt[i];
			}
			int t=0;
			
			while(true)
			{
				done=true;
				
				for(i=0;i<n;i++)
				{
					if(copy_bt[i]>0)
					{
							done=false;
							if(copy_bt[i]>quantum)
							{
									t=t+quantum;
									copy_bt[i]=copy_bt[i]-quantum;
							}
							else	
							{	
									t=t+copy_bt[i];	
									wt[i]=t-bt[i];
									copy_bt[i]=0;
							}
					}
				}				
				if(done==true)
				{
					break;
				}
			}			
		}
		public void caltat()
		{
			for(i=0;i<n;i++)
			{
				tat[i]=wt[i]+bt[i];
			}
		}
		public void avgtime()
		{
			System.out.println("Avg WT :");
			int total_wt,total_tat;
			total_wt=0;
			total_tat=0;
			for(i=0;i<n;i++)
			{
				total_wt=total_wt+wt[i];
			}
			double avgwt=(float)total_wt/n;
			System.out.println(avgwt);
			for(i=0;i<n;i++)
			{
				total_tat=total_tat+tat[i];
			}
			
			double avgtat=(float)total_tat/n;
			System.out.println("AVG TAT:");
			System.out.println(avgtat);
		}
}

public class roundrobin 
{
	public static void main(String args[])
	{
			logicforround rr=new logicforround();
			rr.accept();
			rr.display();
			
			rr.avgtime();
	}
}
