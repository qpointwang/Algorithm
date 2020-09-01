#include<iostream>
#include<vector>
using namespace std;


void str2regv(string str){
    vector<string> res;
    str=str.substr(1,str.size()-1);
    cout<<str<<endl;
    res.push_back("/");
    size_t pos=str.find("/");
    while(pos!=string::npos){
        res.push_back(str.substr(0,pos));
        res.push_back("/");
        str=str.substr(pos+1);
        pos=str.find("/");
    }
    if(str.size()) res.push_back(str);
}

int main() {
	int n,m;
	cin>>n>>m;
	getchar();
	vector <string> p;
	vector <string> r;
	vector <string> q;
	for(int i =0; i<n; i++) {
		string s1,s2;
		cin>>s1>>s2;
		p.push_back(s1);
		r.push_back(s2);
		cout<<p[i]<<endl;
		cout<<r[i]<<endl;
	}
	for(int i =0; i<m; i++) {
		string s;
		cin>>s;
		q.push_back(s);
		str2regv(s);
		cout<<q[i]<<endl;
	}
	for(int i=0; i<m; i++) {
		for(int j=0; j<n; j++) {

		}
	}
	return 0;
}

