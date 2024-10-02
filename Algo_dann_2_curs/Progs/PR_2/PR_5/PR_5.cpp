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
            }
        }
        ++i;
    }
    cout << s;
    return 0;
}

