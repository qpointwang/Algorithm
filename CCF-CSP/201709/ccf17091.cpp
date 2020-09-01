#include <iostream> 
#include <algorithm>
using namespace std;

int main(){
	int n = 0;
	cin>>n; 
	int five = n/50;
	int flast = n%50;
	int three = flast/30;
	int tlast = flast%30;
	int num = five * 7 + three * 4 + tlast/10;
	cout<<num;
	return 0;
}
