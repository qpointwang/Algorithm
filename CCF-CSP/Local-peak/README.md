# Algorithm

常见算法


Find.py为用田字法查询二维数组中的峰值（有一个即可），算法复杂度怎么算呢？？

![image](https://github.com/qpointwang/Algorithm/blob/master/Local-peak/FindTimeComplexity.png)


此图片为用田字法求峰值的时间复杂度算法，二维矩阵为n\*n，如果矩阵为n\*m，时间复杂度还是一样吗？


算法输入：python二维数组np.array(m\*n),二维数组列起始index,二维数组列数n,二维数组行起始index,二维数组行数m

算法输出：二维数组局部峰值以及其对应的坐标位置(i,j)

时间复杂度如下图所示：
![image](https://github.com/qpointwang/Algorithm/blob/master/Local-peak/FindTimeComplexityMN.png)

总之不论二维数组的m和n大小，该算法的时间复杂度都为线性。
