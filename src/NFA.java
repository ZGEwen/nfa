/**
 * @Title:NFA.java
 * @Description:TODO
 * @author:zgw
 * @date:2018年9月26日下午7:28:52 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author zgw
 *
 */
public class NFA {
	
	public static void main(String[] args) {
		System.out.println("请输入仅含[0,1](中间也可输入用#表示的空字符,#可写可不写)待识别的字符串：");
		//将字符存入字符数组中
		Scanner sc = new Scanner(System.in);
		String str=sc.next();
		char cin[] = str.toCharArray();//利用toCharArray方法转换
		sc.close();
		//初始化关系集合
		ArrayList<Old2New> list=initRelation();
		//初始化状态集合
		HashSet<String> hs = new HashSet<String>();
		//初始化辅助状态集合
		HashSet<String> hsTmp = new HashSet<String>();
		//起始状态
		String beginState="q1";
		//终止状态
		String endState="q4";
		//初始化状态对象
		State st=new State(beginState,endState);
		//将初始状态放入hashset中
		hs.add(st.getBeginState());
		//从前到后依次遍历读取字符
		for (int i = 0; i < cin.length; i++) {			
				//当前输入字符cin[i];
				//根据当前状态，当前字符，查询关系集合
				/*老状态：q1转移数字：0新状态：q1
				老状态：q1转移数字：1新状态：q1
				老状态：q1转移数字：1新状态：q2
				老状态：q1转移数字：#新状态：NO
				老状态：q2转移数字：0新状态：q3
				老状态：q2转移数字：1新状态：NO
				老状态：q2转移数字：#新状态：q3
				老状态：q3转移数字：0新状态：NO
				老状态：q3转移数字：1新状态：q4
				老状态：q3转移数字：#新状态：NO
				老状态：q4转移数字：0新状态：q4
				老状态：q4转移数字：1新状态：q4
				老状态：q4转移数字：#新状态：NO
				 * */
			//1.克隆集合，克隆前清空克隆的集合
			hsTmp.clear();
			hsTmp.addAll(hs);
			//2.用克隆的集合进行比较，在原来的集合中进行添加
			//3.用原来的集合进行输出判断
			System.out.println("--------------------------------------------");
			System.out.printf("识别第%d个字符%s",i+1,cin[i]);
			System.out.println();
			//遍历集合
			for (Iterator iterator = hsTmp.iterator(); iterator.hasNext();) {
				//获取集合中的状态
				String strState = (String) iterator.next();
				System.out.println("当前状态："+strState);
				for (Old2New stateTr : list)
				{//遍历所有的状态，由于可能存在多个新的状态，因此需要将这多个新的状态全部记录，对于每个新的状态单独	
				    //System.out.println("当前状态："+stateTr.getOldState()+" 识别字符："+stateTr.getTrans()+"转移到新状态："+stateTr.getNewState());
				    if(strState.equals(stateTr.getOldState())&&(cin[i]==stateTr.getTrans())) {
				    	if (!"NO".equals(stateTr.getNewState())) {//如果状态的转移不为空，将新状态添加到集
					    	hs.add(stateTr.getNewState());//将新的状态添加到集合，先将其记录下来
					    	System.out.println("当前状态："+stateTr.getOldState()+" 识别字符："+stateTr.getTrans()+"转移到新状态："+stateTr.getNewState()+"添加状态："+stateTr.getNewState());
						}
				    }				
				}	
			}
			//单独处理，用来得到空闭包
			//遍历集合,得到空闭包
			for (Iterator iterator = hs.iterator(); iterator.hasNext();) {
				//获取集合中的状态
				String strState = (String) iterator.next();
				System.out.println("单独识别空字符，当前状态："+strState);
				for (Old2New stateTr : list)
				{//遍历所有的状态，由于可能存在多个新的状态，因此需要将这多个新的状态全部记录，对于每个新的状态单独	
					//System.out.println("当前状态："+stateTr.getOldState()+" 识别字符："+stateTr.getTrans()+"转移到新状态："+stateTr.getNewState());
				    if (strState.equals(stateTr.getOldState())&&('#'==stateTr.getTrans())) {
				    	if (!"NO".equals(stateTr.getNewState())) {//如果状态的转移不为空，将新状态添加到集
					    	hs.add(stateTr.getNewState());//将新的状态添加到集合，先将其记录下来
					    	System.out.println("添加状态："+stateTr.getNewState());
						}
					}				
				}	
			}
			//将新添加的状态集合内容全部添加到旧的状态集合中
			//得到读取当前字符之后，空闭包的状态集合
			System.out.print("识别当前字符:"+cin[i]+",得到的空闭包为{");
			for (String s : hs) {
				System.out.print(s+",");
			}
			System.out.println("}");
			System.out.println("--------------------------------------------");
		}
		if (hs.contains(st.getEndState())) {
			System.out.println("ε闭包集合中包含接受状态 "+st.getEndState()+"，该字符串被状态机接收");
		}else {
			System.out.println("ε闭包集合中不包含接受状态 "+st.getEndState()+"，该字符串被状态机拒绝");
		}
		System.out.println("------------------END-------------------");
	}

	/**
	 * 初始化关系集合
	 */
	public static ArrayList<Old2New> initRelation() {
		//将拒绝状态用NO表示，将空串用#表示
		ArrayList<Old2New> list = new ArrayList<Old2New>();
		list.add(new Old2New("q1",'0',"q1"));
		list.add(new Old2New("q1",'1',"q1"));
		list.add(new Old2New("q1",'1',"q2"));
		list.add(new Old2New("q1",'#',"NO"));
		list.add(new Old2New("q2",'0',"q3"));
		list.add(new Old2New("q2",'1',"NO"));
		list.add(new Old2New("q2",'#',"q3"));
		list.add(new Old2New("q3",'0',"NO"));
		list.add(new Old2New("q3",'1',"q4"));
		list.add(new Old2New("q3",'#',"NO"));
		list.add(new Old2New("q4",'0',"q4"));
		list.add(new Old2New("q4",'1',"q4"));
		list.add(new Old2New("q4",'#',"NO"));
		return list;
	}
}
