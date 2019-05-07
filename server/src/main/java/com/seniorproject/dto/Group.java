package com.seniorproject.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "groups")
@TypeAlias("group")
public class Group{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String groupId;
    private final String groupName;
    private List<String> user_list;
    private List<String> user_list_withAdmin;

    public Group(String groupName) {
        this.groupName = groupName;
        this.user_list = new ArrayList<String>();
        this.user_list_withAdmin = new ArrayList<String>();
    }

    public String getId() {
        return groupId;
    }

    public List<String> getList() {
        return user_list;
    }

    public List<String> getAdminList() {
        return user_list_withAdmin;
    }

    public String getGroupName() {
        return groupName;
    }

    public void addToList(String id) {
        user_list.add(id);
    }

    public void addToListWithAdmin(String id) {
        user_list_withAdmin.add(id);
    }
}