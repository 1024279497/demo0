package com.sjtu.team.service;

import com.sjtu.team.domain.Architect;
import com.sjtu.team.domain.Designer;
import com.sjtu.team.domain.Employee;
import com.sjtu.team.domain.Programmer;
import sun.security.krb5.internal.crypto.Des;

public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public TeamService() {
    }

    public Programmer[] getTeam(){
        Programmer[] team_new = new Programmer[total];
        for(int i = 0;i<team_new.length;i++){
            team_new[i] = team[i];
        }
        return team_new;
    }

    public void addMember(Employee e) throws TeamException {
        //成员已满，无法添加
        if(total>=MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        //该成员不是开发人员，无法添加
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        //该成员已在开发团队中
        if(isExist(e)){
            throw new TeamException("该成员已在开发团队中");
        }
        //该成员已是某团队成员
        //该成员正在休假（均用状态来判断）
        Programmer p = (Programmer)e;
        if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())){
            throw new TeamException("该成员已是某团队成员");
        }else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())){
            throw new TeamException("该成员正在休假");
        }
        int numOfArch = 0,numOfDes = 0,numOfPro = 0;
        //团队中至多只能有一名架构师
        for(int i = 0;i<total;i++){
            if(team[i] instanceof Architect){
                numOfArch++;
            }else if(team[i] instanceof Designer){
                numOfDes++;
            }else if(team[i] instanceof Programmer){
                numOfPro++;
            }
        }
        if(p instanceof Architect){
            if(numOfArch>=1){
                throw new TeamException("团队中至多只能有一名架构师");
            }else if(p instanceof Designer){
                if(numOfDes>=2){
                    throw new TeamException("团队中至多只能有两名设计师");
                }
            }
            else if(p instanceof Programmer){
                if(numOfPro>=3){
                    throw new TeamException("团队中至多只能有三名程序员");
                }
            }
        }
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++] = p;
    }

    private boolean isExist(Employee e) {
        for(int i =0;i<total;i++){
            if(e.getId()==team[i].getId()){
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i =0;
        for(i =0;i<total;i++){
            if(team[i].getMemberId()==memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i==total){
            throw new TeamException("找不到指定员工，删除失败。");
        }

        for(int j =i+1;j<total;j++){
            team[j-1] = team[j];
        }
        team[--total] = null;


    }
}
