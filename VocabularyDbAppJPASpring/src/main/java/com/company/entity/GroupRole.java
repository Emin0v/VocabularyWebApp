/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Eminov
 */
@Entity
@Table(name = "group_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupRole.findAll", query = "SELECT g FROM GroupRole g"),
    @NamedQuery(name = "GroupRole.findById", query = "SELECT g FROM GroupRole g WHERE g.id = :id"),
    @NamedQuery(name = "GroupRole.findByGroupId", query = "SELECT g FROM GroupRole g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "GroupRole.findByRoleId", query = "SELECT g FROM GroupRole g WHERE g.roleId = :roleId")})
public class GroupRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "role_id")
    private Integer roleId;

    public GroupRole() {
    }

    public GroupRole(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupRole)) {
            return false;
        }
        GroupRole other = (GroupRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.GroupRole[ id=" + id + " ]";
    }
    
}
