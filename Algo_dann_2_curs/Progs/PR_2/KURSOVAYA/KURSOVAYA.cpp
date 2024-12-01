// KURSOVAYA.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
#include <fstream>
#include <string>
#include <map>
using namespace std;
struct info {
    string f, i, o;
    int number, series;
    bool operator<(const info& other) const
    {
        string s1 = "", s2 = "";
        s1 += this->f + this->i + this->o;
        s2 += other.f + other.i + other.o;
        return (s1 < s2);
    }
    
    string get_data() {
        return f + " " + i + " " + o + " | " + to_string(number) + " " + to_string(series);
    }
};

//bool operator<(const info& t1, const info& t2)
//{
//    string s1 = "", s2 = "";
//    for (int i = 0; i < 3; i++)
//    {
//        s1 += t1.fio[i];
//        s2 += t2.fio[i];
//    }
//    return (s1 < s2);
//}

void print_instructions() {
    cout << "1 - создать пустой словарь\n";
    cout << "2 - добавить элемент в словарь\n";
    cout << "3 - исключить элемент из словаря\n";
    cout << "4 - найти элемент в словаре по ключу\n";
    cout << "5 - изменить значение элемента\n";
    cout << "6 - вывести словарь в порядке возрастания ключей\n";
    cout << "0 - записать словарь в файл и завершить работу программы\n";
}

void add_elem(map<string, info>& mp) {
    cout << "Введите номер телефона, ФИО, номер и серию паспорта через пробел:\n";
    string phone;
    string fio[3];
    int number, series;
    cin >> phone >> fio[0] >> fio[1] >> fio[2] >> number >> series;
    mp[phone] = info{ fio[0], fio[1], fio[2], number, series };
}

void delete_elem(map<string, info>& mp) {
    cout << "Введите ключ элемента(номер телефона), который вы хотите удалить:\n";
    string s;
    cin >> s;
    mp.erase(s);
}

void find_elem(map<string, info>& mp) {
    cout << "Введите ключ элемента(номер телефона), который вы хотите найти:\n";
    string s;
    cin >> s;
    if (mp.count(s) == 0)cout << "Элемент не найден\n";
    else cout << "Информация о номере " << s << ": " << mp[s].get_data() << "\n";
}

void print_map(map<string, info>& mp) {
    cout << "Словарь:\n";
    for (auto a : mp) {
        cout << a.first << " : " << a.second.get_data() << "\n";
    }
}

int read_instructions() {
    int n;
    while (1) {
        cin >> n;
        if (n >= 0 && n <= 6)return n;
    }
}

int main()
{
    ifstream fin;
    ofstream fout;
    setlocale(LC_ALL, "Ru");
    cout << "Введите путь к текстовому файлу: ";
    string path;
    cin >> path;
    fin.open(path);
    map<string, info> mp;
    string f[] = {"a", "b", "c"};
    if (!fin.is_open()) {
        cout << "Не удалось открыть файл";
    }
    else {
        while (!fin.eof()) {
            string phone;
            string fio[3];
            int number, series;
            fin >> phone >> fio[0] >> fio[1] >> fio[2] >> number >> series;
            mp[phone] = info{ fio[0], fio[1], fio[2], number, series };
        }
        
        print_instructions();
        bool f = true;
        while (f) {
            int instruction = read_instructions();
            switch (instruction)
            {
            case 0:
                f = false;
                break;
            case 1:
                mp.clear();
                break;
            case 2:
                add_elem(mp);
                break;
            case 3:
                delete_elem(mp);
                break;
            case 4:
                find_elem(mp);
            case 5:
                add_elem(mp);
            case 6:
                print_map(mp);
            default:
                break;
            }
        }
        fout.open("output.txt");
        for (const auto& element : mp) {
            fout << element.first << " " << element.second.f << " " << element.second.i << " " << element.second.o << " " << element.second.number << " " << element.second.series << "\n";
        }
    }
    return 0;
}