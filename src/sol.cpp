#include <vector> 
#include <list> 
#include <map> 
#include <set> 
#include <deque> 
#include <stack> 
#include <bitset> 
#include <algorithm> 
#include <functional> 
#include <numeric> 
#include <sstream> 
#include <iostream> 
#include <cstdio> 
#include <cmath> 
#include <cstdlib> 
#include <ctime> 
#include <queue> 
#include <cstring> 
using namespace std; 

struct PalindromeMatrixDiv2 { 
  int minChange(vector <string> A, int rowCount, int columnCount); 
}; 

inline int BIT(int n, int i) { return (n>>i)&1; } 

void Generate(vector<int> &t, int n, int c) { 
  t.clear(); 
  for(int i = 0; i < (1<<n); i++) { 
    int cnt = 0; 
    for(int j = 0; j < n; j++) 
      if (BIT(i, j)) cnt++; 
    if (cnt == c) t.push_back(i); 
  } 
} 

int a[8][8]; 
int consider[8][8], key; 
int n, m; 

void dfs(int i, int j, int r, int c, int Count[2]) { 
  if (consider[r][c] == key) return; 
  consider[r][c] = key; 
  Count[a[r][c]]++; 
  if (BIT(i, r)) dfs(i, j, r, m-c-1, Count); 
  if (BIT(j, c)) dfs(i, j, n-r-1, c, Count); 
} 

int PalindromeMatrixDiv2::minChange(vector <string> A, int rowCount, int columnCount) { 

  n = A.size(); 
  m = A[0].length(); 
  for(int i = 0; i < n; i++) 
    for(int j = 0; j < m; j++) 
      a[i][j] = A[i][j]-'0'; 

  vector<int> tr, tc; 
  Generate(tr, n, rowCount); 
  Generate(tc, m, columnCount); 

  key = 0; 
  memset(consider, 0, sizeof consider); 

  int ret = 1e9; 
  for(int ii = 0; ii < tr.size(); ii++) { 
    int i = tr[ii]; 
    for(int jj = 0; jj < tc.size(); jj++) { 
      int j = tc[jj]; 
      int tret = 0; 
      key++; 
      for(int r = 0; r < n; r++) 
        for(int c = 0; c < m; c++) { 
          int Count[2] = {0, 0}; 
          dfs(i, j, r, c, Count); 
          tret += min(Count[0], Count[1]); 
        } 

      ret = min(ret, tret); 
    } 
  } 

  return ret; 
} 



// Powered by FileEdit
// Powered by TesterDream 1.2.4 by fushar (December 19 2012)
// Powered by CodeProcessor