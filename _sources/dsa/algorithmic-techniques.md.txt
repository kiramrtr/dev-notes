# Algorithmic Techniques

## Prefix Sum

:::{table}
:class: ps-ex1

| Index $i$               |   0 |   1 |   2 |   3 |   4 |   5 |   6 |
| ----------------------- | --: | --: | --: | --: | --: | --: | --: |
| $\texttt{arr}[i]$       |   1 |   6 |   4 |   2 |   5 |   3 |   - |
| $\texttt{prefixSum}[i]$ |   0 |   1 |   7 |  11 |  13 |  18 |  21 |

:::

Prefix sum can be calculated in $\mathcal{O}(n)$ by the below formula:

$$
\texttt{prefixSum}[i] = \texttt{prefixSum}[i - 1] + \texttt{arr}[i - 1]
$$

Now, the sum of the elements of $\texttt{arr}$ from $\textit{L}$ to $\textit{R}$ can be computed using:

$$
\sum_{i=L}^{R} \texttt{arr}[i] = \sum_{i=0}^{R} \texttt{arr}[i] - \sum_{i=0}^{L-1} \texttt{arr}[i]
$$

Using the prefix sum array, the same can be

$$
\sum_{i=L}^{R} \texttt{arr}[i] = \texttt{prefixSum}[R+1] - \texttt{prefixSum}[L]
$$

Example should make it more clearer:

$$
\sum_{1=1}^{4} \texttt{arr}[i] = \sum_{i=0}^{4} \texttt{arr}[i]  - \sum_{i=0}^{0} \texttt{arr}[i] \\
\sum_{n=1}^{4} \texttt{arr}[i] = (1 + 6 + 4 + 2 + 5) - (1) = 18 - 1 = 17.
$$

Using prefix sums:

$$
\texttt{prefixSum}[5] - \texttt{prefixSum}[1] = 18 - 1 = 17.
$$

> Read more at: https://usaco.guide/silver/prefix-sums and https://labuladong.gitbook.io/algo-en/iii.-algorithmic-thinking/prefix_sum

## Backtracking

Types of problems

1. Decision - Search for a solution.
2. Optimization - Search for best solution.
3. Enumeration - Find all possible/feasible solutions.
