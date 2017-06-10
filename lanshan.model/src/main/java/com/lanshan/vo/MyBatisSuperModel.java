package com.lanshan.vo;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Minko
 * mybatis 分页model
 */
@SuppressWarnings("rawtypes")
public class MyBatisSuperModel {

	
	private int pageNo = 1;// 页码，默认是第一页
	private int pageSize = 10;// 每页显示的记录数，默认是10
	private int totalRecord;// 总记录数
	private int totalPage;// 总页数
	private List results;// 对应的当前页记录
	private Integer count;//数据的条数
	private Map<String, Object> params;// 其他的参数我们把它分装成一个Map对象
	

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	private String tableId;

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
		this.totalPage = (totalRecord + this.pageSize - 1) / pageSize;
		this.totalPage = this.totalPage == 0 ? 1 : this.totalPage;
	}
	
	public void setTotalPage(Integer totalPage){
		this.totalPage=totalPage;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	// 是否启动分页，默认不启动;只有启动分页才执行后面分页语句
 	private boolean ispaging = false;

	public boolean isIspaging() {
		return ispaging;
	}

	public void setIspaging(boolean ispaging) {
		this.ispaging = ispaging;
	}
	// 其他的参数我们把它分装成一个Map对象
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public List getResults() {
		return results;
	}

	public void setResults(List results) {
		this.results = results;
	}

}
