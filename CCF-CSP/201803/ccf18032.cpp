#include <iostream>
#include <map>
using namespace std;

void print(int *array,int n) {
	for(int i =0; i<n; i++) {
		cout<<array[i]<<" ";
	}
	cout<<endl;
}

int main() {
	int choice = 1;
	int n,L,t;
	cin>>n>>L>>t;
	int* input = new int[n];
	int direct[n];// = new int[n];
	if(choice == 0) {
		int n = 3;
		int L = 10;
		int t = 5;
		//int input [] = {4,6,8};
		//int direct []= {1,1,1};
	} else {

		//cin>>n>>L>>t;
		for(int i =0; i<n; i++) {
			cin>>input[i];
		}
		for(int i =0; i<n; i++) {
			direct[i]=1;
		}
	}

	//print(direct,n);
	//print(input,n);

	for(int i = 0; i < t; i++) {
		map<int, int> count;
		int one,two;
		for(int j=0; j<n; j++) {
			input[j] = input[j]+direct[j];
			map<int,int>::iterator it;
			it=count.find(input[j]);
			if(it==count.end()) {
				count.insert(pair<int, int>(input[j], j));
				//cout<<"test1 not found"<<endl;
			} else {
				one = it->second;
				two = j;
				direct[one] = direct[one]*-1;
				direct[two] = direct[two]*-1;
				//cout<<it->second<<endl;
			}

		}

		for(int j=0; j<n; j++) {
			if(input[j]==L || input[j]==0) {
				direct[j] = direct[j]*-1;
			}
		}
		//print(input,n);
		//cout<<input[i]<<endl;
	}
	print(input,n);
	return 0;
}
