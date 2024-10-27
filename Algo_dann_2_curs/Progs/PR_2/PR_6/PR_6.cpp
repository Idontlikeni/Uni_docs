// PR_6.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
#include <vector>
using namespace std;
int find(vector<int>& v) {
    for (int i = v.size(); i >= 0; i--)
    {
        if (v[i] < 0)return i;
    }
    return -1;
}

void delete_max(vector<int>& v) {
    int mx = v[0];
    for (auto a : v) {
        if (a > mx) mx = a;
    }
    int i = 0;
    while (i < v.size()) {
        if (v[i] == mx && i != v.size() - 1) {
            v.erase(v.begin() + i + 1, v.begin() + i + 2);
        }
        ++i;
    }
}

void enter(vector<int>& v) {
    while (1) {
        
        int a;
        cin >> a;
        v.push_back(a);
        if (std::cin.peek() == '\n') {
            break;
        }
    }
}

void print_arr(vector<int>& v) {
    for (auto a : v)
    {
        cout << a << " ";
    }
    cout << "\n";
}

int main()
{
    setlocale(LC_ALL, "RU");
    vector<int>vec;
    while (1) {
        cout << "Что вы хотите сделать?\n";
        cout << "1 - Ввести массив\n2 - найти последний отрицательный элемет\n";
        cout << "3 - удалить все элементы после каждого максимального числа\n4 - вывести массив\n";
        cout << "0 - выход из программы\n";
        short c;
        cin >> c;
        switch (c)
        {
        case 0:
            return 0;
            break;
        case 1:
            enter(vec);
            break;
        case 2:
            find(vec);
            break;
        case 3:
            delete_max(vec);
            break;
        case 4:
            print_arr(vec);
            break;
        default:
            break;
        }
    }
}
