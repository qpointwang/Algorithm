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
	//cout<<"--  "<<x<<"  --  "<<y<<"  --  "<<v<<"+++++ "<<head[x]<<"   �ߵı�ţ�"<<cur<<endl;
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


// ����Сֵ��Ҳ�������·�� 
void spfa() {
	queue<int>qq;
	for(int i=0; i<n+1; i++) {
		qq.push(i);
		vis[i]=1;
		dist[i]=0;  //��̾���
		inq[i]=1; 
	}
	while(!qq.empty()) {
		int x=qq.front(); // ȡ���ڵ�x
		//cout<<"ȡ���ڵ�"<<x<<endl;
		qq.pop();
		inq[x]++;  //ÿ��������Ӵ�����n���������ͬһ������ӳ���n�Σ���ô�����ڻ� 
		vis[x]=0; //�Ѿ�������x�ڵ�
		if(inq[x]>n) {
			cout<<"noanswer"<<endl;
			return ;
		}
		for(int i=head[x]; i!=-1; i=edge[i].next) { //��ʼ�ڵ�Ϊx�����бߣ�i=edge[i].nextΪȡ��ǰһ����ʼ��Ϊx�ıߵ���ţ�ÿһ���߶����¼��ʼ��Ϊx��ǰһ���ߣ�-1����ǰ��û�б���
			//cout<<"�ߵı��     "<<i<<endl;
			int nx=edge[i].to; // nxΪ�սڵ㣬x->nx��ÿ��ѭ����һ������Ϊx�������Ӷ���ս��
			//cout<<"*****"<<x<<"->"<<nx<<endl;
			//cout<<"------------  "<<dist[nx]<<"  --  "<<dist[x]<<"  --  "<<edge[i].v<<endl;
			if(dist[nx]<dist[x]+edge[i].v) { //��������֮�ʹ��ڵ����ߣ������ɳ� 
				dist[nx]=dist[x]+edge[i].v;
				if(!vis[nx]) { //nx���ڶ����� ������ȴ���˸��ģ�dist[nx]���ӣ�����˺�nxֱ����Ҳ��Ҫ������Ӧ�ĸ��ģ����Ա߸��� �����Ҫ��ӻ��� 
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
	addedge(0,2,input[1]*2);   //�Կ�ʼ������������
	addedge(n,n-2,-(input[n]*2+1));
	addedge(n-2,n,input[n]*2);  //�Խ�β������������
	//rep(i,1,n+1)addedge(i-1,i,1);              //ÿ������Ҫ���ڵ���1
	for(int i = 1; i < n+1; i++) {
		addedge(i-1,i,1);
	}
	/*for(int i = 0; i < cur; i++) {
		cout<<"--  "<<edge[i].to<<"  --  "<<edge[i].next<<"  --  "<<edge[i].v<<"   �ߵı�ţ�"<<i<<endl;
	}*/

	spfa();
	for(int i=0; i<n; i++) {
		cout<<dist[i+1]-dist[i]<<" ";
	}


	return 0;
}
