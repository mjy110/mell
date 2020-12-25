package com.example.firsttest.httplibrary.httplibrary.requestbeans;

public
/*
修改       确认修改
*/   class requestnean {

    public requestnean(int parentId) {
        this.parentId = parentId;
    }

    public requestnean() {
    }

    /**
     * parentId : 0
     */
    
    private int parentId;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
