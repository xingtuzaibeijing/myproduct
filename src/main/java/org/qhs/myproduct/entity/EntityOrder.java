package org.qhs.myproduct.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description 订单表
 * @date 2018/11/17
 */
@Entity
@Table(name = "tb_order")
public class EntityOrder implements Serializable {
	private static final long serialVersionUID = -6828831279534057309L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rid;

	private String rname;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}
}
