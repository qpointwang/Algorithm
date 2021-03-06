### 差分约束系统

差分约束系统（system of difference constraints），是求解关于一组变数的特殊不等式组之方法。如果一个系统由n个变量和m个约束条件组成，其中每个约束条件形如xj-xi<=bk(i,j∈[1,n],k∈[1,m]),则称其为差分约束系统(system of difference constraints)。亦即，差分约束系统是求解关于一组变量的特殊不等式组的方法。

比如有这样一组不等式：
```
X1 - X2 <= 0
X1 - X5 <= -1
X2 - X5 <= 1
X3 - X1 <= 5
X4 - X1 <= 4
X4 - X3 <= -1
X5 - X3 <= -3
X5 - X4 <= -3
```
全都是两个未知数的差小于等于某个常数（大于等于也可以，因为左右乘以-1就可以化成小于等于）。这样的不等式组就称作差分约束系统。这个不等式组要么无解，要么就有无数组解。因为如果有一组解{X1, X2, ..., Xn}的话，那么对于任何一个常数k，{X1 + k, X2 + k, ..., Xn + k}肯定也是一组解，因为任何两个数同时加一个数之后，它们的差是不变的，那么这个差分约束系统中的所有不等式都不会被破坏。

差分约束系统的解法利用到了单源最短路径问题中的三角形不等式。即对于任何一条边u -> v，都有：
```
d(v) <= d(u) + w(u, v)
```



显然以上不等式就是d(v) - d(u) <= w(u, v)。这个形式正好和差分约束系统中的不等式形式相同。于是我们就可以把一个差分约束系统转化成一张图，每个未知数Xi对应图中的一个顶点Vi，把所有不等式都化成图中的一条边。对于不等式Xi - Xj <= c，把它化成三角形不等式：Xi <= Xj + c，就可以化成边Vj -> Vi，权值为c。最后，我们在这张图上求一次单源最短路径，这些三角形不等式就会全部都满足了，因为它是最短路径问题的基本性质嘛。

话说回来，所谓单源最短路径，当然要有一个源点，然后再求这个源点到其他所有点的最短路径。那么源点在哪呢？我们不妨自已造一个。以上面的不等式组为例，我们就再新加一个未知数X0。然后对原来的每个未知数都对X0随便加一个不等式（这个不等式当然也要和其它不等式形式相同，即两个未知数的差小于等于某个常数）。我们索性就全都写成Xn - X0 <= 0，于是这个差分约束系统中就多出了下列不等式：
```
X1 - X0 <= 0
X2 - X0 <= 0
X3 - X0 <= 0
X4 - X0 <= 0
X5 - X0 <= 0
```

当我们把不等式整理成d[a]+w<=d[b]时，我们求最长路。整理成d[a]+w>=d[b]时，我们求最短路。当求最短路时，我们通常要把各点距离初始化为正无穷，求最短路，把各点距离逐渐减小，直到符合所有不等式。
其中d(u)和d(v)是从源点分别到点u和点v的最短路径的权值，w(u, v)是边u -> v的权值。

差分约束系统的解法如下：

* 1、  根据条件把题意通过变量组表达出来得到不等式组，注意要发掘出隐含的不等式，比如说前后两个变量之间隐含的不等式关系。

* 2、  进行建图：

首先根据题目的要求进行不等式组的标准化。

(1)、如果要求取最小值，那么求出最长路，那么将不等式全部化成xi – xj >= k的形式，这样建立j->i的边，权值为k的边，如果不等式组中有xi – xj > k，因为一般题目都是对整形变量的约束，化为xi – xj >= k+1即可，如果xi – xj = k呢，那么可以变为如下两个：xi – xj >= k, xi – xj <= k,进一步变为xj – xi >= -k，建立两条边即可。

(2)、如果求取的是最大值，那么求取最短路，将不等式全部化成xi – xj <= k的形式, 这样建立j->i的边，权值为k的边，如果像上面的两种情况，那么同样地标准化就行了。

(3)、如果要判断差分约束系统是否存在解，一般都是判断环，选择求最短路或者最长路求解都行，只是不等式标准化时候不同，判环地话，用spfa即可，n个点中如果同一个点入队超过n次，那么即存在环。

值得注意的一点是：建立的图可能不联通，我们只需要加入一个超级源点，比如说求取最长路时图不联通的话，我们只需要加入一个点S，对其他的每个点建立一条权值为0的边图就联通了，然后从S点开始进行spfa判环。最短路类似。

* 3、  建好图之后直接spfa或bellman-ford求解，不能用dijstra算法，因为一般存在负边，注意初始化的问题。


```
ProcedureSPFA;
Begin
    initialize-single-source(G,s);
    initialize-queue(Q);
    enqueue(Q,s);
    while not empty(Q) do begin
        u:=dequeue(Q);
        for each v∈adj[u] do begin
            tmp:=d[v];
            relax(u,v);
            if(tmp<>d[v])and(not v in Q)then enqueue(Q,v);
        end;
    end;
End; 
```