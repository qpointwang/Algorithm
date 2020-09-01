#include <iostream>
using namespace std;
int main() {
	int* input = new int[1000];
	int n = 0;
	while(true){
		int x;
		cin >>x;
		if(x != 0){
			input[n++]=x;
		}
		else{
			input[n++]=x;
			break;
		}
	}
	int flag = 1;
	int result = 0;
	for(int i =0;i<n;i++){
		if(input[i]==1){
			flag = 1;
			result+=flag;
		}
		else if(input[i]==2){
			result+=flag*2;
			flag++;
		}
		else{
			cout<<result;
		}
		// cout<<input[i]<< "  "<<flag<<"  "<<result<<endl;
	}
	return 0;
}
