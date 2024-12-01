#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <stdio.h>
using namespace std;
struct bill {
    int number, money_sum;
    string date, time;
    bill(int n, int m, string d, string t) {
        number = n;
        money_sum = m;
        date = d;
        time = t;
    }
    string info() {
        return to_string(number) + " " + to_string(money_sum) + " " + date + " " + time;
    }
    bool operator < (const bill& sec) const
    {
        return number < sec.number;
    }
};

bool comp(bill &a, bill &b) {
    return a.number < b.number;
}

int bin_search(vector<bill>& a, const int& b) {
    int l = 0, r = a.size() - 1;
    while (1) {
        int mid = (r + l) / 2;
        //cout << l << " " << r << " " << mid << "\n";
        if (a[mid].number > b)r = mid - 1;
        else if (a[mid].number < b) l = mid + 1;
        else if (a[mid].number == b)return mid;
        if (l > r)return -1;
    }
}

void sort_vec(vector<bill>& a) {
    sort(a.begin(), a.end());
}

int read_vec(vector<bill>& vec, string input) {
    ifstream fin(input);
    if (!fin) {
        cout << "Input file is not open!";
        return -1;
    }
    while (!fin.eof()) {
        int n, money;
        string date, time;
        fin >> n >> money >> date >> time;
        vec.push_back(bill(n, money, date, time));
    }
    return 0;
}

void print_vec(vector<bill>& vec) {
    for (auto a : vec) {
        cout << a.info() << "\n";
    }
}

int write_vec(vector<bill>& vec, string output) {
    ofstream fout(output);
    if (!fout) {
        cout << "Output file is not open!";
        return -1;
    }
    for (auto a : vec) {
        string temp = a.info();
        fout.write(a.info().c_str(), sizeof(a.info()));
    }
    return 0;
}

int main()
{
    setlocale(LC_ALL, "RU");
    string input, output;
    cout << "Введите название входного файла:\n";
    cin >> input;
    cout << "Введите название выходного файла:\n";
    cin >> output;
    vector<bill>vec;
    read_vec(vec, input);
    sort_vec(vec);
    print_vec(vec);
    cout << "Введите номер чека: \n";
    int n;
    cin >> n;
    cout << "Информация о чеке под введенным номером: " << vec[bin_search(vec, n)].info();
    write_vec(vec, output);
}