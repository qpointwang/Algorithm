#include <iostream>
#include <cstring>
#include <queue>
using namespace std;

struct Edge {
	int to,next,v;
} edge[2006];

int n;

int cur=0,head[306],dist[306],inq[306],vis[306];
void Print(int array[]) {
	for(int i = 0; i < n+1; i++) {
		cout<<array[i]<<" ";
	}
	cout<<endl;
}
void addedge(int x,int y,int v) {
	//cout<<"--  "<<x<<"  --  "<<y<<"  --  "<<v<<"+++++ "<<head[x]<<"   边的编号："<<cur<<endl;
	edge[cur].to=y;
	edge[cur].next=head[x];
	edge[cur].v=v;
	head[x]=cur++;
	/*for(int i = 0; i < n+1; i++) {
		cout<<head[i]<<" ";
	}
	cout<<endl;*/
	//Print(head);
}


// 求最小值，也就是求最长路。 
void spfa() {
	queue<int>qq;
	for(int i=0; i<n+1; i++) {
		qq.push(i);
		vis[i]=1;
		dist[i]=0;  //最短距离
		inq[i]=1; 
	}
	while(!qq.empty()) {
		int x=qq.front(); // 取出节点x
		//cout<<"取出节点"<<x<<endl;
		qq.pop();
		inq[x]++;  //每个结点的入队次数，n个点中如果同一个点入队超过n次，那么即存在环 
		vis[x]=0; //已经便利过x节点
		if(inq[x]>n) {
			cout<<"noanswer"<<endl;
			return ;
		}
		for(int i=head[x]; i!=-1; i=edge[i].next) { //起始节点为x的所有边，i=edge[i].next为取出前一个起始点为x的边的序号，每一条边都会记录起始点为x的前一条边，-1代表前面没有边了
			//cout<<"边的编号     "<<i<<endl;
			int nx=edge[i].to; // nx为终节点，x->nx，每次循环不一样，因为x可能连接多个终结点
			//cout<<"*****"<<x<<"->"<<nx<<endl;
			//cout<<"------------  "<<dist[nx]<<"  --  "<<dist[x]<<"  --  "<<edge[i].v<<endl;
			if(dist[nx]<dist[x]+edge[i].v) { //满足两边之和大于第三边，进行松弛 
				dist[nx]=dist[x]+edge[i].v;
				if(!vis[nx]) { //nx不在队列中 ，但是却做了更改（dist[nx]增加），因此和nx直连的也都要进行响应的更改（可以边更大） ，因此要添加回来 
					vis[nx]=1;
					qq.push(nx);
				}
			}
		//	Print(dist);
		}
	}
	return ;
}

int main() {
	int* input = new int[1000];
	int* output = new int[1000];
	int choice =0;
	if(choice==0) {
		input[0]=1;
		cin >> n;
		for(int i = 1; i < n+1; i++) {
			cin >> input[i];
		}
	} else {
		n=8;
		int temp[n+1]= {0, 2, 2, 1, 3, 4, 9, 10, 13};
		for(int i = 0; i < n+1; i++) {
			input[i]=temp[i];
		}
	}
	memset(head,-1,sizeof(head));

	for(int i=0; i<n-2; i++) {
		addedge(i+3,i,-(input[i+2]*3+2));
		addedge(i,i+3,input[i+2]*3);
	}
	addedge(2,0,-(input[1]*2+1));
	addedge(0,2,input[1]*2);   //对开始两个单独处理
	addedge(n,n-2,-(input[n]*2+1));
	addedge(n-2,n,input[n]*2);  //对结尾两个单独处理
	//rep(i,1,n+1)addedge(i-1,i,1);              //每个数都要大于等于1
	for(int i = 1; i < n+1; i++) {
		addedge(i-1,i,1);
	}
	/*for(int i = 0; i < cur; i++) {
		cout<<"--  "<<edge[i].to<<"  --  "<<edge[i].next<<"  --  "<<edge[i].v<<"   边的编号："<<i<<endl;
	}*/

	spfa();
	for(int i=0; i<n; i++) {
		cout<<dist[i+1]-dist[i]<<" ";
	}


	return 0;
}
