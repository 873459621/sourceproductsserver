package cn.edu.njupt.sourceproductsserver.domain;

/**
 * 封装分类的Javabean
 * 
 * @author hhw
 */
public class Category {

	private int cid;
	private String cname;

	public Category(int cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "{\"cid\":\"" + cid + "\", \"cname\":\"" + cname + "\"}";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
