package com.lw.bean;

public class MemoBean {
    private int id;// ����¼���
    private String username;// �û�����
    private String title;// ����¼����
    private String content;// ����¼����
    private String memotype;// ����¼����
    private String memotime;// ����¼ʱ��
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getMemotype() {
        return memotype;
    }
    
    public void setMemotype(String memotype) {
        this.memotype = memotype;
    }
    
    public String getMemotime() {
        return memotime;
    }
    
    public void setMemotime(String memotime) {
        this.memotime = memotime;
    }
}
