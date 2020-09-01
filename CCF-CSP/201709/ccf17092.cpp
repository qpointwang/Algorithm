#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Order {
	int id;
	int flag;
};
struct Bro {
	int btime;
	int id;
};
struct Ret {
	int rtime;
	int id;
};

bool CompareB(const Bro &a, const Bro &b) {
	return a.btime < b.btime;
}
bool CompareR(const Ret &a, const Ret &b) {
	return a.rtime < b.rtime;
}



int main() {
	int N = 5;
	int K = 7;
	cin>>N>>K;
	Order order[N];
	Bro bro[K];
	Ret ret[K];
	for(int i =0; i<N; i++) {
		order[i].id = i+1;
		order[i].flag = 0;
	}
	for(int i =0; i<K; i++) {
		int w,s,c;
		cin>>w>>s>>c;
		bro[i].btime = s;
		bro[i].id = w;
		ret[i].rtime = s+c;
		ret[i].id = w;
	}
	sort(bro,bro+K,CompareB);
	sort(ret,ret+K,CompareR);
	int timemin = bro[0].btime;
	int timemax = ret[K-1].rtime;
	/*for(int i=0; i<K; i++) {
		cout<<bro[i].btime<<" "<<bro[i].id<<endl;
	}
	for(int i=0; i<K; i++) {
		cout<<ret[i].rtime<<" "<<ret[i].id<<endl;
	}*/
	int x=0;
	int y=0;
	vector <int> b;
	vector <int> r;
	for(int i = timemin; i <= timemax; i++) {
		while(ret[y].rtime==i) {
			r.insert(r.end(),ret[y].id);
			y++;
		}
		sort(r.begin(),r.end());
		for(int j = 0; j<r.size(); j++) {

			for(int k=0; k<N; k++) {
				if(order[k].flag==1) {
					order[k].flag=0;
					order[k].id=r[j];
					break;
				}
			}
		}
		r.clear();

		while(bro[x].btime==i) {
			for(int k=0; k<N; k++) {
				if(bro[x].id == order[k].id) {
					order[k].flag=1;
					order[k].id=0;
					break;
				}
			}
			x++;
		}

		/*cout<<i<<"     ++++++     "<<endl;
		for(int i =0; i<N; i++) {
			cout<<order[i].id<<" ";
		}
		cout<<endl;*/
	}
	for(int i =0; i<N; i++) {
		cout<<order[i].id<<" ";
	}
	cout<<endl;

	return 0;
}
