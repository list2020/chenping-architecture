package com.ping.chen.model;

/**
 * 列的属性
 *
 *
 * @author ping.chen
 * @email 2676455951@qq.com
 * @date 2020年09月05日 下午21:12:58
 */
public class ColumnEntity {
	//列名
    private String columnName;
    //列名类型
    private String dataType;
    //列名备注
    private String comments;
    
    //属性中文名称
    private String attrChName; //在备注中取第一个，号前的名称，
    
    private String attrHtmlType; //  取第二个，号内，若是下拉框，择取[内值]，支持input,select,check,datetime,用于编辑
    
    //属性名称(第一个字母大写)，如：user_name => UserName
    private String attrName;
    //属性名称(第一个字母小写)，如：user_name => userName
    private String attrname;
    //属性类型
    private String attrType;
    //auto_increment
    private String extra;
    
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getAttrname() {
		return attrname;
	}
	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getAttrType() {
		return attrType;
	}
	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getAttrChName() {
		return attrChName;
	}
	public void setAttrChName(String attrChName) {
		this.attrChName = attrChName;
	}
	public String getAttrHtmlType() {
		return attrHtmlType;
	}
	public void setAttrHtmlType(String attrHtmlType) {
		this.attrHtmlType = attrHtmlType;
	}
}
