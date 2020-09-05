package com.ping.chen.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pager{

    private int pageNo = 1;//页码，默认是第一页
    private int pageSize = 15;//每页显示的记录数，默认是15
    private long totalRecord;//总记录数
    private long totalPage;//总页数
    private List<?> results;//对应的当前页记录
    private Map<String, Object> params = new HashMap<String, Object>();//其他的参数我们把它分装成一个Map对象

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

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
        //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
        long totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
        this.setTotalPage(totalPage);
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getResults() {
        return results;
    }

    public void setResults(List<?> results) {
        this.results = results;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
