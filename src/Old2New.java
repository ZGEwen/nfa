/**
 * @Title:old2New.java
 * @Description:TODO
 * @author:zgw
 * @date:2018年9月26日下午8:07:24 
 */

/**
 * @author zgw
 *
 */
public class Old2New {

	private String oldState;
	private char trans;
	private String newState;
	/**
	 * @return oldState
	 */
	public String getOldState() {
		return oldState;
	}
	/**
	 * @param oldState 要设置的 oldState
	 */
	public void setOldState(String oldState) {
		this.oldState = oldState;
	}
	/**
	 * @return trans
	 */
	public char getTrans() {
		return trans;
	}
	/**
	 * @param trans 要设置的 trans
	 */
	public void setTrans(char trans) {
		this.trans = trans;
	}
	/**
	 * @return newState
	 */
	public String getNewState() {
		return newState;
	}
	/**
	 * @param newState 要设置的 newState
	 */
	public void setNewState(String newState) {
		this.newState = newState;
	}
	/**
	 * @param oldState
	 * @param trans
	 * @param newState
	 */
	public Old2New(String oldState, char trans, String newState) {
		super();
		this.oldState = oldState;
		this.trans = trans;
		this.newState = newState;
	}
	
}
