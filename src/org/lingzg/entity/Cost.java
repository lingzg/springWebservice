package org.lingzg.entity;

import java.util.Date;

import org.lingzg.base.BaseEntity;

public class Cost extends BaseEntity {

	private static final long serialVersionUID = 906860242651363740L;
	
	private Integer costId; //ID
	private String name; //资费名
	private Integer baseDuration; //基本时长
	private Double baseCost; //基本费用
	private Double unitCost; //单位费用
	private String status; //状态：0-开通，1-暂停
	private String descr; //描述
	private Date creatime; //创建时间
	private Date startime; //开通时间
	private String costType; //资费类型：1-包月，2-套餐，3-计时
	
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBaseDuration() {
		return baseDuration;
	}
	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}
	public Double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}
	public Double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	public Date getStartime() {
		return startime;
	}
	public void setStartime(Date startime) {
		this.startime = startime;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	
	public static String getTableName() {
		return "cost";
	}
	
	public static String[] getCloumnNames() {
		return new String[]{"cost_id","name","base_duration","base_cost","unit_cost","status",
				"descr","creatime","startime","cost_type"};
	}
	
	public static String[] getFieldNames() {
		return new String[]{"costId","name","baseDuration","baseCost","unitCost","status",
				"descr","creatime","startime","costType"};
	}
	
	public static String column2field(String columnName) {
		String[] cols = getCloumnNames();
		for(int i=0;i<cols.length;i++){
			if(cols[i]!=null&&cols[i].equalsIgnoreCase(columnName)){
				return getFieldNames()[i];
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return super.toString()+"{costId=" + costId + ", name=" + name + ", baseDuration=" + baseDuration + ", baseCost=" + baseCost
				+ ", unitCost=" + unitCost + ", status=" + status + ", descr=" + descr + ", creatime=" + creatime
				+ ", startime=" + startime + ", costType=" + costType + "}";
	}
	
	
}
