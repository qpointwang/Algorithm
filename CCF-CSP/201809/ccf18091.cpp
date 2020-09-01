#include <iostream>
using namespace std;
int main() {
	int n;
	cin >> n;
	int* input = new int[1000];
	int* output = new int[1000];
	for(int i = 0; i < n; i++) {
		cin >> input[i];
	}
	for(int i = 0; i < n; i++) {
		if(i==0) {
			output[i]=(input[i]+input[i+1])/2;
		} else if(i==n-1) {
			output[i]=(input[i-1]+input[i])/2;
		} else {
			output[i]=(input[i-1]+input[i]+input[i+1])/3;
		}
	}
	for(int i = 0; i < n; i++) {
		cout << output[i] << " ";
	}
	return 0;
}
