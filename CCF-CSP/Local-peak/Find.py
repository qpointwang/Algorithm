import numpy as np


def getMaxLocation(myMatrix, x1, x2, y1, y2):
    # m = myMatrix.shape[0]
    # n = myMatrix.shape[1]
    m_m = int((y1+y2-1)/2)
    n_m = int((x1+x2-1)/2)
    # print("分界点 ", m_m, n_m)
    maxValue = myMatrix[y1][x1]
    maxLocation = [y1, x1]
    # print("左上顶点", maxValue)
    # 求横向三排的最大值和位置
    for i in range(x1, x2):
        if myMatrix[y1][i] > maxValue:
            maxValue = myMatrix[y1][i]
            maxLocation = [y1, i]
        if myMatrix[m_m][i] > maxValue:
            maxValue = myMatrix[m_m][i]
            maxLocation = [m_m, i]
        if myMatrix[y2-1][i] > maxValue:
            maxValue = myMatrix[y2-1][i]
            maxLocation = [y2-1, i]
    # 求纵向三列的最大值和位置
    for i in range(y1, y2):
        if myMatrix[i][x1] > maxValue:
            maxValue = myMatrix[i][x1]
            maxLocation = [i, x1]
        if myMatrix[i][n_m] > maxValue:
            maxValue = myMatrix[i][n_m]
            maxLocation = [i, n_m]
        if myMatrix[i][x2-1] > maxValue:
            maxValue = myMatrix[i][x2-1]
            maxLocation = [i, x2-1]
    # print(maxLocation)
    # print(maxValue)
    return maxValue, maxLocation, n_m, m_m


def isMaxAroundNeighbor(myMatrix, maxValue, maxLocation, x1, x2, y1, y2):
    # m = myMatrix.shape[0]
    # n = myMatrix.shape[1]
    flag = 0
    neighborMax = maxValue
    neighborMaxLocation = []
    # 元素上方
    if maxLocation[0] != y1:
        if myMatrix[maxLocation[0]-1][maxLocation[1]] > neighborMax:
            neighborMax = myMatrix[maxLocation[0]-1][maxLocation[1]]
            neighborMaxLocation = [maxLocation[0]-1, maxLocation[1]]
            flag = flag + 1
    # 元素下方
    if maxLocation[0] != y2-1:
        if myMatrix[maxLocation[0]+1][maxLocation[1]] > neighborMax:
            neighborMax = myMatrix[maxLocation[0]+1][maxLocation[1]]
            neighborMaxLocation = [maxLocation[0]+1, maxLocation[1]]
            flag = flag + 1
    # 元素左方
    if maxLocation[1] != x1:
        if myMatrix[maxLocation[0]][maxLocation[1]-1] > neighborMax:
            neighborMax = myMatrix[maxLocation[0]][maxLocation[1]-1]
            neighborMaxLocation = [maxLocation[0], maxLocation[1]-1]
            flag = flag + 1
    # 元素右方
    if maxLocation[1] != x2-1:
        if myMatrix[maxLocation[0]][maxLocation[1]+1] > neighborMax:
            neighborMax = myMatrix[maxLocation[0]][maxLocation[1]+1]
            neighborMaxLocation = [maxLocation[0], maxLocation[1]+1]
            flag = flag + 1

    if flag > 0:
        return False, neighborMax, neighborMaxLocation
    else:
        return True, maxValue, maxLocation


def Tian(myMatrix, x1, x2, y1, y2):
    # print("坐标范围", x1, x2, y1, y2)
    value, location, x, y = getMaxLocation(myMatrix, x1, x2, y1, y2)
    print("找到田字中的最大值： "+str(value)+"  其位置为： "+str(location))
    isMax, maxValue, MaxLocation = isMaxAroundNeighbor(myMatrix, value, location, x1, x2, y1, y2)
    if isMax:
        return maxValue, MaxLocation
    else:
        print("找到领域比其大的值： "+str(maxValue)+"  其位置为： "+str(MaxLocation))
        if MaxLocation[0] < y and MaxLocation[1] > x:
            # print("第1象限")
            X1 = x
            X2 = x2
            Y1 = y1
            Y2 = y+1
        elif MaxLocation[0] < y and MaxLocation[1] < x:
            # print("第2象限")
            X1 = x1
            X2 = x+1
            Y1 = y1
            Y2 = y+1
        elif MaxLocation[0] > y and MaxLocation[1] < x:
            # print("第3象限")
            X1 = x1
            X2 = x+1
            Y1 = y
            Y2 = y2
        elif MaxLocation[0] > y and MaxLocation[1] > x:
            # print("第4象限")
            X1 = x
            X2 = x2
            Y1 = y
            Y2 = y2
        # print(maxValue, MaxLocation)
        return Tian(myMatrix, X1, X2, Y1, Y2)
        # print("----")
        # print(maxValue, MaxLocation)
        # return maxValue, MaxLocation


def makeArray(m, n): #随机生成形为m*n的二维数组
    myArray = np.random.randint(0, 100, n*m)
    myMatrix = myArray.reshape(m, n)
    return myMatrix


if __name__ == '__main__':
    myMatrix = np.array([[5, 2, 7, 3, 8, 10, 11, 8, 5],
                         [4, 5, 9, 2, 6, 22, 8, 2, 8],
                         [4, 13, 1, 5, 16, 18, 2, 6, 7],
                         [1, 4, 8, 4, 9, 2, 8, 30, 1],
                         [5, 2, 1, 2, 1, 9, 7, 6, 4],
                         [4, 5, 5, 17, 13, 2, 2, 4, 9],
                         [5, 6, 5, 2, 5, 2, 9, 7, 1],
                         [2, 16, 15, 3, 2, 8, 3, 6, 8],
                         [6, 8, 8, 4, 8, 7, 7, 5, 6],
                         [10, 5, 4, 6, 7, 4, 8, 3, 3],
                         ])
    print("二维数组为：")
    print(myMatrix)
    peak, peakLocation = Tian(myMatrix, 0, myMatrix.shape[1], 0, myMatrix.shape[0])
    print("局部峰值为： " + str(peak) + "   峰值的位置为： " + str(peakLocation))
