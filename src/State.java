/**
 * @Title:State.java
 * @Package:cn.work.nfa
 * @Description:TODO
 * @author:zgw
 * @date:2018年10月4日下午12:48:56 
 */

/**
 * @author zgw
 *
 */
public class State {
	private String beginState;//状态机的初始状态
	private String endState;//状态机的接收终止状态
	/**
	 * @return beginState
	 */
	public String getBeginState() {
		return beginState;
	}
	/**
	 * @param beginState 要设置的 beginState
	 */
	public void setBeginState(String beginState) {
		this.beginState = beginState;
	}
	/**
	 * @return endState
	 */
	public String getEndState() {
		return endState;
	}
	/**
	 * @param endState 要设置的 endState
	 */
	public void setEndState(String endState) {
		this.endState = endState;
	}
	/**
	 * @param beginState
	 * @param endState
	 */
	public State(String beginState, String endState) {
		super();
		this.beginState = beginState;
		this.endState = endState;
	}
	/**
	 * 
	 */
	public State() {
		super();
	}
	
}
