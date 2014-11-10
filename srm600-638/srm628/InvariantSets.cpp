#include <stdio.h>
#include <stdlib.h>
#include <cstring>
#include <iostream>
#include <sstream>
#include <ctype.h>
#include <algorithm>
#include <vector>
#include <string>
#include <set>
#include <map>
#include <stack>
#include <queue>
#include <cmath>
#include <bitset>
#include <iomanip>

using namespace std;

typedef long long LL;

class InvariantSets
{
public:
    int D[52];
    LL dp[52];
    queue<int> Q;
    long long countSets(vector <int> f)
    {
        int N = f.size();
        memset(D, 0, sizeof(D));
        long long ret = 1;
        for (int i = 0; i < N; ++i) ++D[f[i]], dp[i] = 1;
        for (int i = 0; i < N; ++i) if (D[i] == 0) Q.push(i);
        while (!Q.empty())
        {
            int x = Q.front();
            Q.pop();
            dp[f[x]] *= (1 + dp[x]);
            if (--D[f[x]] == 0) Q.push(f[x]);
        }
        for (int i = 0; i < N; ++i) 
          if (D[i])
            {
                int j = i;
                LL ans = 1;
                do
                {
                    ans *= dp[j];
                    D[j] = 0;
                    j = f[j];
                }
                while (j != i);
                ret *= ans + 1;
            }
        return ret;
    }


};


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor

