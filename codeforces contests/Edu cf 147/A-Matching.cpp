#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string s;
        cin >> s;
        int flag = 0;

        if (s[0] - '0' >= 1 && s[0] - '0' <= 9 && s.length() == 1)
        {
            // cout << "hey i'm here 1" << endl;
            cout << "1" << endl;
            flag = 1;
        }

        if (flag == 0)
        {
            // cout << "hey i'm here 2" << endl;
            if (s[0] - '0' == 0 && s.length() == 1)
            {
                // cout << " len : " << s.length() << endl;
                cout << "0" << endl;
                flag = 1;
            }
        }

        if(flag == 0){
            // cout << "hey i'm here 3" << endl;
            int len = s.length();
            int count = 0 ;
            for(int i = 0 ; i < len ; i++){
                if(s[i] != '?'){
                    count++;
                }
            }
            if(len == count && count > 1){
                cout << "0" << endl;
                flag = 1 ;
            }
        }

        if(flag == 0){
            // cout << "hey i'm here 4" << endl;
            long count = 1;
            for(int i = 0 ; i < s.length() ; i++){
                if(s[i] == '?' && i == 0) count*=9;

                if(s[i] == '?' && i!= 0) count*=10;

            }
            cout<<count<<endl;
        }
    }
    return 0;
}
