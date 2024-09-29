#include <iostream>
using namespace std;
int main()
{

    int a[100][50], cols[50];
    int n, m, ans = 0;
    cout << "n, m? ";
    cin >> n >> m;
    for (int i = 0; i < m; i++)cols[i] = 0;
    
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
            cols[j] += a[i][j];
        }
    }
    //for (int i = 0; i < m; i++)cout << cols[i] << " ";
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++) {
            if (a[i][j] > cols[j])ans++;
        }
    }
    cout << ans;
    return 0;
}
