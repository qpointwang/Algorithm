#include <iostream>
using namespace std;
int index[1000000];
int main()
{
	int time = 0;
	//int n = 4;
	//int inputH[n][2]={{1,3},{5,6},{9,13},{14,15}};
	//int inputH[n][2]={{2,10},{14,15},{100,110},{130,140}};
	//int inputW[n][2]={{2,4},{5,7},{10,11},{13,14}};
	//int inputW[n][2]={{,3},{5,6},{9,13},{14,15}};
	//int inputW[n][2]={{100,300},{500,600},{900,1300},{1400,1500}};
	int n;
	cin >> n;
	int inputH[2000][2];
	int inputW[2000][2];
	for(int i = 0; i < n; i++){
		cin >> inputH[i][0] >> inputH[i][1];
	}
	for(int i = 0; i < n; i++){
		cin >> inputW[i][0] >> inputW[i][1];
	}
	//方法三 
	for(int i = 0;i<n;i++){
		for(int j = inputH[i][0];j<inputH[i][1];j++){
			//cout<<j<<endl;
			index[j]=1;
		}
	}
	for(int i = 0;i<n;i++){
		for(int j = inputW[i][0];j<inputW[i][1];j++){
			//cout<<j<<endl;
			if(index[j]){
				time++;
			}
		}
	}
	//for(int i = 0;i<100;i++){
	//	cout<<index[i]<<endl;
	//}
	//方法二 
	/*int Hmin = inputH[0][0];
	int Hmax = inputH[n-1][1];
	int Wmin = inputW[0][0];
	int Wmax = inputW[n-1][1];
	int max,min;
	if(Hmin<=Wmin){
		min = Hmin;
	}
	else{
		min = Wmin;
	}
	if(Hmax>=Wmax){
		max = Hmax;
	}
	else{
		max = Wmax;
	}
	int flagH = 0;
	int flagW = 0;
	for(int i = min;i<max;i++){
		//cout<<i<<" "<<i+1<<endl;
		flagH = 0;
		flagW = 0;
		for(int j = 0; j<n;j++){
			if((inputH[j][0]<=i)&&((i+1)<=inputH[j][1])){
				//cout << "dd"<<endl;
				flagH = 1;
			}
			if((inputW[j][0]<=i)&&((i+1)<=inputW[j][1])){
				flagW = 1;
				//cout<<"ff"<<endl;
			}
			if(flagH == 1 && flagW == 1){
				time++;
				break; 
			}
		}	
	}*/
	//方法一 
	/*int iH = 0;
	int iW = 0;
	while(iH<n & iW<n){
		if(inputH[iH][0] < inputW[iW][0]){
			if((inputW[iW][0] < inputH[iH][1]) & (inputW[iW][1]>=inputH[iH][1])){
				time += inputH[iH][1] - inputW[iW][0];
			    iH++;
			    continue;
			}
			if((inputW[iW][0] < inputH[iH][1]) & (inputW[iW][1] < inputH[iH][1])){
				time += inputW[iW][1] - inputW[iW][0];
			    iW++;
			    continue;
			}
			if(inputW[iW][0] >= inputH[iH][1]){
				iH++;
				continue;
			}
		}
		else if(inputH[iH][0] > inputW[iW][0]){
			if((inputH[iH][0] < inputW[iW][1])&(inputH[iH][1] >= inputW[iW][1])){
				time += inputW[iW][1] - inputH[iH][0];
				iW++;
				continue;
			}
			if((inputH[iH][0] < inputW[iW][1])&(inputH[iH][1] < inputW[iW][1])){
				time += inputH[iH][1] - inputH[iH][0];
				iH++;
				continue;
			}
			if(inputH[iH][0] >= inputW[iW][1]){
				iW++;
				continue;
			}
		}
		else{
			if(inputH[iH][1] < inputW[iW][1]){
				time += inputH[iH][1] - inputH[iH][0];
				iH++;
				continue;
			}
			else if(inputH[iH][1] > inputW[iW][1]){
				time += inputW[iW][1] - inputW[iW][0];
				iW++;
				continue;
			}
			else if(inputH[iH][1] == inputW[iW][1]){
				time += inputH[iH][1] - inputH[iH][0];
				iW++;
				iH++;
				continue;
			}
		}
	}*/ 
	cout<<time<<endl;
    return 0;
}
