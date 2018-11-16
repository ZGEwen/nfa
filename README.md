# nfa
计算理论导引课程实验一：NFA对字符串的识别

要求理解NFA工作原理设计数据结构或类，编写代码实现NFA，通过某些字符串作为输入，通过代码运行判断NFA能否正确接受或拒绝这些字符串，并将得到的结果进行输出。

状态集合为：{q1,q2,q3,q4}

其中输入项：01 并且用#号表示空

状态转移关系

|      | 0    | 1     | 空【用#号表示】 |
| ---- | ---- | ----- | --------------- |
| q1   | q1   | q1,q2 | NO              |
| q2   | q3   | NO    | q3              |
| q3   | NO   | q4    | NO              |
| q4   | q4   | q4    | NO              |

起始项：q1

终止接受状态：q4

程序中对每个状态都进行转移，最后判断结束时，最后状态为q4则接受，状态为其他则拒绝
