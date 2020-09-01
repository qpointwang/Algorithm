#include <iostream>
#include <algorithm>
using namespace std;


struct Child {
	int id;
	int flag;
};

int main() {
	int n = 0;
	int k = 0;
	cin>>n>>k;
	Child a[n];
	for(int i =0; i<n; i++) {
		a[i].id = i + 1;
		a[i].flag = 0;
	}
	int m = n;
	int j =0;
	int num =0;
	while(m!=1) {

		if(a[j].flag != 1) {
			num++;
		} else {
			j++;
			if(j%n==0) {
				j=0;
			}
			continue;
		}
		//cout<<a[j].id<<" -->"<<num<<endl;
		if(num%k==0 || num%10==k) {
			//cout<<a[j].id<<endl;
			a[j].flag=1;
			m--;
		}
		j++;
		if(j%n==0) {
			j=0;
		}
	}
	for(int i = 0;i<n;i++){
		if(a[i].flag == 0){
			cout<<a[i].id<<endl;
		}
	}
	//cout<<a[j].id<<endl;
	return 0;

}

