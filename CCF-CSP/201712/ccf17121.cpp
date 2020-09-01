#include <iostream> 
#include <algorithm>
using namespace std;

bool complare(int a,int b){
	return a>b;
}

int main(){
	int n = 5;
	
	cin>>n;
	int* input = new int[n];
	for(int i =0;i<n;i++){
		cin>>input[i];
	}
	int* output = new int[n-1];
	sort(input,input+n);
	for(int i = 1;i <n;i++){
		output[i-1] = input[i] - input[i-1];
	}
	cout<<*min_element(output,output+n-1);
	return 0;
}
