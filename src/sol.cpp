// #include <bits/stdc++.h>
#define  RD(x)      scanf("%d", &x)
#define  REP(i, n)  for (int i=0; i<int(n); ++i)
#define  FOR(i, n)  for (int i=1; i<=int(n); ++i)
#define  pii        pair<int, int>
#define  piL        pair<int, long long>
#define  mp         make_pair
#define  pb         push_back
#define  whatis(x)  cout << #x << ": " << x << endl;
int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};

using namespace std;
#include "vector"
#define  N   123456
#define  eps 1e-8
#define  pi  acos(-1.0)
#define  inf 0XFFFFFFFll
#define  mod 1000000007ll
#define  LL  long long
#define  ULL unsigned long long

class BuildingTowers
{
public:
    long long maxHeight(int _n, int _K, vector <int> x, vector <int> t)
    {
        LL n = _n;
        LL K = _K;
        vector<LL> X, T;
        X.push_back(1);
        T.push_back(0);

        REP(i, x.size()) if (x[i] != 1)
            X.push_back(x[i]), T.push_back(t[i]);

        if (X[X.size() - 1] != n)
            X.push_back(n), T.push_back((n - 1)*K);


        bool ok = true;
        while (ok)
        {
            ok = false;
            for (int i = 1; i < (int)X.size(); i++)
            {
                LL u = T[i - 1] + (X[i] - X[i - 1]) * K;
                if (T[i] > u)
                {
                    T[i] = u;
                    ok = true;
                }
            }

            for (int i = X.size() - 2; i >= 0; i--)
            {
                LL u = T[i + 1] + (X[i + 1] - X[i]) * K;
                if (T[i] > u)
                {
                    T[i] = u;
                    ok = true;
                }
            }
        }

        LL ans = 0;
        for (LL v : T)
            ans = max(ans, v);

        for (int i = 1; i < X.size(); i++)
        {
            LL l = 1, r = T[i - 1] + (X[i] - X[i - 1]) * K;
            while (l < r)
            {
                LL mid = (l + r + 1) / 2;
                LL need = (mid - T[i - 1] + K - 1) / K;
                LL all = X[i] - X[i - 1];
                LL has = all - need;
                if (mid - has * K <= T[i])
                    l = mid;
                else
                    r = mid - 1;
            }
            ans = max(ans, l);
        }

        return ans;
    }


};
