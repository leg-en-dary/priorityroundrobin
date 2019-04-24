import java.util.Scanner;

class logicforpriority
{
		Scanner scan=new Scanner(System.in);
		int i,j,n;
		int pid[],bt[],wt[],tat[],pri[];
		int ct[],at[];	
		logicforpriority()
		{
			ct=new int[100];
			at=new int[100];
			pid = new int[100];
			bt = new int[100];
			wt = new int[100];
			tat = new int[100];
			pri = new int[100];
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
			System.out.println("Enter pri:");
			for(i=0;i<n;i++)
			{
				pri[i]=scan.nextInt();
			}
			System.out.println("Enter Arrival time:");
			for(i=0;i<n;i++)
			{
				at[i]=scan.nextInt();
			}
		}
		public void display() 
		{
				System.out.println("table");
				System.out.println("pid\tpri\tbt\tAT\tCT\twt\ttat");
				
				for(i=0;i<n;i++)
				{
					System.out.println(pid[i]+"\t"+pri[i]+"\t"+bt[i]+"\t"+at[i]+"\t"+ct[i]+"\t"+wt[i]+"\t"+tat[i]);
				}
		}
		
		public void sort() 
		{
			int temp=0;
			
			for(i=0;i<n;i++)
			{	
				for(j=0;j<n-i-1;j++)
				{
					if(pri[j]<pri[j+1])
					{
						temp=pri[j];
						pri[j]=pri[j+1];
						pri[j+1]=temp;
						
						temp=bt[j];
						bt[j]=bt[j+1];
						bt[j+1]=temp;	
						
						temp=pid[j];
						pid[j]=pid[j+1];
						pid[j+1]=temp;

						temp=at[i];
						at[i]=at[i+1];
						at[i+1]=temp;
					
					}					
				}				
			}			
		}
		public void findall() 
		{
			int t=0;			
			for(i=0;i<n;i++)
			{
				ct[i]=t+bt[i];
				t=ct[i];		
			}	
				
			for(i=0;i<n;i++)
			{
				tat[i]=ct[i]-at[i];
			}
			for(i=0;i<n;i++)
			{
				wt[i]=tat[i]-bt[i];
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

public class Priority 
{
	public static void main(String args[])
	{
		logicforpriority abc = new logicforpriority();
		
		abc.accept();
		abc.sort();
		abc.findall();
		abc.display();
		abc.avgtime();
	}
}
