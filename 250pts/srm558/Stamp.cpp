#include <vector>
#include <list>
#include <map>
#include <set>
#include <queue>
#include <deque>
#include <stack>
#include <string>
#include <algorithm>
#include <iostream>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>
#include <cassert>
#include <cstring>

using namespace std;

#define eprintf printf
#define pb push_back
#define mp make_pair
#define sz(x) ((int)(x).size())
#define sqr(x) ((x) * (x))
typedef long long ll;
typedef vector<ll> vll;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<bool> vb;
typedef vector<vb> vvb;
typedef pair<int, int> pii;

const int INF = 1e9;

class Stamp
{
public:
    int getMinimumCost(string desiredColor, int stampCost, int pushCost)
    {
        int n = sz(desiredColor);
        vi msks(n);
        for (int i = 0; i < n; i++)
        {
            switch (desiredColor[i])
            {
            case 'R': msks[i] = 1; break;
            case 'G': msks[i] = 2; break;
            case 'B': msks[i] = 4; break;
            case '*': msks[i] = 7; break;
            }
        }

        int ans = INF;
        for (int len = 1; len <= n; len++)
        {
            vi dyn(n + 1, INF);
            dyn[0] = 0;
            for (int i = 0; i < n; i++)
            {
                int ccol = 7;
                for (int ne = i; ne < n; ne++)
                {
                    ccol = ccol & msks[ne];
                    if (!ccol) break;

                    int clen = (ne - i + 1);
                    if (clen < len) continue;

                    int cops = (clen + len - 1) / len;
                    dyn[ne + 1] = min(dyn[ne + 1], dyn[i] + cops * pushCost);
                }
            }

            ans = min(ans, dyn[n] + len * stampCost);
        }
        return ans;
    }
}