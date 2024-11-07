// KMP.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
#include <string>
#include <vector>
std::vector<int> computePrefixFunction(const std::string& pattern) {
    int m = pattern.size();
    std::vector<int> pi(m, 0);
    int k = 0;
    for (int i = 1; i < m; i++) {
        while (k > 0 && pattern[i] != pattern[k]) {
            k = pi[k - 1];
        }
        if (pattern[i] == pattern[k]) {
            k++;
        }
        pi[i] = k;
    }
    return pi;
}

void print_vec(const std::vector<int>& vec) {
    for (int i = 0; i < vec.size(); i++)
    {
        std::cout << vec[i] << " ";
    }
    std::cout << "\n";
}

int kmp(const std::string& text, const std::string& pattern) {
    int n = text.size();
    int m = pattern.size();
    std::vector<int>pi = computePrefixFunction(pattern); // префикс-массив
    int j = 0;
    for (int i = 0; i < n; i++)
    {
        while (j > 0 && text[i] != pattern[j])j = pi[j - 1];
        if (text[i] == pattern[j]) {
            j++;
        }
        if (j == m) {
            return i - m + 1;
        }
    }
    return -1;
}

int main()
{
    std::string s = "ababd", t = "ababcabcabababd";
    std::vector<int>pi = computePrefixFunction(s);
    print_vec(pi);
    std::cout << kmp(t, s);
}

// Запуск программы: CTRL+F5 или меню "Отладка" > "Запуск без отладки"
// Отладка программы: F5 или меню "Отладка" > "Запустить отладку"

// Советы по началу работы 
//   1. В окне обозревателя решений можно добавлять файлы и управлять ими.
//   2. В окне Team Explorer можно подключиться к системе управления версиями.
//   3. В окне "Выходные данные" можно просматривать выходные данные сборки и другие сообщения.
//   4. В окне "Список ошибок" можно просматривать ошибки.
//   5. Последовательно выберите пункты меню "Проект" > "Добавить новый элемент", чтобы создать файлы кода, или "Проект" > "Добавить существующий элемент", чтобы добавить в проект существующие файлы кода.
//   6. Чтобы снова открыть этот проект позже, выберите пункты меню "Файл" > "Открыть" > "Проект" и выберите SLN-файл.
