/* &*#()&*#)&E*F& */

#include <iostream>
#include <cstdio>
#include <cstring>
#include <ctime>
#include <cmath>
#include <algorithm>
#include <sstream>
#include <string>
#include <vector>
#include <map>

using namespace std;

#define REP(I, N) for (int I=0;I<int(N);++I)
#define FOR(I, A, B) for (int I=int(A);I<int(B);++I)
#define DWN(I, B, A) for (int I=int(B-1);I>=int(A);--I)
#define ECH(it, A) for (typeof(A.begin()) it=A.begin(); it != A.end(); ++it)

#define ALL(A) A.begin(), A.end()
#define CLR(A) A.clear()
#define CPY(A, B) memcpy(A, B, sizeof(A))
#define INS(A, P, B) A.insert(A.begin() + P, B)
#define ERS(A, P) A.erase(A.begin() + P)
#define SRT(A) sort(ALL(A))
#define SZ(A) int(A.size())
#define PB push_back
#define MP(A, B) make_pair(A, B)

#define s x

typedef long long LL;
typedef double DB;

template<class T> inline void RST(T &A) {memset(A, 0, sizeof(A));}
template<class T> inline void FLC(T &A, int x) {memset(A, x, sizeof(A));}

template<class T> inline void checkMin(T &a, T b) {if (b < a) a = b;}
template<class T> inline void checkMax(T &a, T b) {if (b > a) a = b;}

/* -&$&#*( &#*@)^$@&*)*/

const int MOD = 1000000007;
const int INF = 0x7fffffff;



const int N = int(209);


int n;
namespace DSU { // Disjoint Set Union
int P[N];
inline void Make(int x) {
    P[x] = x;
}
inline int Find(int x) {
    return P[x] == x ? x : P[x] = Find(P[x]);
}
inline void Union(int x, int y) {
    int xx = Find(x), yy = Find(y);

    if (xx == yy) {
        return;
    }
    else {
        P[xx] = yy;
    }
}

void Union(int x, int y, int z) {
    if (z) Union(x, y + n), Union(x + n, y);
    else Union(x, y), Union(x + n, y + n);
}

inline void Init(int n) {
    REP(i, n + n) Make(i);
}
} using namespace DSU;



class OddEvenTreeHard {
public:
    vector <int> getTree(vector <string> x) {

        n = x.size() ;


        vector<int> res;
        int odd = -1;


        Init(n + n);

        REP(i, n) REP(j, n) {
            if (x[i][j] == 'O') {
                Union(i, j, 1);
            }
            else if (x[i][j] == 'E') {
                Union(i, j, 0);
            }
        }


        REP(i, n) if (Find(i) == Find(i + n)) {
            res.PB(-1);
            return res;
        }
        REP(i, n) if (s[0][i] == '?') {
            if (Find(0) == Find(i)) {
                x[0][i] = 'E';
                Union(0, i, 0);
            } else {
                s[0][i] = 'O';
                Union(0, i, 1);
            }
        }


        FOR(i, 1, n) {
            if (x[0][i] == 'O') odd = i, res.PB(0), res.PB(i);
        }



        if (odd == -1) {

            res.clear(); res.PB(-1);
            return res;
        }

        FOR(i, 1, n) {
            if (x[0][i] == 'E') res.PB(odd), res.PB(i);
        }

        return res;
    }
};

