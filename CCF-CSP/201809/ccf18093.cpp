#include <iostream>
#include <fstream>
#include <sstream>
#include <stack>
#include <map>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

string printStackS(stack<string> mystack) {
	int flag = 0;
	string temp="";
	while(!mystack.empty()) {
		if(flag ==0) {
			temp = mystack.top();
			flag++;
		} else {
			if(mystack.top().find("#") != mystack.top().npos) {
				string s = mystack.top();
				s = s.erase(s.find_first_of("#")-1);
				temp = s+" "+temp;
			} else {
				temp = mystack.top()+" "+temp;
			}
		}
		mystack.pop();
	}
	cout<<temp<<endl;
	return temp;
}

vector<string> spilt(string str,string interval) {
	vector<string> res;
	size_t pos = str.find(interval);
	size_t size = str.size();
	while (pos != str.npos) {
		//	cout<<str.substr(0,pos)<<endl;
		//	cout<<str.substr(0,pos).size()<<endl;
		res.push_back(str.substr(0,pos));
		str = str.substr(pos+1,size);
		pos = str.find(interval);
	}
	res.push_back(str);
	return res;
}

int main() {
	int n; //结构化文档的行数
	int m; //待查询的选择器个数
	map<int, string> inputDoc;
	map<int, string> outputDoc;
	map<int, vector<string> > outputDocVec;
	map<int, string> inputSel;

	int choice = 0;

	if(choice==0) {
		cin >> n >> m;
		getchar();
		for(int i =1; i<=n; i++) {
			getline(cin,inputDoc[i]);
			if(inputDoc[i].find("#") != inputDoc[i].npos) {
				string str1="";
				string str2="";
				str1 = inputDoc[i].substr(0,inputDoc[i].find_first_of("#"));
				str2 = inputDoc[i].substr(inputDoc[i].find_first_of("#"));
				transform(str1.begin(),str1.end(),str1.begin(),::tolower);
				inputDoc[i]= str1+str2;
			} else {
				transform(inputDoc[i].begin(),inputDoc[i].end(),inputDoc[i].begin(),::tolower);
			}
		}
		for(int i =1; i<=m; i++) {
			getline(cin,inputSel[i]);
			if(inputSel[i].find("#") != inputSel[i].npos) {
				string str1="";
				string str2="";
				str1 = inputSel[i].substr(0,inputSel[i].find_first_of("#"));
				str2 = inputSel[i].substr(inputSel[i].find_first_of("#"));
				transform(str1.begin(),str1.end(),str1.begin(),::tolower);
				inputSel[i]= str1+str2;
			} else {
				transform(inputSel[i].begin(),inputSel[i].end(),inputSel[i].begin(),::tolower);
			}
		}
	} else {
		n = 11;
		m = 5;
		ifstream infile;
		infile.open("html.txt");
		string data;
		int count=1;
		while(getline(infile,data)) {
			if(count<=n) {
				inputDoc[count]=data;
				if(inputDoc[count].find("#") != inputDoc[count].npos) {
					string str1="";
					string str2="";
					str1 = inputDoc[count].substr(0,inputDoc[count].find_first_of("#"));
					str2 = inputDoc[count].substr(inputDoc[count].find_first_of("#"));
					transform(str1.begin(),str1.end(),str1.begin(),::tolower);
					inputDoc[count]= str1+str2;
				} else {
					transform(inputDoc[count].begin(),inputDoc[count].end(),inputDoc[count].begin(),::tolower);
				}

			} else {
				inputSel[count-n]=data;
				if(inputSel[count-n].find("#") != inputSel[count-n].npos) {
					string str1="";
					string str2="";
					str1 = inputSel[count-n].substr(0,inputSel[count-n].find_first_of("#"));
					str2 = inputSel[count-n].substr(inputSel[count-n].find_first_of("#"));
					transform(str1.begin(),str1.end(),str1.begin(),::tolower);
					inputSel[count-n]= str1+str2;
				} else {
					transform(inputSel[count-n].begin(),inputSel[count-n].end(),inputSel[count-n].begin(),::tolower);
				}
			}
			count++;
		}
	}



	/*for(int i =1; i<=n; i++) {
		cout<<inputDoc[i].c_str()<<endl;
	}*/
	for(int i =1; i<=m; i++) {
		//cout<<inputSel[i].c_str()<<endl;
	}
	stack<string> mystack;
	stack<int> myindex;
	myindex.push(-1);
	for(int i =1; i<=n; i++) {
		//char temp[] = inputDoc[i].c_str();
		int length = inputDoc[i].length();
		string src = inputDoc[i];
		int flag = 0;
		int numPoint = 0;
		//char *dst = new char[length];
		for(int j=0; j <=length; j++) {
			if(src[j]=='.' && flag ==0) {
				numPoint++;
			} else {
				flag=1;
			}
		}
		src = src.substr(numPoint, length);
		if(numPoint>myindex.top()) {
			mystack.push(src);
			myindex.push(numPoint);
		} else if(numPoint==myindex.top()) {
			mystack.pop();
			mystack.push(src);
		} else if(numPoint < myindex.top()) {
			while(numPoint<=myindex.top()) {
				myindex.pop();
				mystack.pop();
			}
			mystack.push(src);
			myindex.push(numPoint);
		}
		//cout<<numPoint<<endl;
		outputDoc[i]=printStackS(mystack);
	}

	/*for(int i =1; i<=m; i++) {
		int num =0;
		string result ="";
		for(int j=1; j<=n; j++) {
			//cout<<outputDoc[j]<<"     "<<inputSel[i]<<endl;
			if(outputDoc[j].find(inputSel[i]) != outputDoc[j].npos) {
				//cout<<"找到了"<<endl;
				stringstream ss;
				ss<<j;
				string s1 = ss.str();
				result = result + " "+s1;
				num++;
			}
		}
		cout<<num<<result<<endl;
	}*/
	for(int i=1; i<=n; i++) {
		outputDocVec[i] = spilt(outputDoc[i]," ");
		/*for (int k = 0; k < outputDocVec[i].size(); k++) {
			cout<<outputDocVec[i][k]<<endl;
		}*/
	}

	for(int i =1; i <= m; i++) {
		//cout<<"第"<<i<<"个输出行"<<endl;
		int num =0;
		string result ="";
		vector<string> res = spilt(inputSel[i]," ");



		for(int j=1; j<=n; j++) {
			vector<string> tempvec = outputDocVec[j];
			int number=0;
			int y=0;
			for (int k = 0; k < res.size(); k++) {
				for(int x=y; x<tempvec.size(); x++) {
					if(tempvec[x]==res[k]) {
						number++;
						y=x+1;
						break;
					}
				}
			}
			if(number == res.size()) {
				num++;
				stringstream ss;
				ss<<j;
				string s1 = ss.str();
				result = result + " "+s1;
			}

		}
		cout<<num<<result<<endl;
	}

//cout << n << " "<< m <<endl;;
	return 0;
}


