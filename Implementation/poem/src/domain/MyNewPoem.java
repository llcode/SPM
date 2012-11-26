package domain;

import java.util.Date;

public class MyNewPoem {

	private Integer newpid;
	private Date createdate;
	private Date testdate;
	private Integer count;

	private UserCount user;
	private Poem poem;

	public Integer getNewpid() {
		return newpid;
	}

	public void setNewpid(Integer newpid) {
		this.newpid = newpid;
	}

	public UserCount getUser() {
		return user;
	}

	public void setUser(UserCount user) {
		this.user = user;
	}

	public Poem getPoem() {
		return poem;
	}

	public void setPoem(Poem poem) {
		this.poem = poem;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getTestdate() {
		return testdate;
	}

	public void setTestdate(Date testdate) {
		this.testdate = testdate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
