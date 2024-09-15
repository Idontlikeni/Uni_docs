// PR_5.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
#include <string>
#include <stack>
#include <queue>
using namespace std;
int main()
{
    string s;
    setlocale(LC_ALL, "Ru");
    cout << "Введите текст: ";
    getline(cin, s);
    stack<int>l;
    queue<int>r;
    int i = 0;

    while (i < s.length()){
        if (s[i] == '(') {
            l.push(i);
        }
        else if (s[i] == ')') {
            if (l.size() != 0) {
                s.erase(l.top(), i - l.top() + 1);
                i -= i - l.top() + 1;
                l.pop();
                //cout << "\n-> " << s << " <-\n";
                
            }
        }
        //cout << s[i] << " ";
        ++i;
    }
    /*int shift = 0;
    int n = min(l.size(), r.size());
    for (int i = 0; i < n; ++i) {
        cout << s.substr(l.top(), r.front() - l.top() + 1 - shift) << "\n";
        s.erase(l.top(), r.front() - l.top() + 1 - shift);
        shift += r.front() - l.top() + 1;
        l.pop();
        r.pop();
    }
    */
    cout << s;
    // ab(c(d)e)------(1(2)3)4444
    // ab(c(d)e)------(1(2)3)4444
    // 0123456789
}

