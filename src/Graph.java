import java.util.*;

class node
{
    int data;
    node next;

node(int Data)
{
    data=Data ;
    next=null;
}
}

class Route
{

int [][]arr=new int [20][20];
int src[]=new int[20];

Scanner sc=new Scanner(System.in);
int v=0,e=0;
node[] head=new node[10];

void create()
{
    System.out.println("Enter number of Homes : ");
    v=sc.nextInt();
   
    System.out.println("Enter number of Lanes : ");
    e=sc.nextInt();
    int i=1;
   
    for( i=1;i<=v;i++)
    {
        for(int j=1;j<=v;j++)
        {
            arr[i][j]=0;
        }
    }

    for( i=0;i<e;i++)
    {
        System.out.println("Enter source home and destination home : ");
        int src=sc.nextInt();
        int dest=sc.nextInt();
       
        arr[src][dest]=1;
        arr[dest][src]=1;
   
    }
}



void display_matrix()
    {
        int i=0,j=0;
        for(i=1;i<=v;i++)
        {
            System.out.print(i+" ");
        }
       
        
        System.out.println();
        for(i=1;i<=v;i++)
        {
             for(j=1;j<=v;j++)
             {
                System.out.print(arr[i][j]+" ");
             }
             System.out.println();
        }
    }


void bfs_list()
{
    System.out.println("Enter number of homes : ");
    v=sc.nextInt();
   
    System.out.println("Enter number of lanes : ");
    e=sc.nextInt();
   
    for(int i=1;i<=e;i++)
    {
        System.out.println("Enter source home and destination home: ");
        int src=sc.nextInt();
        int dest=sc.nextInt();
       
        insert(src,dest);
        insert(dest,src);
    }

}

void insert(int u,int v)
{
    node newnode=new node(v);
   if(head[u]==null)
            {
           head[u]=newnode;
       }
       else
       {
           node curr=head[u];
           while(curr.next!=null)
           {
               curr=curr.next;
           }
           curr.next=newnode;
       }
}


void display_bfs_list()
{
    for(int i=1;i<=v;i++)
    {
        node curr=head[i];
        System.out.print(i+" ");
        //System.out.println();
        while(curr!=null)
        {
            System.out.print(" -> "+curr.data);
            curr=curr.next;
        }
        System.out.println();
    }
}

// bfs using queue for adjecency list...
void bfs(int str)
{
    System.out.println("BFS of given graph is : ");
    Queue<Integer>q=new LinkedList<Integer>();
   
    int visited[]=new int[v+1];
   
    for(int i=0;i<=v;i++)
    {
        visited[i]=0;
    }
   
    q.add(str);
    visited[str]=1;
    System.out.print(str+" ");
   
    while(! q.isEmpty())
    {
        int a=q.remove();
        node curr=head[a] ;
        while(curr!=null )
        {
        if(visited[curr.data]!=1)
        {
            q.add(curr.data);
            visited[curr.data]=1;
            System.out.print(curr.data+" ");
        }
        curr=curr.next;
        }
       
    }
}



//dfs using stack for adj matrix

void dfs(int str)
{
    System.out.println("DFS of given graph is : ");
    Stack<Integer> st=new Stack<Integer>();
    int []visited=new int [10];
   
    for(int i=1;i<=v;i++)
    {
        visited[i]=0;
    }
   
    visited[str]=1;
    st.push(str);
   
    while(! st.empty())
    {
        int a=st.pop();
        System.out.print(" "+a);
        for(int i=1;i<=v;i++)
        {
            if(arr[a][i]==1 && visited[i]==0)
            {
                st.push(i);
                visited[i]=1;
            }
        }
    }
}
}
public class Graph {

public static void main(String[] args) {

Scanner sc=new Scanner(System.in);
char option;
Route obj=new Route();
int ch=0;

	do
		{
		System.out.println("Search shortest route by \n1) DFS \n2) BFS\n3) EXTI\n==> ENTER CHOICE");
		ch=sc.nextInt();

		switch(ch)
		{
		case 1 : //DFS in adjecency matrix
			obj.create();

			obj.display_matrix();

			System.out.println("Enter starting vertex : ");
			int str=sc.nextInt();

			obj.dfs(str);
			break;
			case 2:

				obj.bfs_list();

				obj.display_bfs_list();

				System.out.println("Enter starting vertex : ");
				int str1=sc.nextInt();

				obj.bfs(str1);
				break;

				case 3:
				System.out.println("Thank you!!!");
		
		 }System.out.println("\nDo you want to continue? If yes enter Y.");
         option=sc.next().charAt(0);
     } while(option=='Y');
	}

}


// *** OUTPUT *** //

//Search shortest route by 
//1) DFS 
//2) BFS
//3) EXTI
//==> ENTER CHOICE
//1
//Enter number of Homes : 
//7
//Enter number of Lanes : 
//7
//Enter source home and destination home : 
//1 2
//Enter source home and destination home : 
//1 3
//Enter source home and destination home : 
//1 4
//Enter source home and destination home : 
//2 5
//Enter source home and destination home : 
//3 7
//Enter source home and destination home : 
//4 6
//Enter source home and destination home : 
//2 6
//1 2 3 4 5 6 7 
//
//0 1 1 1 0 0 0 
//1 0 0 0 1 1 0 
//1 0 0 0 0 0 1 
//1 0 0 0 0 1 0 
//0 1 0 0 0 0 0 
//0 1 0 1 0 0 0 
//0 0 1 0 0 0 0 
//Enter starting vertex : 
//1
//DFS of given graph is : 
// 1 4 6 3 7 2 5
//Do you want to continue? If yes enter Y.
//Y
//Search shortest route by 
//1) DFS 
//2) BFS
//3) EXTI
//==> ENTER CHOICE
//2
//Enter number of homes : 
//7
//Enter number of lanes : 
//7
//Enter source home and destination home: 
//1 2
//Enter source home and destination home: 
//1 3
//Enter source home and destination home: 
//1 4
//Enter source home and destination home: 
//4 6
//Enter source home and destination home: 
//2 5
//Enter source home and destination home: 
//2 6
//Enter source home and destination home: 
//3 7
//1  -> 2 -> 3 -> 4
//2  -> 1 -> 5 -> 6
//3  -> 1 -> 7
//4  -> 1 -> 6
//5  -> 2
//6  -> 4 -> 2
//7  -> 3
//Enter starting vertex : 
//1
//BFS of given graph is : 
//1 2 3 4 5 6 7 
//Do you want to continue? If yes enter Y.
